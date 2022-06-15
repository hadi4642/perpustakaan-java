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
import javax.swing.table.DefaultTableModel;
import koneksi.KoneksiMysql;

/**
 *
 * @author ACER
 */
public class TransaksiPengembalian extends Crud{
    private String[] dataTransaksiPengembalian;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public TransaksiPengembalian() {
        koneksi();
    }
    
    public String[] getDataTransaksiPengembalian(){
        return dataTransaksiPengembalian;
    }
    
    public void setDataTransaksiPengembalian(String[] dataTransaksiPengembalian){
        this.dataTransaksiPengembalian = dataTransaksiPengembalian;
    }

    @Override
    public ResultSet tampilData() {
        CRUDquery = "SELECT * FROM peminjaman INNER JOIN anggota ON peminjaman.nim = anggota.nim INNER JOIN pengembalian ON peminjaman.no_peminjaman=pengembalian.no_peminjaman;";
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
        CRUDquery = "INSERT INTO pengembalian VALUES (?, ?, ?, ?)";
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
    
    public ResultSet simpanDataDetail(String no_peminjaman, DefaultTableModel table, int jumlah_data, String tgl_kembali) {
        try {
            for(int i=0;i<jumlah_data;i++){
                conn.createStatement().executeUpdate("INSERT INTO detail_pengembalian VALUES ('"+no_peminjaman+"','"+table.getValueAt(i, 0)+"','"+tgl_kembali+"','"+table.getValueAt(i, 5)+"')");
                CRUDpsmt.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilNoPeminjaman(){
        CRUDquery = "SELECT * FROM peminjaman";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet getNoPeminjaman(String nomor){
        CRUDquery = "SELECT * FROM peminjaman INNER JOIN anggota ON peminjaman.nim = anggota.nim where no_peminjaman = '"+nomor+"'";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilDataPeminjaman(String no_peminjaman){
        CRUDquery = "SELECT * FROM peminjaman WHERE no_peminjaman = '"+no_peminjaman+"' ";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilDataAnggota(String nim){
        CRUDquery = "SELECT * FROM anggota WHERE nim = '"+nim+"'";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    
    public ResultSet tampilNoIndukBuku(String no_peminjaman){
        CRUDquery = "SELECT * FROM detail_peminjaman WHERE no_peminjaman = '"+no_peminjaman+"' AND status = 'Dipinjam' ";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilDetailBuku(Object nib){
        CRUDquery = "SELECT * FROM buku WHERE no_induk_buku= '"+nib+"'";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    public ResultSet tampilDenda(){
        CRUDquery = "SELECT * FROM denda";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet updateBuku(DefaultTableModel table, int jumlah_data){
        try {
            int tersedia = 0;
            int keluar = 0;
            int jumlah_buku = 0;
            for(int i=0;i<jumlah_data;i++){
                ResultSet re = conn.createStatement().executeQuery("SELECT * FROM buku WHERE no_induk_buku = '"+table.getValueAt(i, 0)+"'");
                while(re.next()){
                    jumlah_buku = Integer.parseInt(re.getString("jumlah"));
                    keluar = Integer.parseInt(re.getString("keluar")) - 1;
                    tersedia = jumlah_buku - keluar;
                }
                
                conn.createStatement().executeUpdate("UPDATE buku SET jumlah='"+jumlah_buku+"',tersedia='"+tersedia+"',keluar='"+keluar+"' "
                + "WHERE no_induk_buku = '"+table.getValueAt(i, 0)+"'");
                CRUDpsmt.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet updateStatus(DefaultTableModel table, int jumlah_data, Object no_peminjaman){
        try {
            for(int i=0;i<jumlah_data;i++){
                conn.createStatement().executeUpdate("UPDATE detail_peminjaman SET status='Kembali' WHERE no_induk_buku = '"+table.getValueAt(i, 0)+"' AND no_peminjaman = '"+no_peminjaman+"'");
                CRUDpsmt.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
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
