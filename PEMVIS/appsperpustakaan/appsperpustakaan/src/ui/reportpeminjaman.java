
package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import koneksi.koneksi;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class reportpeminjaman extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode4;
    
    public reportpeminjaman() {
        initComponents();
        kosong();
        aktif();
        tablepeminjaman();
        loaddata();
        
    }
    
    private void showPanel(){
        pn_main.removeAll();
        pn_main.add(new reportpeminjaman());
        pn_main.repaint();
        pn_main.revalidate();
    }
    
    protected void aktif (){
        txtid.requestFocus();
    }
    
    
    private void loaddata(){
      
    }
    
    
    
    protected void kosong (){
        
        txtid.setText("");
        txtnm.setText("");
        txtkelasview.setText("");
        txttelepon.setText("");
        txtalamat.setText("");
        txtcaripinjam.setText("");
        buttonGroup1.clearSelection();
    }

   

    
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pn_main = new javax.swing.JPanel();
        pn_view = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepeminjaman = new tools.JTableCustom();
        jLabel1 = new javax.swing.JLabel();
        bprint = new tools.MyButton();
        txtcaripinjam = new tools.JTextFieldRounded();
        bcariview = new tools.MyButton();
        pn_add = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new tools.JTextFieldRounded();
        txtnm = new tools.JTextFieldRounded();
        jLabel4 = new javax.swing.JLabel();
        txtkelasview = new tools.JTextFieldRounded();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rlaki = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txttelepon = new tools.JTextFieldRounded();
        txtalamat = new tools.JTextFieldRounded();
        jLabel8 = new javax.swing.JLabel();
        rperempuan = new javax.swing.JRadioButton();

        setLayout(new java.awt.CardLayout());

        pn_main.setBackground(new java.awt.Color(255, 255, 255));
        pn_main.setLayout(new java.awt.CardLayout());

        pn_view.setBackground(new java.awt.Color(255, 255, 255));

        tablepeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tablepeminjaman.setShowGrid(true);
        tablepeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablepeminjaman);

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-graph-report-30.png"))); // NOI18N
        jLabel1.setText("Data Peminjaman Buku Perpustakaan");

        bprint.setForeground(new java.awt.Color(255, 255, 255));
        bprint.setText("Print");
        bprint.setBorderColor(new java.awt.Color(242, 242, 242));
        bprint.setColor(new java.awt.Color(51, 153, 255));
        bprint.setColorClick(new java.awt.Color(0, 51, 255));
        bprint.setColorOver(new java.awt.Color(51, 102, 255));
        bprint.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        bprint.setRadius(15);
        bprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprintActionPerformed(evt);
            }
        });

        txtcaripinjam.setCornerRadius(10);
        txtcaripinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaripinjamActionPerformed(evt);
            }
        });

        bcariview.setForeground(new java.awt.Color(255, 255, 255));
        bcariview.setText("CARI");
        bcariview.setBorderColor(new java.awt.Color(242, 242, 242));
        bcariview.setColor(new java.awt.Color(51, 153, 255));
        bcariview.setColorClick(new java.awt.Color(0, 51, 255));
        bcariview.setColorOver(new java.awt.Color(51, 102, 255));
        bcariview.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        bcariview.setRadius(15);
        bcariview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariviewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_viewLayout = new javax.swing.GroupLayout(pn_view);
        pn_view.setLayout(pn_viewLayout);
        pn_viewLayout.setHorizontalGroup(
            pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_viewLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pn_viewLayout.createSequentialGroup()
                                .addComponent(bprint, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bcariview, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcaripinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
                        .addGap(50, 50, 50))))
        );
        pn_viewLayout.setVerticalGroup(
            pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_viewLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcaripinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bprint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcariview, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        pn_main.add(pn_view, "card2");

        pn_add.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel2.setText("Data Siswa Perpustakaan");

        jLabel3.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel3.setText("ID SISWA");

        txtid.setForeground(new java.awt.Color(51, 51, 51));
        txtid.setCornerRadius(10);
        txtid.setFont(new java.awt.Font("Poppins Medium", 2, 12)); // NOI18N
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        txtnm.setForeground(new java.awt.Color(51, 51, 51));
        txtnm.setCornerRadius(10);
        txtnm.setFont(new java.awt.Font("Poppins Medium", 2, 12)); // NOI18N
        txtnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel4.setText("NAMA SISWA");

        txtkelasview.setForeground(new java.awt.Color(51, 51, 51));
        txtkelasview.setCornerRadius(10);
        txtkelasview.setFont(new java.awt.Font("Poppins Medium", 2, 12)); // NOI18N
        txtkelasview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkelasviewActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel5.setText("KELAS");

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel6.setText("JENIS KELAMIN");

        buttonGroup1.add(rlaki);
        rlaki.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        rlaki.setText("Laki-Laki");
        rlaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rlakiActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel7.setText("NO.TELEPON");

        txttelepon.setForeground(new java.awt.Color(51, 51, 51));
        txttelepon.setCornerRadius(10);
        txttelepon.setFont(new java.awt.Font("Poppins Medium", 2, 12)); // NOI18N
        txttelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtteleponActionPerformed(evt);
            }
        });

        txtalamat.setForeground(new java.awt.Color(51, 51, 51));
        txtalamat.setCornerRadius(10);
        txtalamat.setFont(new java.awt.Font("Poppins Medium", 2, 12)); // NOI18N
        txtalamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalamatActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel8.setText("ALAMAT");

        buttonGroup1.add(rperempuan);
        rperempuan.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        rperempuan.setText("Perempuan");
        rperempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rperempuanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_addLayout = new javax.swing.GroupLayout(pn_add);
        pn_add.setLayout(pn_addLayout);
        pn_addLayout.setHorizontalGroup(
            pn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_addLayout.createSequentialGroup()
                .addGroup(pn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_addLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addGroup(pn_addLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(rlaki)
                        .addGap(18, 18, 18)
                        .addComponent(rperempuan)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_addLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txttelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addGroup(pn_addLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(pn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtkelasview, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        pn_addLayout.setVerticalGroup(
            pn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_addLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(85, 85, 85)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(txtkelasview, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rperempuan)
                    .addComponent(rlaki))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pn_main.add(pn_add, "card2");

        add(pn_main, "card2");
    }// </editor-fold>//GEN-END:initComponents

   
    
    
        
    
    private void bprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprintActionPerformed
        try {
            HashMap<String, Object> param = new HashMap<>();

            // Data tabel sebagai datasource
            JRTableModelDataSource dataSource = new JRTableModelDataSource(tabmode4);

            JasperPrint jp = JasperFillManager.fillReport(
                    "src/report/Simple_Blue.jasper",
                    param,
                    dataSource
            );

            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Gagal mencetak struk!\n" + e.getMessage());
        }
    }//GEN-LAST:event_bprintActionPerformed

    private void txtnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmActionPerformed

    private void txtkelasviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkelasviewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkelasviewActionPerformed

    private void txtteleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtteleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtteleponActionPerformed

    private void txtalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalamatActionPerformed

    private void rlakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rlakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rlakiActionPerformed

    private void rperempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rperempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rperempuanActionPerformed

    private void bcariviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariviewActionPerformed
           tablepeminjaman();
    }//GEN-LAST:event_bcariviewActionPerformed

    private void tablepeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepeminjamanMouseClicked
       
    }//GEN-LAST:event_tablepeminjamanMouseClicked

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtcaripinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaripinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaripinjamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tools.MyButton bcariview;
    private tools.MyButton bprint;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pn_add;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_view;
    private javax.swing.JRadioButton rlaki;
    private javax.swing.JRadioButton rperempuan;
    private tools.JTableCustom tablepeminjaman;
    private tools.JTextFieldRounded txtalamat;
    private tools.JTextFieldRounded txtcaripinjam;
    private tools.JTextFieldRounded txtid;
    private tools.JTextFieldRounded txtkelasview;
    private tools.JTextFieldRounded txtnm;
    private tools.JTextFieldRounded txttelepon;
    // End of variables declaration//GEN-END:variables

    

   

    
   
    
    
   protected void tablepeminjaman() {
        Object[] Baris = {
            "ID Pinjam", "Tanggal Pinjam",
            "ID Siswa", "Nama Siswa", "Kelas", "Telp",
            "ID Buku", "Nama Buku", "Penerbit", "Tahun Terbit", "Tebal Halaman","Status"
        };

        tabmode4 = new DefaultTableModel(null, Baris);
        String caridata = txtcaripinjam.getText();

        try {
            String sql =
                "SELECT p.id_peminjaman, p.tgl_pinjam, " +
                "       s.id_siswa, s.nm_siswa, s.kelas, s.telepon, " +
                "       b.id_buku, b.judul_buku, b.nama_penulis, b.tahun_terbit, b.tebal_buku, d.status " +
                "FROM peminjaman p " +
                "JOIN datasiswa s ON p.id_siswa = s.id_siswa " +
                "JOIN detail_peminjaman d ON p.id_peminjaman = d.id_peminjaman " +
                "JOIN databuku b ON d.id_buku = b.id_buku " +
                "WHERE p.id_peminjaman LIKE '%" + caridata + "%' " +
                "OR s.nm_siswa LIKE '%" + caridata + "%' " + 
                "OR b.judul_buku LIKE '%" + caridata + "%' " +
                "ORDER BY p.id_peminjaman ASC";

            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);

            while (hasil.next()) {
                tabmode4.addRow(new Object[]{
                    hasil.getString("id_peminjaman"),
                    hasil.getString("tgl_pinjam"),
                    hasil.getString("id_siswa"),
                    hasil.getString("nm_siswa"),
                    hasil.getString("kelas"),
                    hasil.getString("telepon"),
                    hasil.getString("id_buku"),
                    hasil.getString("judul_buku"),
                    hasil.getString("nama_penulis"),
                    hasil.getString("tahun_terbit"),
                    hasil.getString("tebal_buku"),
                    hasil.getString("status"),
                });
            }

            tablepeminjaman.setModel(tabmode4);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + e.getMessage());
        }
    }
    
    
}


