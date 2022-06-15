/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.*;
import koneksi.KoneksiMysql;
import javax.swing.table.DefaultTableModel;


public class TransaksiPeminjaman extends Crud {
    private String[] dataPeminjaman;
    private String no_peminjaman, nim, tanggal_pinjam, batas_pengembalian;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public TransaksiPeminjaman() {
        koneksi();
    }
    
    public String[] getDataPeminjaman(){
        return dataPeminjaman;
    }
    
    public void setDataPeminjaman(String[] dataPeminjaman){
        this.dataPeminjaman = dataPeminjaman;
    }

    @Override
    public ResultSet tampilData() {
        CRUDquery = "SELECT * FROM peminjaman ORDER BY no_peminjaman DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilAnggota() {
        CRUDquery = "SELECT * FROM Anggota ORDER BY nim DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public boolean checkAnggota(String nim) {
        boolean tanggunan_peminjaman = false;
        try {
            ResultSet re= conn.createStatement().executeQuery("SELECT * FROM peminjaman WHERE nim = '"+nim+"'");
            while(re.next()){
                ResultSet re1= conn.createStatement().executeQuery("SELECT * FROM detail_peminjaman WHERE no_peminjaman = '"+re.getString("no_peminjaman")+"' AND status ='Dipinjam'");
                if(re1.next()){
                    tanggunan_peminjaman = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tanggunan_peminjaman;
    }
    
    
    public ResultSet tampilBuku() {
        CRUDquery = "SELECT * FROM Buku ORDER BY no_induk_buku DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet getAnggotaByNim(String nim) {
        CRUDquery = "SELECT * FROM Anggota where nim= '"+nim+"' ";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet getBukuByNo(String no) {
        CRUDquery = "SELECT * FROM Buku where no_induk_buku= '"+no+"' ";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public String penomoranOtomatis(){
        CRUDquery = "SELECT count(*) as total FROM peminjaman";
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
        return "PJM-" + total;
    }

    @Override
    public ResultSet simpanData(String data[]) {
        CRUDquery = "INSERT INTO Peminjaman VALUES (?, ?, ?, ?, ?)";
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
    
    public ResultSet simpanDataDetail(String no_peminjaman, DefaultTableModel table, int jumlah_data) {
        try {
            for(int i=0;i<jumlah_data;i++){
                conn.createStatement().executeUpdate("INSERT INTO detail_peminjaman VALUES ('"+no_peminjaman+"','"+table.getValueAt(i, 0)+"','Dipinjam')");
                CRUDpsmt.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet updateStokBuku(DefaultTableModel table, int jumlah_data) {
        try {
            int tersedia = 0;
            int keluar = 0;
            int jumlah_buku = 0;
            for(int i=0;i<jumlah_data;i++){
                ResultSet re = conn.createStatement().executeQuery("SELECT * FROM buku WHERE no_induk_buku = '"+table.getValueAt(i, 0)+"'");
                while(re.next()){
                    jumlah_buku = Integer.parseInt(re.getString("jumlah"));
                    keluar = Integer.parseInt(re.getString("keluar")) + 1;
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

    @Override
    public ResultSet ubahData(String[] data) {
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

    @Override
    public ResultSet hapusData(String no_peminjaman) {
        CRUDquery = "DELETE FROM Peminjaman WHERE no_peminjaman=?";
        try {
            CRUDpsmt = conn.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, no_peminjaman);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet cariData(String data) {
        CRUDquery = "SELECT * FROM Peminjaman WHERE no_peminjaman LIKE '%" + data + "%' OR nim LIKE '%" + data + "%' ORDER BY no_peminjaman DESC";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    
}
