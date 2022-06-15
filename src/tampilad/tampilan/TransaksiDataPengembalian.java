/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import crud.TransaksiPengembalian;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ACER
 */
public class TransaksiDataPengembalian extends javax.swing.JFrame {
    private final DefaultTableModel tabMode;
    private ResultSet hasil;
    private ResultSet hasil2;
    private ResultSet hasil3;
    
    TransaksiPengembalian crud = new TransaksiPengembalian();
    
    public TransaksiDataPengembalian() {
        initComponents();
//        tampilDatabase();
        tampilNoPeminjaman();
                String[] judul={"No Induk Buku", "Judul Buku", "Pengarang", "Batas Pengembalian", "Tanggal Kembali", "Denda"};
        tabMode = new DefaultTableModel(judul,0);
        table_transaksi_pengembalian.setModel(tabMode);
    }
    
//    public void tampilDatabase() {
//        Object[] baris = {"No Induk Buku", "Judul Buku", "Pengarang", "Batas Pengembalian", "Tanggal Kembali", "Denda"}; 
//        tabMode = new DefaultTableModel(null, baris); 
//        table_transaksi_pengembalian.setModel(tabMode);
//            try {
//               hasil = crud.tampilData();
//                while (hasil.next()){
//                    String[] data = {
//                        hasil.getString("nim"),
//                        hasil.getString("tanggal_kembali"),
//                        hasil.getString("total_denda")
//                    };
//                    crud.setDataTransaksiPengembalian(data);
//                    tabMode.addRow(crud.getDataTransaksiPengembalian());
//                }
//            } catch (Exception e) {
//            }      
//    }
    
    public void resetText() { 
        cb_no_peminjaman.setSelectedItem("-"); 
        txt_nim.setText(""); 
        txt_nama_anggota.setText("");
        txt_no_telepon.setText("");
        cb_no_induk_buku.setSelectedItem("-");
        txt_judul_buku.setText("");
        txt_pengarang.setText("");
        txt_batas_pengembalian.setText("");
        txt_tanggal_kembali.setText("");
        txt_denda.setText("");
        txt_total_denda.setText("");
        int data = table_transaksi_pengembalian.getRowCount();
        for(int i=0;i<data;i++){
            tabMode.removeRow(0);
        }
    }
    
    public void tampilNoPeminjaman() {
        try {
           hasil = crud.tampilNoPeminjaman();
            while (hasil.next()){
                cb_no_peminjaman.addItem(hasil.getString(1));
            }
        } catch (Exception e) {

        }      
    }
   
