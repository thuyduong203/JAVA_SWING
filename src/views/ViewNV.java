/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import domainModel.ChucVu;
import domainModel.CuaHang;
import domainModel.NhanVien;
import service.impl.ChucVuServiceImpl;
import service.impl.CuaHangServiceImpl;
import service.impl.NhanVienServiceImpl;
import viewModel.NhanVienViewModel;

/**
 *
 * @author Duongntt
 */
public class ViewNV extends javax.swing.JFrame {

    private DefaultComboBoxModel dcbmCH;
    private DefaultComboBoxModel dcbmCV;
    private DefaultComboBoxModel dcbmBC;
    private DefaultTableModel dtmHienThi;
    private List<NhanVien> listNV;
    private NhanVienServiceImpl nvSVImpl;
    private ChucVuServiceImpl chucVuImpl;
    private CuaHangServiceImpl cuaHangSVImpl;
    private List<ChucVu> listCV;
    private List<CuaHang> listCH;
    private List<NhanVien> listGuiBC;
    private List<NhanVienViewModel> listNVView = new ArrayList<>();

    public ViewNV() {
        initComponents();
        dcbmCH = new DefaultComboBoxModel();
        dcbmCV = new DefaultComboBoxModel();
        dcbmBC = new DefaultComboBoxModel();
        dtmHienThi = new DefaultTableModel();
        listNV = new ArrayList<>();
        nvSVImpl = new NhanVienServiceImpl();
        chucVuImpl = new ChucVuServiceImpl();
        cuaHangSVImpl = new CuaHangServiceImpl();
        listCH = new ArrayList<>();
        listCV = new ArrayList<>();
        listGuiBC = new ArrayList<>();
        cbbChucVu.setModel(dcbmCV);
        cbbCuaHang.setModel(dcbmCH);
        cbbGuiBC.setModel(dcbmBC);
        tblHienThiNV.setModel(dtmHienThi);
        setCbb();
        String headers[] = {"Mã NV", "Tên NV", "Id CH", "Id Chức vụ", " ID Người gửi báo cáo", "Ngày sinh"};
        dtmHienThi.setColumnIdentifiers(headers);
        listNV = nvSVImpl.getAllNV();
        showData(listNV);
    }

    private void setCbb() {
        listCH = cuaHangSVImpl.getAllCH();
        listCV = chucVuImpl.getAllCV();
        listGuiBC = nvSVImpl.getAllNV();
        for (NhanVien nhanVien : listGuiBC) {
            dcbmBC.addElement(nhanVien.getIdNV());
        }
        for (CuaHang cuaHang : listCH) {
            dcbmCH.addElement(cuaHang.getIdCH());
        }
        for (ChucVu chucVu : listCV) {
            dcbmCV.addElement(chucVu.getIdCV());
        }
    }

    public void showData(List<NhanVien> listNV) {
        dtmHienThi.setRowCount(0);
        listNV = nvSVImpl.getAllNV();
        listNVView = nvSVImpl.convertOb(listNV);
        for (NhanVienViewModel nhanVienViewModel : listNVView) {
            dtmHienThi.addRow(nhanVienViewModel.toDataRow());
        }
    }

    private NhanVien newNhanVien() {
        String maNV = txtMa.getText();
        String tenNV = txtTen.getText();
        String tenDem = txtTenDem.getText();
        String hoNV = txtHo.getText();
        String gioiTinh = txtGtinh.getText();
        Date ngaySinh = Date.valueOf(txtNgaySinh.getText());
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        String matKhau = txtMatKhau.getText();
        CuaHang cuaHang = new CuaHang(cbbCuaHang.getSelectedItem().toString());
        ChucVu chucVu = new ChucVu(cbbChucVu.getSelectedItem().toString());
        NhanVien guiBC = new NhanVien(cbbGuiBC.getSelectedItem().toString());
        int trangThai = Integer.valueOf(txtTrangThai.getText());
        NhanVien nhanVien = new NhanVien(hoNV, maNV, tenNV, tenDem, hoNV, gioiTinh, ngaySinh, diaChi, sdt, matKhau, cuaHang, chucVu, guiBC, trangThai);
        return nhanVien;
    }

