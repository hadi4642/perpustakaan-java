/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import koneksi.KoneksiMysql;

/**
 *
 * @author hadif
 */
public class Login extends Crud {
    private String[] dataPengguna;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public Login() {
        koneksi();
    }
    
    public String[] getDataPengguna(){
        return dataPengguna;
    }
    
    public void setDataPengguna(String[] dataPengguna){
        this.dataPengguna = dataPengguna;
    }
    
    public ResultSet cekLogin(String username, String password){
        CRUDquery = "SELECT * FROM pengguna WHERE username = '"+username+"' and password = '"+password+"'";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    @Override
    public ResultSet tampilData() {
        return null;
    }

    @Override
    public ResultSet simpanData(String[] data) {
        return null;
    }

    @Override
    public ResultSet ubahData(String[] data) {
        return null;
    }

    @Override
    public ResultSet hapusData(String id) {
        return null;
    }

    @Override
    public void koneksi() {
        try {
            KoneksiMysql connection = new KoneksiMysql();
            conn = connection.getKoneksi();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
