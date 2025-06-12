/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Core.Database;
import Entity.Animal;
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


/**
 *
 * @author elmaz
 */
public class AnimalDao {
    
    private Connection connection;
    private User user;
    public AnimalDao(User user) {
        connection = Database.getDatabase();
        this.user = user;
    }
     
        //Finding all
    public List<Animal> findAllAnimalsByUserId(){
            String sql = "Select * from Animal where user_id = ?";
            List<Animal> animals = new ArrayList<>();        
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1 ,this.user.getId());
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                animals.add(this.matchAnimal(rs));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return animals;
    
    }
    
    //check for matching
    public Animal matchAnimal(ResultSet rs) throws SQLException{
        Animal animal = new Animal();
        
        animal.setEarTagNumber(rs.getString("earTagNumber"));
        animal.setUser_id(rs.getInt("user_id"));
        animal.setParentEarTagNumber(rs.getString("parentEarTagNumber"));
        animal.setType(rs.getString("type"));
        animal.setBreed(rs.getString("breed"));
        animal.setBirthDate(rs.getDate("birthDate"));
        animal.setGender(rs.getString("gender"));
        animal.setWeight(rs.getFloat("weight"));
        animal.setHasOffspring(rs.getBoolean("hasOffspring"));
     
        return animal;
        
    }
    
       //adding animal
public Animal addAnimal(String earTagNumber,int user_id,String parentEarTagNumber,String type,String breed,Date birthDate,String gender,float weight,boolean hasOffspring) {
    String sql = "Insert into Animal (earTagNumber,user_id,parentEarTagNumber,type,breed,birthDate,gender,weight,hasOffspring)"
          + " Values (?,?,?,?,?,?,?,?,?)";  
        
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, earTagNumber);
            pstm.setInt(2, user_id);
            pstm.setString(3, parentEarTagNumber);
            pstm.setString(4, type);
            pstm.setString(5, breed);
            pstm.setDate(6, birthDate);
            pstm.setString(7, gender);
            pstm.setFloat(8, weight);
            pstm.setBoolean(9, hasOffspring);
           
            int affectedRow = pstm.executeUpdate();
            if(affectedRow == 0) {
                throw new SQLException("Hayvan eklenemedi !");
            }
        
            Animal animal = new Animal();
            animal.setEarTagNumber(earTagNumber);
            animal.setUser_id(user_id);
            animal.setParentEarTagNumber(parentEarTagNumber);
            animal.setType(type);
            animal.setBreed(breed);
            animal.setBirthDate(birthDate);
            animal.setGender(gender);
            animal.setWeight(weight);
            animal.setHasOffspring(hasOffspring);
            
            return animal;
        
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
  }


    
    //get all ear Tags for comboBox
    public List<String> getEarTagsByUserId () {
        String sql = "Select earTagNumber from Animal where user_id = ?";
        List<String> earTagNumbers = new ArrayList<>();
        try {
            // getting animals based on user
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, this.user.getId());//each user
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                earTagNumbers.add(rs.getString("earTagNumber"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return earTagNumbers;
        
    }
    
    public boolean  deleteAnimal(String earTagNo) {
                String delete_sql = "DELETE FROM Animal WHERE earTagNumber = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(delete_sql);
            pstm.setString(1, earTagNo);
            
            int affected = pstm.executeUpdate();
            if(affected > 0) {
                return true;
            }        
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
        //get all ear Tags for comboBox
    public List<String> getAllUserEarTags () {
        String sql = "Select earTagNumber from Animal where user_id = ?";
        List<String> earTagNumbers = new ArrayList<>();
        try {
            // getting animals based on user
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, this.user.getId());//each user
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                earTagNumbers.add(rs.getString("earTagNumber"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return earTagNumbers;
        
    }

}
