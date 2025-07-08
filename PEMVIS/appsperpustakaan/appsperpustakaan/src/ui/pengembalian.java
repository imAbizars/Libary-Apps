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
        aktif();
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
    protected void aktif(){
        
        Object[] Baris = {
    "Id Pinjam", "Tanggal Pinjam", "Id Siswa", "Nama Siswa", "Id Buku", "Nama Buku",
    "Penerbit", "Tahun Terbit", "Tebal Halaman", "Jumlah"
        };

        tabmode2 = new DefaultTableModel(null,Baris);
        tabledata.setModel(tabmode2);
        tglkembali.setDate(new java.util.Date());
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
        pn_data = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabledata = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bsimpan = new tools.MyButton();
        bkembali = new tools.MyButton();
        idpengembalian = new tools.JTextFieldRounded();
        jLabel6 = new javax.swing.JLabel();
        bbatal = new tools.MyButton();
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
        tabelpinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpinjamMouseClicked(evt);
            }
        });
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
        jLabel2.setText("Data Pengembalian Buku Perpustakaan ");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Data Peminjaman");

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

        javax.swing.GroupLayout pn_viewLayout = new javax.swing.GroupLayout(pn_view);
        pn_view.setLayout(pn_viewLayout);
        pn_viewLayout.setHorizontalGroup(
            pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_viewLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pn_viewLayout.createSequentialGroup()
                            .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pn_viewLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(tglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(pn_viewLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtcaripinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bcaridata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(blihatdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel2))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        pn_viewLayout.setVerticalGroup(
            pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_viewLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addComponent(blihatdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bcaridata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcaripinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        pn_main.add(pn_view, "card2");

        pn_data.setBackground(new java.awt.Color(255, 255, 255));

        tabledata.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabledata);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setText("Denda                     :");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("jLabel4");

        bsimpan.setBackground(new java.awt.Color(51, 153, 255));
        bsimpan.setForeground(new java.awt.Color(255, 255, 255));
        bsimpan.setText("Simpan");
        bsimpan.setBorderColor(new java.awt.Color(51, 153, 255));
        bsimpan.setColor(new java.awt.Color(51, 153, 255));
        bsimpan.setColorClick(new java.awt.Color(101, 178, 255));
        bsimpan.setColorOver(new java.awt.Color(101, 178, 255));
        bsimpan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bsimpan.setRadius(20);
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bkembali.setBackground(new java.awt.Color(51, 153, 255));
        bkembali.setForeground(new java.awt.Color(255, 255, 255));
        bkembali.setText("Kembali");
        bkembali.setBorderColor(new java.awt.Color(51, 153, 255));
        bkembali.setColor(new java.awt.Color(51, 153, 255));
        bkembali.setColorClick(new java.awt.Color(101, 178, 255));
        bkembali.setColorOver(new java.awt.Color(101, 178, 255));
        bkembali.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bkembali.setRadius(20);
        bkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkembaliActionPerformed(evt);
            }
        });

        idpengembalian.setText("jTextFieldRounded2");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("ID Pengembalian           :");

        bbatal.setBackground(new java.awt.Color(51, 153, 255));
        bbatal.setForeground(new java.awt.Color(255, 255, 255));
        bbatal.setText("Batal");
        bbatal.setBorderColor(new java.awt.Color(51, 153, 255));
        bbatal.setColor(new java.awt.Color(51, 153, 255));
        bbatal.setColorClick(new java.awt.Color(101, 178, 255));
        bbatal.setColorOver(new java.awt.Color(101, 178, 255));
        bbatal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bbatal.setRadius(20);
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_dataLayout = new javax.swing.GroupLayout(pn_data);
        pn_data.setLayout(pn_dataLayout);
        pn_dataLayout.setHorizontalGroup(
            pn_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dataLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pn_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_dataLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(idpengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pn_dataLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pn_dataLayout.setVerticalGroup(
            pn_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dataLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pn_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idpengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        pn_main.add(pn_data, "card3");

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

    private void tabelpinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpinjamMouseClicked
       int tablepinjam = tabelpinjam.getSelectedRow();
       String a  = tabmode.getValueAt(tablepinjam, 0).toString();
       String b  = tabmode.getValueAt(tablepinjam, 1).toString();
       String c  = tabmode.getValueAt(tablepinjam, 2).toString();
       String d  = tabmode.getValueAt(tablepinjam, 3).toString();
       String e  = tabmode.getValueAt(tablepinjam, 4).toString();
       String f  = tabmode.getValueAt(tablepinjam, 5).toString();
       String g  = tabmode.getValueAt(tablepinjam, 6).toString();
       String h  = tabmode.getValueAt(tablepinjam, 7).toString();
       String i  = tabmode.getValueAt(tablepinjam, 8).toString();
       String j  = tabmode.getValueAt(tablepinjam, 9).toString();
       
      tabmode2.addRow(new Object[]{
          a,b,c,d,e,f,g,h,i,j
      });
      pn_main.removeAll();
      pn_main.add(pn_data);
      pn_main.repaint();
      pn_main.revalidate();
      hitungDenda(b);
    }//GEN-LAST:event_tabelpinjamMouseClicked
    
    private void bcaridataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaridataActionPerformed
        datatablepinjam();
    }//GEN-LAST:event_bcaridataActionPerformed

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        pn_main.removeAll();
        pn_main.add(pn_view);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_bkembaliActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
       String sql = "insert into pengembalian values(?,?,?,?,?,?,?,?,?,?,?,?)";
       String zsql = "insert into pengembalianbuku values(?,?,?,?,?,?,?)";
       
       java.sql.Date tanggalkembali = new java.sql.Date(tglkembali.getDate().getTime());
       
       try{
           PreparedStatement stat = conn.prepareStatement(sql);
           int t = tabledata.getRowCount();
           for(int i = 0; i<t;i++){
             String idpinjam = tabledata.getValueAt(i, 0).toString();
             String tglpinjam = tabledata.getValueAt(i, 1).toString();
             String idsiswa = tabledata.getValueAt(i, 2).toString();
             String nmsiswa = tabledata.getValueAt(i, 3).toString();
             String idbuku = tabledata.getValueAt(i, 4).toString();
             String nmbuku = tabledata.getValueAt(i, 5).toString();
             String penerbit = tabledata.getValueAt(i, 6).toString();
             String tahunterbit = tabledata.getValueAt(i, 7).toString();
             String tebal = tabledata.getValueAt(i, 8).toString();
             String jumlah = tabledata.getValueAt(i, 9).toString();
             
             stat.setString(1,idpengembalian.getText());
             stat.setString(2,idpinjam );
             stat.setString(3, tglpinjam);
             stat.setDate(4, tanggalkembali);
             stat.setString(5,idsiswa);
             stat.setString(6, nmsiswa);
             stat.setString(7,idbuku);
             stat.setString(8, nmbuku);
             stat.setString(9, penerbit);
             stat.setString(10, tahunterbit);
             stat.setString(11, tebal);
             stat.setString(12, jumlah);
             stat.executeUpdate();
             
            
            }
             PreparedStatement stat2 = conn.prepareStatement(zsql);
             String idpinjam2 = tabledata.getValueAt(0, 0).toString();
             String idsiswa2 = tabledata.getValueAt(0, 2).toString();
             String nmsiswa2 = tabledata.getValueAt(0, 3).toString();
             String tglpinjam2 = tabledata.getValueAt(0,1).toString();
             
             stat2.setString(1,idpengembalian.getText());
             stat2.setString(2,idpinjam2 );
             stat2.setString(3, idsiswa2);
             stat2.setString(4,nmsiswa2 );
             stat2.setString(5, tglpinjam2);
             stat2.setDate(6, tanggalkembali);
             stat2.setString(7,jLabel4.getText() );
             
             stat2.executeUpdate();
             String hapusdatapinjam = "delete from peminjaman where id =?";
             String hapusdatapinjamdetail = "delete from datapeminjaman where id_pinjam = ?";
             PreparedStatement stat3 = conn.prepareStatement(hapusdatapinjam);
             stat3.setString(1, idpinjam2);

             PreparedStatement stat4 = conn.prepareStatement(hapusdatapinjamdetail);
             stat4.setString(1, idpinjam2);
             stat3.executeUpdate();
             stat4.executeUpdate();
           JOptionPane.showMessageDialog(null, "data berhasil disimpan");
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
       }
       
        DefaultTableModel model = (DefaultTableModel) tabledata.getModel();
        model.setRowCount(0);
        datatablepinjam();
        AutoNumber();
        pn_main.removeAll();
        pn_main.add(pn_view);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
    DefaultTableModel model = (DefaultTableModel) tabledata.getModel();
    model.setRowCount(0); // Ini akan menghapus semua baris
    
    pn_main.removeAll();
    pn_main.add(pn_view);
    pn_main.repaint();
    pn_main.revalidate();
    }//GEN-LAST:event_bbatalActionPerformed

    private void blihatdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blihatdataActionPerformed
        tablepengembalian();
        pn_main.removeAll();
        pn_main.add(pn_table);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_blihatdataActionPerformed

    private void txtcaripinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaripinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaripinjamActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tools.MyButton bbatal;
    private tools.MyButton bcari;
    private tools.MyButton bcaridata;
    private tools.MyButton bcetak;
    private tools.MyButton bkembali;
    private tools.MyButton bkembaliview;
    private tools.MyButton blihatdata;
    private tools.MyButton bsimpan;
    private tools.JTextFieldRounded idpengembalian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pn_data;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_table;
    private javax.swing.JPanel pn_view;
    private javax.swing.JTable tabelpinjam;
    private javax.swing.JTable tabledata;
    private javax.swing.JTable tabledatapengembalian;
    private com.toedter.calendar.JDateChooser tglkembali;
    private tools.JTextFieldRounded txtcaridata;
    private tools.JTextFieldRounded txtcaripinjam;
    // End of variables declaration//GEN-END:variables
}
