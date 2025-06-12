/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Core.Database;
import Entity.Animal;
import Entity.Maintenance;
import Entity.Reminder;
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

public class ReminderDao {
    
    private Connection connection;
    
    private User user;
    public ReminderDao(User user){
        connection = Database.getDatabase();
        this.user = user;
                
    }
        //add reminder section 
        //add reminder for animals maintenance dates, 
        //when different dates are entered.
        //check all dates , find different ones. 
    public Reminder addReminderIfNotExist(Maintenance maintenance ,Date date){
            
String sql = "SELECT COUNT(*) FROM Reminder WHERE animalEarTagNumber = ? AND maintenance_id = ?";
        try {
            
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, maintenance.getEarTagNumber());
            pstm.setInt(2, maintenance.getMaintenanceId());
            
            
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next() && rs.getInt(1) == 0){
                String insertSql = "INSERT INTO Reminder (maintenance_id, animalEarTagNumber, phoneNumber, isSent,reminder_date) VALUES (?, ?, ?, ? ,?)";
            try (PreparedStatement new_pstm = connection.prepareStatement(insertSql ,PreparedStatement.RETURN_GENERATED_KEYS)){
                
                new_pstm.setInt(1, maintenance.getMaintenanceId());
                new_pstm.setString(2, maintenance.getEarTagNumber());
                new_pstm.setString(3, this.user.getPhoneNumber());
                new_pstm.setBoolean(4, false);
                
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                
                new_pstm.setDate(5,sqlDate);
                
                int affectedRows = new_pstm.executeUpdate();
                
                if(affectedRows != 0) {
                try (ResultSet generatedKeys = new_pstm.getGeneratedKeys()){
                    if(generatedKeys.next()) {
                        Reminder reminder = new Reminder();
                        reminder.setReminder_id(generatedKeys.getInt(1));
                        reminder.setMaintenance_id(maintenance.getMaintenanceId());
                        reminder.setAnimalEarTagNumber(maintenance.getEarTagNumber());
                        reminder.setPhoneNumber(this.user.getPhoneNumber()); 
                        reminder.setSent(false);
                        reminder.setReminder_date(date);
                        return reminder;
                         
                    } 
                 }
               }   
            } catch (SQLException ex) {
            Logger.getLogger(ReminderDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReminderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }
    
    //update reminder
    public boolean updateReminder (Maintenance maintenance ,Date date ,int maintenance_id) {
        
        String sql = "SELECT COUNT(*) FROM Reminder WHERE animalEarTagNumber = ? AND maintenance_id = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, maintenance.getEarTagNumber());
            pstm.setInt(2, maintenance.getMaintenanceId());
            
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next() && rs.getInt(1) == 1) {
                
                String updateSql = "Update Reminder SET reminder_date = ? where maintenance_id = ? and animalEarTagNumber  = ?";
                PreparedStatement new_pstm = connection.prepareStatement(updateSql);
                new_pstm.setDate(1, date);
                new_pstm.setInt(2, maintenance_id);
                new_pstm.setString(3, maintenance.getEarTagNumber());
                
                int affectedRecord = new_pstm.executeUpdate();
                if(affectedRecord > 0) {
                    return true;
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReminderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
        
        //Check all maintenance dates
        public void checkReminderforDifferentDates() {
        MaintenanceDao maintenanceDao = new MaintenanceDao(this.user);
             List<Maintenance> allMaintenancesRecords = maintenanceDao.getAllMaintenanceRecords();
             for(Maintenance maintenances : allMaintenancesRecords) {
                 checkForEachRecord(maintenances);
             }
         }

       public void checkForEachRecord(Maintenance maintenance) {
         if (maintenance.getVaccinationCheckDate() != null) {
            addReminderIfNotExist(maintenance,maintenance.getVaccinationCheckDate());
        }
        if (maintenance.getNailCheckDate() != null) {
           addReminderIfNotExist(maintenance, maintenance.getNailCheckDate());
        }
        if (maintenance.getVeterinarianCheckDate() != null) {
           addReminderIfNotExist(maintenance,maintenance.getVeterinarianCheckDate());
        }
        if (maintenance.getBirthControlDate() != null) {
           addReminderIfNotExist(maintenance,maintenance.getBirthControlDate());
        }
        if (maintenance.getMatingCheckDate() != null) {
            addReminderIfNotExist(maintenance,maintenance.getMatingCheckDate());
        }
        
       }  
       
      //add reminder section ^^^^ 
     
       public List<Reminder> getAllReminderRecords() {
           
         List<Reminder> reminders = new ArrayList<>();
         String sql = "SELECT * FROM Reminder";
         
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()) { 
            Reminder reminder = new Reminder();
            reminder.setReminder_id(rs.getInt("reminder_id"));
            reminder.setMaintenance_id(rs.getInt("maintenance_id"));
            reminder.setAnimalEarTagNumber(rs.getString("animalEarTagNumber"));
            reminder.setPhoneNumber(rs.getString("phoneNumber"));
            reminder.setSent(rs.getBoolean("isSent"));
            reminder.setReminder_date(rs.getDate("reminder_date"));
                   
            
            reminders.add(reminder);
            }
            return  reminders; 
            
        } catch (SQLException ex) {
            Logger.getLogger(ReminderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
           
       }
       
    
}
