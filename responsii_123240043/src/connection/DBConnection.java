/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lab Informatika
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/responsi_pbo_b";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private static Connection connection = null;
    public static Connection getConnection() {
        try{
            if(connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        }catch (ClassNotFoundException e) {
            System.err.println("DRIVER MYSQL TIDAK DITEMUKAN: " + e.getMessage());
        }catch (SQLException e) {
            System.err.println("GAGAL KONEKSI KE DATABASE: " + e.getMessage());
        }
        return connection;
    }
    
    public static void closeConnection(){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch (SQLException e){
            System.err.println("GAGAL MENUTUP KONEKSI: " + e.getMessage());
        }
    }
}
