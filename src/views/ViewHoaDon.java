/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import domainModel.HoaDon;
import domainModel.KhachHang;
import domainModel.NhanVien;
import service.impl.HoaDonChiTietImpl;
import service.impl.HoaDonServiceImpl;
import service.impl.KhachHangServiceImpl;
import service.impl.NhanVienServiceImpl;
import java.sql.Date;
import javax.swing.JOptionPane;
import viewModel.HoaDonViewModel;

/**
 *
 * @author Duongntt
 */
public class ViewHoaDon extends javax.swing.JFrame {
    
    private DefaultTableModel dtmHoaDon = new DefaultTableModel();
    private DefaultComboBoxModel dcbmIdKH = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmIdNV = new DefaultComboBoxModel();
    private List<HoaDon> listHD = new ArrayList<>();
    private List<KhachHang> listKH = new ArrayList<>();
    private List<NhanVien> listNV = new ArrayList<>();
    private HoaDonServiceImpl hoaDonServiceImpl = new HoaDonServiceImpl();
    private HoaDonChiTietImpl hoaDonChiTietImpl = new HoaDonChiTietImpl();
    private KhachHangServiceImpl khachHangServiceImpl = new KhachHangServiceImpl();
    private NhanVienServiceImpl nhanVienServiceImpl = new NhanVienServiceImpl();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public ViewHoaDon() {
        initComponents();
        tblHoaDon.setModel(dtmHoaDon);
        cbbIdKH.setModel(dcbmIdKH);
        cbbIdNV.setModel(dcbmIdNV);
        String headers[] = {"Id HD", "ID KH", "IDNV", "Mã HD", "Ngày Tạo", "Ngày TT", "Ngày ship", "Ngày nhận", "tên NN", "Địa chỉ", "SDT", "Trạng thái"};
        dtmHoaDon.setColumnIdentifiers(headers);
        loadCbb();
        listHD = hoaDonServiceImpl.getAllHDKoJoin();
        showData(listHD);
    }
    
    private void showData(List<HoaDon> listHD) {
        dtmHoaDon.setRowCount(0);
        List<HoaDonViewModel> listHDCiew = hoaDonServiceImpl.convertOb(listHD);
        for (HoaDonViewModel hoaDonViewModel : listHDCiew) {
            dtmHoaDon.addRow(hoaDonViewModel.todataRow());
        }
    }
    
    private void fill(int index, List<HoaDon> listHD) {
        HoaDon hoaDon = listHD.get(index);
        cbbIdKH.setSelectedItem(hoaDon.getKhachHang().getIdKH());
        cbbIdNV.setSelectedItem(hoaDon.getNhanVien().getIdNV());
        txtMaHD.setText(hoaDon.getMaHoaDon());
        txtNguoiNhan.setText(hoaDon.getTenNguoiNhan());
        txtDiaChi.setText(hoaDon.getDiaChiNguoiNhan());
        txtSDT.setText(hoaDon.getSdtNguoiNhan());
        txtTinhTrang.setText(String.valueOf(hoaDon.getTinhTrangHD()));
        dateNgayTao.setDate(hoaDon.getNgayTao());
        dateNgayTT.setDate(hoaDon.getNgayThanhToan());
        dateNgayShip.setDate(hoaDon.getNgayShip());
        dateNgayNhan.setDate(hoaDon.getNgayNhan());
    }
    
    private HoaDon newHoaDon() {
        KhachHang khachHang = new KhachHang(cbbIdKH.getSelectedItem().toString());
        NhanVien nhanVien = new NhanVien(cbbIdNV.getSelectedItem().toString());
        String maHD = txtMaHD.getText();
        String tenNN = txtNguoiNhan.getText();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        int tinhTrang = Integer.valueOf(txtTinhTrang.getText());
        Date ngayTao = Date.valueOf(dateFormat.format(dateNgayTao.getDate()));
        Date ngayTT = Date.valueOf(dateFormat.format(dateNgayTT.getDate()));
        Date ngayShip = Date.valueOf(dateFormat.format(dateNgayShip.getDate()));
        Date ngayNhan = Date.valueOf(dateFormat.format(dateNgayNhan.getDate()));
        HoaDon hoaDon = new HoaDon("", khachHang, nhanVien, maHD, ngayTao, ngayNhan, ngayShip, ngayNhan, tinhTrang, tenNN, diaChi, sdt);
        return hoaDon;
    }
    
