/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hadif
 */

public class KoneksiMysql {
    private Connection connect;
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String jdbc = "jdbc:mysql://";
    private String host = "localhost:";
    private String port = "3306/";
    private String database = "perpustakaan";
    private String url = jdbc + host + port + database;
    private String username = "root";
    private String password = "";
    
    public Connection getKoneksi() throws SQLException {
        if (connect == null) {
            try {
                Class.forName(driverName);
                System.out.println("Class Driver ditemukan");
                
                try {                                                                                                                                                                                
                    connect = DriverManager.getConnection(url, username, password);
                    System.out.println("Koneksi Database Sukses");
                } catch (SQLException e) {
                    System.out.println("Koneksi Database Gagal : " + e);
                    System.exit(0);
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Class Driver tidak ditemukan, Terjadi kesalahan pada : " + e);
                System.exit(0);
            }
        }
        return connect;
    }
}