    private void fill(int index, List<NhanVien> listNV) {
        NhanVien nv = listNV.get(index);
        txtMa.setText(nv.getMaNV());
        txtTen.setText(nv.getTenNV());
        txtTenDem.setText(nv.getTenDemNV());
        txtHo.setText(nv.getHoNV());
        txtGtinh.setText(nv.getGioiTinhNV());
        txtNgaySinh.setText(String.valueOf(nv.getNgaySinhNV()));
        txtDiaChi.setText(nv.getDiaChiNV());
        txtSDT.setText(nv.getSdtNV());
        txtMatKhau.setText(nv.getMatKhauNV());
        cbbCuaHang.setSelectedItem(nv.getCuaHang().getIdCH());
        cbbChucVu.setSelectedItem(nv.getChucVu().getIdCV());
        cbbGuiBC.setSelectedItem(nv.getNguoiGuiBC().getIdNV());
        txtTrangThai.setText(String.valueOf(nv.getTrangThai()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtTenDem = new javax.swing.JTextField();
        txtHo = new javax.swing.JTextField();
        txtGtinh = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbCuaHang = new javax.swing.JComboBox<>();
        cbbChucVu = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbbGuiBC = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btbUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHienThiNV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("NHÂN VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel5.setText("Gtinh:");

        jLabel6.setText("Ngày sinh:");

        jLabel7.setText("Địa chỉ:");

        jLabel8.setText("SDT:");

        jLabel9.setText("Mật khẩu:");

        jLabel10.setText("Chức Vụ:");

        jLabel11.setText("Cửa Hàng:");

        jLabel12.setText("Người Gửi BC:");

        jLabel13.setText("Trạng thái:");

        jLabel2.setText("Mã:");

        jLabel3.setText("Tên:");

        cbbCuaHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Tên Đệm:");

        cbbGuiBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Họ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2))
                    .addComponent(jLabel4)
                    .addComponent(jLabel14)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGtinh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel13)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbGuiBC, 0, 265, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtDiaChi))))))))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cbbCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(cbbGuiBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGtinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Nhân viên:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btbUpdate.setText("Update");
        btbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbUpdateActionPerformed(evt);
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

        tblHienThiNV.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHienThiNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHienThiNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHienThiNV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btnAdd)
                        .addGap(59, 59, 59)
                        .addComponent(btbUpdate)
                        .addGap(64, 64, 64)
                        .addComponent(btnDelete)
                        .addGap(66, 66, 66)
                        .addComponent(btnClear)
                        .addGap(59, 59, 59)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btbUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnExit))
                .addGap(19, 19, 19)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbUpdateActionPerformed
        int index = tblHienThiNV.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
        } else {
            String idNV = listNV.get(index).getIdNV();
            NhanVien nhanVien = newNhanVien();
            JOptionPane.showMessageDialog(rootPane, nvSVImpl.updateNV(nhanVien, idNV));
            listNV = nvSVImpl.getAllNV();
            showData(listNV);
        }
    }//GEN-LAST:event_btbUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        NhanVien nhanVien = newNhanVien();
        JOptionPane.showMessageDialog(this, nvSVImpl.addNhanVien(nhanVien));
        listNV = nvSVImpl.getAllNV();
        showData(listNV);
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblHienThiNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHienThiNVMouseClicked
        int index = tblHienThiNV.getSelectedRow();
        fill(index, listNV);        // TODO add your handling code here:
    }//GEN-LAST:event_tblHienThiNVMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblHienThiNV.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xoá!");
        } else {
            String idNV = listNV.get(index).getIdNV();
            JOptionPane.showMessageDialog(rootPane, nvSVImpl.deleteNV(idNV));
            listNV = nvSVImpl.getAllNV();
            showData(listNV);
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
            java.util.logging.Logger.getLogger(ViewNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbUpdate;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbbCuaHang;
    private javax.swing.JComboBox<String> cbbGuiBC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JTable tblHienThiNV;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGtinh;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDem;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
