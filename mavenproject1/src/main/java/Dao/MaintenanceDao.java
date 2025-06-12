package Dao;

import Core.Database;
import Entity.Maintenance;
import Entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MaintenanceDao {
    private Connection connection;
    
    private User user;
    
    public MaintenanceDao(User user) {
        connection = Database.getDatabase();
        this.user = user;
    }
    
    //getting all maintenance records 
    public List<Maintenance> getAllMaintenanceRecords() {
        List<Maintenance> maintenanceList = new ArrayList<>();
        
    String sql = "SELECT DISTINCT m.* FROM Maintenance m " +
                 "JOIN Animal a ON m.earTagNumber = a.earTagNumber " +
                 "WHERE a.user_id = ?";
        
        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            //based on user
            pstm.setInt(1, this.user.getId());
            
            try (ResultSet rs = pstm.executeQuery()) {
            
            while (rs.next()) {
                Maintenance maintenance = new Maintenance();
                maintenance.setMaintenanceId(rs.getInt("maintenance_id"));
                maintenance.setEarTagNumber(rs.getString("earTagNumber"));
                maintenance.setVaccinationCheckDate(rs.getDate("vaccinationCheckDate"));
                maintenance.setNailCheckDate(rs.getDate("nailCheckDate"));
                maintenance.setVeterinarianCheckDate(rs.getDate("veterinarianCheckDate"));
                maintenance.setBirthControlDate(rs.getDate("birthControlDate"));
                maintenance.setMatingCheckDate(rs.getDate("matingCheckDate"));
                    
                maintenanceList.add(maintenance); 
                }
            }
        } catch (SQLException ex) { 
            Logger.getLogger(MaintenanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maintenanceList;
    }
    
    public boolean updateMaintenanceDate(int maintenance_id,String earTagNumber ,Date vaccinationCheckDate, Date nailCheckDate, Date veterinarianCheckDate, Date birthControlDate, Date matingCheckDate){
        String sql = "UPDATE Maintenance SET earTagNumber=?, vaccinationCheckDate=?, " +
                 "nailCheckDate=?, veterinarianCheckDate=?, birthControlDate=?, " +
                 "matingCheckDate=? WHERE maintenance_id=?";
        
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            
            pstm.setString(1, earTagNumber);
            pstm.setDate(2, vaccinationCheckDate);
            pstm.setDate(3, nailCheckDate);
            pstm.setDate(4, veterinarianCheckDate);
            pstm.setDate(5, birthControlDate);
            pstm.setDate(6, matingCheckDate);
            pstm.setInt(7, maintenance_id);
            int rows = pstm.executeUpdate();
            
            if(rows > 0) {
                
              return true;  
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MaintenanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // adding maintenance
    public Maintenance addMaintenanceDate(String earTagNumber ,Date vaccinationCheckDate, Date nailCheckDate, Date veterinarianCheckDate, Date birthControlDate, Date matingCheckDate) {
 String sql = "INSERT INTO Maintenance (earTagNumber, vaccinationCheckDate, nailCheckDate, veterinarianCheckDate, birthControlDate, matingCheckDate) VALUES (?, ?, ?, ?, ?, ?)";

        if(maintenanceCheck(earTagNumber)) {
            JOptionPane.showMessageDialog(null, "Bu hayvanın bakım kaydı bulunuyor.");
            return null;
        }
        
        
        try (PreparedStatement pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
           
            pstm.setString(1, earTagNumber);
            pstm.setDate(2, vaccinationCheckDate);
            pstm.setDate(3, nailCheckDate);
            pstm.setDate(4, veterinarianCheckDate);
            pstm.setDate(5, birthControlDate);
            pstm.setDate(6, matingCheckDate);
            
            int affectedRows = pstm.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Bakım olusturma sekteye ugradı.");
            }
            
            try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    Maintenance maintenance = new Maintenance();
                    maintenance.setMaintenanceId(generatedKeys.getInt(1));
                    maintenance.setEarTagNumber(earTagNumber); 
                    maintenance.setVaccinationCheckDate(vaccinationCheckDate);
                    maintenance.setNailCheckDate(nailCheckDate);
                    maintenance.setVeterinarianCheckDate(veterinarianCheckDate);
                    maintenance.setBirthControlDate(birthControlDate);
                    maintenance.setMatingCheckDate(matingCheckDate);
                    return maintenance;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaintenanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean maintenanceCheck(String earTagNumber){
        String sql = "SELECT COUNT(*) FROM Maintenance WHERE earTagNumber = ?";
        
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, earTagNumber);
            
            //checking count(*)
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                return rs.getInt(1) > 0;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MaintenanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean deleteMaintenance(int maintenanceId) {
        String delete_sql = "DELETE FROM Maintenance WHERE maintenance_id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(delete_sql);
            pstm.setInt(1, maintenanceId);
            
            int affected = pstm.executeUpdate();
            if(affected > 0) {
                return true;
            }        
            
        } catch (SQLException ex) {
            Logger.getLogger(MaintenanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
public Maintenance getMaintenanceById(int maintenanceId) {
    String sql = "SELECT * FROM Maintenance WHERE maintenance_id = ?";
    
    try {
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, maintenanceId);
        
        ResultSet rs = pstm.executeQuery();
        if(rs.next()) {
            Maintenance maintenance = new Maintenance();
                maintenance.setMaintenanceId(rs.getInt("maintenance_id"));
                maintenance.setEarTagNumber(rs.getString("earTagNumber"));
                maintenance.setVaccinationCheckDate(rs.getDate("vaccinationCheckDate"));
                maintenance.setNailCheckDate(rs.getDate("nailCheckDate"));
                maintenance.setVeterinarianCheckDate(rs.getDate("veterinarianCheckDate"));
                maintenance.setBirthControlDate(rs.getDate("birthControlDate"));
                maintenance.setMatingCheckDate(rs.getDate("matingCheckDate"));
            
            return maintenance;
        }
    } catch (SQLException ex) {
        Logger.getLogger(MaintenanceDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
    
}