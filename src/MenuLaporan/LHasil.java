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
public class LHasil extends javax.swing.JPanel {
    
    private Connection connection = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    public LHasil() {
        initComponents();
        datatable();
    }
    
    public void datatable(){
        Object [] baris = {"Peringkat","NIK","Nama","Nilai Akhir"};
        tabmode = new DefaultTableModel(null, baris);
        try {
            String sql= "select * from hasilAkhir order by NILAI desc";
            java.sql.Statement stat = connection.createStatement();
            ResultSet hasil=stat.executeQuery(sql);
            while (hasil.next()){
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4)
                });
            }
            trangking.setModel(tabmode);
        } catch (Exception e) {
        
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PUtama = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bCetak = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        trangking = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        PUtama.setBackground(new java.awt.Color(255, 255, 240));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 128));
        jLabel2.setText("LAPORAN HASIL AKHIR");

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

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        trangking.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        trangking.setForeground(new java.awt.Color(0, 0, 128));
        trangking.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(trangking);

        javax.swing.GroupLayout PUtamaLayout = new javax.swing.GroupLayout(PUtama);
        PUtama.setLayout(PUtamaLayout);
        PUtamaLayout.setHorizontalGroup(
            PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(0, 180, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PUtamaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
        );
        PUtamaLayout.setVerticalGroup(
            PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addComponent(bCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PUtamaLayout.createSequentialGroup()
                    .addGap(92, 92, 92)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(54, Short.MAX_VALUE)))
        );

        add(PUtama, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetakActionPerformed
        // TODO add your handling code here:
         try {
            String LHasil = "src/Report/LHasil.jasper";
            Connection connection = new koneksi().connect();
            HashMap<String, Object> parameter = new HashMap();
            File report_file = new File (LHasil);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, connection);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_bCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PUtama;
    private javax.swing.JButton bCetak;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable trangking;
    // End of variables declaration//GEN-END:variables
}
