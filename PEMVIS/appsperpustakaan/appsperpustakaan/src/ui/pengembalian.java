package ui;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author user
 */
public class pengembalian extends javax.swing.JPanel {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode,tabmode2,tabmode3;
    public pengembalian() {
        initComponents();
        datatablepinjam();
        AutoNumber();
    }
    
    
    
    
     protected void AutoNumber(){
        try{
            String sql = "SELECT id from pengembalian order by id asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            idpengembalian.setText("IN0001");
            while(rs.next()){
                String id_nota = rs.getString("id").substring(2);
                int AN = Integer.parseInt(id_nota)+1;
                String Nol = "";
                
                if(AN<10){
                    Nol = "000";
                }else if (AN<100){
                    Nol = "00";
                }else if (AN < 1000){
                    Nol = "0";
                }else if(AN < 10000){
                    Nol = "";
                }
                idpengembalian.setText("IN" + Nol + AN);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" + e);
        }
     }
    
    private void hitungDenda(String tanggalPinjamString) {
    try {
        // Ambil tanggal kembali dari JDateChooser
        Date tanggalKembali = tglkembali.getDate();

        // Format dan parse tanggal pinjam dari database
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggalPinjam = sdf.parse(tanggalPinjamString);

        // Hitung selisih hari
        long diffInMillies = tanggalKembali.getTime() - tanggalPinjam.getTime();
        long selisihHari = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        int denda = 0;
        if (selisihHari > 7 && selisihHari <= 8) {
            denda = 3000;
        } else if (selisihHari ==9) {
            denda = 4000;
        } else if (selisihHari > 9) {
            denda = 5000;
        }

        jLabel4.setText("Rp " + denda);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal menghitung denda: " + e.getMessage());
    }
}
    protected void tablepengembalian(){
    Object[] Baris = {
        "Id", "Id Peminjaman", "Tanggal Pinjam", "Tanggal Kembali", "Id Siswa", "Nama Siswa", "Id Buku", "Jumlah", "Denda"
    };
    tabmode3 = new DefaultTableModel(null, Baris);
    String caridata = txtcaridata.getText();

    try {
        String sql = "SELECT p.id AS id, p.idpinjam, p.tglpinjam, p.tglkembali, " +
                     "p.idsiswa, p.nmsiswa, d.id_buku, d.jumlah, p.denda " +
                     "FROM pengembalianbuku p " +
                     "JOIN pengembalian d ON p.id = d.id " +
                     "WHERE p.id LIKE '%" + caridata + "%' " +
                     "OR p.idsiswa LIKE '%" + caridata + "%' " +
                     "OR p.nmsiswa LIKE '%" + caridata + "%' " +
                     "ORDER BY p.id ASC";

        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            tabmode3.addRow(new Object[] {
                hasil.getString("id"),
                hasil.getString("idpinjam"),
                hasil.getString("tglpinjam"),
                hasil.getString("tglkembali"),
                hasil.getString("idsiswa"),
                hasil.getString("nmsiswa"),
                hasil.getString("id_buku"),
                hasil.getString("jumlah"),
                hasil.getString("denda")
            });
        }

        tabledatapengembalian.setModel(tabmode3);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + e.getMessage());
    }
}

    protected void datatablepinjam() {
    Object[] Baris = {
    "Id Pinjam", "Tanggal Pinjam", "Id Siswa", "Nama Siswa", "Id Buku", "Nama Buku",
    "Penerbit", "Tahun Terbit", "Tebal Halaman", "Jumlah"};
    tabmode = new DefaultTableModel(null, Baris);
    String caridata = txtcaripinjam.getText();

    try {
        String sql = "SELECT p.id AS id_pinjam, p.id_siswa, p.nm_siswa, p.tgl_pinjam, " +
             "d.id_buku, d.nama_buku, d.penerbit, d.tahun_terbit, d.tebal_buku, d.qty " +
             "FROM peminjaman p " +
             "JOIN datapeminjaman d ON p.id = d.id_pinjam " +  // <== tambahkan SPASI di akhir
             "WHERE p.id LIKE '%" + caridata + "%' " +
             "OR d.nama_buku LIKE '%" + caridata + "%' " +
             "OR p.nm_siswa LIKE '%" + caridata + "%' " +
             "ORDER BY p.id ASC";

        Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            tabmode.addRow(new Object[]{
                hasil.getString("id_pinjam"),
                hasil.getString("tgl_pinjam"),
                hasil.getString("id_siswa"),
                hasil.getString("nm_siswa"),
                hasil.getString("id_buku"),
                hasil.getString("nama_buku"),
                hasil.getString("penerbit"),
                hasil.getString("tahun_terbit"),
                hasil.getString("tebal_buku"),
                hasil.getString("qty")
            });
        }

        tabelpinjam.setModel(tabmode);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + e.getMessage());
    }
    
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_main = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pn_view = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpinjam = new javax.swing.JTable();
        tglkembali = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtcaripinjam = new tools.JTextFieldRounded();
        bcaridata = new tools.MyButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        blihatdata = new tools.MyButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        idpengembalian = new tools.JTextFieldRounded();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pn_table = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabledatapengembalian = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        bcari = new tools.MyButton();
        txtcaridata = new tools.JTextFieldRounded();
        bcetak = new tools.MyButton();
        bkembaliview = new tools.MyButton();

        setLayout(new java.awt.CardLayout());

        pn_main.setLayout(new java.awt.CardLayout());

        pn_view.setBackground(new java.awt.Color(255, 255, 255));

        tabelpinjam.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelpinjam);

        tglkembali.setDateFormatString("dd-MM-yyyy");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Tanggal Pengembalian :");

        txtcaripinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaripinjamActionPerformed(evt);
            }
        });

        bcaridata.setBackground(new java.awt.Color(51, 153, 255));
        bcaridata.setForeground(new java.awt.Color(255, 255, 255));
        bcaridata.setText("Cari");
        bcaridata.setBorderColor(new java.awt.Color(51, 153, 255));
        bcaridata.setColor(new java.awt.Color(51, 153, 255));
        bcaridata.setColorClick(new java.awt.Color(101, 178, 255));
        bcaridata.setColorOver(new java.awt.Color(101, 178, 255));
        bcaridata.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bcaridata.setRadius(20);
        bcaridata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaridataActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-health-graph-30.png"))); // NOI18N
        jLabel2.setText("Data Peminjaman Buku Perpustakaan ");

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel5.setText("Pilih data buku yang akan di kembalikan!");

        blihatdata.setBackground(new java.awt.Color(51, 153, 255));
        blihatdata.setForeground(new java.awt.Color(255, 255, 255));
        blihatdata.setText("Lihat Data");
        blihatdata.setBorderColor(new java.awt.Color(51, 153, 255));
        blihatdata.setColor(new java.awt.Color(51, 153, 255));
        blihatdata.setColorClick(new java.awt.Color(101, 178, 255));
        blihatdata.setColorOver(new java.awt.Color(101, 178, 255));
        blihatdata.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        blihatdata.setRadius(20);
        blihatdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blihatdataActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setText("Id Pengembalian     :");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-health-graph-30.png"))); // NOI18N
        jLabel14.setText("Data Peminjaman Buku Perpustakaan ");

        idpengembalian.setText("jTextFieldRounded2");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setText("Tanggal Pinjam        :");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setText("Id Siswa                    :");

        jLabel17.setText("jLabel17");

        jLabel18.setText("jLabel18");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setText("Nama                         :");

        jLabel20.setText("jLabel20");

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel21.setText("Kelas                         :");

        javax.swing.GroupLayout pn_viewLayout = new javax.swing.GroupLayout(pn_view);
        pn_view.setLayout(pn_viewLayout);
        pn_viewLayout.setHorizontalGroup(
            pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_viewLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(518, 518, 518)
                        .addComponent(blihatdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(473, 473, 473)
                        .addComponent(txtcaripinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bcaridata, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idpengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_viewLayout.setVerticalGroup(
            pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_viewLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blihatdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(txtcaripinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcaridata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idpengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(pn_view);

        pn_main.add(jScrollPane2, "card4");

        pn_table.setBackground(new java.awt.Color(255, 255, 255));
        pn_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabledatapengembalian.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabledatapengembalian);

        pn_table.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 980, 490));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setText("Data Pengembalian");
        pn_table.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        bcari.setBackground(new java.awt.Color(51, 153, 255));
        bcari.setForeground(new java.awt.Color(255, 255, 255));
        bcari.setText("Cari");
        bcari.setBorderColor(new java.awt.Color(51, 153, 255));
        bcari.setColor(new java.awt.Color(51, 153, 255));
        bcari.setColorClick(new java.awt.Color(101, 178, 255));
        bcari.setColorOver(new java.awt.Color(101, 178, 255));
        bcari.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bcari.setRadius(20);
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });
        pn_table.add(bcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
        pn_table.add(txtcaridata, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 120, -1));

        bcetak.setBackground(new java.awt.Color(51, 153, 255));
        bcetak.setForeground(new java.awt.Color(255, 255, 255));
        bcetak.setText("Cetak Laporan");
        bcetak.setBorderColor(new java.awt.Color(51, 153, 255));
        bcetak.setColor(new java.awt.Color(51, 153, 255));
        bcetak.setColorClick(new java.awt.Color(101, 178, 255));
        bcetak.setColorOver(new java.awt.Color(101, 178, 255));
        bcetak.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bcetak.setRadius(20);
        bcetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcetakActionPerformed(evt);
            }
        });
        pn_table.add(bcetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, -1, -1));

        bkembaliview.setBackground(new java.awt.Color(51, 153, 255));
        bkembaliview.setForeground(new java.awt.Color(255, 255, 255));
        bkembaliview.setText("Kembali");
        bkembaliview.setBorderColor(new java.awt.Color(51, 153, 255));
        bkembaliview.setColor(new java.awt.Color(51, 153, 255));
        bkembaliview.setColorClick(new java.awt.Color(101, 178, 255));
        bkembaliview.setColorOver(new java.awt.Color(101, 178, 255));
        bkembaliview.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bkembaliview.setRadius(20);
        bkembaliview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkembaliviewActionPerformed(evt);
            }
        });
        pn_table.add(bkembaliview, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, -1, -1));

        pn_main.add(pn_table, "card4");

        add(pn_main, "card2");
    }// </editor-fold>//GEN-END:initComponents
    
    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        tablepengembalian();
    }//GEN-LAST:event_bcariActionPerformed

    private void bcetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcetakActionPerformed
        try{
            String reportpath = "src/report/pengembalian.jasper";
            HashMap<String, Object> parameters = new HashMap();
            JasperPrint print  = JasperFillManager.fillReport(reportpath, parameters,conn);
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_bcetakActionPerformed

    private void bkembaliviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliviewActionPerformed
        pn_main.removeAll();
        pn_main.add(pn_view);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_bkembaliviewActionPerformed

    private void blihatdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blihatdataActionPerformed
        tablepengembalian();
        pn_main.removeAll();
        pn_main.add(pn_table);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_blihatdataActionPerformed

    private void bcaridataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaridataActionPerformed
        datatablepinjam();
    }//GEN-LAST:event_bcaridataActionPerformed

    private void txtcaripinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaripinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaripinjamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tools.MyButton bcari;
    private tools.MyButton bcaridata;
    private tools.MyButton bcetak;
    private tools.MyButton bkembaliview;
    private tools.MyButton blihatdata;
    private tools.JTextFieldRounded idpengembalian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_table;
    private javax.swing.JPanel pn_view;
    private javax.swing.JTable tabelpinjam;
    private javax.swing.JTable tabledatapengembalian;
    private com.toedter.calendar.JDateChooser tglkembali;
    private tools.JTextFieldRounded txtcaridata;
    private tools.JTextFieldRounded txtcaripinjam;
    // End of variables declaration//GEN-END:variables
}
