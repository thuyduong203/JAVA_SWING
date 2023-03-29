/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import domainModel.GioHang;
import domainModel.KhachHang;
import domainModel.NhanVien;
import service.impl.GioHangServiceImpl;
import service.impl.KhachHangServiceImpl;
import java.sql.Date;
import javax.swing.JOptionPane;
import service.impl.GioHangChiTietImpl;

/**
 *
 * @author Duongntt
 */
public class ViewGioHang extends javax.swing.JFrame {

    private DefaultTableModel dtmGioHang = new DefaultTableModel();
    private DefaultComboBoxModel dcbmIdKH = new DefaultComboBoxModel();
    private List<GioHang> listGH = new ArrayList<>();
    private List<KhachHang> listKH = new ArrayList<>();
    private GioHangServiceImpl gioHangServiceImpl = new GioHangServiceImpl();
    private KhachHangServiceImpl khachHangServiceImpl = new KhachHangServiceImpl();
    private GioHangChiTietImpl gioHangChiTietImpl = new GioHangChiTietImpl();

    public ViewGioHang() {
        initComponents();
        tblGioHang.setModel(dtmGioHang);
        cbbIdKH.setModel(dcbmIdKH);
        String headers[] = {"Id GH", "IdKH", "IdNV", "Mã HD", "Ngày tạo", "Ngày TT", "Tên NN", "Địa Chỉ", "SDT", "Trạng thái"};
        dtmGioHang.setColumnIdentifiers(headers);
        loadCbb();
        listGH = gioHangServiceImpl.getAllGH();
        showData(listGH);
    }

    private void showData(List<GioHang> listGH) {
        dtmGioHang.setRowCount(0);
        for (GioHang gioHang : listGH) {
            dtmGioHang.addRow(gioHang.toDataRow());
        }
    }

    private void loadCbb() {
        listKH = khachHangServiceImpl.getAllKH();
        for (KhachHang khachHang : listKH) {
            dcbmIdKH.addElement(khachHang.getIdKH());
        }
    }

    private void fill(int index, List<GioHang> listGH) {
        GioHang gioHang = listGH.get(index);
        txtIdNV.setText(gioHang.getNhanVien().getIdNV());
        cbbIdKH.setSelectedItem(gioHang.getKhachHang().getIdKH());
        txtMaHD.setText(gioHang.getMaGioHang());
        txtNgayTao.setText(String.valueOf(gioHang.getNgayTao()));
        txtNgayTT.setText(String.valueOf(gioHang.getNgayThanhToan()));
        txtTenNN.setText(gioHang.getTenNguoiNhan());
        txtDiaChi.setText(gioHang.getDiaChiNN());
        txtSDT.setText(gioHang.getSoDienThoaiNN());
        txtTinhTrang.setText(String.valueOf(gioHang.getTinhTrang()));
    }

    private GioHang newGioHang() {
        KhachHang khachHang = new KhachHang(cbbIdKH.getSelectedItem().toString());
        NhanVien nhanVien = new NhanVien(txtIdNV.getText());
        String maHD = txtMaHD.getText();
        Date ngayTao = Date.valueOf(txtNgayTao.getText());
        Date ngayTT = Date.valueOf(txtNgayTT.getText());
        String tenNN = txtTenNN.getText();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        int tinhTrang = Integer.valueOf(txtTinhTrang.getText());
        GioHang gioHang = new GioHang("", khachHang, nhanVien, maHD, ngayTao, ngayTao, tenNN, diaChi, diaChi, tinhTrang);
        return gioHang;
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbbIdKH = new javax.swing.JComboBox<>();
        txtIdNV = new javax.swing.JTextField();
        txtMaHD = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtNgayTT = new javax.swing.JTextField();
        txtTenNN = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtTinhTrang = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("GIỎ HÀNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel2.setText("ID KH:");

        jLabel3.setText("ID NV:");

        jLabel4.setText("Mã HD:");

        jLabel5.setText("Ngày tạo:");

        jLabel6.setText("Ngày TT:");

        jLabel7.setText("Tên NN:");

        jLabel8.setText("Địa chỉ:");

        jLabel9.setText("SDT:");

        jLabel10.setText("Tình trạng:");

        cbbIdKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIdNV, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(cbbIdKH, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenNN)
                            .addComponent(txtDiaChi)
                            .addComponent(txtSDT)
                            .addComponent(txtTinhTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                    .addComponent(txtNgayTT, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(cbbIdKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(txtIdNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNgayTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Giỏ Hàng:");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGioHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(btnAdd)
                                .addGap(75, 75, 75)
                                .addComponent(btnUpdate)
                                .addGap(58, 58, 58)
                                .addComponent(btnDelete)
                                .addGap(61, 61, 61)
                                .addComponent(btnClear)
                                .addGap(66, 66, 66)
                                .addComponent(btnExit))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(285, 285, 285)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 70, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JOptionPane.showMessageDialog(this, gioHangServiceImpl.themGH(newGioHang()));
        listGH = gioHangServiceImpl.getAllGH();
        showData(listGH);
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        int index = tblGioHang.getSelectedRow();
        fill(index, listGH);
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int index = tblGioHang.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
        } else {
            GioHang gioHang = newGioHang();
            JOptionPane.showMessageDialog(this, gioHangServiceImpl.updateGH(gioHang, listGH.get(index).getIdGioHang()));
            listGH = gioHangServiceImpl.getAllGH();
            showData(listGH);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblGioHang.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xoá");
        } else {
            String idGH = listGH.get(index).getIdGioHang();
            String delete = gioHangChiTietImpl.deleteGHCTByIdGH(idGH);
            JOptionPane.showMessageDialog(this, gioHangServiceImpl.deleteGH(idGH));
            listGH = gioHangServiceImpl.getAllGH();
            showData(listGH);
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
            java.util.logging.Logger.getLogger(ViewGioHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGioHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGioHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGioHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGioHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbIdKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtIdNV;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTT;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNN;
    private javax.swing.JTextField txtTinhTrang;
    // End of variables declaration//GEN-END:variables
}
