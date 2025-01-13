package MenuLaporan;

import Koneksi.koneksi;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author agar
 */
public class LDataPenerima extends javax.swing.JPanel {

    private Connection connection = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    public LDataPenerima() {
        initComponents();
        datatable();
    }
    
    private void datatable(){
       Object [] baris = {"NIK","Nama","Pendapatan Bulanan","Jumlah Tanggungan","Kepemilikan Rumah","Transportasi"};
       tabmode = new DefaultTableModel(null, baris);
        try {
            String sql               = "select * from dataPenerima";
            java.sql.Statement stat  = connection.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    
            });   
            }
            tabelCalonPenerima.setModel(tabmode);
        } catch (Exception e) {
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PUtama = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bCetak = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelCalonPenerima = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        PUtama.setBackground(new java.awt.Color(255, 255, 240));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 128));
        jLabel2.setText("LAPORAN DATA PENERIMA");

        bCetak.setBackground(new java.awt.Color(255, 8, 0));
        bCetak.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        bCetak.setForeground(new java.awt.Color(255, 255, 240));
        bCetak.setText("CETAK");
        bCetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCetakActionPerformed(evt);
            }
        });

        tabelCalonPenerima.setBackground(new java.awt.Color(255, 255, 240));
        tabelCalonPenerima.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        tabelCalonPenerima.setForeground(new java.awt.Color(0, 0, 128));
        tabelCalonPenerima.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelCalonPenerima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelCalonPenerimaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelCalonPenerima);

        javax.swing.GroupLayout PUtamaLayout = new javax.swing.GroupLayout(PUtama);
        PUtama.setLayout(PUtamaLayout);
        PUtamaLayout.setHorizontalGroup(
            PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PUtamaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                    .addGroup(PUtamaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PUtamaLayout.setVerticalGroup(
            PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(PUtama, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetakActionPerformed
        // TODO add your handling code here:
        try {
            String LCalonPenerima = "src/Report/LCalonPenerima.jasper";
            Connection connection = new koneksi().connect();
            HashMap<String, Object> parameter = new HashMap();
            File report_file = new File (LCalonPenerima);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, connection);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_bCetakActionPerformed

    private void tabelCalonPenerimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelCalonPenerimaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelCalonPenerimaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PUtama;
    private javax.swing.JButton bCetak;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelCalonPenerima;
    // End of variables declaration//GEN-END:variables
}
