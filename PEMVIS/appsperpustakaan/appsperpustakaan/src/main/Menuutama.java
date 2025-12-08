/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.Timer;
import ui.MenuDasboard;
import ui.peminjaman;
import ui.pengembalian;
import ui.reportbuku;
import ui.reportpeminjaman;
import ui.reportsiswa;
import ui.uidatabuku;
import ui.uirakbuku;
import ui.uisiswa;

import ui.reportpengembalian;
import ui.uipetugas;
public class Menuutama extends javax.swing.JFrame {
    int xx,xy;
   private Timer timer;
    public Menuutama() {
        initComponents();
        setDate();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new tools.JScrollPaneMod(pn_kiri);
        pn_kiri = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pn_ds1 = new javax.swing.JPanel();
        pn_ds2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_dasboard = new javax.swing.JLabel();
        pn_ds7 = new javax.swing.JPanel();
        pn_ds8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_siswa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pn_ds9 = new javax.swing.JPanel();
        pn_ds10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_peminjaman = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pn_ds21 = new javax.swing.JPanel();
        pn_ds22 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_rak = new javax.swing.JLabel();
        pn_ds13 = new javax.swing.JPanel();
        pn_ds14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btn_reportsiswa = new javax.swing.JLabel();
        pn_ds11 = new javax.swing.JPanel();
        pn_ds12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_pengembalian = new javax.swing.JLabel();
        pn_ds15 = new javax.swing.JPanel();
        pn_ds16 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btn_reportbuku = new javax.swing.JLabel();
        pn_ds23 = new javax.swing.JPanel();
        pn_ds24 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btn_reportpinjam = new javax.swing.JLabel();
        pn_ds17 = new javax.swing.JPanel();
        pn_ds18 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_buku = new javax.swing.JLabel();
        pn_ds25 = new javax.swing.JPanel();
        pn_ds26 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btn_reportambil = new javax.swing.JLabel();
        pn_ds27 = new javax.swing.JPanel();
        pn_ds28 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btn_petugas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pn_kanan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pn_dasar = new javax.swing.JPanel();
        jpanelGradient1 = new tools.JpanelGradient();
        lbDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1360, 768));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pn_kiri.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("MASTER");

        pn_ds1.setBackground(new java.awt.Color(255, 255, 255));

        pn_ds2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_ds2Layout = new javax.swing.GroupLayout(pn_ds2);
        pn_ds2.setLayout(pn_ds2Layout);
        pn_ds2Layout.setHorizontalGroup(
            pn_ds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_ds2Layout.setVerticalGroup(
            pn_ds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-tv-30.png"))); // NOI18N

        btn_dasboard.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_dasboard.setForeground(new java.awt.Color(153, 153, 153));
        btn_dasboard.setText("Dasboard");
        btn_dasboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dasboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dasboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dasboardMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_ds1Layout = new javax.swing.GroupLayout(pn_ds1);
        pn_ds1.setLayout(pn_ds1Layout);
        pn_ds1Layout.setHorizontalGroup(
            pn_ds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ds1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_ds2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_dasboard, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_ds1Layout.setVerticalGroup(
            pn_ds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ds1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_ds2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_ds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_dasboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        pn_ds7.setBackground(new java.awt.Color(255, 255, 255));

        pn_ds8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_ds8Layout = new javax.swing.GroupLayout(pn_ds8);
        pn_ds8.setLayout(pn_ds8Layout);
        pn_ds8Layout.setHorizontalGroup(
            pn_ds8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_ds8Layout.setVerticalGroup(
            pn_ds8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-user-30 (1).png"))); // NOI18N

        btn_siswa.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_siswa.setForeground(new java.awt.Color(153, 153, 153));
        btn_siswa.setText("Siswa");
        btn_siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_siswaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_siswaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_siswaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_ds7Layout = new javax.swing.GroupLayout(pn_ds7);
        pn_ds7.setLayout(pn_ds7Layout);
        pn_ds7Layout.setHorizontalGroup(
            pn_ds7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ds7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_ds8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_ds7Layout.setVerticalGroup(
            pn_ds7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ds7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ds7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_ds8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_ds7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_siswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("TRANSAKSI");

        pn_ds9.setBackground(new java.awt.Color(255, 255, 255));

        pn_ds10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_ds10Layout = new javax.swing.GroupLayout(pn_ds10);
        pn_ds10.setLayout(pn_ds10Layout);
        pn_ds10Layout.setHorizontalGroup(
            pn_ds10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_ds10Layout.setVerticalGroup(
            pn_ds10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-date-30.png"))); // NOI18N

        btn_peminjaman.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_peminjaman.setForeground(new java.awt.Color(153, 153, 153));
        btn_peminjaman.setText("Peminjaman");
        btn_peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_peminjamanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_peminjamanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_peminjamanMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_ds9Layout = new javax.swing.GroupLayout(pn_ds9);
        pn_ds9.setLayout(pn_ds9Layout);
        pn_ds9Layout.setHorizontalGroup(
            pn_ds9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ds9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_ds10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pn_ds9Layout.setVerticalGroup(
            pn_ds9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ds9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ds9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_ds10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_ds9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_peminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        jLabel10.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("REPORT");

        pn_ds21.setBackground(new java.awt.Color(255, 255, 255));

        pn_ds22.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_ds22Layout = new javax.swing.GroupLayout(pn_ds22);
        pn_ds22.setLayout(pn_ds22Layout);
        pn_ds22Layout.setHorizontalGroup(
            pn_ds22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_ds22Layout.setVerticalGroup(
            pn_ds22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-book-shelf-30.png"))); // NOI18N

        btn_rak.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_rak.setForeground(new java.awt.Color(153, 153, 153));
        btn_rak.setText("Rak Buku");
        btn_rak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_rakMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_rakMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_rakMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_ds21Layout = new javax.swing.GroupLayout(pn_ds21);
        pn_ds21.setLayout(pn_ds21Layout);
        pn_ds21Layout.setHorizontalGroup(
            pn_ds21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ds21Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_ds22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_rak, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pn_ds21Layout.setVerticalGroup(
            pn_ds21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ds21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ds21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_ds22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_ds21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_rak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        pn_ds13.setBackground(new java.awt.Color(255, 255, 255));

        pn_ds14.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_ds14Layout = new javax.swing.GroupLayout(pn_ds14);
        pn_ds14.setLayout(pn_ds14Layout);
        pn_ds14Layout.setHorizontalGroup(
            pn_ds14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_ds14Layout.setVerticalGroup(
            pn_ds14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-business-report-30.png"))); // NOI18N

        btn_reportsiswa.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_reportsiswa.setForeground(new java.awt.Color(153, 153, 153));
        btn_reportsiswa.setText("Siswa");
        btn_reportsiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reportsiswaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_reportsiswaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_reportsiswaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_ds13Layout = new javax.swing.GroupLayout(pn_ds13);
        pn_ds13.setLayout(pn_ds13Layout);
        pn_ds13Layout.setHorizontalGroup(
            pn_ds13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ds13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_ds14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_reportsiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        pn_ds13Layout.setVerticalGroup(
            pn_ds13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ds13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ds13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_ds14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_ds13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reportsiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        pn_ds11.setBackground(new java.awt.Color(255, 255, 255));

        pn_ds12.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_ds12Layout = new javax.swing.GroupLayout(pn_ds12);
        pn_ds12.setLayout(pn_ds12Layout);
        pn_ds12Layout.setHorizontalGroup(
            pn_ds12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_ds12Layout.setVerticalGroup(
            pn_ds12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-tear-off-calendar-30.png"))); // NOI18N

        btn_pengembalian.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_pengembalian.setForeground(new java.awt.Color(153, 153, 153));
        btn_pengembalian.setText("Pengembalian");
        btn_pengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pengembalianMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_pengembalianMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_pengembalianMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_ds11Layout = new javax.swing.GroupLayout(pn_ds11);
        pn_ds11.setLayout(pn_ds11Layout);
        pn_ds11Layout.setHorizontalGroup(
            pn_ds11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ds11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_ds12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pn_ds11Layout.setVerticalGroup(
            pn_ds11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ds11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ds11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_ds12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_ds11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_pengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        pn_ds15.setBackground(new java.awt.Color(255, 255, 255));

        pn_ds16.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_ds16Layout = new javax.swing.GroupLayout(pn_ds16);
        pn_ds16.setLayout(pn_ds16Layout);
        pn_ds16Layout.setHorizontalGroup(
            pn_ds16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_ds16Layout.setVerticalGroup(
            pn_ds16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-open-book-30.png"))); // NOI18N

        btn_reportbuku.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_reportbuku.setForeground(new java.awt.Color(153, 153, 153));
        btn_reportbuku.setText("Buku");
        btn_reportbuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reportbukuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_reportbukuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_reportbukuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_ds15Layout = new javax.swing.GroupLayout(pn_ds15);
        pn_ds15.setLayout(pn_ds15Layout);
        pn_ds15Layout.setHorizontalGroup(
            pn_ds15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ds15Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_ds16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_reportbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        pn_ds15Layout.setVerticalGroup(
            pn_ds15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ds15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ds15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_ds16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_ds15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reportbuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        pn_ds23.setBackground(new java.awt.Color(255, 255, 255));

        pn_ds24.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_ds24Layout = new javax.swing.GroupLayout(pn_ds24);
        pn_ds24.setLayout(pn_ds24Layout);
        pn_ds24Layout.setHorizontalGroup(
            pn_ds24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_ds24Layout.setVerticalGroup(
            pn_ds24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-graph-report-30.png"))); // NOI18N

        btn_reportpinjam.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_reportpinjam.setForeground(new java.awt.Color(153, 153, 153));
        btn_reportpinjam.setText("Peminjaman");
        btn_reportpinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reportpinjamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_reportpinjamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_reportpinjamMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_ds23Layout = new javax.swing.GroupLayout(pn_ds23);
        pn_ds23.setLayout(pn_ds23Layout);
        pn_ds23Layout.setHorizontalGroup(
            pn_ds23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ds23Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_ds24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_reportpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        pn_ds23Layout.setVerticalGroup(
            pn_ds23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ds23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ds23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_ds24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_ds23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reportpinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        pn_ds17.setBackground(new java.awt.Color(255, 255, 255));

        pn_ds18.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_ds18Layout = new javax.swing.GroupLayout(pn_ds18);
        pn_ds18.setLayout(pn_ds18Layout);
        pn_ds18Layout.setHorizontalGroup(
            pn_ds18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_ds18Layout.setVerticalGroup(
            pn_ds18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-book-30.png"))); // NOI18N

        btn_buku.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_buku.setForeground(new java.awt.Color(153, 153, 153));
        btn_buku.setText("Buku");
        btn_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_bukuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_bukuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_bukuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_ds17Layout = new javax.swing.GroupLayout(pn_ds17);
        pn_ds17.setLayout(pn_ds17Layout);
        pn_ds17Layout.setHorizontalGroup(
            pn_ds17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ds17Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_ds18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_ds17Layout.setVerticalGroup(
            pn_ds17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ds17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ds17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_ds18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_ds17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_buku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        pn_ds25.setBackground(new java.awt.Color(255, 255, 255));

        pn_ds26.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_ds26Layout = new javax.swing.GroupLayout(pn_ds26);
        pn_ds26.setLayout(pn_ds26Layout);
        pn_ds26Layout.setHorizontalGroup(
            pn_ds26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_ds26Layout.setVerticalGroup(
            pn_ds26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-health-graph-30.png"))); // NOI18N

        btn_reportambil.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_reportambil.setForeground(new java.awt.Color(153, 153, 153));
        btn_reportambil.setText("Pengembalian");
        btn_reportambil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reportambilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_reportambilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_reportambilMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_ds25Layout = new javax.swing.GroupLayout(pn_ds25);
        pn_ds25.setLayout(pn_ds25Layout);
        pn_ds25Layout.setHorizontalGroup(
            pn_ds25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ds25Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_ds26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_reportambil, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        pn_ds25Layout.setVerticalGroup(
            pn_ds25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ds25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ds25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_ds26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_ds25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reportambil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        pn_ds27.setBackground(new java.awt.Color(255, 255, 255));

        pn_ds28.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_ds28Layout = new javax.swing.GroupLayout(pn_ds28);
        pn_ds28.setLayout(pn_ds28Layout);
        pn_ds28Layout.setHorizontalGroup(
            pn_ds28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pn_ds28Layout.setVerticalGroup(
            pn_ds28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-admin-30 (1).png"))); // NOI18N

        btn_petugas.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btn_petugas.setForeground(new java.awt.Color(153, 153, 153));
        btn_petugas.setText("Petugas");
        btn_petugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_petugasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_petugasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_petugasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_ds27Layout = new javax.swing.GroupLayout(pn_ds27);
        pn_ds27.setLayout(pn_ds27Layout);
        pn_ds27Layout.setHorizontalGroup(
            pn_ds27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ds27Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pn_ds28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_ds27Layout.setVerticalGroup(
            pn_ds27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ds27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ds27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_ds28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_ds27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_petugas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo jakarta-01.png"))); // NOI18N
        jLabel1.setText("SI Perpus SMKN 22");

        javax.swing.GroupLayout pn_kiriLayout = new javax.swing.GroupLayout(pn_kiri);
        pn_kiri.setLayout(pn_kiriLayout);
        pn_kiriLayout.setHorizontalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10))
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pn_ds9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pn_ds11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pn_ds13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pn_ds15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pn_ds23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pn_ds25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pn_ds17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pn_ds7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pn_ds21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_kiriLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6))
                            .addComponent(pn_ds27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2))
                    .addGroup(pn_kiriLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(pn_ds1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        pn_kiriLayout.setVerticalGroup(
            pn_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kiriLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_ds1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pn_ds27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_ds7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pn_ds17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pn_ds21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(pn_ds9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_ds11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_ds13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_ds15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pn_ds23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_ds25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        jScrollPane1.setViewportView(pn_kiri);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.LINE_START);

        pn_kanan.setBackground(new java.awt.Color(255, 255, 255));
        pn_kanan.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        pn_dasar.setBackground(new java.awt.Color(255, 255, 255));
        pn_dasar.setLayout(new java.awt.BorderLayout());

        jpanelGradient1.setColorEnd(new java.awt.Color(78, 102, 136));
        jpanelGradient1.setColorStart(new java.awt.Color(51, 45, 86));

        lbDate.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        lbDate.setForeground(new java.awt.Color(255, 255, 255));
        lbDate.setText("Date");

        javax.swing.GroupLayout jpanelGradient1Layout = new javax.swing.GroupLayout(jpanelGradient1);
        jpanelGradient1.setLayout(jpanelGradient1Layout);
        jpanelGradient1Layout.setHorizontalGroup(
            jpanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelGradient1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jpanelGradient1Layout.setVerticalGroup(
            jpanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelGradient1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lbDate)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pn_dasar, javax.swing.GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addComponent(jpanelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpanelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pn_dasar, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pn_kanan.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pn_kanan, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                    

     
    private void btn_dasboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dasboardMouseClicked
        pn_ds1.setBackground(new Color (240,240,240,240));
        pn_ds2.setBackground(new Color (0,102,153));

        pn_dasar.removeAll();
        pn_dasar.add(new MenuDasboard());
        pn_dasar.repaint();
        pn_dasar.revalidate();
    }//GEN-LAST:event_btn_dasboardMouseClicked

    private void btn_dasboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dasboardMouseEntered
        pn_ds1.setBackground(new Color (250,250,250,250));
        pn_ds2.setBackground(new Color (0,102,153));

    }//GEN-LAST:event_btn_dasboardMouseEntered

    private void btn_dasboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dasboardMouseExited
        pn_ds1.setBackground(new Color (255,255,255,255));
        pn_ds2.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_dasboardMouseExited

    private void btn_siswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_siswaMouseClicked
        pn_ds7.setBackground(new Color (240,240,240,240));
        pn_ds8.setBackground(new Color (0,102,153));

        pn_dasar.removeAll();
        pn_dasar.add(new uisiswa());
        pn_dasar.repaint();
        pn_dasar.revalidate();
    }//GEN-LAST:event_btn_siswaMouseClicked

    private void btn_siswaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_siswaMouseEntered
        pn_ds7.setBackground(new Color (255,255,255,255));
        pn_ds8.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_siswaMouseEntered

    private void btn_siswaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_siswaMouseExited
        pn_ds7.setBackground(new Color (255,255,255,255));
        pn_ds8.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_siswaMouseExited

    private void btn_peminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_peminjamanMouseClicked
        pn_ds9.setBackground(new Color (240,240,240,240));
        pn_ds10.setBackground(new Color (0,102,153));

        pn_dasar.removeAll();
        pn_dasar.add(new peminjaman());
        pn_dasar.repaint();
        pn_dasar.revalidate();
    }//GEN-LAST:event_btn_peminjamanMouseClicked

    private void btn_peminjamanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_peminjamanMouseEntered
        pn_ds9.setBackground(new Color (255,255,255,255));
        pn_ds10.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_peminjamanMouseEntered

    private void btn_peminjamanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_peminjamanMouseExited
        pn_ds11.setBackground(new Color (255,255,255,255));
        pn_ds12.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_peminjamanMouseExited

    private void btn_rakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rakMouseClicked
        pn_ds21.setBackground(new Color (240,240,240,240));
        pn_ds22.setBackground(new Color (0,102,153));

        pn_dasar.removeAll();
        pn_dasar.add(new uirakbuku());
        pn_dasar.repaint();
        pn_dasar.revalidate();
    }//GEN-LAST:event_btn_rakMouseClicked

    private void btn_rakMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rakMouseEntered
        pn_ds21.setBackground(new Color (255,255,255,255));
        pn_ds22.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_rakMouseEntered

    private void btn_rakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rakMouseExited
        pn_ds21.setBackground(new Color (255,255,255,255));
        pn_ds22.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_rakMouseExited

    private void btn_reportsiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportsiswaMouseClicked
        pn_ds13.setBackground(new Color (240,240,240,240));
        pn_ds14.setBackground(new Color (0,102,153));

        pn_dasar.removeAll();
        pn_dasar.add(new reportsiswa());
        pn_dasar.repaint();
        pn_dasar.revalidate();
    }//GEN-LAST:event_btn_reportsiswaMouseClicked

    private void btn_reportsiswaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportsiswaMouseEntered
        pn_ds13.setBackground(new Color (255,255,255,255));
        pn_ds14.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_reportsiswaMouseEntered

    private void btn_reportsiswaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportsiswaMouseExited
        pn_ds13.setBackground(new Color (255,255,255,255));
        pn_ds14.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_reportsiswaMouseExited

    private void btn_pengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pengembalianMouseClicked
        pn_ds11.setBackground(new Color (240,240,240,240));
        pn_ds12.setBackground(new Color (0,102,153));

        pn_dasar.removeAll();
        pn_dasar.add(new pengembalian());
        pn_dasar.repaint();
        pn_dasar.revalidate();
    }//GEN-LAST:event_btn_pengembalianMouseClicked

    private void btn_pengembalianMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pengembalianMouseEntered
        pn_ds11.setBackground(new Color (255,255,255,255));
        pn_ds12.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_pengembalianMouseEntered

    private void btn_pengembalianMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pengembalianMouseExited
        pn_ds9.setBackground(new Color (255,255,255,255));
        pn_ds10.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_pengembalianMouseExited

    private void btn_reportbukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportbukuMouseClicked
        pn_ds15.setBackground(new Color (240,240,240,240));
        pn_ds16.setBackground(new Color (0,102,153));

        pn_dasar.removeAll();
        pn_dasar.add (new reportbuku());
        pn_dasar.repaint();
        pn_dasar.revalidate();
    }//GEN-LAST:event_btn_reportbukuMouseClicked

    private void btn_reportbukuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportbukuMouseEntered
        pn_ds15.setBackground(new Color (255,255,255,255));
        pn_ds16.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_reportbukuMouseEntered

    private void btn_reportbukuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportbukuMouseExited
        pn_ds11.setBackground(new Color (255,255,255,255));
        pn_ds12.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_reportbukuMouseExited

    private void btn_reportpinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportpinjamMouseClicked
        pn_ds23.setBackground(new Color (240,240,240,240));
        pn_ds24.setBackground(new Color (0,102,153));

        pn_dasar.removeAll();
        pn_dasar.add (new reportpeminjaman());
        pn_dasar.repaint();
        pn_dasar.revalidate();
    }//GEN-LAST:event_btn_reportpinjamMouseClicked

    private void btn_reportpinjamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportpinjamMouseEntered
        pn_ds23.setBackground(new Color (255,255,255,255));
        pn_ds24.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_reportpinjamMouseEntered

    private void btn_reportpinjamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportpinjamMouseExited
        pn_ds23.setBackground(new Color (255,255,255,255));
        pn_ds24.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_reportpinjamMouseExited

    private void btn_bukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bukuMouseClicked
        pn_ds17.setBackground(new Color (240,240,240,240));
        pn_ds18.setBackground(new Color (0,102,153));

        pn_dasar.removeAll();
        pn_dasar.add(new uidatabuku());
        pn_dasar.repaint();
        pn_dasar.revalidate();
    }//GEN-LAST:event_btn_bukuMouseClicked

    private void btn_bukuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bukuMouseEntered
        pn_ds17.setBackground(new Color (255,255,255,255));
        pn_ds18.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_bukuMouseEntered

    private void btn_bukuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bukuMouseExited
        pn_ds17.setBackground(new Color (255,255,255,255));
        pn_ds18.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_bukuMouseExited

    private void btn_reportambilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportambilMouseClicked
        pn_ds25.setBackground(new Color (240,240,240,240));
        pn_ds26.setBackground(new Color (0,102,153));

        pn_dasar.removeAll();
        pn_dasar.add (new reportpengembalian());
        pn_dasar.repaint();
        pn_dasar.revalidate();
    }//GEN-LAST:event_btn_reportambilMouseClicked

    private void btn_reportambilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportambilMouseEntered
        pn_ds25.setBackground(new Color (255,255,255,255));
        pn_ds26.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_reportambilMouseEntered

    private void btn_reportambilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportambilMouseExited
        pn_ds25.setBackground(new Color (255,255,255,255));
        pn_ds26.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_reportambilMouseExited

    private void btn_petugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_petugasMouseClicked
        pn_ds27.setBackground(new Color (240,240,240,240));
        pn_ds28.setBackground(new Color (0,102,153));

        pn_dasar.removeAll();
        pn_dasar.add(new uipetugas());
        pn_dasar.repaint();
        pn_dasar.revalidate();
    }//GEN-LAST:event_btn_petugasMouseClicked

    private void btn_petugasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_petugasMouseEntered
        pn_ds27.setBackground(new Color (255,255,255,255));
        pn_ds28.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_petugasMouseEntered

    private void btn_petugasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_petugasMouseExited
        pn_ds27.setBackground(new Color (255,255,255,255));
        pn_ds28.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_btn_petugasMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        pn_dasar.removeAll();
        pn_dasar.add(new MenuDasboard());
        pn_dasar.repaint();
        pn_dasar.revalidate();
    }//GEN-LAST:event_formWindowOpened
                                   

    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
       xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx,y - xy);
    }//GEN-LAST:event_formMouseDragged

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
            java.util.logging.Logger.getLogger(Menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menuutama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_buku;
    private javax.swing.JLabel btn_dasboard;
    private javax.swing.JLabel btn_peminjaman;
    private javax.swing.JLabel btn_pengembalian;
    private javax.swing.JLabel btn_petugas;
    private javax.swing.JLabel btn_rak;
    private javax.swing.JLabel btn_reportambil;
    private javax.swing.JLabel btn_reportbuku;
    private javax.swing.JLabel btn_reportpinjam;
    private javax.swing.JLabel btn_reportsiswa;
    private javax.swing.JLabel btn_siswa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private tools.JpanelGradient jpanelGradient1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JPanel pn_dasar;
    private javax.swing.JPanel pn_ds1;
    private javax.swing.JPanel pn_ds10;
    private javax.swing.JPanel pn_ds11;
    private javax.swing.JPanel pn_ds12;
    private javax.swing.JPanel pn_ds13;
    private javax.swing.JPanel pn_ds14;
    private javax.swing.JPanel pn_ds15;
    private javax.swing.JPanel pn_ds16;
    private javax.swing.JPanel pn_ds17;
    private javax.swing.JPanel pn_ds18;
    private javax.swing.JPanel pn_ds2;
    private javax.swing.JPanel pn_ds21;
    private javax.swing.JPanel pn_ds22;
    private javax.swing.JPanel pn_ds23;
    private javax.swing.JPanel pn_ds24;
    private javax.swing.JPanel pn_ds25;
    private javax.swing.JPanel pn_ds26;
    private javax.swing.JPanel pn_ds27;
    private javax.swing.JPanel pn_ds28;
    private javax.swing.JPanel pn_ds7;
    private javax.swing.JPanel pn_ds8;
    private javax.swing.JPanel pn_ds9;
    private javax.swing.JPanel pn_kanan;
    private javax.swing.JPanel pn_kiri;
    // End of variables declaration//GEN-END:variables
    private Timer timer(int i, ActionListener actionListener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private void setDate() {
        timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar calendar = Calendar.getInstance(); 
            Date now = new Date();

            SimpleDateFormat formatHari = new SimpleDateFormat("EEEE", new Locale("in", "ID")); 
            SimpleDateFormat formatTanggal = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 

            String hari = formatHari.format(calendar.getTime());
            String waktuTanggal = formatTanggal.format(now);

            lbDate.setText(hari + ", " + waktuTanggal);
        }
    });

    timer.start();
    }
}
