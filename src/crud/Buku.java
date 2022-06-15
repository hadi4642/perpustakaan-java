/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.ResultSet;
import java.sql.*;
import koneksi.KoneksiMysql;


/**
 *
 * @author HP
 */
public class Buku extends Crud{
    private String[] dataBuku;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    private String KategoriQuery;
    
    public Buku() {
        koneksi();
    }
    
    public String[] getDataBuku(){
        return dataBuku;
    }
    
    public void setDataBuku(String[] dataBuku){
        this.dataBuku = dataBuku;
    }

    @Override
    public ResultSet tampilData() {
        CRUDquery = "SELECT * FROM buku INNER JOIN kategori ON buku.kategori_id = kategori.id ORDER BY no_induk_buku DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilKategori() {
        CRUDquery = "SELECT * FROM kategori";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet getIdKategori(String nama) {
        String query = String.format("SELECT id, nama_kategori FROM kategori WHERE nama_kategori = '%s'", nama);
        System.out.println(query);
        CRUDquery = query;
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
        CRUDquery = "INSERT INTO buku VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        CRUDquery = "UPDATE buku SET judul=?, pengarang=?, penerbit=?, kategori_id=?, jumlah=?, tersedia=?, keluar=?, tahun_terbit=?, no_klasifikasi=?, lokasi_buku=? WHERE no_induk_buku=?";
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
        CRUDquery = "DELETE FROM buku WHERE no_induk_buku=?";
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
        CRUDquery = "SELECT * FROM buku INNER JOIN kategori ON buku.kategori_id = kategori.id WHERE no_induk_buku LIKE '%" + data + "%' OR judul LIKE '%" + data + "%' ORDER BY no_induk_buku DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
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
    
}
