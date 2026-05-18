/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import connection.DBConnection;
import model.mahasiswa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lab Informatika
 */
public class mahasiswaController {
    public List<mahasiswa> getAllmahasiswa(){
        List<mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa ORDER BY id";
        Connection conn = DBConnection.getConnection();
        if(conn == null) {
            return null;
        }
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                list.add(new mahasiswa(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("angkatan")
                ));
            }
        } catch (SQLException e) {
            System.err.println("ERROR getAllmahasiswa: " + e.getMessage());
        }
        return list;
    }
    
    public boolean hapusMahasiswa(int id){
        String sql = "DELETE FROM mahasiswa WHERE id=?";
        Connection conn = DBConnection.getConnection();
        if(conn == null) {
            return false;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("ERROR hapusMahasiswa: " + e.getMessage());
            return false;
        }
    }
    
    public boolean tambahMahasiswa(mahasiswa m){
        String sql = "INSERT INTO mahasiswa (nama, nim, angkatan) VALUES (?,?,?)";
        Connection conn = DBConnection.getConnection();
        if(conn == null) {
            return false;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, m.getNama());
            ps.setString(2, m.getNim());
            ps.setString(3, m.getAngkatan());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("ERROR tambahMahasiswa: " + e.getMessage());
            return false;
        }
    }
    
    public boolean editMahasiswa(mahasiswa m){
        String sql = "UPDATE mahasiswa SET nama=?, nim=?, angkatan=? WHERE id=?";
        Connection conn = DBConnection.getConnection();
        if(conn == null) {
            return false;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, m.getNama());
            ps.setString(2, m.getNim());
            ps.setString(3, m.getAngkatan());
            ps.setInt(4, m.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("ERROR editMahasiswa: " + e.getMessage());
            return false;
        }
    }
}
