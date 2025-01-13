/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuUtama;

import Koneksi.koneksi;
import PopUp.PopupBobotNilai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author agar
 */
public class dataBobotNilai extends javax.swing.JPanel {
    
    private Connection connection = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    public String NIK, NW;
    public Double BPB,BJT,BKR,BT;
    
    public dataBobotNilai() {
        initComponents();
        kosong();
        aktif();
        datatable();
        setLayout();
    }
    
    public void bobotNilai(){
    PopupBobotNilai popup = new PopupBobotNilai();
    popup.CP = this;
    txtNik.setText(NIK);
    txtNama.setText(NW);
    txtPB.setText(Double.toString(BPB));
    txtJT.setText(Double.toString(BJT));
    txtKR.setText(Double.toString(BKR));
    txtTR.setText(Double.toString(BT));
}
    
    protected void setLayout(){
        /*TableColumn a = tabelKriteria.getColumnModel().getColumn(0);
        TableColumn b = tabelKriteria.getColumnModel().getColumn(1);
        TableColumn c = tabelKriteria.getColumnModel().getColumn(2);
        DefaultTableCellRenderer cellren = new DefaultTableCellRenderer();
        cellren.setHorizontalAlignment(JLabel.CENTER);
        a.setCellRenderer(cellren);
        b.setCellRenderer(cellren);
        c.setCellRenderer(cellren);
        */
        JTableHeader header = tabelBobotNilai.getTableHeader();
        DefaultTableCellRenderer render = (DefaultTableCellRenderer)header.getDefaultRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PUtama = new javax.swing.JPanel();
        dataBobotNilai = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bTambah = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBobotNilai = new javax.swing.JTable();
        bobotNilai = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bSimpan = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPB = new javax.swing.JTextField();
        txtKR = new javax.swing.JTextField();
        txtJT = new javax.swing.JTextField();
        txtTR = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();
        bHapus1 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        PUtama.setLayout(new java.awt.CardLayout());

        dataBobotNilai.setBackground(new java.awt.Color(255, 255, 240));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 128));
        jLabel2.setText("DATA BOBOT NILAI");

        bTambah.setBackground(new java.awt.Color(255, 8, 0));
        bTambah.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        bTambah.setForeground(new java.awt.Color(255, 255, 240));
        bTambah.setText("TAMBAH");
        bTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        tabelBobotNilai.setBackground(new java.awt.Color(255, 255, 240));
        tabelBobotNilai.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        tabelBobotNilai.setForeground(new java.awt.Color(0, 0, 128));
        tabelBobotNilai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NIK", "NAMA", "PENDAPATAN", "JUMLAH TANGGUNGAN", "KEPEMILIKAN RUMAH", "TRANSPORTASI"
            }
        ));
        tabelBobotNilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBobotNilaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelBobotNilai);

        javax.swing.GroupLayout dataBobotNilaiLayout = new javax.swing.GroupLayout(dataBobotNilai);
        dataBobotNilai.setLayout(dataBobotNilaiLayout);
        dataBobotNilaiLayout.setHorizontalGroup(
            dataBobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataBobotNilaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataBobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                    .addGroup(dataBobotNilaiLayout.createSequentialGroup()
                        .addComponent(bTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(dataBobotNilaiLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataBobotNilaiLayout.setVerticalGroup(
            dataBobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataBobotNilaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        PUtama.add(dataBobotNilai, "card2");

        bobotNilai.setBackground(new java.awt.Color(255, 255, 240));

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 128));
        jLabel3.setText("DATA BOBOT NILAI");

        bSimpan.setBackground(new java.awt.Color(255, 8, 0));
        bSimpan.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        bSimpan.setForeground(new java.awt.Color(255, 255, 240));
        bSimpan.setText("SIMPAN");
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        bBatal.setBackground(new java.awt.Color(255, 8, 0));
        bBatal.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        bBatal.setForeground(new java.awt.Color(255, 255, 240));
        bBatal.setText("KEMBALI");
        bBatal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 128));
        jLabel4.setText("NIK");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 128));
        jLabel5.setText("NAMA ");

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 128));
        jLabel6.setText("PENDAPATAN BULANAN");

        txtNik.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        txtNik.setForeground(new java.awt.Color(0, 0, 128));
        txtNik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNikActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 128));
        jLabel7.setText("JUMLAH TANGGUNGAN");

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 128));
        jLabel8.setText("KEPEMILIKAN RUMAH");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 128));
        jLabel9.setText("TRANSPORTASI");

        txtPB.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        txtPB.setForeground(new java.awt.Color(0, 0, 128));
        txtPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPBActionPerformed(evt);
            }
        });

        txtKR.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        txtKR.setForeground(new java.awt.Color(0, 0, 128));
        txtKR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKRActionPerformed(evt);
            }
        });

        txtJT.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        txtJT.setForeground(new java.awt.Color(0, 0, 128));
        txtJT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJTActionPerformed(evt);
            }
        });

        txtTR.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        txtTR.setForeground(new java.awt.Color(0, 0, 128));
        txtTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTRActionPerformed(evt);
            }
        });

        txtNama.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        txtNama.setForeground(new java.awt.Color(0, 0, 128));
        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        bCari.setBackground(new java.awt.Color(255, 8, 0));
        bCari.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        bCari.setForeground(new java.awt.Color(255, 255, 240));
        bCari.setText("CARI");
        bCari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        bHapus1.setBackground(new java.awt.Color(255, 8, 0));
        bHapus1.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        bHapus1.setForeground(new java.awt.Color(255, 255, 240));
        bHapus1.setText("HAPUS");
        bHapus1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bHapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bobotNilaiLayout = new javax.swing.GroupLayout(bobotNilai);
        bobotNilai.setLayout(bobotNilaiLayout);
        bobotNilaiLayout.setHorizontalGroup(
            bobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bobotNilaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bobotNilaiLayout.createSequentialGroup()
                        .addComponent(bHapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bobotNilaiLayout.createSequentialGroup()
                        .addGroup(bobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bobotNilaiLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(bobotNilaiLayout.createSequentialGroup()
                                .addGroup(bobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(bobotNilaiLayout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(txtKR, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTR, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(bobotNilaiLayout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(txtPB, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtJT, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(bobotNilaiLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(78, 78, 78)))
                        .addGap(39, 39, 39))
                    .addGroup(bobotNilaiLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bobotNilaiLayout.createSequentialGroup()
                        .addGroup(bobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNik, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bobotNilaiLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(bobotNilaiLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(bCari)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        bobotNilaiLayout.setVerticalGroup(
            bobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bobotNilaiLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(bobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(bobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(bobotNilaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bHapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        PUtama.add(bobotNilai, "card2");

        add(PUtama, "card2");
    }// </editor-fold>//GEN-END:initComponents
    protected void aktif(){
        txtNik.setEnabled(false);
        txtNama.setEnabled(false);
        txtPB.setEnabled(false);
        txtJT.setEnabled(false);
        txtKR.setEnabled(false);
        txtTR.setEnabled(false);
    }
    protected void kosong(){
        txtNik.setText("");
        txtNama.setText("");
        txtPB.setText("");
        txtJT.setText("");
        txtKR.setText("");
        txtTR.setText("");
    }
    protected void datatable(){
        Object[] Baris={"NIK","Nama","Pendapatan Bulanan","Jumlah Tanggungan","Kepemilikan Rumah","Transportasi"};
        tabmode = new DefaultTableModel(null, Baris);
        try {
            String sql= "select * from nilaiBobot";
            java.sql.Statement stat = connection.createStatement();
            ResultSet hasil=stat.executeQuery(sql);
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
            tabelBobotNilai.setModel(tabmode);
        }catch (Exception e){
        
        }
    }
    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // TODO add your handling code here:
        PUtama.removeAll();
        PUtama.repaint();
        PUtama.revalidate();
        kosong();
        txtNik.requestFocus();
        datatable();
        PUtama.add(bobotNilai);
        PUtama.repaint();
        PUtama.revalidate();
        bSimpan.setVisible(true);
//        bUbah1.setVisible(false);
        bHapus1.setVisible(false);
    }//GEN-LAST:event_bTambahActionPerformed

    private void tabelBobotNilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBobotNilaiMouseClicked
        // TODO add your handling code here:

        int bar = tabelBobotNilai.getSelectedRow( );
        String  a = tabmode.getValueAt (bar, 0) .toString( );
        String  b = tabmode.getValueAt (bar, 1) .toString( );
        String  c = tabmode.getValueAt (bar, 2) .toString( );
        String  d = tabmode.getValueAt (bar, 3) .toString( );
        String  e = tabmode.getValueAt (bar, 4) .toString( );
        String  f = tabmode.getValueAt (bar, 5) .toString( );

        txtNik.setText(a);
        txtNama.setText(b);
        txtPB.setText(c);
        txtJT.setText(d);
        txtKR.setText(e);
        txtTR.setText(f);
        

        PUtama.removeAll();
        PUtama.repaint();
        PUtama.revalidate();

        PUtama.add(bobotNilai);
        PUtama.repaint();
        PUtama.revalidate();
        bSimpan.setVisible(false);
//        bUbah1.setVisible(true);
        bHapus1.setVisible(true);
        datatable();
    }//GEN-LAST:event_tabelBobotNilaiMouseClicked

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        String sql = "insert into nilaiBobot values (?,?,?,?,?,?)";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, txtNik.getText());
            stat.setString(2, txtNama.getText());
            stat.setString(3, txtPB.getText());
            stat.setString(4, txtJT.getText());
            stat.setString(5, txtKR.getText());
            stat.setString(6, txtTR.getText());
            
            // Menjalankan update
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

            // Reset form dan UI
            kosong();
            txtNik.requestFocus();
            PUtama.removeAll();
            PUtama.repaint();
            PUtama.revalidate();

            PUtama.add(dataBobotNilai);
            PUtama.repaint();
            PUtama.revalidate();
            bSimpan.setVisible(true);
            datatable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan, Data Sudah Ada");
        }
    }//GEN-LAST:event_bSimpanActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        // TODO add your handling code here:
        PUtama.removeAll();
        PUtama.repaint();
        PUtama.revalidate();

        PUtama.add(dataBobotNilai);
        PUtama.repaint();
        PUtama.revalidate();
    }//GEN-LAST:event_bBatalActionPerformed

    private void txtNikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNikActionPerformed

    private void txtPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPBActionPerformed

    private void txtKRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKRActionPerformed

    private void txtJTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJTActionPerformed

    private void txtTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTRActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        // TODO add your handling code here:
        PopupBobotNilai popup = new PopupBobotNilai();
        popup.CP = this;
        popup.setVisible(true);
        popup.setResizable(false);
    }//GEN-LAST:event_bCariActionPerformed

    private void bHapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus1ActionPerformed
        // TODO add your handling code here:
        int ok=JOptionPane.showConfirmDialog(null,"Hapus","Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql="delete from nilaiBobot where NIK ='"+txtNik.getText()+"'";
            try{
                PreparedStatement stat=connection.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
                kosong();
                txtNik.requestFocus();
                PUtama.removeAll();
                PUtama.repaint();
                PUtama.revalidate();

                PUtama.add(dataBobotNilai);
                PUtama.repaint();
                PUtama.revalidate();
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal Dihapus"+e);
            }
            datatable();
        }
    }//GEN-LAST:event_bHapus1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PUtama;
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bHapus1;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bTambah;
    private javax.swing.JPanel bobotNilai;
    private javax.swing.JPanel dataBobotNilai;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelBobotNilai;
    private javax.swing.JTextField txtJT;
    private javax.swing.JTextField txtKR;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNik;
    private javax.swing.JTextField txtPB;
    private javax.swing.JTextField txtTR;
    // End of variables declaration//GEN-END:variables
}
