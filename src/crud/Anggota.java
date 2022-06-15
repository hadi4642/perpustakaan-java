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
 * @author ACER
 */
public class Anggota extends Crud {
    private String[] dataAnggota;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public Anggota() {
        koneksi();
    }
    
    public String[] getDataAnggota(){
        return dataAnggota;
    }
    
    public void setDataAnggota(String[] dataAnggota){
        this.dataAnggota = dataAnggota;
    }
    
    @Override
    public ResultSet tampilData() {
        CRUDquery = "SELECT * FROM anggota ORDER BY nim ASC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    @Override
    public ResultSet simpanData(String[] data) {
        CRUDquery = "INSERT INTO anggota VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            CRUDpsmt = conn.prepareStatement(CRUDquery);
            for (int i = 1; i <= data.length; i++) {
                CRUDpsmt.setString(i, data[i-1]);
            }
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    @Override
    public ResultSet ubahData(String[] data) {
        CRUDquery = "UPDATE anggota SET nama_anggota=?, tempat_lahir=?, tanggal_lahir=?, jenis_kelamin=?, no_telp=?, alamat=? WHERE nim=?";
        try {
            CRUDpsmt = conn.prepareStatement(CRUDquery);
            for (int i = 1; i <= data.length; i++) {
                CRUDpsmt.setString(i, data[i-1]);
            }
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    @Override
    public ResultSet hapusData(String id) {
        CRUDquery = "DELETE FROM anggota WHERE nim=?";
        try {
            CRUDpsmt = conn.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
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
    
    public ResultSet cariData(String data) {
        CRUDquery = "SELECT * FROM anggota WHERE nim LIKE '%" + data + "%' OR nama_anggota LIKE '$" + data + "%' ORDER BY nim ASC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
}
