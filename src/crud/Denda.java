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
public class Denda extends Crud {
    private String[] dataDenda;
    private Connection conn;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public String tampilDenda(){
        CRUDquery = "SELECT jumlah FROM denda";
        String nominal = "0";
        try {
            CRUDstat = conn.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
            while(CRUDhasil.next()){
                nominal = CRUDhasil.getString("jumlah");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return nominal;
    }
    
    public Denda() {
        koneksi();
    }
    
    public String[] getDataDenda(){
        return dataDenda;
    }
    
    public void setDataDenda(String[] dataDenda){
        this.dataDenda = dataDenda;
    }

    @Override
    public ResultSet tampilData() {
        CRUDquery = "SELECT * FROM denda";
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
        CRUDquery = "UPDATE denda SET jumlah=?";
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
