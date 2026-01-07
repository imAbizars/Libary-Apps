package ui;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class peminjaman extends javax.swing.JPanel {
    
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode,tabmode2,tabmode5,tabmode4;
    
    
    public peminjaman() {
        initComponents();
        String KD = UserID.getUserLogin();
        jLabel6.setText(KD);
        datatablesiswa();
        datatablebuku();
        tablepeminjaman();
        aktif();
        nama();
        AutoNumber();
        kosong();
    }
    protected void nama(){
        try{
            String sql = "SELECT * from datapetugas where id_petugas='"
                    +jLabel6.getText()+"'";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if(hasil.next()){
                jLabel7.setText(hasil.getString("nm_petugas"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal dipanggil");
        }
    }
    protected void aktif(){
        Object[] Baris = {"Id Detail","Id Pinjam" ,"Tanggal Pinjam", "Id Siswa",
            "Nama", "Kelas", "No Telp",
        "Id Buku", "Nama Buku", "Penerbit", "Tahun", "Tebal", "Tanggal Kembali"
        };
        tabmode5 = new DefaultTableModel(null,Baris);
        jTable1.setModel(tabmode5);
        tglpinjam.setDate(new java.util.Date());
    }
    protected void kosong(){
        txtidsiswa.setText("");
        txtnmsiswa.setText("");
        txtkelas.setText("");
        txtjenis.setText("");
        txttelp.setText("");
        txtalamat.setText("");
        txtidbuku.setText("");
        txtnmbuku.setText("");
        txtpenerbit.setText("");
        txttahun.setText("");
        txttebal.setText("");
    }
    protected void AutoNumber(){
         try {
            String sql = "SELECT id_peminjaman FROM peminjaman ORDER BY "
                    + "id_peminjaman DESC LIMIT 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String nextID;
            if (rs.next()) {
                String lastID = rs.getString("id_peminjaman").substring(3);
                int number = Integer.parseInt(lastID) + 1;                 
                nextID = String.format("PMJ%04d", number);
            } else {
                nextID = "PMJ0001";
            }
            jTextFieldRounded1.setText(nextID);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto Number Error: " + 
                    e.getMessage());
        }
    }
    private String autoDetailPerPinjam(String idPinjam) {
        int count = tabmode5.getRowCount() + 1;
        return idPinjam + "-DT" + String.format("%03d", count);
    }
    protected void tablepeminjaman() {
        Object[] Baris = {
            "ID Pinjam", "Tanggal Pinjam",
            "ID Siswa", "Nama Siswa", "Kelas", "Telp",
            "ID Buku", "Nama Buku", "Penerbit", "Tahun Terbit", "Tebal Halaman"
        };
        tabmode4 = new DefaultTableModel(null, Baris);
        String caridata = txtcaripinjam.getText();
        try {
            String sql =
                "SELECT p.id_peminjaman, p.tgl_pinjam, " +
                "       s.id_siswa, s.nm_siswa, s.kelas, s.telepon, " +
                "       b.id_buku, b.judul_buku, b.nama_penulis, "
                    + "b.tahun_terbit, b.tebal_buku " +
                "FROM peminjaman p " +
                "JOIN datasiswa s ON p.id_siswa = s.id_siswa " +
                "JOIN detail_peminjaman d ON "
                    + "p.id_peminjaman = d.id_peminjaman " +
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
                    hasil.getString("tebal_buku")
                });
            }
            tablepeminjaman.setModel(tabmode4);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " 
                    + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_main = new javax.swing.JPanel();
        pn_view = new javax.swing.JPanel();
        panelRound4 = new test.PanelRound();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtidbuku = new tools.JTextFieldRounded();
        bcaribuku = new tools.MyButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btambah = new tools.MyButton();
        jLabel26 = new javax.swing.JLabel();
        txtnmbuku = new javax.swing.JLabel();
        txtpenerbit = new javax.swing.JLabel();
        txttahun = new javax.swing.JLabel();
        txttebal = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tglpinjam1 = new com.toedter.calendar.JDateChooser();
        panelRound3 = new test.PanelRound();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtidsiswa = new tools.JTextFieldRounded();
        bcarisiswa = new tools.MyButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtnmsiswa = new javax.swing.JLabel();
        txtkelas = new javax.swing.JLabel();
        txtjenis = new javax.swing.JLabel();
        txttelp = new javax.swing.JLabel();
        txtalamat = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldRounded1 = new tools.JTextFieldRounded();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bbatal = new tools.MyButton();
        tglpinjam = new com.toedter.calendar.JDateChooser();
        blihatdata1 = new tools.MyButton();
        pn_datasiswa = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablesiswa = new javax.swing.JTable();
        bcaridatasiswa = new tools.MyButton();
        txtcaridatasiswa = new tools.JTextFieldRounded();
        pn_databuku = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablebuku = new javax.swing.JTable();
        bcaridatabuku = new tools.MyButton();
        txtdatatablebuku = new tools.JTextFieldRounded();
        pn_data = new javax.swing.JPanel();
        bcaridatapinjam = new tools.MyButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablepeminjaman = new javax.swing.JTable();
        txtcaripinjam = new tools.JTextFieldRounded();
        btncetak1 = new tools.MyButton();
        jLabel10 = new javax.swing.JLabel();
        bkembali = new tools.MyButton();
        pn_pinjam = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bsimpan1 = new tools.MyButton();
        bbatal1 = new tools.MyButton();
        bhapus = new tools.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1088, 734));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.CardLayout());

        pn_main.setBackground(new java.awt.Color(255, 255, 255));
        pn_main.setLayout(new java.awt.CardLayout());

        pn_view.setBackground(new java.awt.Color(255, 255, 255));
        pn_view.setForeground(new java.awt.Color(255, 255, 255));
        pn_view.setMinimumSize(new java.awt.Dimension(1088, 734));
        pn_view.setOpaque(false);
        pn_view.setPreferredSize(new java.awt.Dimension(1088, 734));
        pn_view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound4.setBackground(new java.awt.Color(79, 149, 157));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Data Buku");

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("ID Buku            : ");

        bcaribuku.setBackground(new java.awt.Color(51, 153, 255));
        bcaribuku.setForeground(new java.awt.Color(255, 255, 255));
        bcaribuku.setText("Cari");
        bcaribuku.setBorderColor(new java.awt.Color(51, 153, 255));
        bcaribuku.setColor(new java.awt.Color(51, 153, 255));
        bcaribuku.setColorClick(new java.awt.Color(101, 178, 255));
        bcaribuku.setColorOver(new java.awt.Color(101, 178, 255));
        bcaribuku.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bcaribuku.setRadius(20);
        bcaribuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaribukuActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Nama Buku       :");

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Penerbit             :");

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Tahun Terbit     :");

        btambah.setBackground(new java.awt.Color(51, 153, 255));
        btambah.setForeground(new java.awt.Color(255, 255, 255));
        btambah.setText("Masukkan Peminjaman");
        btambah.setBorderColor(new java.awt.Color(51, 153, 255));
        btambah.setColor(new java.awt.Color(51, 153, 255));
        btambah.setColorClick(new java.awt.Color(101, 178, 255));
        btambah.setColorOver(new java.awt.Color(101, 178, 255));
        btambah.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btambah.setRadius(30);
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Tebal Buku        :");

        txtnmbuku.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtnmbuku.setForeground(new java.awt.Color(255, 255, 255));
        txtnmbuku.setText("jLabel25");

        txtpenerbit.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtpenerbit.setForeground(new java.awt.Color(255, 255, 255));
        txtpenerbit.setText("jLabel25");

        txttahun.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txttahun.setForeground(new java.awt.Color(255, 255, 255));
        txttahun.setText("jLabel25");

        txttebal.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txttebal.setForeground(new java.awt.Color(255, 255, 255));
        txttebal.setText("jLabel25");

        jLabel25.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("*Hasil pencarian akan tampil dibawah");

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Tgl kembali        :");

        tglpinjam1.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound4Layout.createSequentialGroup()
                                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound4Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelRound4Layout.createSequentialGroup()
                                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelRound4Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel26)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound4Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound4Layout.createSequentialGroup()
                                .addComponent(txtidbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bcaribuku, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound4Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tglpinjam1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtnmbuku, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                        .addComponent(txtpenerbit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txttahun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txttebal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(38, 38, 38))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bcaribuku, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(txtidbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel25)
                        .addGap(27, 27, 27)
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtnmbuku))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpenerbit)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttahun)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttebal)
                            .addComponent(jLabel26))
                        .addGap(17, 17, 17)
                        .addComponent(jLabel27))
                    .addComponent(tglpinjam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pn_view.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 440, 400));

        panelRound3.setBackground(new java.awt.Color(79, 149, 157));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Data Siswa");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ID Siswa            : ");

        bcarisiswa.setForeground(new java.awt.Color(255, 255, 255));
        bcarisiswa.setText("Cari");
        bcarisiswa.setBorderColor(new java.awt.Color(51, 153, 255));
        bcarisiswa.setColor(new java.awt.Color(51, 153, 255));
        bcarisiswa.setColorClick(new java.awt.Color(101, 178, 255));
        bcarisiswa.setColorOver(new java.awt.Color(101, 178, 255));
        bcarisiswa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bcarisiswa.setRadius(20);
        bcarisiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcarisiswaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nama                 :");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Alamat               :");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Kelas                 :");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Jenis                 :");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("No Telepon       :");

        txtnmsiswa.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtnmsiswa.setForeground(new java.awt.Color(255, 255, 255));
        txtnmsiswa.setText("jLabel11");

        txtkelas.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtkelas.setForeground(new java.awt.Color(255, 255, 255));
        txtkelas.setText("jLabel11");

        txtjenis.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtjenis.setForeground(new java.awt.Color(255, 255, 255));
        txtjenis.setText("jLabel22");

        txttelp.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txttelp.setForeground(new java.awt.Color(255, 255, 255));
        txttelp.setText("jLabel22");

        txtalamat.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtalamat.setForeground(new java.awt.Color(255, 255, 255));
        txtalamat.setText("jLabel22");

        jLabel11.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("*Hasil pencarian akan tampil dibawah");

        jLabel22.setFont(new java.awt.Font("SansSerif", 3, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/warning (1).png"))); // NOI18N
        jLabel22.setText("(Note) pastikan data siswa sudah benar pada hasil diatas!");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidsiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bcarisiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addGroup(panelRound3Layout.createSequentialGroup()
                                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel14))
                                .addGap(31, 31, 31)
                                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnmsiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtkelas, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelp, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtidsiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcarisiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(27, 27, 27)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtnmsiswa))
                .addGap(18, 18, 18)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtkelas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtjenis))
                .addGap(18, 18, 18)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txttelp))
                .addGap(18, 18, 18)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtalamat))
                .addGap(33, 33, 33)
                .addComponent(jLabel22)
                .addGap(49, 49, 49))
        );

        pn_view.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 430, 400));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Tgl Peminjaman :");
        pn_view.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 160, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-graph-report-30.png"))); // NOI18N
        jLabel2.setText("Data Peminjaman Buku Perpustakaan");
        pn_view.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("ID Petugas        :");
        pn_view.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText(" ID Peminjaman :");
        pn_view.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 150, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Nama Petugas    :");
        pn_view.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 160, -1));
        pn_view.add(jTextFieldRounded1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 180, 20));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("jLabel6");
        pn_view.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("jLabel7");
        pn_view.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 73, -1, -1));

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
        pn_view.add(bbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, 100, -1));

        tglpinjam.setDateFormatString("dd-MM-yyyy");
        pn_view.add(tglpinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 140, -1));

        blihatdata1.setBackground(new java.awt.Color(51, 153, 255));
        blihatdata1.setForeground(new java.awt.Color(255, 255, 255));
        blihatdata1.setText("Lihat Data");
        blihatdata1.setBorderColor(new java.awt.Color(51, 153, 255));
        blihatdata1.setColor(new java.awt.Color(51, 153, 255));
        blihatdata1.setColorClick(new java.awt.Color(101, 178, 255));
        blihatdata1.setColorOver(new java.awt.Color(101, 178, 255));
        blihatdata1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        blihatdata1.setRadius(20);
        blihatdata1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blihatdata1ActionPerformed(evt);
            }
        });
        pn_view.add(blihatdata1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, -1, -1));

        pn_main.add(pn_view, "card4");

        pn_datasiswa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablesiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        tablesiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablesiswaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablesiswa);

        pn_datasiswa.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 1010, -1));

        bcaridatasiswa.setBackground(new java.awt.Color(51, 153, 255));
        bcaridatasiswa.setForeground(new java.awt.Color(255, 255, 255));
        bcaridatasiswa.setText("Cari");
        bcaridatasiswa.setBorderColor(new java.awt.Color(51, 153, 255));
        bcaridatasiswa.setColor(new java.awt.Color(51, 153, 255));
        bcaridatasiswa.setColorClick(new java.awt.Color(101, 178, 255));
        bcaridatasiswa.setColorOver(new java.awt.Color(101, 178, 255));
        bcaridatasiswa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bcaridatasiswa.setRadius(20);
        bcaridatasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaridatasiswaActionPerformed(evt);
            }
        });
        pn_datasiswa.add(bcaridatasiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, -1, -1));

        txtcaridatasiswa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcaridatasiswaKeyPressed(evt);
            }
        });
        pn_datasiswa.add(txtcaridatasiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 50, 150, -1));

        pn_main.add(pn_datasiswa, "card4");

        pn_databuku.setBackground(new java.awt.Color(255, 255, 255));
        pn_databuku.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablebuku.setModel(new javax.swing.table.DefaultTableModel(
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
        tablebuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebukuMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablebuku);

        pn_databuku.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 1010, -1));

        bcaridatabuku.setBackground(new java.awt.Color(51, 153, 255));
        bcaridatabuku.setForeground(new java.awt.Color(255, 255, 255));
        bcaridatabuku.setText("Cari");
        bcaridatabuku.setBorderColor(new java.awt.Color(51, 153, 255));
        bcaridatabuku.setColor(new java.awt.Color(51, 153, 255));
        bcaridatabuku.setColorClick(new java.awt.Color(101, 178, 255));
        bcaridatabuku.setColorOver(new java.awt.Color(101, 178, 255));
        bcaridatabuku.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bcaridatabuku.setRadius(20);
        bcaridatabuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaridatabukuActionPerformed(evt);
            }
        });
        pn_databuku.add(bcaridatabuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, -1, -1));

        txtdatatablebuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdatatablebukuKeyPressed(evt);
            }
        });
        pn_databuku.add(txtdatatablebuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 50, 150, -1));

        pn_main.add(pn_databuku, "card4");

        pn_data.setBackground(new java.awt.Color(255, 255, 255));
        pn_data.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bcaridatapinjam.setBackground(new java.awt.Color(51, 153, 255));
        bcaridatapinjam.setForeground(new java.awt.Color(255, 255, 255));
        bcaridatapinjam.setText("Cari");
        bcaridatapinjam.setBorderColor(new java.awt.Color(51, 153, 255));
        bcaridatapinjam.setColor(new java.awt.Color(51, 153, 255));
        bcaridatapinjam.setColorClick(new java.awt.Color(101, 178, 255));
        bcaridatapinjam.setColorOver(new java.awt.Color(101, 178, 255));
        bcaridatapinjam.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bcaridatapinjam.setRadius(20);
        bcaridatapinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaridatapinjamActionPerformed(evt);
            }
        });
        pn_data.add(bcaridatapinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

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
        jScrollPane5.setViewportView(tablepeminjaman);

        pn_data.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 1000, 320));
        pn_data.add(txtcaripinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 160, -1));

        btncetak1.setBackground(new java.awt.Color(51, 153, 255));
        btncetak1.setForeground(new java.awt.Color(255, 255, 255));
        btncetak1.setText("Cetak Laporan");
        btncetak1.setBorderColor(new java.awt.Color(51, 153, 255));
        btncetak1.setColor(new java.awt.Color(51, 153, 255));
        btncetak1.setColorClick(new java.awt.Color(101, 178, 255));
        btncetak1.setColorOver(new java.awt.Color(101, 178, 255));
        btncetak1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btncetak1.setRadius(20);
        btncetak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetak1ActionPerformed(evt);
            }
        });
        pn_data.add(btncetak1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, -1, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Data Peminjaman Perpustakaan SMK NEGERI 22 JAKARTA");
        pn_data.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

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
        pn_data.add(bkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, -1, 30));

        pn_main.add(pn_data, "card6");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-graph-report-30.png"))); // NOI18N
        jLabel8.setText("Keranjang Peminjaman Buku");

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

        bsimpan1.setForeground(new java.awt.Color(255, 255, 255));
        bsimpan1.setText("Simpan");
        bsimpan1.setBorderColor(new java.awt.Color(51, 153, 255));
        bsimpan1.setColor(new java.awt.Color(51, 153, 255));
        bsimpan1.setColorClick(new java.awt.Color(101, 178, 255));
        bsimpan1.setColorOver(new java.awt.Color(101, 178, 255));
        bsimpan1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bsimpan1.setRadius(20);
        bsimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpan1ActionPerformed(evt);
            }
        });

        bbatal1.setForeground(new java.awt.Color(255, 255, 255));
        bbatal1.setText("Tambah");
        bbatal1.setBorderColor(new java.awt.Color(51, 153, 255));
        bbatal1.setColor(new java.awt.Color(51, 153, 255));
        bbatal1.setColorClick(new java.awt.Color(101, 178, 255));
        bbatal1.setColorOver(new java.awt.Color(101, 178, 255));
        bbatal1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bbatal1.setRadius(20);
        bbatal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatal1ActionPerformed(evt);
            }
        });

        bhapus.setForeground(new java.awt.Color(255, 255, 255));
        bhapus.setText("Hapus");
        bhapus.setBorderColor(new java.awt.Color(51, 153, 255));
        bhapus.setColor(new java.awt.Color(51, 153, 255));
        bhapus.setColorClick(new java.awt.Color(101, 178, 255));
        bhapus.setColorOver(new java.awt.Color(101, 178, 255));
        bhapus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bhapus.setRadius(20);
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_pinjamLayout = new javax.swing.GroupLayout(pn_pinjam);
        pn_pinjam.setLayout(pn_pinjamLayout);
        pn_pinjamLayout.setHorizontalGroup(
            pn_pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_pinjamLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pn_pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(pn_pinjamLayout.createSequentialGroup()
                        .addComponent(bsimpan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bbatal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pn_pinjamLayout.setVerticalGroup(
            pn_pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_pinjamLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel8)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(pn_pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbatal1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(367, Short.MAX_VALUE))
        );

        pn_main.add(pn_pinjam, "card6");

        add(pn_main, "card4");
    }// </editor-fold>//GEN-END:initComponents

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
       try {
        String idPinjam = jTextFieldRounded1.getText();
        String idDetail = autoDetailPerPinjam(idPinjam);
        java.sql.Date tanggalPinjam = new java.sql.Date
        (tglpinjam.getDate().getTime());
        java.sql.Date tanggalKembali = new java.sql.Date
        (tglpinjam1.getDate().getTime());
        tabmode5.addRow(new Object[]{
            idDetail,
            idPinjam,
            tanggalPinjam,
            txtidsiswa.getText(),
            txtnmsiswa.getText(),
            txtkelas.getText(),
            txttelp.getText(),
            txtidbuku.getText(),
            txtnmbuku.getText(),
            txtpenerbit.getText(),
            txttahun.getText(),
            txttebal.getText(),
            tanggalKembali
        });
        jTable1.setModel(tabmode5);
    } catch (Exception e) {
        System.err.println("Error : " + e);
    }
    pn_main.removeAll();
    pn_main.add(pn_pinjam);
    pn_main.repaint();
    pn_main.revalidate();
    }//GEN-LAST:event_btambahActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        kosong();
        aktif();
        AutoNumber();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bcarisiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcarisiswaActionPerformed
        String idSiswa = txtidsiswa.getText().trim();
        if(idSiswa.isEmpty()){
            pn_main.removeAll();
            pn_main.add(pn_datasiswa);
            pn_main.repaint();
            pn_main.revalidate();
        }else{
            try{
                String sql = "SELECT * FROM datasiswa WHERE id_siswa = ?";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1,idSiswa);
                ResultSet hasil = stat.executeQuery();
                if(hasil.next()){
                    txtnmsiswa.setText(hasil.getString("nm_siswa"));
                    txtkelas.setText(hasil.getString("kelas"));
                    txtjenis.setText(hasil.getString("jenis"));
                    txttelp.setText(hasil.getString("telepon"));
                    txtalamat.setText(hasil.getString("alamat"));
                }else{
                    JOptionPane.showMessageDialog(this, "data siswa dengan id "+
                            idSiswa+"tidak ditemukan");
                }
                hasil.close();
                stat.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "terjadi kesalahan"
                        +e.getMessage());
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_bcarisiswaActionPerformed
    private void tablesiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablesiswaMouseClicked
        int tabledatasiswa = tablesiswa.getSelectedRow();
        String a = tabmode.getValueAt(tabledatasiswa, 0).toString();
       String b = tabmode.getValueAt(tabledatasiswa, 1).toString();
       String c = tabmode.getValueAt(tabledatasiswa, 2).toString();
       String d = tabmode.getValueAt(tabledatasiswa, 3).toString();
       String e = tabmode.getValueAt(tabledatasiswa, 4).toString();
       String f = tabmode.getValueAt(tabledatasiswa, 5).toString();
        txtidsiswa.setText(a);
        txtnmsiswa.setText(b);
        txtkelas.setText(c);
        txtjenis.setText(d);
        txttelp.setText(e);
        txtalamat.setText(f);
        pn_main.removeAll();
        pn_main.add(pn_view);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_tablesiswaMouseClicked
    protected void datatablesiswa(){
        Object [] Baris = {"Id Siswa","Nama","Kelas","Jenis Kelamin","Telepon",
            "Alamat"};
        tabmode = new DefaultTableModel(null,Baris);
        String caridata = txtcaridatasiswa.getText();
        try{
            String sql = "SELECT * FROM datasiswa WHERE id_siswa LIKE '%"
                    + caridata + "%' OR nm_siswa LIKE '%" + caridata + "%' "
                    + "ORDER BY id_siswa ASC";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                });
            }
            tablesiswa.setModel(tabmode);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"data gagal dipanggil"+ e);
        }
    }     
    private void bcaribukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaribukuActionPerformed
        String idBuku = txtidbuku.getText().trim();
        if(idBuku.isEmpty()){
           pn_main.removeAll();
           pn_main.add(pn_databuku);
           pn_main.repaint();
           pn_main.revalidate(); 
        }else{
            try{
                String sql = "SELECT * FROM databuku WHERE id_buku = ?";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, idBuku);
                ResultSet hasil = stat.executeQuery();
                if(hasil.next()){
                    txtnmbuku.setText(hasil.getString("judul_buku"));
                    txtpenerbit.setText(hasil.getString("nama_penulis"));
                    txttahun.setText(hasil.getString("tahun_terbit"));
                    txttebal.setText(hasil.getString("tebal_buku"));
                }else{
                    JOptionPane.showMessageDialog(this,"data buku dengan id " 
                            + idBuku+ " tidak ditemukan" );
                    txtidbuku.setText("");
                    txtnmbuku.setText("");
                    txtpenerbit.setText("");
                    txttahun.setText("");
                    txttebal.setText("");
                }
                hasil.close();
                stat.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"terjadi kesalahan"
                        +e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_bcaribukuActionPerformed

    private void tablebukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebukuMouseClicked
        int tabledatabuku = tablebuku.getSelectedRow();
        String a = tabmode2.getValueAt(tabledatabuku, 0).toString();
       String b = tabmode2.getValueAt(tabledatabuku, 1).toString();
       String c = tabmode2.getValueAt(tabledatabuku, 2).toString();
       String d = tabmode2.getValueAt(tabledatabuku, 3).toString();
       String e = tabmode2.getValueAt(tabledatabuku, 4).toString();
        txtidbuku.setText(a);
        txtnmbuku.setText(b);
        txtpenerbit.setText(c);
        txttahun.setText(d);
        txttebal.setText(e);
        java.util.Date tglPinjam = tglpinjam.getDate();
        if (tglPinjam != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(tglPinjam);
            cal.add(Calendar.DAY_OF_MONTH, 30);
            tglpinjam1.setDate(cal.getTime());
        }
        pn_main.removeAll();
        pn_main.add(pn_view);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_tablebukuMouseClicked

    private void bcaridatasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaridatasiswaActionPerformed
        datatablesiswa();
    }//GEN-LAST:event_bcaridatasiswaActionPerformed

    private void txtcaridatasiswaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaridatasiswaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            datatablesiswa();
        }
    }//GEN-LAST:event_txtcaridatasiswaKeyPressed

    private void bcaridatabukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaridatabukuActionPerformed
        datatablebuku();
    }//GEN-LAST:event_bcaridatabukuActionPerformed

    private void txtdatatablebukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdatatablebukuKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            datatablebuku();
        }
    }//GEN-LAST:event_txtdatatablebukuKeyPressed

    private void blihatdata1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blihatdata1ActionPerformed
        tablepeminjaman();
        pn_main.removeAll();
        pn_main.add(pn_data);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_blihatdata1ActionPerformed

    private void bcaridatapinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaridatapinjamActionPerformed
        tablepeminjaman();
    }//GEN-LAST:event_bcaridatapinjamActionPerformed

    private void btncetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetak1ActionPerformed
        try{
            String reportpath = "src/report/peminjaman.jasper";
            HashMap<String, Object> parameters = new HashMap();
            JasperPrint print  = JasperFillManager.fillReport(reportpath, 
                    parameters,conn);
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_btncetak1ActionPerformed

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        pn_main.removeAll();
        pn_main.add(pn_view);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_bkembaliActionPerformed
    private void simpanMaster() throws SQLException {
        String sql = "INSERT INTO peminjaman (id_peminjaman, tgl_pinjam, "
                + "id_siswa, nama_siswa, kelas, telp, tgl_kembali) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, jTextFieldRounded1.getText());
        stat.setDate(2, new java.sql.Date(tglpinjam.getDate().getTime()));
        stat.setString(3, txtidsiswa.getText());
        stat.setString(4, txtnmsiswa.getText());
        stat.setString(5, txtkelas.getText());
        stat.setString(6, txttelp.getText());
        stat.setDate(7, new java.sql.Date(tglpinjam1.getDate().getTime()));
        stat.executeUpdate();
    }
    private void simpanDetail() throws SQLException {
        String sql = "INSERT INTO detail_peminjaman "
                   + "(id_detail, id_peminjaman, id_buku, nama_buku, penerbit, "
                + "tahun_terbit, tebal_buku, status) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int rowCount = jTable1.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, jTable1.getValueAt(i, 0).toString()); // id_detail
            stat.setString(2, jTable1.getValueAt(i, 1).toString()); // id_peminjaman
            stat.setString(3, jTable1.getValueAt(i, 7).toString()); // id_buku
            stat.setString(4, jTable1.getValueAt(i, 8).toString()); // nama_buku
            stat.setString(5, jTable1.getValueAt(i, 9).toString()); // penerbit
            stat.setString(6, jTable1.getValueAt(i,10).toString()); // tahun
            stat.setString(7, jTable1.getValueAt(i,11).toString()); // tebal
            stat.setString(8,"Dipinjam");
            stat.executeUpdate();
        }
    }

    private void bsimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpan1ActionPerformed
        try {
            simpanMaster();
            simpanDetail();
            Object[] options = {"Cetak Bukti", "Tidak"};
            int pilih = JOptionPane.showOptionDialog(
                    null,
                    "<html>Data Berhasil Disimpan"
                            + "<br>Ingin mencetak bukti?</html>",
                    "Cetak",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (pilih == 0) {
                cetakBukti();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Penyimpanan gagal: " 
                    + e.getMessage());
        }
        kosong();
        aktif();
        AutoNumber();
    }//GEN-LAST:event_bsimpan1ActionPerformed
    
    public void cetakBukti(){
        try {
        JRTableModelDataSource dataSource = new JRTableModelDataSource
        (jTable1.getModel());
        JasperPrint print = JasperFillManager.fillReport(
                "src/report/buktipinjam.jasper", 
                null,
                dataSource
        );
        JasperViewer.viewReport(print, false);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal mencetak: " 
                + e.getMessage());
    } 
    }
    private void bbatal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatal1ActionPerformed
        pn_main.removeAll();
        pn_main.add(pn_view);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_bbatal1ActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int row = jTable1.getSelectedRow();
        if (row != -1) {int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Yakin ingin menghapus baris ini?",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                ((DefaultTableModel) jTable1.getModel()).removeRow(row);
            }
        } else {
            JOptionPane.showMessageDialog
        (null, "Pilih baris yang ingin dihapus!");
        }
    }//GEN-LAST:event_bhapusActionPerformed
    protected void datatablebuku(){
        Object [] Baris = {"Id Buku","Nama Buku","Penulis",
            "Tahun Terbit","Tebal Halaman"};
        tabmode2 = new DefaultTableModel(null,Baris);
        String caridata = txtdatatablebuku.getText();
        try{
            String sql = "SELECT * FROM databuku WHERE id_buku LIKE '%" 
                    + caridata + "%' OR judul_buku LIKE '%" + caridata + "%' "
                    + "ORDER BY id_buku ASC";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                tabmode2.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                });
            }
            tablebuku.setModel(tabmode2);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"data gagal dipanggil"+ e);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tools.MyButton bbatal;
    private tools.MyButton bbatal1;
    private tools.MyButton bcaribuku;
    private tools.MyButton bcaridatabuku;
    private tools.MyButton bcaridatapinjam;
    private tools.MyButton bcaridatasiswa;
    private tools.MyButton bcarisiswa;
    private tools.MyButton bhapus;
    private tools.MyButton bkembali;
    private tools.MyButton blihatdata1;
    private tools.MyButton bsimpan1;
    private tools.MyButton btambah;
    private tools.MyButton btncetak1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private tools.JTextFieldRounded jTextFieldRounded1;
    private test.PanelRound panelRound3;
    private test.PanelRound panelRound4;
    private javax.swing.JPanel pn_data;
    private javax.swing.JPanel pn_databuku;
    private javax.swing.JPanel pn_datasiswa;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_pinjam;
    private javax.swing.JPanel pn_view;
    private javax.swing.JTable tablebuku;
    private javax.swing.JTable tablepeminjaman;
    private javax.swing.JTable tablesiswa;
    private com.toedter.calendar.JDateChooser tglpinjam;
    private com.toedter.calendar.JDateChooser tglpinjam1;
    private javax.swing.JLabel txtalamat;
    private tools.JTextFieldRounded txtcaridatasiswa;
    private tools.JTextFieldRounded txtcaripinjam;
    private tools.JTextFieldRounded txtdatatablebuku;
    private tools.JTextFieldRounded txtidbuku;
    private tools.JTextFieldRounded txtidsiswa;
    private javax.swing.JLabel txtjenis;
    private javax.swing.JLabel txtkelas;
    private javax.swing.JLabel txtnmbuku;
    private javax.swing.JLabel txtnmsiswa;
    private javax.swing.JLabel txtpenerbit;
    private javax.swing.JLabel txttahun;
    private javax.swing.JLabel txttebal;
    private javax.swing.JLabel txttelp;
    // End of variables declaration//GEN-END:variables
}
