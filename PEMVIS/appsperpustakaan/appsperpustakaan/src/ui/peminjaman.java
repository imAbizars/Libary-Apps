
package ui;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class peminjaman extends javax.swing.JPanel {
    
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode,tabmode2,tabmode3,tabmode4;
    
    
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
        Hitung();
        kosong();
    }
    protected void nama(){
        try{
            String sql = "SELECT * from datapetugas where id_petugas='"+jLabel6.getText()+"'";
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
        txtqty.requestFocus();
        tglpinjam.setDate(new java.util.Date());
        Object[] Baris = {"Kode Buku","Nama Buku","Penerbit","Tahun Terbit","Tebal Buku","Total"};
        tabmode3 = new DefaultTableModel(null,Baris);
        tablepinjam.setModel(tabmode3);
        
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
        txtqty.setText("");
        txttotal.setText("");
    }
    protected void AutoNumber(){
        try{
            String sql = "SELECT id from peminjaman order by id asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jTextFieldRounded1.setText("IN0001");
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
                jTextFieldRounded1.setText("IN" + Nol + AN);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" + e);
        }
        txtidbuku.setText("");
        txtnmbuku.setText("");
        txtpenerbit.setText("");
        txttahun.setText("");
        txttebal.setText("");
        txtqty.setText("");
    }
    protected void Hitung(){
        int totalbuku = 0 ;
        for(int i = 0; i < tablepinjam.getRowCount();i++){
            int amount = Integer.valueOf(tablepinjam.getValueAt(i, 5).toString());
            totalbuku+=amount;
        }
        txttotal.setText(Integer.toString(totalbuku));
    }
    protected void tablepeminjaman(){
        Object[] Baris = {
            "Id Pinjam", "Tanggal Pinjam", "Id Siswa", "Nama Siswa", "Id Buku", "Nama Buku",
            "Penerbit", "Tahun Terbit", "Tebal Halaman", "Jumlah"};
        tabmode4 = new DefaultTableModel(null,Baris);
        String caridata = txtcaripinjam.getText();
        
        try{
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
                tabmode4.addRow(new Object[]{
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
                tablepeminjaman.setModel(tabmode4);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + e.getMessage());
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
        txtnmbuku = new tools.JTextFieldRounded();
        jLabel23 = new javax.swing.JLabel();
        txtpenerbit = new tools.JTextFieldRounded();
        txttahun = new tools.JTextFieldRounded();
        jLabel24 = new javax.swing.JLabel();
        btambah = new tools.MyButton();
        txttebal = new tools.JTextFieldRounded();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtqty = new tools.JTextFieldRounded();
        panelRound3 = new test.PanelRound();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtidsiswa = new tools.JTextFieldRounded();
        bcarisiswa = new tools.MyButton();
        jLabel14 = new javax.swing.JLabel();
        txtnmsiswa = new tools.JTextFieldRounded();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        txtkelas = new tools.JTextFieldRounded();
        txtjenis = new tools.JTextFieldRounded();
        jLabel17 = new javax.swing.JLabel();
        txttelp = new tools.JTextFieldRounded();
        jLabel18 = new javax.swing.JLabel();
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
        pn_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepinjam = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txttotal = new tools.JTextFieldRounded();
        bsimpan = new tools.MyButton();
        jLabel9 = new javax.swing.JLabel();
        btnkembali1 = new tools.MyButton();
        btnbatal = new tools.MyButton();
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

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1088, 734));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.CardLayout());

        pn_main.setLayout(new java.awt.CardLayout());

        pn_view.setBackground(new java.awt.Color(255, 255, 255));
        pn_view.setMinimumSize(new java.awt.Dimension(1088, 734));
        pn_view.setPreferredSize(new java.awt.Dimension(1088, 734));
        pn_view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound4.setBackground(new java.awt.Color(79, 149, 157));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Data Buku");

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
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

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Nama Buku      :");

        txtnmbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmbukuActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Penerbit           :");

        txttahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttahunActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Tahun Terbit     :");

        btambah.setBackground(new java.awt.Color(51, 153, 255));
        btambah.setForeground(new java.awt.Color(255, 255, 255));
        btambah.setText("Tambah");
        btambah.setBorderColor(new java.awt.Color(51, 153, 255));
        btambah.setColor(new java.awt.Color(51, 153, 255));
        btambah.setColorClick(new java.awt.Color(101, 178, 255));
        btambah.setColorOver(new java.awt.Color(101, 178, 255));
        btambah.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btambah.setRadius(30);
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Tebal Buku       :");

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("QTY                   :");

        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(56, 56, 56))
                            .addGroup(panelRound4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel27))
                                    .addGroup(panelRound4Layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addGap(30, 30, 30)))
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRound4Layout.createSequentialGroup()
                                .addComponent(txtidbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bcaribuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txttahun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtpenerbit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnmbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttebal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel19)
                .addGap(26, 26, 26)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtidbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcaribuku, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtnmbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtpenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txttahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txttebal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pn_view.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 470, 440));

        panelRound3.setBackground(new java.awt.Color(79, 149, 157));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Data Siswa");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
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

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nama                 :");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Alamat               :");

        txtalamat.setColumns(20);
        txtalamat.setRows(5);
        jScrollPane2.setViewportView(txtalamat);

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Kelas                 :");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Jenis                 :");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("No Telepon       :");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12)
                        .addGap(24, 24, 24))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel18)))))
                .addGap(32, 32, 32)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(txtidsiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bcarisiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtjenis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(txttelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtkelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnmsiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(26, 26, 26)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtidsiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcarisiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtnmsiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtkelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txttelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pn_view.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 480, 440));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Tgl Peminjaman :");
        pn_view.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 160, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-graph-report-30.png"))); // NOI18N
        jLabel2.setText("Data Peminjaman Buku Perpustakaan");
        pn_view.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setText("ID Petugas        :");
        pn_view.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setText(" ID Peminjaman :");
        pn_view.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 150, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setText("Nama Petugas    :");
        pn_view.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 160, -1));
        pn_view.add(jTextFieldRounded1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 190, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("jLabel6");
        pn_view.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 73, -1, -1));

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

        pn_table.setBackground(new java.awt.Color(255, 255, 255));
        pn_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablepinjam.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablepinjam);

        pn_table.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 990, 480));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setText("Table Peminjaman");
        pn_table.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));
        pn_table.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 100, 80, -1));

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
        pn_table.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, 30));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("Total Buku :");
        pn_table.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, -1, -1));

        btnkembali1.setBackground(new java.awt.Color(51, 153, 255));
        btnkembali1.setForeground(new java.awt.Color(255, 255, 255));
        btnkembali1.setText("Tambah");
        btnkembali1.setBorderColor(new java.awt.Color(51, 153, 255));
        btnkembali1.setColor(new java.awt.Color(51, 153, 255));
        btnkembali1.setColorClick(new java.awt.Color(101, 178, 255));
        btnkembali1.setColorOver(new java.awt.Color(101, 178, 255));
        btnkembali1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnkembali1.setRadius(20);
        btnkembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembali1ActionPerformed(evt);
            }
        });
        pn_table.add(btnkembali1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, 30));

        btnbatal.setBackground(new java.awt.Color(51, 153, 255));
        btnbatal.setForeground(new java.awt.Color(255, 255, 255));
        btnbatal.setText("Batal");
        btnbatal.setBorderColor(new java.awt.Color(51, 153, 255));
        btnbatal.setColor(new java.awt.Color(51, 153, 255));
        btnbatal.setColorClick(new java.awt.Color(101, 178, 255));
        btnbatal.setColorOver(new java.awt.Color(101, 178, 255));
        btnbatal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnbatal.setRadius(20);
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });
        pn_table.add(btnbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, 30));

        pn_main.add(pn_table, "card3");

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
        pn_data.add(bcaridatapinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

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

        pn_data.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1000, -1));
        pn_data.add(txtcaripinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 160, -1));

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
        pn_data.add(btncetak1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, -1, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Data Peminjaman Perpustakaan SMK NEGERI 22 JAKARTA");
        pn_data.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

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
        pn_data.add(bkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, -1, 30));

        pn_main.add(pn_data, "card6");

        add(pn_main, "card4");
    }// </editor-fold>//GEN-END:initComponents

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        try{
            String kodebuku = txtidbuku.getText();
            String namabuku = txtnmbuku.getText();
            String penerbit = txtpenerbit.getText();
            String tahunterbit = txttahun.getText();
            String tebal = txttebal.getText();
            int qty = Integer.parseInt(txtqty.getText());
            
            tabmode3.addRow(new Object[]{kodebuku,namabuku,penerbit,tahunterbit,tebal,qty});
            tablepinjam.setModel(tabmode3);
        }catch(Exception e){
            System.out.println("Error : "+ e);
        }
        Hitung();
        pn_main.removeAll();
        pn_main.add(pn_table);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_btambahActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        kosong();
        aktif();
        AutoNumber();
    }//GEN-LAST:event_bbatalActionPerformed
        //method table siswa
    private void bcarisiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcarisiswaActionPerformed
        pn_main.removeAll();
        pn_main.add(pn_datasiswa);
        pn_main.repaint();
        pn_main.revalidate();
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
        Object [] Baris = {"Id Siswa","Nama","Kelas","Jenis Kelamin","Telepon","Alamat"};
        tabmode = new DefaultTableModel(null,Baris);
        String caridata = txtcaridatasiswa.getText();
        
        try{
            String sql = "SELECT * FROM datasiswa WHERE id_siswa LIKE '%" + caridata + "%' OR nm_siswa LIKE '%" + caridata + "%' ORDER BY id_siswa ASC";
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
    //end method table siswa
    
// method table buku        
    private void bcaribukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaribukuActionPerformed
        pn_main.removeAll();
        pn_main.add(pn_databuku);
        pn_main.repaint();
        pn_main.revalidate();
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

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String sql = "insert into peminjaman values(?,?,?,?,?,?)";
        String zsql = "insert into datapeminjaman values(?,?,?,?,?,?,?)";
        
        java.sql.Date tanggalpinjam = new java.sql.Date(tglpinjam.getDate().getTime());
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,jTextFieldRounded1.getText());
            stat.setString(2, txtidsiswa.getText());
            stat.setString(3,txtnmsiswa.getText());
            stat.setDate(4,tanggalpinjam );
            stat.setString(5, jLabel6.getText());
            stat.setString(6, txttotal.getText());
            stat.executeUpdate();
            int t = tablepinjam.getRowCount();
            for (int i = 0; i<t ;i++){
                String idbuku = tablepinjam.getValueAt(i, 0).toString();
                String namabuku = tablepinjam.getValueAt(i, 1).toString();
                String penerbit = tablepinjam.getValueAt(i, 2).toString();
                String tahun = tablepinjam.getValueAt(i, 3).toString();
                String tebal = tablepinjam.getValueAt(i, 4).toString();
                String qty = tablepinjam.getValueAt(i, 5).toString();
                
                PreparedStatement stat2 = conn.prepareStatement(zsql);
                stat2.setString(1,jTextFieldRounded1.getText());
                stat2.setString(2, idbuku);
                stat2.setString(3,namabuku);
                stat2.setString(4, penerbit);
                stat2.setString(5,tahun);
                stat2.setString(6, tebal);
                stat2.setString(7, qty);
                
                stat2.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        kosong();
        aktif();
        AutoNumber();
        pn_main.removeAll();
        pn_main.add(pn_view);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void btnkembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembali1ActionPerformed
        pn_main.removeAll();
        pn_main.add(pn_view);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_btnkembali1ActionPerformed

    private void bcaridatapinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaridatapinjamActionPerformed
        tablepeminjaman();
    }//GEN-LAST:event_bcaridatapinjamActionPerformed

    private void btncetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetak1ActionPerformed
        try{
            String reportpath = "src/report/peminjaman.jasper";
            HashMap<String, Object> parameters = new HashMap();
            JasperPrint print  = JasperFillManager.fillReport(reportpath, parameters,conn);
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_btncetak1ActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablepinjam.getModel();
        model.setRowCount(0); // Ini akan menghapus semua baris

        pn_main.removeAll();
        pn_main.add(pn_view);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        pn_main.removeAll();
        pn_main.add(pn_view);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_bkembaliActionPerformed

    private void txttahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttahunActionPerformed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtyActionPerformed

    private void txtnmbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmbukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmbukuActionPerformed
    protected void datatablebuku(){
        Object [] Baris = {"Id Buku","Nama Buku","Penulis","Tahun Terbit","Tebal Halaman"};
        tabmode2 = new DefaultTableModel(null,Baris);
        String caridata = txtdatatablebuku.getText();
        
        try{
            String sql = "SELECT * FROM databuku WHERE id_buku LIKE '%" + caridata + "%' OR judul_buku LIKE '%" + caridata + "%' ORDER BY id_buku ASC";
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
    private tools.MyButton bcaribuku;
    private tools.MyButton bcaridatabuku;
    private tools.MyButton bcaridatapinjam;
    private tools.MyButton bcaridatasiswa;
    private tools.MyButton bcarisiswa;
    private tools.MyButton bkembali;
    private tools.MyButton blihatdata1;
    private tools.MyButton bsimpan;
    private tools.MyButton btambah;
    private tools.MyButton btnbatal;
    private tools.MyButton btncetak1;
    private tools.MyButton btnkembali1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private tools.JTextFieldRounded jTextFieldRounded1;
    private test.PanelRound panelRound3;
    private test.PanelRound panelRound4;
    private javax.swing.JPanel pn_data;
    private javax.swing.JPanel pn_databuku;
    private javax.swing.JPanel pn_datasiswa;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_table;
    private javax.swing.JPanel pn_view;
    private javax.swing.JTable tablebuku;
    private javax.swing.JTable tablepeminjaman;
    private javax.swing.JTable tablepinjam;
    private javax.swing.JTable tablesiswa;
    private com.toedter.calendar.JDateChooser tglpinjam;
    private javax.swing.JTextArea txtalamat;
    private tools.JTextFieldRounded txtcaridatasiswa;
    private tools.JTextFieldRounded txtcaripinjam;
    private tools.JTextFieldRounded txtdatatablebuku;
    private tools.JTextFieldRounded txtidbuku;
    private tools.JTextFieldRounded txtidsiswa;
    private tools.JTextFieldRounded txtjenis;
    private tools.JTextFieldRounded txtkelas;
    private tools.JTextFieldRounded txtnmbuku;
    private tools.JTextFieldRounded txtnmsiswa;
    private tools.JTextFieldRounded txtpenerbit;
    private tools.JTextFieldRounded txtqty;
    private tools.JTextFieldRounded txttahun;
    private tools.JTextFieldRounded txttebal;
    private tools.JTextFieldRounded txttelp;
    private tools.JTextFieldRounded txttotal;
    // End of variables declaration//GEN-END:variables
}
