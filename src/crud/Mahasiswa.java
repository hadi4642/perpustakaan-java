/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.*;
import koneksi.KoneksiMysql;

/**
 *
 * @author hadif
 */
public class Mahasiswa extends Crud {
    private String[] dataMahasiswa;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public Mahasiswa() {
        koneksi();
    }
    
    public String[] getDataMahasiswa(){
        return dataMahasiswa;
    }
    
    public void setDataMahasiswa(String[] dataMahasiswa){
        this.dataMahasiswa = dataMahasiswa;
    }

    @Override
    public ResultSet tampilData() {
        CRUDquery = "SELECT * FROM mahasiswa ORDER BY nim DESC";
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
        CRUDquery = "INSERT INTO mahasiswa VALUES (?, ?, ?, ?)";
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
                CRUDquery = "UPDATE mahasiswa SET nama=?, jenis_kelamin=?, alamat=? WHERE nim=?";
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
        CRUDquery = "DELETE FROM mahasiswa WHERE nim=?";
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
        CRUDquery = "SELECT * FROM mahasiswa WHERE nim LIKE '%" + data + "%' OR nama LIKE '$" + data + "%' ORDER BY nim DESC";
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
