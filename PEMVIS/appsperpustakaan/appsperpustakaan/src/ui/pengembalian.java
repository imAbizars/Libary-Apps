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
        Aktif();
        tablePeminjaman();
        AutoNumber();
    }
    
    
    protected void Aktif(){
        Object[] Baris = {
            "Id Peminjaman","Tgl Pinjam","Id Siswa","Nama Siswa",
            "Id Buku","Nama Buku","Penerbit","Denda","Kondisi"
        };
        tabmode2 = new DefaultTableModel(null,Baris);
        tablekembali.setModel(tabmode2);
        tgalkembali.setDate(new java.util.Date());
    }
        
    protected void AutoNumber(){
        try{
            String sql = "SELECT id from pengembalian order by id asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jLabel33.setText("IN0001");
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
                jLabel33.setText("IN" + Nol + AN);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" + e);
        }
     }
    private String autoDetailPerPinjam(String idPinjam) {
        String nextID = idPinjam + "-DT001";

        try {
            String sql = "SELECT id FROM detail_pengembalian WHERE id_pengembalian=? ORDER BY id DESC LIMIT 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idPinjam);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Ambil angka setelah DT
                String lastID = rs.getString("id"); // contoh: PMJ0007-DT003
                String nomor = lastID.substring(lastID.length() - 3); // "003"

                int nextNo = Integer.parseInt(nomor) + 1;

                nextID = idPinjam + "-DT" + String.format("%03d", nextNo);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto Detail Error: " + e.getMessage());
        }

        return nextID;
    }
    private void tablePeminjaman(){
        Object[] kolom = {
            "ID Pinjam", "Tanggal Pinjam", "ID Siswa", "Nama Siswa",
            "ID Buku", "Nama Buku", "Penerbit"
        };
        tabmode = new DefaultTableModel(null, kolom);
        String caridata = txtcaripinjam.getText().trim();

        try{
            String sql =
                "SELECT p.id_peminjaman, p.tgl_pinjam, p.id_siswa, p.nama_siswa, " +
                "d.id_buku, d.nama_buku, d.penerbit " +
                "FROM peminjaman p " +
                "JOIN detail_peminjaman d ON p.id_peminjaman = d.id_peminjaman " +
                "WHERE p.id_peminjaman LIKE ? OR p.nama_siswa LIKE ? OR p.id_siswa LIKE ? " +
                "ORDER BY p.id_peminjaman ASC";

            PreparedStatement ps = conn.prepareStatement(sql);
            String like = "%" + caridata + "%";
            ps.setString(1, like);
            ps.setString(2, like);
            ps.setString(3, like);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tabmode.addRow(new Object[]{
                    rs.getString("id_peminjaman"),
                    rs.getDate("tgl_pinjam"),
                    rs.getString("id_siswa"),
                    rs.getString("nama_siswa"),
                    rs.getString("id_buku"),
                    rs.getString("nama_buku"),
                    rs.getString("penerbit")
                });
            }
            tabelpinjam.setModel(tabmode);
        } catch(Exception e){
            System.out.println("data gagal di panggil : " + e);
        }
    }
    
    private Date ambilTanggalPinjam(String idPinjam){
         try {
        String sql = "SELECT tgl_kembali FROM peminjaman WHERE id_peminjaman=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, idPinjam);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getDate("tgl_kembali");  
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
    }
    
    private int hitungDenda(Date tglkembali,Date tgldikembalikan){
        long selisih = tgldikembalikan.getTime() - tglkembali.getTime();

        // konversi selisih ke hari
        long hariTelat = selisih / (1000 * 60 * 60 * 24);

        if (hariTelat <= 0) {
            return 0; // tidak telat, denda 0
        }

        // hari pertama: 3000
        // hari selanjutnya: +1000
        return 3000 + (int)((hariTelat - 1) * 1000);
    }
    
    private void hapusDetail(String idPinjam,String idBuku){
        String sql = "DELETE FROM detail_peminjaman WHERE id_peminjaman=? AND id_buku=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idPinjam);
            ps.setString(2,idBuku);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private boolean checkDetail(String idPinjam){
         try{
             String sql = "SELECT COUNT(*) AS total from detail_peminjaman WHERE id_peminjaman=?";
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, idPinjam);
             ResultSet hasil = ps.executeQuery();
             
             if(hasil.next()){
                 return hasil.getInt("total")>0;
             }
         }catch(Exception e){
             e.printStackTrace();
         }
         return false;
    }
    private void hapusMaster(String idPinjam){
        try{
            String sql = "DELETE FROM peminjaman WHERE id_peminjaman=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idPinjam);;
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private int totalDendaGlobal = 0;

    private void hitungTotalDenda(){
        int total = 0;
        for(int i = 0; i < tabmode2.getRowCount(); i++){
            total += Integer.parseInt(tabmode2.getValueAt(i, 7).toString());
        }
        totalDendaGlobal = total;
        jLabel4.setText("Rp " + totalDendaGlobal);
    }
    private void tambahKeKeranjang(){
        int row = tabelpinjam.getSelectedRow();
        if(row == -1) return;

        String idPinjam = tabelpinjam.getValueAt(row, 0).toString();
        Date tglKembali = ambilTanggalPinjam(idPinjam);
        Date tglDikembalikan = tgalkembali.getDate();

        int denda = hitungDenda(tglKembali, tglDikembalikan);

        tabmode2.addRow(new Object[]{
            tabelpinjam.getValueAt(row, 0),  // id pinjam
            tabelpinjam.getValueAt(row, 1),  // tgl pinjam
            tabelpinjam.getValueAt(row, 2),  // id siswa
            tabelpinjam.getValueAt(row, 3),  // nama siswa
            tabelpinjam.getValueAt(row, 4),  // id buku
            tabelpinjam.getValueAt(row, 5),  // nama buku
            tabelpinjam.getValueAt(row, 6),  // penerbit
            denda,                           // denda awal
            "bagus"                          // kondisi default
        });

        hitungTotalDenda();
    }
    private void updateKondisiBuku(){
        int row = tablekembali.getSelectedRow();
        if(row == -1) return;

        // denda awal (keterlambatan)
        int dendaAwal = Integer.parseInt(tabmode2.getValueAt(row, 7).toString());

        // sebelum tambah denda kondisi, hilangkan denda kondisi sebelumnya
        // agar tidak double
        String kondisiSebelumnya = tabmode2.getValueAt(row, 8).toString();

        if(kondisiSebelumnya.equals("rusak")){
            dendaAwal -= 3000;
        }else if(kondisiSebelumnya.equals("hilang")){
            dendaAwal -= 10000;
        }

        // kondisi baru
        String kondisiBaru = "bagus";

        if(rdrusak.isSelected()){
            dendaAwal += 3000;
            kondisiBaru = "rusak";
        }else if(rdhilang.isSelected()){
            dendaAwal += 10000;
            kondisiBaru = "hilang";
        }

        // Update ke tabel
        tabmode2.setValueAt(dendaAwal, row, 7);  
        tabmode2.setValueAt(kondisiBaru, row, 8);

        hitungTotalDenda();
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
        tgalkembali = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtcaripinjam = new tools.JTextFieldRounded();
        bcaridata = new tools.MyButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pn_kembali = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablekembali = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        rdbagus = new javax.swing.JRadioButton();
        rdrusak = new javax.swing.JRadioButton();
        rdhilang = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        bsimpan = new tools.MyButton();
        bbatal = new tools.MyButton();
        jLabel14 = new javax.swing.JLabel();
        bbatal1 = new tools.MyButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

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

        tgalkembali.setDateFormatString("dd-MM-yyyy");

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

        javax.swing.GroupLayout pn_viewLayout = new javax.swing.GroupLayout(pn_view);
        pn_view.setLayout(pn_viewLayout);
        pn_viewLayout.setHorizontalGroup(
            pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_viewLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(pn_viewLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(tgalkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(363, 363, 363)
                        .addComponent(txtcaripinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bcaridata, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pn_viewLayout.setVerticalGroup(
            pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_viewLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tgalkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_viewLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcaripinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bcaridata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(658, Short.MAX_VALUE))
        );

        pn_main.add(pn_view, "card2");

        pn_kembali.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setText("Id Pengembalian     :");

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel26.setText("Total Denda   :");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("jLabel4");

        tablekembali.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablekembali);

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel25.setText("Kondisi Buku               :");

        rdbagus.setText("Bagus");
        rdbagus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbagusActionPerformed(evt);
            }
        });

        rdrusak.setText("Rusak");
        rdrusak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdrusakActionPerformed(evt);
            }
        });

        rdhilang.setText("Hilang");
        rdhilang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdhilangActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel27.setText("Deskripsi Fisik             :");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

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

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-health-graph-30.png"))); // NOI18N
        jLabel14.setText("Form Pengembalian Buku");

        bbatal1.setBackground(new java.awt.Color(51, 153, 255));
        bbatal1.setForeground(new java.awt.Color(255, 255, 255));
        bbatal1.setText("Batal");
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

        jPanel1.setBackground(new java.awt.Color(242, 248, 242));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel10.setText("Note");

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel11.setText("- denda akan diberikan dengan ketentuan :");

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel12.setText("a.) >7 hari akan dikenakan sebesar Rp.3.000");

        jLabel28.setBackground(new java.awt.Color(204, 204, 204));
        jLabel28.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel28.setText("b.) buku yang dikembalikan rusak atau hilang");

        jLabel29.setBackground(new java.awt.Color(204, 204, 204));
        jLabel29.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel29.setText("b.) denda akan bertambah Rp.1.000 sesuai dengan");

        jLabel30.setBackground(new java.awt.Color(204, 204, 204));
        jLabel30.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel30.setText("bertambahnya keterlambatan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel30)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel9.setText("*Pastikan data siswa dan buku sudah benar!");

        javax.swing.GroupLayout pn_kembaliLayout = new javax.swing.GroupLayout(pn_kembali);
        pn_kembali.setLayout(pn_kembaliLayout);
        pn_kembaliLayout.setHorizontalGroup(
            pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_kembaliLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_kembaliLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_kembaliLayout.createSequentialGroup()
                        .addGroup(pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pn_kembaliLayout.createSequentialGroup()
                                .addGroup(pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_kembaliLayout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdbagus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdrusak)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdhilang))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_kembaliLayout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(pn_kembaliLayout.createSequentialGroup()
                                                .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(bbatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3)
                            .addGroup(pn_kembaliLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(347, 347, 347)
                                .addGroup(pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pn_kembaliLayout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bbatal1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(77, 77, 77))))
        );
        pn_kembaliLayout.setVerticalGroup(
            pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_kembaliLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_kembaliLayout.createSequentialGroup()
                        .addGroup(pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(4, 4, 4))
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bbatal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_kembaliLayout.createSequentialGroup()
                        .addGroup(pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbagus)
                            .addComponent(rdrusak)
                            .addComponent(rdhilang))
                        .addGap(27, 27, 27)
                        .addGroup(pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_kembaliLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(413, Short.MAX_VALUE))
        );

        pn_main.add(pn_kembali, "card3");

        add(pn_main, "card4");
    }// </editor-fold>//GEN-END:initComponents

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
       if(tabmode2.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Tidak ada data pengembalian untuk disimpan.");
            return;
        }

        try {
            // Ambil tanggal dan validasi
            Date tgl = tgalkembali.getDate();
            if (tgl == null) {
                JOptionPane.showMessageDialog(null, "Tanggal pengembalian belum diisi.");
                return;
            }
            java.sql.Date sqlTgl = new java.sql.Date(tgl.getTime());

            // Ambil total denda dari label -> ekstrak angka saja
            String raw = jLabel4.getText(); // format: "Rp 123000"
            String digits = raw.replaceAll("[^0-9]", "");
            int totalDenda = digits.isEmpty() ? 0 : Integer.parseInt(digits);

            String idPengembalian = jLabel33.getText();

            // Mulai transaksi
            conn.setAutoCommit(false);

            // INSERT HEADER
            String sqlHeader = "INSERT INTO pengembalian (id, id_siswa, nama_siswa, tgl_kembali, total_denda) VALUES (?,?,?,?,?)";
            PreparedStatement pstHeader = conn.prepareStatement(sqlHeader);

            String idSiswa = tabmode2.getValueAt(0, 2).toString();
            String namaSiswa = tabmode2.getValueAt(0, 3).toString();

            pstHeader.setString(1, idPengembalian);
            pstHeader.setString(2, idSiswa);
            pstHeader.setString(3, namaSiswa);
            pstHeader.setDate(4, sqlTgl);
            pstHeader.setInt(5, totalDenda);
            pstHeader.executeUpdate();

            // INSERT DETAIL
            String sqlDetail = "INSERT INTO detail_pengembalian (id, id_buku, nama_buku, kondisi, denda, id_pengembalian) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstDetail = conn.prepareStatement(sqlDetail);

            for(int i = 0; i < tabmode2.getRowCount(); i++) {
                String idPinjam = tabmode2.getValueAt(i, 0).toString();
                String idBuku   = tabmode2.getValueAt(i, 4).toString();

                // gunakan autoDetailPerPinjam jika ingin cek last id di DB:
                // String idDetail = autoDetailPerPinjam(idPengembalian);
                // atau simple incremental seperti ini:
                String idDetail = idPengembalian + "-DT" + String.format("%03d", i+1);

                pstDetail.setString(1, idDetail);
                pstDetail.setString(2, idBuku);
                pstDetail.setString(3, tabmode2.getValueAt(i, 5).toString()); // nama buku
                pstDetail.setString(4, tabmode2.getValueAt(i, 8).toString()); // kondisi
                pstDetail.setInt(5, Integer.parseInt(tabmode2.getValueAt(i, 7).toString())); // denda
                pstDetail.setString(6, idPengembalian);
                pstDetail.executeUpdate();

                // HAPUS DETAIL PEMINJAMAN dan cek master
                hapusDetail(idPinjam, idBuku);
                if(!checkDetail(idPinjam)){
                    hapusMaster(idPinjam);
                }
            }

            conn.commit();
            conn.setAutoCommit(true);

            JOptionPane.showMessageDialog(null, "Pengembalian Disimpan dan Data Peminjaman Diperbarui!");
            tabmode2.setRowCount(0);
            AutoNumber();

        } catch (Exception e) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Error Simpan: " + e.getMessage());
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bbatalActionPerformed

    private void rdhilangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdhilangActionPerformed
        updateKondisiBuku();
    }//GEN-LAST:event_rdhilangActionPerformed

    private void rdrusakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdrusakActionPerformed
        updateKondisiBuku();
    }//GEN-LAST:event_rdrusakActionPerformed

    private void bcaridataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaridataActionPerformed
        tablePeminjaman();
    }//GEN-LAST:event_bcaridataActionPerformed

    private void txtcaripinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaripinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaripinjamActionPerformed

    private void tabelpinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpinjamMouseClicked
         tambahKeKeranjang();
         pn_main.removeAll();
        pn_main.add(pn_kembali);
        pn_main.repaint();
        pn_main.revalidate();
    }//GEN-LAST:event_tabelpinjamMouseClicked

    private void bbatal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bbatal1ActionPerformed

    private void rdbagusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbagusActionPerformed
        updateKondisiBuku();
    }//GEN-LAST:event_rdbagusActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tools.MyButton bbatal;
    private tools.MyButton bbatal1;
    private tools.MyButton bcaridata;
    private tools.MyButton bsimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel pn_kembali;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_view;
    private javax.swing.JRadioButton rdbagus;
    private javax.swing.JRadioButton rdhilang;
    private javax.swing.JRadioButton rdrusak;
    private javax.swing.JTable tabelpinjam;
    private javax.swing.JTable tablekembali;
    private com.toedter.calendar.JDateChooser tgalkembali;
    private tools.JTextFieldRounded txtcaripinjam;
    // End of variables declaration//GEN-END:variables
}
