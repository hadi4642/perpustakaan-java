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
public class Laporan_Peminjaman extends Crud{
    
    private String[] dataLPeminjaman;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public Laporan_Peminjaman() {
        koneksi();
    }
    
    public String[] getDataPeminjaman(){
        return dataLPeminjaman;
    }
    
    public void setDataPeminjaman(String[] dataLPeminjaman){
        this.dataLPeminjaman = dataLPeminjaman;
    }
    
    public ResultSet cariData(String data) {
        CRUDquery = "SELECT * FROM peminjaman INNER JOIN anggota ON peminjaman.nim = anggota.nim WHERE no_peminjaman LIKE '%" + data + "%' OR peminjaman.nim LIKE '%" + data + "%' ORDER BY no_peminjaman DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
//    public ResultSet hitungData() {
//        CRUDquery = "SELECT COUNT(*) FROM peminjaman";
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
        CRUDquery = "SELECT * FROM peminjaman INNER JOIN anggota ON peminjaman.nim = anggota.nim ORDER BY no_peminjaman DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;}

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
