
package ui;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import koneksi.koneksi;

public class uisiswa extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;
    
    public uisiswa() {
        initComponents();
        kosong();
        aktif();
        datatable();
        loaddata();
    }
    
    private void showPanel(){
        pn_main.removeAll();
        pn_main.add(new uisiswa());
        pn_main.repaint();
        pn_main.revalidate();
    }
    
    protected void aktif (){
        txtid.requestFocus();
    }
    
    
    private void loaddata(){
       bbatalview.setVisible(false);
       bhapusview.setVisible(false);
    }
    
    
    
    protected void kosong (){
        txtid.setText("");
        txtnm.setText("");
        txtkelasview.setText("");
        txttelepon.setText("");
        txtalamat.setText("");
        txtcari.setText("");
        buttonGroup1.clearSelection();
    }

    protected void datatable(){
        pn_view.setVisible(true);
        pn_add.setVisible(false);
        int row = tblsiswa.getSelectedRow();
        
        
        
        
        
        Object [] Baris ={"ID SISWA","NAMA","KELAS","JENIS KELAMIN","NO.TELEPON","ALAMAT"};
        tabmode = new DefaultTableModel(null,Baris);
        String cariitem=txtcari.getText();
        
        try{
            String sql = "SELECT * FROM datasiswa where id_siswa like '%"+cariitem+"%' or nm_siswa like '%"+cariitem+"%' order by id_siswa asc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6)
                });
            }
            tblsiswa.setModel(tabmode);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"data gagal dipanggil"+e);
        }
    }

    
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pn_main = new javax.swing.JPanel();
        pn_view = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsiswa = new tools.JTableCustom();
        jLabel1 = new javax.swing.JLabel();
        btambahview = new tools.MyButton();
        bhapusview = new tools.MyButton();
        bbatalview = new tools.MyButton();
        txtcari = new tools.JTextFieldRounded();
        bcariview = new tools.MyButton();
        pn_add = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bsimpan = new tools.MyButton();
        bbatal = new tools.MyButton();
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

        tblsiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        tblsiswa.setShowGrid(true);
        tblsiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsiswa);

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-user-30 (1).png"))); // NOI18N
        jLabel1.setText("Data Siswa Perpustakaan");

        btambahview.setForeground(new java.awt.Color(255, 255, 255));
        btambahview.setText("TAMBAH");
        btambahview.setBorderColor(new java.awt.Color(242, 242, 242));
        btambahview.setColor(new java.awt.Color(51, 153, 255));
        btambahview.setColorClick(new java.awt.Color(0, 51, 255));
        btambahview.setColorOver(new java.awt.Color(51, 102, 255));
        btambahview.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btambahview.setRadius(15);
        btambahview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahviewActionPerformed(evt);
            }
        });

        bhapusview.setForeground(new java.awt.Color(255, 255, 255));
        bhapusview.setText("HAPUS");
        bhapusview.setBorderColor(new java.awt.Color(242, 242, 242));
        bhapusview.setColor(new java.awt.Color(51, 153, 255));
        bhapusview.setColorClick(new java.awt.Color(0, 51, 255));
        bhapusview.setColorOver(new java.awt.Color(51, 102, 255));
        bhapusview.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        bhapusview.setRadius(15);
        bhapusview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusviewActionPerformed(evt);
            }
        });

        bbatalview.setForeground(new java.awt.Color(255, 255, 255));
        bbatalview.setText("BATAL");
        bbatalview.setBorderColor(new java.awt.Color(242, 242, 242));
        bbatalview.setColor(new java.awt.Color(51, 153, 255));
        bbatalview.setColorClick(new java.awt.Color(0, 51, 255));
        bbatalview.setColorOver(new java.awt.Color(51, 102, 255));
        bbatalview.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        bbatalview.setRadius(15);
        bbatalview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalviewActionPerformed(evt);
            }
        });

        txtcari.setCornerRadius(10);
        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
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
                                .addComponent(btambahview, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bbatalview, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bhapusview, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bcariview, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btambahview, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bhapusview, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bbatalview, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bcariview, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        pn_main.add(pn_view, "card2");

        pn_add.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel2.setText("Data Siswa Perpustakaan");

        bsimpan.setForeground(new java.awt.Color(255, 255, 255));
        bsimpan.setText("SIMPAN");
        bsimpan.setBorderColor(new java.awt.Color(242, 242, 242));
        bsimpan.setColor(new java.awt.Color(51, 153, 255));
        bsimpan.setColorClick(new java.awt.Color(0, 51, 255));
        bsimpan.setColorOver(new java.awt.Color(51, 102, 255));
        bsimpan.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        bsimpan.setRadius(10);
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bbatal.setForeground(new java.awt.Color(255, 255, 255));
        bbatal.setText("BATAL");
        bbatal.setBorderColor(new java.awt.Color(242, 242, 242));
        bbatal.setColor(new java.awt.Color(51, 153, 255));
        bbatal.setColorClick(new java.awt.Color(0, 51, 255));
        bbatal.setColorOver(new java.awt.Color(51, 102, 255));
        bbatal.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        bbatal.setRadius(10);
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

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
                        .addGroup(pn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_addLayout.createSequentialGroup()
                                .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
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
                .addGap(33, 33, 33)
                .addGroup(pn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void btambahviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahviewActionPerformed
        pn_main.removeAll();
        pn_main.add(pn_add);
        pn_main.repaint();
        pn_main.revalidate();
        
        if(btambahview.getText().equals("UBAH")){
            datatable();
            bsimpan.setText("PERBARUI");
        }
        
       
    }//GEN-LAST:event_btambahviewActionPerformed

    private void insertData(){
     String jenis = null;
        if(rlaki.isSelected()){
            jenis = "Laki-Laki";
        } else if(rperempuan.isSelected()){
            jenis ="Perempuan";
        }
        String sql = "insert into datasiswa values (?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
           stat.setString(1,txtid.getText());
           stat.setString(2,txtnm.getText());                                     
           stat.setString(3,txtkelasview.getText());
           stat.setString(4,jenis);
           stat.setString(5,txttelepon.getText());
           stat.setString(6,txtalamat.getText());
            
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"data berhasil disimpan");
            kosong();
            txtid.requestFocus();
            showPanel();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"data gagal disimpan"+e);
        }
        datatable();
    }
    
    
    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        if(bsimpan.getText().equals("TAMBAH"))
        {
            bsimpan.setText("SIMPAN");
                
        }
        else if(bsimpan.getText().equals("SIMPAN"))
        {
            insertData();
        }
        else if (bsimpan.getText().equals("PERBARUI"))
        {
            updateData();
        }
         
             

    }//GEN-LAST:event_bsimpanActionPerformed

        
    
    private void bbatalviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalviewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bbatalviewActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        pn_main.removeAll();
        pn_main.add(pn_view);
        pn_main.repaint();
        pn_main.revalidate();
        
        showPanel();
    }//GEN-LAST:event_bbatalActionPerformed

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
           datatable();
    }//GEN-LAST:event_bcariviewActionPerformed

    private void bhapusviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusviewActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","konfirmasi dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from datasiswa where id_siswa ='"+txtid.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"data berhasil dihapus");
                kosong();
                txtid.requestFocus();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null,"data gagal dihapus");
            }
            datatable();
        }
    }//GEN-LAST:event_bhapusviewActionPerformed

    private void tblsiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsiswaMouseClicked
       if(btambahview.getText().equals("TAMBAH")){
           btambahview.setText("UBAH");
           bbatalview.setVisible(true);
           bhapusview.setVisible(true);
       }
       
       int bar = tblsiswa.getSelectedRow();
       String a = tabmode.getValueAt(bar, 0).toString();
       String b = tabmode.getValueAt(bar, 1).toString();
       String c = tabmode.getValueAt(bar, 2).toString();
       String d = tabmode.getValueAt(bar, 3).toString();
       String e = tabmode.getValueAt(bar, 4).toString();
       String f = tabmode.getValueAt(bar, 5).toString();
       
       
       txtid.setText(a);
       txtnm.setText(b);
       txtkelasview.setText(c);
       txttelepon.setText(e);
       txtalamat.setText(f);
       if("Laki-Laki".equals(d)){
           rlaki.setSelected(true);
       }else{
           rperempuan.setSelected(true);
       }
       
    }//GEN-LAST:event_tblsiswaMouseClicked

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tools.MyButton bbatal;
    private tools.MyButton bbatalview;
    private tools.MyButton bcariview;
    private tools.MyButton bhapusview;
    private tools.MyButton bsimpan;
    private tools.MyButton btambahview;
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
    private tools.JTableCustom tblsiswa;
    private tools.JTextFieldRounded txtalamat;
    private tools.JTextFieldRounded txtcari;
    private tools.JTextFieldRounded txtid;
    private tools.JTextFieldRounded txtkelasview;
    private tools.JTextFieldRounded txtnm;
    private tools.JTextFieldRounded txttelepon;
    // End of variables declaration//GEN-END:variables

    

    private void updateData() {
       String jenis = null;
        if(rlaki.isSelected()){
            jenis = "Laki-Laki";
        } else if(rperempuan.isSelected()){
            jenis ="Perempuan";
        }
        String sql = "update datasiswa set nm_siswa=?,kelas=?,jenis=?,telepon=?,alamat=? where id_siswa='"+txtid.getText()+"'";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,txtnm.getText());
            stat.setString(2,txtkelasview.getText());
            stat.setString(3,jenis);
            stat.setString(4,txttelepon.getText());
            stat.setString(5,txtalamat.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null,"data berhasil diubah");
            kosong();
            txtid.requestFocus();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"data gagal diubah"+e);
        }
        datatable();
    }
}
