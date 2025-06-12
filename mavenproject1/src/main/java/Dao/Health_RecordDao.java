/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Core.Database;
import Entity.Health_Record;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author elmaz
 */
public class Health_RecordDao {
    private Connection connection;

    public Health_RecordDao() {
        connection = Database.getDatabase();
    }
    
    //Finding all
    public List<Health_Record> findAllHealth_Record(){
            String sql = "Select * from Health_Record";
            List<Health_Record> health_records = new ArrayList<>();        
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                health_records.add(this.matchHealth_Record(rs));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Health_RecordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return health_records;
    
    }
    
    //check for matching
    public Health_Record matchHealth_Record(ResultSet rs) throws SQLException{
        Health_Record health_record = new Health_Record();
        
                health_record.setId(rs.getInt(1));
                health_record.setEarTagNumber(rs.getString("earTagNumber"));
                health_record.setHealthCondition(rs.getBoolean("healthCondition"));
                health_record.setDiagnosis(rs.getString("diagnosis"));
                
                return health_record;
        
    }
    
    //adding health record
public Health_Record addHealth_Record(String earTagNumber, boolean healthCondition, String diagnosis) throws SQLException {

    String sql = "Insert into Health_Record (earTagNumber, healthCondition, diagnosis) Values (?,?,?)";

    try (PreparedStatement pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
        pstm.setString(1, earTagNumber);
        pstm.setBoolean(2, healthCondition);
        pstm.setString(3, diagnosis);
        
        int affectedRow = pstm.executeUpdate();
        if (affectedRow == 0) {
            throw new SQLException("Kullanıcı eklenemedi.");        
        }
        
        try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                Health_Record health_record = new Health_Record();
                
                health_record.setId(generatedKeys.getInt(1));
                health_record.setEarTagNumber(earTagNumber);
                health_record.setHealthCondition(healthCondition);
                health_record.setDiagnosis(diagnosis);
                
                return health_record;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Health_RecordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }
     return null;

    }

    public boolean deleteHealth(int health_id){
        String delete_sql = "DELETE FROM Health_Record WHERE id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(delete_sql);
            pstm.setInt(1, health_id);
            
            int affected = pstm.executeUpdate();
            if(affected > 0) {
                return true;
            }        
            
        } catch (SQLException ex) {
            Logger.getLogger(Health_RecordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean checkForHealthRecord(String earTagNo){
        String sql = "Select * from Health_Record where earTagNumber = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, earTagNo);
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Health_RecordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
