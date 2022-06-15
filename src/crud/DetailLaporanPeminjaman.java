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
public class DetailLaporanPeminjaman extends Crud {
    private String[] dataDetailLaporanPeminjaman;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public String[] getDataDetailLaporanPeminjaman(){
        return dataDetailLaporanPeminjaman;
    }
    
    public void setDataDetailLaporanPeminjaman(String[] dataDetailLaporanPeminjaman){
        this.dataDetailLaporanPeminjaman = dataDetailLaporanPeminjaman;
    }
    
    public DetailLaporanPeminjaman(){
        koneksi();
    }
    
    public ResultSet tampilDataPeminjaman(String no) {
        CRUDquery = "SELECT * FROM peminjaman INNER JOIN anggota ON peminjaman.nim=anggota.nim WHERE peminjaman.no_peminjaman='"+no+"'";
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
        CRUDquery = "SELECT * FROM peminjaman";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilDataDetail(String no) {
            CRUDquery = "SELECT * FROM detail_peminjaman INNER JOIN peminjaman on detail_peminjaman.no_peminjaman=peminjaman.no_peminjaman INNER JOIN buku ON detail_peminjaman.no_induk_buku=buku.no_induk_buku WHERE detail_peminjaman.no_peminjaman = '"+no+"'";
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
