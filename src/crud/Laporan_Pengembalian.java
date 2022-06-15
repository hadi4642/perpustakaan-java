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
public class Laporan_Pengembalian extends Crud{
    
    private String[] dataLPengembalian;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public Laporan_Pengembalian() {
        koneksi();
    }
    
    public String[] getDataPengembalian(){
        return dataLPengembalian;
    }
    
    public void setDataPengembalian(String[] dataLPengembalian){
        this.dataLPengembalian = dataLPengembalian;
    }
    
    public ResultSet cariData(String data) {
        CRUDquery = "SELECT * FROM pengembalian INNER JOIN anggota ON pengembalian.nim = anggota.nim INNER JOIN peminjaman ON peminjaman.no_peminjaman=pengembalian.no_peminjaman WHERE pengembalian.no_peminjaman LIKE '%" + data + "%' OR pengembalian.nim LIKE '%" + data + "%' ORDER BY pengembalian.no_peminjaman DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
//    public ResultSet hitungData() {
//        CRUDquery = "SELECT COUNT(*) FROM pengembalian";
//        try {
//            CRUDstat = conn.createStatement();
//            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return CRUDhasil;
//    }
    
    

    @Override
    public ResultSet tampilData() {
        CRUDquery = "SELECT * FROM pengembalian INNER JOIN anggota ON pengembalian.nim = anggota.nim INNER JOIN peminjaman ON pengembalian.no_peminjaman=peminjaman.no_peminjaman";
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

    public void koneksi() {
         try {
            KoneksiMysql connection = new KoneksiMysql();
            conn = connection.getKoneksi();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
