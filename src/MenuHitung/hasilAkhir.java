package MenuHitung;

import Koneksi.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author agar
 */
public class hasilAkhir extends javax.swing.JPanel {

    private Connection connection = new koneksi().connect();
    private DefaultTableModel tabmode;
    private static final double bobotBPB = 0.4;
    private static final double bobotBTJ = 0.3;
    private static final double bobotBKR = 0.1;
    private static final double bobotBT = 0.2;
    private List<Normalisasi> normalisasiList = new ArrayList<>();
    
    public hasilAkhir() {
        initComponents();
        tabelKriteria();
        tabelNormalisasi();
        tabelRangking();
        trangking.setVisible(false);
        jScrollPane3.setVisible(false);
    }
   
   public void tabelKriteria(){
    Object [] baris = {" ", "Pendapatan Bulanan (C1)", "Jumlah Tanggungan (C2)", "Kepemilikan Rumah (C3)", "Transportasi (C4)"};
    tabmode = new DefaultTableModel(null, baris);
         try {
            String sql = "SELECT " +
                         "MAX(CASE WHEN ID = 'C1' THEN bobotPreferensi END) AS C1, " +
                         "MAX(CASE WHEN ID = 'C2' THEN bobotPreferensi END) AS C2, " +
                         "MAX(CASE WHEN ID = 'C3' THEN bobotPreferensi END) AS C3, " +
                         "MAX(CASE WHEN ID = 'C4' THEN bobotPreferensi END) AS C4 " +
                         "FROM Kriteria";

            java.sql.Statement stat = connection.createStatement();
            ResultSet hasil = stat.executeQuery(sql);

            if (hasil.next()) {
                tabmode.addRow(new Object[]{
                    "Bobot",
                    hasil.getString("C1")+"%",
                    hasil.getString("C2")+"%",
                    hasil.getString("C3")+"%",
                    hasil.getString("C4")+"%"
                });
            }

            tkriteria.setModel(tabmode);
        } catch (Exception e) {
        }
}

    public void tabelNormalisasi(){
        Object [] baris = {"NIK","Nama","Pendapatan Bulanan","Jumlah Tanggungan","Kepemilikan Rumah","Transportasi"};
        tabmode = new DefaultTableModel(null, baris);
        try {
            String sql               = "select * from normalisasi";
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
            tNormalisasi.setModel(tabmode);
        } catch (Exception e) {
        }
    }
    public void tabelRangking(){
        Object [] baris = {"Peringkat","NIK","Nama","Nilai Akhir"};
        tabmode = new DefaultTableModel(null, baris);
        trangking.setModel(tabmode);
    }
   
    public void hitung () {                                        
        try {
            String sql= "select * from normalisasi";
            java.sql.Statement stat = connection.createStatement();
            ResultSet rs=stat.executeQuery(sql);
            while (rs.next()) {
                Normalisasi data = new Normalisasi(
                        rs.getString("NIK"),
                        rs.getString("NW"),
                        rs.getDouble("BPB"),
                        rs.getDouble("BTJ"),
                        rs.getDouble("BKR"),
                        rs.getDouble("BT")
                );
                normalisasiList.add(data);
            } 
        } catch (Exception e) {
        }
        for (Normalisasi data : normalisasiList) {
            double nilaiAkhir = (data.BPB * bobotBPB) +
                                (data.BTJ * bobotBTJ) +
                                (data.BKR * bobotBKR) +
                                (data.BT * bobotBT);
            data.setNilaiAkhir(nilaiAkhir);
        }
        //Perangkingan
        Collections.sort(normalisasiList, Comparator.comparingDouble(Normalisasi::getNilaiAkhir).reversed());
        
        for (int i = 0; i < normalisasiList.size(); i++) {
            Normalisasi data = normalisasiList.get(i);
            data.setRank(i + 1);
        }
        updateTabelHasilAkhir(normalisasiList);
}
    private void updateTabelHasilAkhir(List<Normalisasi> normalisasiList) {
    tabmode.setRowCount(0); // Clear existing data
    int rank = 1;
    DecimalFormat df = new DecimalFormat("#.###"); // Format for 3 decimal places
    for (Normalisasi data : normalisasiList) {
        tabmode.addRow(new Object[]{
                rank++,
                data.NIK,
                data.NW,
                df.format(data.getNilaiAkhir()) // Format nilai akhir
        });
    }
    trangking.setModel(tabmode);
}
    