    private void loadCbb() {
        listKH = khachHangServiceImpl.getAllKH();
        listNV = nhanVienServiceImpl.getAllNV();
        for (KhachHang khachHang : listKH) {
            dcbmIdKH.addElement(khachHang.getIdKH());
        }
        for (NhanVien nhanVien : listNV) {
            dcbmIdNV.addElement(nhanVien.getIdNV());
        }
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbbIdKH = new javax.swing.JComboBox<>();
        cbbIdNV = new javax.swing.JComboBox<>();
        txtMaHD = new javax.swing.JTextField();
        txtNguoiNhan = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtTinhTrang = new javax.swing.JTextField();
        dateNgayNhan = new com.toedter.calendar.JDateChooser();
        dateNgayTT = new com.toedter.calendar.JDateChooser();
        dateNgayShip = new com.toedter.calendar.JDateChooser();
        dateNgayTao = new com.toedter.calendar.JDateChooser();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnBanHang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("HOÁ ĐƠN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel2.setText("ID KH:");

        jLabel3.setText("ID NV:");

        jLabel4.setText("Mã HD:");

        jLabel5.setText("Người nhận:");

        jLabel6.setText("Địa chỉ:");

        jLabel7.setText("Ngày tạo:");

        jLabel8.setText("Ngày TT:");

        jLabel9.setText("Ngay Ship:");

        jLabel10.setText("Ngày nhận:");

        jLabel11.setText("Tình trạng");

        jLabel12.setText("SDT:");

        cbbIdKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbIdNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbIdKH, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbIdNV, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNguoiNhan)
                                    .addComponent(txtDiaChi)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateNgayNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(dateNgayShip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateNgayTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 84, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel7)
                        .addComponent(cbbIdKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel8)
                        .addComponent(cbbIdNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateNgayTT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel9)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateNgayShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel10)
                        .addComponent(txtNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
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

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Hoá Đơn:");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        btnBanHang.setText("Bán Hàng");
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnAdd)
                .addGap(50, 50, 50)
                .addComponent(btnUpdate)
                .addGap(46, 46, 46)
                .addComponent(btnDelete)
                .addGap(60, 60, 60)
                .addComponent(btnClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBanHang)
                .addGap(34, 34, 34)
                .addComponent(btnExit)
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnExit)
                    .addComponent(btnBanHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        HoaDon hoaDon = newHoaDon();
        JOptionPane.showMessageDialog(this, hoaDonServiceImpl.addHoaDon(hoaDon));
        listHD = hoaDonServiceImpl.getAllHDKoJoin();
        showData(listHD);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int index = tblHoaDon.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
        } else {
            String idHD = listHD.get(index).getIdHoaDon();
            HoaDon hoaDon = newHoaDon();
            JOptionPane.showMessageDialog(this, hoaDonServiceImpl.updateHoaDon(hoaDon, idHD));
            listHD = hoaDonServiceImpl.getAllHDKoJoin();
            showData(listHD);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int index = tblHoaDon.getSelectedRow();
        fill(index, listHD);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblHoaDon.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
        } else {
            String idHD = listHD.get(index).getIdHoaDon();
            String delete = hoaDonChiTietImpl.deleteHDCTByIdHD(idHD);
            JOptionPane.showMessageDialog(this, hoaDonServiceImpl.deleteHoaDon(idHD));
            listHD = hoaDonServiceImpl.getAllHD();
            showData(listHD);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        ViewBanHang viewBanHang = new ViewBanHang();
        this.dispose();
        viewBanHang.setVisible(true);
    }//GEN-LAST:event_btnBanHangActionPerformed

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
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbIdKH;
    private javax.swing.JComboBox<String> cbbIdNV;
    private com.toedter.calendar.JDateChooser dateNgayNhan;
    private com.toedter.calendar.JDateChooser dateNgayShip;
    private com.toedter.calendar.JDateChooser dateNgayTT;
    private com.toedter.calendar.JDateChooser dateNgayTao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNguoiNhan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTinhTrang;
    // End of variables declaration//GEN-END:variables
}
