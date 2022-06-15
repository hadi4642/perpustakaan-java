/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.*;
import koneksi.KoneksiMysql;
import java.sql.ResultSet;

/**
 *
 * @author hadif
 */
public class Pengguna extends Crud {
    private String[] dataPengguna;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public Pengguna() {
        koneksi();
    }
    
    public String[] getDataPengguna(){
        return dataPengguna;
    }
    
    public void setDataPengguna(String[] dataPengguna){
        this.dataPengguna = dataPengguna;
    }

    @Override
    public ResultSet tampilData() {
        CRUDquery = "SELECT * FROM pengguna ORDER BY id DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    @Override
    public ResultSet simpanData(String data[]) {
        CRUDquery = "INSERT INTO pengguna VALUES (?, ?, ?, ?, ?, ?)";
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
        CRUDquery = "UPDATE pengguna SET nama_pengguna=?, username=?, password=?, no_telp=?, alamat=? WHERE id=?";
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
        CRUDquery = "DELETE FROM pengguna WHERE id=?";
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
    
    public ResultSet cariData(String data) {
        CRUDquery = "SELECT * FROM pengguna WHERE nama_pengguna LIKE '%" + data + "%' OR username LIKE '$" + data + "%' ORDER BY id DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public String penomoranOtomatis(){
        CRUDquery = "SELECT count(*) as total FROM pengguna";
        int total = 1;
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
            while (CRUDhasil.next()){
                total = Integer.parseInt(CRUDhasil.getString("total"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        total++;
        return "P" + total;
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
