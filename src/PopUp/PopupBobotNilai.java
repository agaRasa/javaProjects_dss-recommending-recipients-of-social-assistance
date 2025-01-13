package PopUp;

import MenuUtama.dataBobotNilai;
import Koneksi.koneksi;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agar
 */
public class PopupBobotNilai extends javax.swing.JFrame {

    private Connection connection = new koneksi().connect();
    private DefaultTableModel tabmode;
    public dataBobotNilai CP = null;
    public PopupBobotNilai() {
        initComponents();
        datatable();
    }
    
    protected void datatable(){
    Object[] Baris ={"NIK","Nama","Pendapatan Bulanan","Jumlah Tanggungan","Kepemilikan Rumah","Transportasi"};
    tabmode = new DefaultTableModel(null, Baris);
    //tablebarang.setModel(tabmode);
    String cariitem=txtCari.getText();

    try {
    String sql = "SELECT NIK, NW, BPB, BTJ, BKR, BT FROM dataPenerima where NIK like '%"+cariitem+"%' or NW like '%"+cariitem+"%' order by NIK asc";
    java.sql.Statement stat = connection.createStatement();
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
    tabelCP.setModel(tabmode);
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    }
 }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelCP = new javax.swing.JTable();
        bkembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 240));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 128));
        jLabel2.setText("DATA CALON PENERIMA");

        txtCari.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        txtCari.setForeground(new java.awt.Color(0, 0, 128));
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
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

        tabelCP.setBackground(new java.awt.Color(255, 255, 240));
        tabelCP.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        tabelCP.setForeground(new java.awt.Color(0, 0, 128));
        tabelCP.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelCPMouseClicked(evt);
            }
        });
        tabelCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelCPKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabelCP);

        bkembali.setBackground(new java.awt.Color(255, 8, 0));
        bkembali.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        bkembali.setForeground(new java.awt.Color(255, 255, 240));
        bkembali.setText("KEMBALI");
        bkembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bkembali)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bkembali))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable();
        }
    }//GEN-LAST:event_txtCariKeyPressed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        // TODO add your handling code here:
        datatable();
    }//GEN-LAST:event_bCariActionPerformed

    private void tabelCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelCPMouseClicked
        // TODO add your handling code here:
        int tabelCalonPenerima = tabelCP.getSelectedRow();
        CP.NIK = tabelCP.getValueAt(tabelCalonPenerima, 0).toString();
        CP.NW  = tabelCP.getValueAt(tabelCalonPenerima, 1).toString();
        CP.BPB = Double.parseDouble(tabelCP.getValueAt(tabelCalonPenerima, 2).toString());
        CP.BJT = Double.parseDouble(tabelCP.getValueAt(tabelCalonPenerima, 3).toString());
        CP.BKR = Double.parseDouble(tabelCP.getValueAt(tabelCalonPenerima, 4).toString());
        CP.BT  = Double.parseDouble(tabelCP.getValueAt(tabelCalonPenerima, 5).toString());
        CP.bobotNilai();
        this.dispose();
    }//GEN-LAST:event_tabelCPMouseClicked

    private void tabelCPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelCPKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelCPKeyPressed

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bkembaliActionPerformed

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
            java.util.logging.Logger.getLogger(PopupBobotNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PopupBobotNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PopupBobotNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PopupBobotNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupBobotNilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCari;
    private javax.swing.JButton bkembali;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelCP;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
