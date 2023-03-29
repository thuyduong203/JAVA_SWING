/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import domainModel.ChiTietSP;
import domainModel.GioHang;
import domainModel.GioHangChiTiet;
import service.impl.ChiTietSPServiceImpl;
import service.impl.GioHangChiTietImpl;
import service.impl.GioHangServiceImpl;

/**
 *
 * @author Duongntt
 */
public class ViewGioHangChiTiet extends javax.swing.JFrame {

    private DefaultTableModel dtmGHCT = new DefaultTableModel();
    private DefaultComboBoxModel dcbmIDGH = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmIdCTSP = new DefaultComboBoxModel();
    private List<GioHangChiTiet> listGHCT = new ArrayList<>();
    private List<GioHang> listGH = new ArrayList<>();
    private List<ChiTietSP> listCTSP = new ArrayList<>();
    private GioHangChiTietImpl gioHangChiTietSvImpl = new GioHangChiTietImpl();
    private GioHangServiceImpl gioHangSvImpl = new GioHangServiceImpl();
    private ChiTietSPServiceImpl chiTietSPSvImpl = new ChiTietSPServiceImpl();

    public ViewGioHangChiTiet() {
        initComponents();
        tblGHCT.setModel(dtmGHCT);
        cbbIdGH.setModel(dcbmIDGH);
        cbbIdCTSP.setModel(dcbmIdCTSP);
        String headers[] = {"Id Giỏ hàng", "Id CTSP", "Số lượng", "Đơn giá", "Đơn giá khi giảm"};
        dtmGHCT.setColumnIdentifiers(headers);
        loadCbb();
        listGHCT = gioHangChiTietSvImpl.getAllGHCT();
        showData(listGHCT);
    }

    private void showData(List<GioHangChiTiet> listGHCT) {
        dtmGHCT.setRowCount(0);
        for (GioHangChiTiet gioHangChiTiet : listGHCT) {
            dtmGHCT.addRow(gioHangChiTiet.todataRow());
        }
    }

    private void loadCbb() {
        listCTSP = chiTietSPSvImpl.getAllCTSP();
        listGH = gioHangSvImpl.getAllGH();
        for (ChiTietSP chiTietSP : listCTSP) {
            dcbmIdCTSP.addElement(chiTietSP.getIdCTSP());
        }
        for (GioHang gioHang : listGH) {
            dcbmIDGH.addElement(gioHang.getIdGioHang());
        }
    }

    private void fill(int index, List<GioHangChiTiet> listGHCT) {
        GioHangChiTiet gioHangChiTiet = listGHCT.get(index);
        cbbIdGH.setSelectedItem(gioHangChiTiet.getGioHang().getIdGioHang());
        cbbIdCTSP.setSelectedItem(gioHangChiTiet.getChiTietSP().getIdCTSP());
        txtSoLuong.setText(String.valueOf(gioHangChiTiet.getSoLuong()));
        txtDonGia.setText(String.valueOf(gioHangChiTiet.getDonGia()));
        txtDonGiaKhiGiam.setText(String.valueOf(gioHangChiTiet.getDonGiaKhiGiam()));
    }

    private GioHangChiTiet newGHCT() {
        GioHang gioHang = new GioHang(cbbIdGH.getSelectedItem().toString());
        ChiTietSP chiTietSP = new ChiTietSP(cbbIdCTSP.getSelectedItem().toString());
        int soLuong = Integer.valueOf(txtSoLuong.getText());
        BigDecimal donGia = BigDecimal.valueOf(Double.valueOf(txtDonGia.getText()));
        BigDecimal donGiaKhiGiam = BigDecimal.valueOf(Double.valueOf(txtDonGiaKhiGiam.getText()));
        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet(gioHang, chiTietSP, soLuong, donGia, donGiaKhiGiam);
        return gioHangChiTiet;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbIdGH = new javax.swing.JComboBox<>();
        cbbIdCTSP = new javax.swing.JComboBox<>();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtDonGiaKhiGiam = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGHCT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("GIỎ HÀNG CHI TIẾT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Infomation"));

        jLabel2.setText("Id Giỏ hàng:");

        jLabel3.setText("Id CTSP:");

        jLabel4.setText("Số lượng:");

        jLabel5.setText("Đơn giá:");

        jLabel6.setText("Đơn giá khi giảm:");

        cbbIdGH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbIdCTSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbIdGH, 0, 213, Short.MAX_VALUE)
                    .addComponent(cbbIdCTSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonGia)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDonGiaKhiGiam)))
                .addGap(59, 59, 59))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(cbbIdGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(cbbIdCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDonGiaKhiGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Giỏ hàng chi tiết:");

        tblGHCT.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGHCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGHCTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGHCT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 629, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(88, 88, 88)
                .addComponent(btnDelete)
                .addGap(72, 72, 72)
                .addComponent(btnClear)
                .addGap(81, 81, 81)
                .addComponent(btnExit)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        GioHangChiTiet ghct = newGHCT();
        JOptionPane.showMessageDialog(this, gioHangChiTietSvImpl.themGHCT(ghct));
        listGHCT = gioHangChiTietSvImpl.getAllGHCT();
        showData(listGHCT);
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblGHCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGHCTMouseClicked
        int index = tblGHCT.getSelectedRow();
        fill(index, listGHCT);
    }//GEN-LAST:event_tblGHCTMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        cbbIdGH.setSelectedIndex(0);
        cbbIdCTSP.setSelectedIndex(0);
        txtSoLuong.setText("");
        txtDonGia.setText("");
        txtDonGiaKhiGiam.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        JOptionPane.showMessageDialog(this, "Update gtheo gì nhể=))");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblGHCT.getSelectedRow();
        if(index < 0){
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xoá!");
        }else{
            listGHCT = gioHangChiTietSvImpl.getAllGHCT();
            GioHangChiTiet gioHangChiTiet = listGHCT.get(index);
            JOptionPane.showMessageDialog(this, gioHangChiTietSvImpl.deleteGHCT(gioHangChiTiet.getChiTietSP().getIdCTSP(), gioHangChiTiet.getGioHang().getIdGioHang()));
            listGHCT = gioHangChiTietSvImpl.getAllGHCT();
            showData(listGHCT);
        } 
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(ViewGioHangChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGioHangChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGioHangChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGioHangChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGioHangChiTiet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbIdCTSP;
    private javax.swing.JComboBox<String> cbbIdGH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGHCT;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtDonGiaKhiGiam;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
