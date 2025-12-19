/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
/**
 *
 * @author user
 */
public class bookissue extends javax.swing.JPanel {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode1;
    
    public bookissue() {
        initComponents();
        tablebookissue();
    }
    protected void tablebookissue(){
        Object[] baris = {"Id Pengembalian","Id Peminjaman","Tanggal Kembali","Id Buku","Nama Buku","Status","Deskripsi Fisik"};
        tabmode1 = new DefaultTableModel(null,baris);
        try{
            String sql = "SELECT p.id_pengembalian, s.id_peminjaman,s.tgl_kembali, " +
    "p.id_buku, p.nama_buku, " +
    "p.kondisi, p.deskripsifisik " +
    "FROM detail_pengembalian p " +
    "JOIN pengembalian s ON p.id_pengembalian = s.id " +
    "WHERE p.kondisi IN ('hilang','rusak') " +
    "ORDER BY p.id_pengembalian ASC";
        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while(hasil.next()){
            tabmode1.addRow(new Object[]{
                hasil.getString("id_pengembalian"),
                hasil.getString("id_peminjaman"),
                hasil.getString("tgl_kembali"),
                hasil.getString("id_buku"),
                hasil.getString("nama_buku"),
                hasil.getString("kondisi"),
                hasil.getString("deskripsifisik")
            });
        }
        jTable1.setModel(tabmode1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-health-graph-30.png"))); // NOI18N
        jLabel1.setText("Data Buku Yang Bermasalah");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
