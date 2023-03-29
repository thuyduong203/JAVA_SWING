/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import domainModel.ChiTietSP;
import domainModel.DongSP;
import domainModel.GioHangChiTiet;
import domainModel.HoaDonChiTiet;
import service.impl.ChiTietSPServiceImpl;
import service.impl.DongSPServiceImpl;
import service.impl.GioHangChiTietImpl;
import service.impl.HoaDonChiTietImpl;
import viewModel.DongSPViewModel;

/**
 *
 * @author Duongntt
 */
public class ViewDongSP extends javax.swing.JFrame {
    
    private DefaultTableModel dtmDongSP = new DefaultTableModel();
    private DongSPServiceImpl dongSPSVImpl = new DongSPServiceImpl();
    private List<DongSP> listDongSP = new ArrayList<>();
    private ChiTietSPServiceImpl chiTietSPSVImpl = new ChiTietSPServiceImpl();
    private GioHangChiTietImpl gioHangChiTietImpl = new GioHangChiTietImpl();
    private HoaDonChiTietImpl hoaDonChiTietImpl = new HoaDonChiTietImpl();
    private List<ChiTietSP> listCTSPByIdDongSP = new ArrayList<>();
    private List<HoaDonChiTiet> listHDCTByIdCTSP = new ArrayList<>();
    private List<GioHangChiTiet> listGHCTByIdCTSP = new ArrayList<>();
    
    public ViewDongSP() {
        initComponents();
        tblDongSP.setModel(dtmDongSP);
        String headers[] = {"Mã Dòng SP", "Tên Dòng SP"};
        dtmDongSP.setColumnIdentifiers(headers);
        listDongSP = dongSPSVImpl.getAllDongSP();
        showData(listDongSP);
    }
    
    private void showData(List<DongSP> listDongSP) {
        dtmDongSP.setRowCount(0);
        List<DongSPViewModel> listDongSPView = dongSPSVImpl.convertOb(listDongSP);
        for (DongSPViewModel dongSPViewModel : listDongSPView) {
            dtmDongSP.addRow(dongSPViewModel.toDataRow());
        }
    }
    
    private DongSP newDongSP() {
        String maDongSP = txtMaDongSP.getText();
        String tenDongSP = txtTenDongSP.getText();
        DongSP dongSP = new DongSP("", maDongSP, tenDongSP);
        return dongSP;
    }
    
    private void fillData(int index, List<DongSP> listDongSP) {
        DongSP dongSP = listDongSP.get(index);
        txtMaDongSP.setText(dongSP.getMaDongSP());
        txtTenDongSP.setText(dongSP.getTenDongSP());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaDongSP = new javax.swing.JTextField();
        txtTenDongSP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDongSP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Dòng SP:");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setBackground(new java.awt.Color(255, 51, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("DÒNG SẢN PHẨM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel2.setText("Mã Dòng SP:");

        jLabel3.setText("Tên Dòng SP:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tblDongSP.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDongSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDongSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDongSP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnAdd)
                .addGap(63, 63, 63)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(65, 65, 65)
                .addComponent(btnClear)
                .addGap(48, 48, 48)
                .addComponent(btnExit)
                .addGap(15, 15, 15))
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 105, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        DongSP dongSP = newDongSP();
        JOptionPane.showMessageDialog(this, dongSPSVImpl.themDongSP(dongSP));
        listDongSP = dongSPSVImpl.getAllDongSP();
        showData(listDongSP);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int index = tblDongSP.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
        } else {
            String idDongSP = listDongSP.get(index).getIdDongSP();
            DongSP dongSP = newDongSP();
            JOptionPane.showMessageDialog(this, dongSPSVImpl.updateDongSP(dongSP, idDongSP));
            listDongSP = dongSPSVImpl.getAllDongSP();
            showData(listDongSP);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtMaDongSP.setText("");
        txtTenDongSP.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblDongSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDongSPMouseClicked
        int index = tblDongSP.getSelectedRow();
        fillData(index, listDongSP);
    }//GEN-LAST:event_tblDongSPMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        listDongSP = dongSPSVImpl.getAllDongSP();
        int index = tblDongSP.getSelectedRow();
        DongSP dongSP = listDongSP.get(index);
        String idDongSP = dongSP.getIdDongSP();
        String deleteHDCT = hoaDonChiTietImpl.deleteHDCTByIdCTSP2(idDongSP);
        String deleteGHCT = gioHangChiTietImpl.deleteHdctByDongSp(idDongSP);
        String deleteCTSP = chiTietSPSVImpl.deleteCTSPByIdDongSP(idDongSP);
        JOptionPane.showMessageDialog(this, dongSPSVImpl.deleteDongSP(idDongSP));
        listDongSP = dongSPSVImpl.getAllDongSP();
        showData(listDongSP);
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
            java.util.logging.Logger.getLogger(ViewDongSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDongSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDongSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDongSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDongSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDongSP;
    private javax.swing.JTextField txtMaDongSP;
    private javax.swing.JTextField txtTenDongSP;
    // End of variables declaration//GEN-END:variables

}
