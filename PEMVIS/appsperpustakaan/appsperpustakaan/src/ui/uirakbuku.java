
package ui;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import koneksi.koneksi;

public class uirakbuku extends javax.swing.JPanel {
private Connection conn = new koneksi().connect();
private DefaultTableModel tabmode;
    
    public uirakbuku() {
        initComponents();
        kosong();
        aktif();
        datatable();
        loaddata();
    }
    
    private void showPanel(){
        pn_main.removeAll();
        pn_main.add(new uirakbuku());
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
        txtnomor.setText("");
        txtbaris.setText("");
        txtkategori.setText("");
        txtcari.setText("");
        
    }

    protected void datatable(){
        pn_view.setVisible(true);
        pn_add.setVisible(false);
        int row = tblsiswa.getSelectedRow();
        
        
        
        
        
        Object [] Baris ={"ID RAK "," NOMOR RAK "," BARIS RAK "," KATEGORI "};
        tabmode = new DefaultTableModel(null,Baris);
        String cariitem=txtcari.getText();
        
        try{
            String sql = "SELECT * FROM rakbuku where id_rak like '%"+cariitem+"%' or nomor_rak like '%"+cariitem+"%' order by id_rak asc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4)
                    
                    
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
        txtnomor = new tools.JTextFieldRounded();
        jLabel4 = new javax.swing.JLabel();
        txtbaris = new tools.JTextFieldRounded();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtkategori = new tools.JTextFieldRounded();

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

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-book-shelf-30.png"))); // NOI18N
        jLabel1.setText("Data Rak Buku Perpustakaan");

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_viewLayout.createSequentialGroup()
                        .addComponent(btambahview, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bbatalview, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bhapusview, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bcariview, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE))
                .addGap(50, 50, 50))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        pn_main.add(pn_view, "card2");

        pn_add.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel2.setText("Data Rak Buku Perpustakaan");

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
        jLabel3.setText("ID RAK");

        txtid.setForeground(new java.awt.Color(51, 51, 51));
        txtid.setCornerRadius(10);
        txtid.setFont(new java.awt.Font("Poppins Medium", 2, 12)); // NOI18N
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        txtnomor.setForeground(new java.awt.Color(51, 51, 51));
        txtnomor.setCornerRadius(10);
        txtnomor.setFont(new java.awt.Font("Poppins Medium", 2, 12)); // NOI18N
        txtnomor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomorActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel4.setText("NOMOR RAK");

        txtbaris.setForeground(new java.awt.Color(51, 51, 51));
        txtbaris.setCornerRadius(10);
        txtbaris.setFont(new java.awt.Font("Poppins Medium", 2, 12)); // NOI18N
        txtbaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbarisActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel5.setText("BARIS RAK");

        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel7.setText("KATEGORI BUKU");

        txtkategori.setForeground(new java.awt.Color(51, 51, 51));
        txtkategori.setCornerRadius(10);
        txtkategori.setFont(new java.awt.Font("Poppins Medium", 2, 12)); // NOI18N
        txtkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkategoriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_addLayout = new javax.swing.GroupLayout(pn_add);
        pn_add.setLayout(pn_addLayout);
        pn_addLayout.setHorizontalGroup(
            pn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_addLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addContainerGap(805, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_addLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_addLayout.createSequentialGroup()
                        .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(txtbaris, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtnomor, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        pn_addLayout.setVerticalGroup(
            pn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_addLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(88, 88, 88)
                .addGroup(pn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtnomor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtbaris, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
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
             String sql = "insert into rakbuku values (?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
           stat.setString(1,txtid.getText());
           stat.setString(2,txtnomor.getText());                                     
           stat.setString(3,txtbaris.getText());
           stat.setString(4,txtkategori.getText());
           
            
            
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

    private void txtnomorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomorActionPerformed

    private void txtbarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbarisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbarisActionPerformed

    private void txtkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkategoriActionPerformed

    private void bcariviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariviewActionPerformed
           datatable();
    }//GEN-LAST:event_bcariviewActionPerformed

    private void bhapusviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusviewActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"hapus","konfirmasi dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from rakbuku where id_rak ='"+txtid.getText()+"'";
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
       
      
       txtid.setText(a);
       txtnomor.setText(b);
       txtbaris.setText(c);
       txtkategori.setText(d);
       
       
       
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pn_add;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_view;
    private tools.JTableCustom tblsiswa;
    private tools.JTextFieldRounded txtbaris;
    private tools.JTextFieldRounded txtcari;
    private tools.JTextFieldRounded txtid;
    private tools.JTextFieldRounded txtkategori;
    private tools.JTextFieldRounded txtnomor;
    // End of variables declaration//GEN-END:variables

    

    private void updateData() {

        String sql = "update rakbuku set nomor_rak=?,baris_rak=?,kategori=? where id_rak='"+txtid.getText()+"'";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,txtnomor.getText());
            stat.setString(2,txtbaris.getText());
            stat.setString(3,txtkategori.getText());
            
            
            
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
