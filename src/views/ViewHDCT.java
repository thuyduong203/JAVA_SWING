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
import domainModel.HoaDon;
import domainModel.HoaDonChiTiet;
import service.impl.ChiTietSPServiceImpl;
import service.impl.HoaDonChiTietImpl;
import service.impl.HoaDonServiceImpl;
import viewModel.HoaDonChiTietViewModel;

/**
 *
 * @author Duongntt
 */
public class ViewHDCT extends javax.swing.JFrame {

    private DefaultTableModel dtmHDCT = new DefaultTableModel();
    private DefaultComboBoxModel dcbmIdHD = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmIdCTSP = new DefaultComboBoxModel();
    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    private List<HoaDon> listHD = new ArrayList<>();
    private List<ChiTietSP> listCTSP = new ArrayList<>();
    private HoaDonChiTietImpl hoaDonChiTietImpl = new HoaDonChiTietImpl();
    private ChiTietSPServiceImpl chiTietSPServiceImpl = new ChiTietSPServiceImpl();
    private HoaDonServiceImpl hoaDonServiceImpl = new HoaDonServiceImpl();

    public ViewHDCT() {
        initComponents();
        tblHDCT.setModel(dtmHDCT);
        cbbIdCTSP.setModel(dcbmIdCTSP);
        cbbIdHD.setModel(dcbmIdHD);
        String headers[] = {"Id HD", "ID CTSP", "Số lượng", "Đơn giá"};
        loadCbb();
        dtmHDCT.setColumnIdentifiers(headers);
        listHDCT = hoaDonChiTietImpl.getAllHD();
        showData(listHDCT);
    }

    private void showData(List<HoaDonChiTiet> listHDCT) {
        dtmHDCT.setRowCount(0);
        List<HoaDonChiTietViewModel> listHDCTView = hoaDonChiTietImpl.convertOb(listHDCT);
        for (HoaDonChiTietViewModel hoaDonChiTietViewModel : listHDCTView) {
            dtmHDCT.addRow(hoaDonChiTietViewModel.toDataRow());
        }
    }

    private HoaDonChiTiet newHoaDonCT() {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setIdHoaDon(cbbIdHD.getSelectedItem().toString());
        ChiTietSP chiTietSP = new ChiTietSP(cbbIdCTSP.getSelectedItem().toString());
        int soLuong = Integer.valueOf(txtSoLuong.getText());
        BigDecimal donGia = BigDecimal.valueOf(Double.valueOf(txtDonGia.getText()));
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(hoaDon, chiTietSP, soLuong, donGia);
        return hoaDonChiTiet;
    }

    private void loadCbb() {
        listCTSP = chiTietSPServiceImpl.getAllCTSP();
        listHD = hoaDonServiceImpl.getAllHD();
        for (ChiTietSP chiTietSP : listCTSP) {
            dcbmIdCTSP.addElement(chiTietSP.getIdCTSP());
        }
        for (HoaDon hoaDon : listHD) {
            dcbmIdHD.addElement(hoaDon.getIdHoaDon());
        }
    }

    private void fill(int index, List<HoaDonChiTiet> listHDCT) {
        HoaDonChiTiet hoaDonChiTiet = listHDCT.get(index);
        cbbIdHD.setSelectedItem(hoaDonChiTiet.getHoaDon().getIdHoaDon());
        cbbIdCTSP.setSelectedItem(hoaDonChiTiet.getChiTietSP().getIdCTSP());
        txtSoLuong.setText(String.valueOf(hoaDonChiTiet.getSoLuong()));
        txtDonGia.setText(String.valueOf(hoaDonChiTiet.getDonGia()));
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
        cbbIdHD = new javax.swing.JComboBox<>();
        cbbIdCTSP = new javax.swing.JComboBox<>();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("HOÁ ĐƠN CHI TIẾT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel2.setText("Id HD:");

        jLabel3.setText("Id CTSP:");

        jLabel4.setText("Số lượng:");

        jLabel5.setText("Đơn giá:");

        cbbIdHD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbIdCTSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbIdCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbIdHD, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoLuong)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(cbbIdHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbbIdCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
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

        btnExit.setText("Exit");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Hoá đơn chi tiết:");

        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHDCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDCTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHDCT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(60, 60, 60)
                .addComponent(btnDelete)
                .addGap(70, 70, 70)
                .addComponent(btnClear)
                .addGap(71, 71, 71)
                .addComponent(btnExit)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnExit))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int index = tblHDCT.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
        } else {
            String idHD = listHDCT.get(index).getHoaDon().getIdHoaDon();
            String idCTSP = listHDCT.get(index).getChiTietSP().getIdCTSP();
            HoaDonChiTiet hoaDonChiTiet = newHoaDonCT();
            JOptionPane.showMessageDialog(this, hoaDonChiTietImpl.updateHDCT(hoaDonChiTiet, idHD, idCTSP));
            listHDCT = hoaDonChiTietImpl.getAllHD();
            showData(listHDCT);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        HoaDonChiTiet hoaDonChiTiet = newHoaDonCT();
        JOptionPane.showMessageDialog(this, hoaDonChiTietImpl.addHDCT(hoaDonChiTiet));
        listHDCT = hoaDonChiTietImpl.getAllHD();
        showData(listHDCT);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblHDCT.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xoá");
        } else {
            String idHD = listHDCT.get(index).getHoaDon().getIdHoaDon();
            String idCTSP = listHDCT.get(index).getChiTietSP().getIdCTSP();
            JOptionPane.showMessageDialog(this, hoaDonChiTietImpl.deleteHDCT(idHD, idCTSP));
            listHDCT = hoaDonChiTietImpl.getAllHD();
            showData(listHDCT);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblHDCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCTMouseClicked
        int index = tblHDCT.getSelectedRow();
        fill(index, listHDCT);
    }//GEN-LAST:event_tblHDCTMouseClicked

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
            java.util.logging.Logger.getLogger(ViewHDCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHDCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHDCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHDCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHDCT().setVisible(true);
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
    private javax.swing.JComboBox<String> cbbIdHD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
