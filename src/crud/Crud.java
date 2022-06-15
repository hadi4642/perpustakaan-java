/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.sql.*;
/**
 *
 * @author hadif
 */
public abstract class Crud implements Koneksi{
    
    public abstract ResultSet tampilData();
    public abstract ResultSet simpanData(String data[]);
    public abstract ResultSet ubahData(String data[]);
    public abstract ResultSet hapusData(String id);
    
}
