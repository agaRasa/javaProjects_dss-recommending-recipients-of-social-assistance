package MenuHitung;

import Koneksi.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author agar
 */
public class normalisasi extends javax.swing.JPanel {
    private Connection connection = new koneksi().connect();
    private DefaultTableModel tabmode;
    
    ArrayList<double[]> data = new ArrayList<>();
    ArrayList<String> NIK = new ArrayList<>();
    ArrayList<String> Nama = new ArrayList<>();
    
    public normalisasi() {
        initComponents();
        dataBobot();
        dataNormalisasi();
        tNormalisasi.setVisible(false);
        jScrollPane2.setVisible(false);
        setLayoutBobot();
        setLayoutNormalisasi();
    }
    
    protected void setLayoutBobot(){
        /*TableColumn a = tabelKriteria.getColumnModel().getColumn(0);
        TableColumn b = tabelKriteria.getColumnModel().getColumn(1);
        TableColumn c = tabelKriteria.getColumnModel().getColumn(2);
        DefaultTableCellRenderer cellren = new DefaultTableCellRenderer();
        cellren.setHorizontalAlignment(JLabel.CENTER);
        a.setCellRenderer(cellren);
        b.setCellRenderer(cellren);
        c.setCellRenderer(cellren);
        */
        JTableHeader header = tBobot.getTableHeader();
        DefaultTableCellRenderer render = (DefaultTableCellRenderer)header.getDefaultRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);
    }
    protected void setLayoutNormalisasi(){
        /*TableColumn a = tabelKriteria.getColumnModel().getColumn(0);
        TableColumn b = tabelKriteria.getColumnModel().getColumn(1);
        TableColumn c = tabelKriteria.getColumnModel().getColumn(2);
        DefaultTableCellRenderer cellren = new DefaultTableCellRenderer();
        cellren.setHorizontalAlignment(JLabel.CENTER);
        a.setCellRenderer(cellren);
        b.setCellRenderer(cellren);
        c.setCellRenderer(cellren);
        */
        JTableHeader header = tNormalisasi.getTableHeader();
        DefaultTableCellRenderer render = (DefaultTableCellRenderer)header.getDefaultRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);
    }
    public void dataBobot(){
        Object[] Baris={"NIK","Nama","Pendapatan Bulanan","Jumlah Tanggungan","Kepemilikan Rumah","Transportasi"};
        tabmode = new DefaultTableModel(null, Baris);
        try {
            String sql= "select * from nilaiBobot";
            java.sql.Statement stat = connection.createStatement();
            ResultSet hasil=stat.executeQuery(sql);
            while (hasil.next()){
                String nik = hasil.getString("NIK");
                String nama = hasil.getString("NW");
                double[] row = new double[4];
                row[0] = hasil.getDouble("BPB");
                row[1] = hasil.getDouble("BTJ");
                row[2] = hasil.getDouble("BKR");
                row[3] = hasil.getDouble("BT");
                NIK.add(nik);
                Nama.add(nama);
                data.add(row);
                Object[] rowData = {nik, nama, row[0], row[1], row[2], row[3]};
                tabmode.addRow(rowData);
            }
            tBobot.setModel(tabmode);
        }catch (Exception e){
            
        }
    }
    
    public static double[][] normalizeData(ArrayList<double[]> data){
        int numAlternatives = data.size();
        int numCriteria = data.get(0).length;
        double[][] normalizedData = new double[numAlternatives][numCriteria];
        for (int j = 0; j < numCriteria; j++) {
            double max = getMax(data, j);
            for (int i = 0; i < numAlternatives; i++) {
                normalizedData[i][j] = data.get(i)[j]/max;
            }
        }
      return normalizedData;  
    }
    
    public static double getMax(ArrayList<double[]> data, int column){
        double max = data.get(0)[column];
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i)[column] > max){
                max = data.get(i)[column];
        }
        }
      return max;
    }
    
    public void dataNormalisasi(){
        Object[] Baris={"NIK","Nama","Pendapatan Bulanan","Jumlah Tanggungan","Kepemilikan Rumah","Transportasi"};
        tabmode = new DefaultTableModel(null, Baris);
        tNormalisasi.setModel(tabmode);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PUtama = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tBobot = new javax.swing.JTable();
        bHitung = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tNormalisasi = new javax.swing.JTable();
        bSimpan = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        PUtama.setBackground(new java.awt.Color(255, 255, 240));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATA BOBOT NILAI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 13), new java.awt.Color(0, 0, 128))); // NOI18N

        tBobot.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        tBobot.setForeground(new java.awt.Color(0, 0, 128));
        tBobot.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tBobot);

        bHitung.setBackground(new java.awt.Color(255, 8, 0));
        bHitung.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        bHitung.setForeground(new java.awt.Color(255, 255, 240));
        bHitung.setText("HITUNG");
        bHitung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHitungActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TABEL NORMALISASI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 13), new java.awt.Color(0, 0, 128))); // NOI18N

        tNormalisasi.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        tNormalisasi.setForeground(new java.awt.Color(0, 0, 128));
        tNormalisasi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tNormalisasi);

        bSimpan.setBackground(new java.awt.Color(255, 8, 0));
        bSimpan.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        bSimpan.setForeground(new java.awt.Color(255, 255, 240));
        bSimpan.setText("SIMPAN");
        bSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        bHapus.setBackground(new java.awt.Color(255, 8, 0));
        bHapus.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        bHapus.setForeground(new java.awt.Color(255, 255, 240));
        bHapus.setText("HAPUS");
        bHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PUtamaLayout = new javax.swing.GroupLayout(PUtama);
        PUtama.setLayout(PUtamaLayout);
        PUtamaLayout.setHorizontalGroup(
            PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(bHitung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PUtamaLayout.createSequentialGroup()
                        .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PUtamaLayout.setVerticalGroup(
            PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(PUtama, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHitungActionPerformed
       // TODO add your handling code here:
    double[][] normalizedData = normalizeData(data);
    Object[] Baris = {"NIK", "Nama", "Pendapatan Bulanan", "Jumlah Tanggungan", "Kepemilikan Rumah", "Transportasi"};
    tabmode = new DefaultTableModel(null, Baris);
    tNormalisasi.setModel(tabmode);
    
    for (int i = 0; i < normalizedData.length; i++) {
        Object[] rowData = {
            NIK.get(i),
            Nama.get(i),
            normalizedData[i][0],
            normalizedData[i][1],
            normalizedData[i][2],
            normalizedData[i][3]
        };
        tabmode.addRow(rowData);
    }
    tNormalisasi.setModel(tabmode);
    tNormalisasi.setVisible(true);
    jScrollPane2.setVisible(true);
    }//GEN-LAST:event_bHitungActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        double [][] normalizedData = normalizeData(data);
        String sql = "insert into normalisasi values (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            for (int i = 0; i < normalizedData.length; i++) {
                stmt.setString(1, NIK.get(i));
                stmt.setString(2, Nama.get(i));
                stmt.setDouble(3, normalizedData[i][0]);
                stmt.setDouble(4, normalizedData[i][1]);
                stmt.setDouble(5, normalizedData[i][2]);
                stmt.setDouble(6, normalizedData[i][3]);
                stmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan Karena Data Sudah Tersedia");
        }
        
    }//GEN-LAST:event_bSimpanActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
    int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus seluruh data ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_CANCEL_OPTION);
    
    if (ok == JOptionPane.YES_OPTION) {
        String sql = "DELETE FROM normalisasi";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            int rowsDeleted = stmt.executeUpdate();
            
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                // Kosongkan tabel GUI
                tabmode.setRowCount(0);
                tNormalisasi.setVisible(false);
                jScrollPane2.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data");
        }
    }
    }//GEN-LAST:event_bHapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PUtama;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bHitung;
    private javax.swing.JButton bSimpan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tBobot;
    private javax.swing.JTable tNormalisasi;
    // End of variables declaration//GEN-END:variables
}