    /**
     * Creates new form transaksi_data_pengembalian
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_judul_buku = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        txt_nama_anggota = new javax.swing.JTextField();
        txt_no_telepon = new javax.swing.JTextField();
        txt_total_denda = new javax.swing.JTextField();
        txt_pengarang = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_batas_pengembalian = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btn_keluar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_tanggal_kembali = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_denda = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_transaksi_pengembalian = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        cb_no_peminjaman = new javax.swing.JComboBox<>();
        cb_no_induk_buku = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("No Induk Buku");

        jLabel8.setText("Judul Buku");

        jLabel9.setText("Pengarang");

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_reset.setText("Refresh");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        txt_judul_buku.setEditable(false);
        txt_judul_buku.setColumns(20);
        txt_judul_buku.setRows(5);
        jScrollPane1.setViewportView(txt_judul_buku);

        jLabel10.setText("No Telepon");

        txt_nama_anggota.setEditable(false);
        txt_nama_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nama_anggotaActionPerformed(evt);
            }
        });

        txt_no_telepon.setEditable(false);

        txt_pengarang.setEditable(false);

        jLabel11.setText("Batas Pengembalian");

        txt_batas_pengembalian.setEditable(false);

        jLabel12.setText("Tanggal Kembali");

        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        jLabel13.setText("Denda");

        jLabel1.setText("Total Denda");

        txt_tanggal_kembali.setEditable(false);

        jLabel2.setText("NIM");

        jLabel3.setText("Nama Anggota");

        txt_denda.setEditable(false);

        table_transaksi_pengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No Induk Buku", "Judul Buku", "Pengarang", "Batas Pengembalian", "Tanggal Kembali", "Denda"
            }
        ));
        table_transaksi_pengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_transaksi_pengembalianMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_transaksi_pengembalian);

        jLabel4.setText("No. Peminjaman");

        txt_nim.setEditable(false);

        cb_no_peminjaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cb_no_peminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_no_peminjamanActionPerformed(evt);
            }
        });

        cb_no_induk_buku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cb_no_induk_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_no_induk_bukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_no_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_tambah))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btn_simpan)
                                .addGap(32, 32, 32)
                                .addComponent(btn_hapus)
                                .addGap(33, 33, 33)
                                .addComponent(btn_reset)
                                .addGap(33, 33, 33)
                                .addComponent(btn_keluar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_total_denda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_no_peminjaman, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_nama_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_no_induk_buku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane1)
                                            .addComponent(txt_pengarang))))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_denda, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(txt_tanggal_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(24, 24, 24)
                                        .addComponent(txt_batas_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_batas_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_no_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_no_induk_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_nim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nama_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_no_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_tanggal_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_denda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_tambah)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total_denda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_hapus)
                    .addComponent(btn_reset)
                    .addComponent(btn_keluar))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        int data = table_transaksi_pengembalian.getRowCount();
        if(data == 0){
            JOptionPane.showMessageDialog(null, "Lengkapi Data Pengembalian Terlebih Dahulu !");
        }else{
            try {
                SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
                Date tanggal_sekarang = new Date();
                String[] setData = {
                    cb_no_peminjaman.getSelectedItem().toString(),
                    cb_no_induk_buku.getSelectedItem().toString(),
                    sdfdate.format(tanggal_sekarang),
                    txt_total_denda.getText(),
                };
                crud.setDataTransaksiPengembalian(setData);
                crud.simpanData(crud.getDataTransaksiPengembalian());
                crud.simpanDataDetail(cb_no_peminjaman.getSelectedItem().toString(), tabMode, data, sdfdate.format(tanggal_sekarang));
                crud.updateBuku(tabMode, table_transaksi_pengembalian.getRowCount());
                crud.updateStatus(tabMode, data, cb_no_peminjaman.getSelectedItem());
                resetText();
                JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                
            }
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        resetText();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int tabel_data = table_transaksi_pengembalian.getSelectedRow();        
        if(String.valueOf(tabel_data).equals("-1")){
            JOptionPane.showMessageDialog(this, "Pilih Daftar Yang Akan Dihapus !");
        }else
        {
            tabMode.removeRow(tabel_data);
            cb_no_induk_buku.requestFocus();
        }
        hitung_total_denda();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void cb_no_peminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_no_peminjamanActionPerformed
        try {
            String no_peminjaman = cb_no_peminjaman.getSelectedItem().toString();
            hasil = crud.tampilDataPeminjaman(no_peminjaman);
            while(hasil.next()){
                hasil2 = crud.tampilDataAnggota(hasil.getString("nim"));
                while(hasil2.next()){
                    txt_nim.setText(hasil2.getString("nim"));
                    txt_nama_anggota.setText(hasil2.getString("nama_anggota"));
                    txt_no_telepon.setText(hasil2.getString("no_telp"));
                }
                
                hasil3 = crud.tampilDetailBuku(cb_no_induk_buku.getSelectedItem().toString());
                cb_no_induk_buku.removeAllItems();
                cb_no_induk_buku.addItem("-");
                hasil3 = crud.tampilNoIndukBuku(no_peminjaman);
                while(hasil3.next()) {
                    cb_no_induk_buku.addItem(hasil3.getString("no_induk_buku"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
//        tampil_data_peminjaman();
//        tampil_nib();
    }//GEN-LAST:event_cb_no_peminjamanActionPerformed
    
    public void tampil_data_peminjaman(){
        try {
            String no_peminjaman = cb_no_peminjaman.getSelectedItem().toString();
            hasil = crud.getNoPeminjaman(no_peminjaman);
            while(hasil.next()){  

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Terjadi Kesalahan Tampil Data Pengembalian !");
        }
    }

    
    private void table_transaksi_pengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_transaksi_pengembalianMouseClicked
        // TODO add your handling code here:
//        String no_induk_buku = table_transaksi_pengembalian.getValueAt(table_transaksi_pengembalian.getSelectedRow(), 0).toString();
//        try {
//            hasil = crud.getNoPeminjaman(no_induk_buku); 
//            while (hasil.next()) {
//                String[] data = {
//                    hasil.getString("no_induk_buku"),
//                };
//                cb_no_induk_buku.setSelectedItem(data[0] +" - " + no_induk_buku);
//            }
//        } catch (Exception e) {
//        }
//        txt_judul_buku.setText(table_transaksi_pengembalian.getValueAt(table_transaksi_pengembalian.getSelectedRow(), 1).toString());
//        txt_pengarang.setText(table_transaksi_pengembalian.getValueAt(table_transaksi_pengembalian.getSelectedRow(), 2).toString());
//        txt_batas_pengembalian.setText(table_transaksi_pengembalian.getValueAt(table_transaksi_pengembalian.getSelectedRow(), 3).toString());
//        txt_tanggal_kembali.setText(table_transaksi_pengembalian.getValueAt(table_transaksi_pengembalian.getSelectedRow(), 4).toString());
//        txt_denda.setText(table_transaksi_pengembalian.getValueAt(table_transaksi_pengembalian.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_table_transaksi_pengembalianMouseClicked

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        boolean data_ganda=false;
        int data = table_transaksi_pengembalian.getRowCount();
        for(int i=0;i<data;i++){
            if(tabMode.getValueAt(i, 0).equals(cb_no_induk_buku.getSelectedItem())){
                data_ganda = true;
            }
        }
        
        if(data_ganda){
            JOptionPane.showMessageDialog(null, "Data Sudah Dimasukkan Dalam Daftar !");
        }else{
            if(txt_nama_anggota.getText().isEmpty()){
                cb_no_peminjaman.requestFocus();
            }else{
                if(txt_judul_buku.getText().isEmpty()){
                    cb_no_induk_buku.requestFocus();
                }else{
                    String[] table_transaksi_pengembalian={cb_no_induk_buku.getSelectedItem().toString(),txt_judul_buku.getText(),txt_pengarang.getText(),txt_batas_pengembalian.getText(),txt_tanggal_kembali.getText(),txt_denda.getText()};
                    tabMode.addRow(table_transaksi_pengembalian);

                    cb_no_induk_buku.setSelectedItem("-");
                    txt_judul_buku.setText(null);
                    txt_pengarang.setText(null);
                    txt_batas_pengembalian.setText(null);
                    txt_tanggal_kembali.setText(null);
                    txt_denda.setText("0");
                    
                    hitung_total_denda();
                }
            }
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void cb_no_induk_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_no_induk_bukuActionPerformed
        tampil_data_detail_peminjaman();
    }//GEN-LAST:event_cb_no_induk_bukuActionPerformed

    private void txt_nama_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nama_anggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nama_anggotaActionPerformed

    public void tampil_data_detail_peminjaman(){
        BigDecimal denda_perhari;
        denda_perhari = new BigDecimal("0");
        try {
            Object nib = cb_no_induk_buku.getSelectedItem();
            hasil = crud.tampilDetailBuku(cb_no_induk_buku.getSelectedItem());
            while(hasil.next()){  
                txt_judul_buku.setText(hasil.getString("judul"));
                txt_pengarang.setText(hasil.getString("pengarang"));
            }
            
            hasil2 = crud.tampilDataPeminjaman(cb_no_peminjaman.getSelectedItem().toString());
            while(hasil2.next()){
                txt_batas_pengembalian.setText(hasil2.getString("batas_pengembalian"));
            }
            
            hasil3 = crud.tampilDenda();
            while(hasil3.next()){
                denda_perhari = new BigDecimal(hasil3.getString("jumlah"));
            }
            
            //Hitung Keterlambatan dan Denda
            SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal_sekarang = new Date();
            txt_tanggal_kembali.setText(sdfdate.format(tanggal_sekarang));
            
            try{
                if(txt_tanggal_kembali.getText().isEmpty() || txt_batas_pengembalian.getText().isEmpty()){
                    
                }else{
                    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                    Date tanggal_batas_pengembalian = (Date) date.parse(txt_batas_pengembalian.getText());
                    Date tanggal_kembali = (Date) date.parse(txt_tanggal_kembali.getText());                
                    if(tanggal_kembali.getTime() > tanggal_batas_pengembalian.getTime()){
                        long Telat = Math.abs(tanggal_kembali.getTime() - tanggal_batas_pengembalian.getTime());
                        long jumlah_hari_telat = TimeUnit.MILLISECONDS.toDays(Telat);
                        BigDecimal denda_perbuku = denda_perhari.multiply(new BigDecimal(jumlah_hari_telat));
                        txt_denda.setText(""+denda_perbuku);
                    } else {
                        txt_denda.setText("0");
                    }
                }                                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error Hitung Denda !");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Terjadi Kesalahan Tampil Data Pengembalian !");
        }
    }
    
    private void hitung_total_denda() {
        int data = 0;
        data = table_transaksi_pengembalian.getRowCount();
        BigDecimal total_denda, denda;
        total_denda = new BigDecimal("0");
        for(int i=0;i<data;i++){
            denda = new BigDecimal(tabMode.getValueAt(i, 5).toString());
            total_denda = total_denda.add(denda);
        }
        txt_total_denda.setText(""+total_denda);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransaksiDataPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiDataPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiDataPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiDataPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TransaksiDataPengembalian().setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> cb_no_induk_buku;
    private javax.swing.JComboBox<String> cb_no_peminjaman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable table_transaksi_pengembalian;
    private javax.swing.JTextField txt_batas_pengembalian;
    private javax.swing.JTextField txt_denda;
    private javax.swing.JTextArea txt_judul_buku;
    private javax.swing.JTextField txt_nama_anggota;
    private javax.swing.JTextField txt_nim;
    private javax.swing.JTextField txt_no_telepon;
    private javax.swing.JTextField txt_pengarang;
    private javax.swing.JTextField txt_tanggal_kembali;
    private javax.swing.JTextField txt_total_denda;
    // End of variables declaration//GEN-END:variables
}
