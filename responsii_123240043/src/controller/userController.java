/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import connection.DBConnection;
import model.users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lab Informatika
 */
public class userController {
    public users login(String username, String password){
        if (username == null || username.trim().isEmpty()){
            return null;
        }
        if (password == null || password.trim().isEmpty()){
            return null;
        }
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        Connection conn = DBConnection.getConnection();
        
        if(conn == null){
            return null;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, username.trim());
            ps.setString(2, password.trim());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                return new users (rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            System.err.println("ERROR LOGIN: " + e.getMessage());
        }
        return null;
    }
}
