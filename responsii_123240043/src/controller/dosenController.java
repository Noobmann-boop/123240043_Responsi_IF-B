/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import connection.DBConnection;
import model.dosen;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lab Informatika
 */
public class dosenController {
    public List<dosen> getAlldosen(){
        List<dosen> list = new ArrayList<>();
        String sql = "SELECT * FROM dosen ORDER BY id";
        Connection conn = DBConnection.getConnection();
        if(conn == null) {
            return null;
        }
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                list.add(new dosen(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("nidn")
                ));
            }
        } catch (SQLException e) {
            System.err.println("ERROR getAlldosen: " + e.getMessage());
        }
        return list;
    }
    
    public boolean hapusDosen(int id){
        String sql = "DELETE FROM dosen WHERE id=?";
        Connection conn = DBConnection.getConnection();
        if(conn == null) {
            return false;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("ERROR hapusDosen: " + e.getMessage());
            return false;
        }
    }
    
    public boolean tambahDosen(dosen d){
        String sql = "INSERT INTO dosen (nama, nidn) VALUES (?,?)";
        Connection conn = DBConnection.getConnection();
        if(conn == null) {
            return false;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, d.getNama());
            ps.setString(2, d.getNidn());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("ERROR tambahDosen: " + e.getMessage());
            return false;
        }
    }
    
    public boolean editDosen(dosen d){
        String sql = "UPDATE dosen SET nama=?, nidn=? WHERE id=?";
        Connection conn = DBConnection.getConnection();
        if(conn == null) {
            return false;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, d.getNama());
            ps.setString(2, d.getNidn());
            ps.setInt(3, d.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("ERROR editDosen: " + e.getMessage());
            return false;
        }
    }
}
