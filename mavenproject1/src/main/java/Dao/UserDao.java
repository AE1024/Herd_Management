/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Core.Database;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elmaz
 */
public class UserDao {
    private Connection connection;

    public UserDao() {
        connection = Database.getDatabase();
    }

    //find with login
    public User findbyLogin(String name ,String phoneNumber, String password ){
        User user = new User();
        String sql = "Select * from User where name = ? and phoneNumber = ? and password = ?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setString(2, phoneNumber);
            pstm.setString(3, password);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                user = this.matchUser(rs);
                return user;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    } 
    
    //Finding all
    public ArrayList<User> findAllUsers(){
            String sql = "Select * from User";
            ArrayList<User> users = new ArrayList<>();        
        try {
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                users.add(this.matchUser(rs));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    
    }
    
    //check for matching
    public User matchUser(ResultSet rs) throws SQLException{
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPhoneNumber(rs.getString("phoneNumber"));
        user.setPassword(rs.getString("password"));
        return user;
        
    }
    
    //adding user
 public User addUser(String name, String phoneNumber, String password) {
    String sql = "INSERT INTO User (name, phoneNumber, password) VALUES (?, ?, ?)";
    
    try (PreparedStatement pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
        pstm.setString(1, name);
        pstm.setString(2, phoneNumber);
        pstm.setString(3, password);
         
        int affectedRows = pstm.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Kullanıcı eklenemedi.");
        }
        
        try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                User user = new User();
                user.setId(generatedKeys.getInt(1));
                user.setName(name);
                user.setPhoneNumber(phoneNumber);
                user.setPassword(password);
                return user;
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
}