    class Normalisasi {
    String NIK;      // Nomor Induk Kependudukan
    String NW;       // Nama Warga
    double BPB;      // Bobot Pendapatan Bulanan
    double BTJ;      // Bobot Tanggungan Jumlah
    double BKR;      // Bobot Kepemilikan Rumah
    double BT;       // Bobot Transportasi
    double nilaiAkhir; // Nilai akhir setelah perhitungan SAW
    int rank;        // Peringkat setelah perangkingan

    // Konstruktor untuk menginisialisasi data normalisasi
    Normalisasi(String NIK, String NW, double BPB, double BTJ, double BKR, double BT) {
        this.NIK = NIK;
        this.NW = NW;
        this.BPB = BPB;
        this.BTJ = BTJ;
        this.BKR = BKR;
        this.BT = BT;
    }

    // Setter untuk nilai akhir
    void setNilaiAkhir(double nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }

    // Getter untuk nilai akhir
    double getNilaiAkhir() {
        return nilaiAkhir;
    }

    // Setter untuk peringkat
    void setRank(int rank) {
        this.rank = rank;
    }
    
    int getRank() {
        return rank;
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PUtama = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tkriteria = new javax.swing.JTable();
        bHitung = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tNormalisasi = new javax.swing.JTable();
        bSimpan = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        trangking = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        PUtama.setBackground(new java.awt.Color(255, 255, 240));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KRITERIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 13), new java.awt.Color(0, 0, 128))); // NOI18N

        tkriteria.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        tkriteria.setForeground(new java.awt.Color(0, 0, 128));
        tkriteria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tkriteria);

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

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HASIL AKHIR PERANGKINGAN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 13), new java.awt.Color(0, 0, 128))); // NOI18N

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
        jScrollPane3.setViewportView(trangking);

        javax.swing.GroupLayout PUtamaLayout = new javax.swing.GroupLayout(PUtama);
        PUtama.setLayout(PUtamaLayout);
        PUtamaLayout.setHorizontalGroup(
            PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bHitung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PUtamaLayout.createSequentialGroup()
                        .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PUtamaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PUtamaLayout.setVerticalGroup(
            PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addGroup(PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(PUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PUtamaLayout.createSequentialGroup()
                    .addContainerGap(313, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(57, 57, 57)))
        );

        add(PUtama, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHitungActionPerformed
    // TODO add your handling code here:
        hitung();
        trangking.setVisible(true);
        jScrollPane3.setVisible(true);
    }//GEN-LAST:event_bHitungActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        String sqlInsert = "INSERT INTO hasilAkhir (NO, NIK, NW, NILAI) VALUES (?, ?, ?, ?)";
        try {
        PreparedStatement ps = connection.prepareStatement(sqlInsert);
        for (Normalisasi data : normalisasiList) {
            ps.setInt(1, data.getRank());
            ps.setString(2, data.NIK);
            ps.setString(3, data.NW);
            ps.setDouble(4, data.getNilaiAkhir());
            ps.addBatch();
        }
            updateTabelHasilAkhir(normalisasiList);
            ps.executeBatch(); // Execute all batch operations at once
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_bSimpanActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus seluruh data ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_CANCEL_OPTION);
    
    if (ok == JOptionPane.YES_OPTION) {
        String sql = "DELETE FROM hasilAkhir";
        
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tNormalisasi;
    private javax.swing.JTable tkriteria;
    private javax.swing.JTable trangking;
    // End of variables declaration//GEN-END:variables
}
