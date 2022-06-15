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
public class DetailLaporanPengembalian extends Crud {
    private String[] dataDetailLaporanPengembalian;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public String[] getDataDetailLaporanPengembalian(){
        return dataDetailLaporanPengembalian;
    }
    
    public void setDataDetailLaporanPengembalian(String[] dataDetailLaporanPengembalian){
        this.dataDetailLaporanPengembalian = dataDetailLaporanPengembalian;
    }
    
    public DetailLaporanPengembalian(){
        koneksi();
    }
    
    public ResultSet tampilDataPeminjaman(String no) {
        CRUDquery = "SELECT * FROM pengembalian INNER JOIN anggota ON pengembalian.nim=anggota.nim INNER JOIN peminjaman ON pengembalian.no_peminjaman=peminjaman.no_peminjaman WHERE pengembalian.no_peminjaman='"+no+"'";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilDataDetail(String no) {
            CRUDquery = "SELECT * FROM detail_pengembalian INNER JOIN buku on buku.no_induk_buku = detail_pengembalian.no_induk_buku INNER JOIN peminjaman on peminjaman.no_peminjaman = detail_pengembalian.no_peminjaman WHERE detail_pengembalian.no_peminjaman = '"+no+"'";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ResultSet tampilData() {
        CRUDquery = "SELECT * FROM pengembalian";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    @Override
    public ResultSet ubahData(String[] data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet hapusData(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
