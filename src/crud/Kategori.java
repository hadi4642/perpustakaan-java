/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.*;
import koneksi.KoneksiMysql;


public class Kategori extends Crud {
    private String[] dataKategori;
    private String id, nama_kategori;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public Kategori() {
        koneksi();
    }
    
    public String[] getDataKategori(){
        return dataKategori;
    }
    
    public void setDataKategori(String[] dataKategori){
        this.dataKategori = dataKategori;
    }

    @Override
    public ResultSet tampilData() {
        CRUDquery = "SELECT * FROM kategori ORDER BY id DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public String penomoranOtomatis(){
        CRUDquery = "SELECT count(*) as total FROM kategori";
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
        return "K" + total;
    }

    @Override
    public ResultSet simpanData(String data[]) {
        CRUDquery = "INSERT INTO kategori VALUES (?, ?)";
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
                CRUDquery = "UPDATE kategori set nama_kategori=? WHERE id=?";
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
    public void koneksi() {
        try {
            KoneksiMysql connection = new KoneksiMysql();
            conn = connection.getKoneksi();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public ResultSet hapusData(String id) {
        CRUDquery = "DELETE FROM kategori WHERE id=?";
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
        CRUDquery = "SELECT * FROM kategori WHERE id LIKE '%" + data + "%' OR nama_kategori LIKE '%" + data + "%' ORDER BY id DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    
}
