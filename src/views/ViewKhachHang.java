/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import domainModel.KhachHang;
import service.impl.HoaDonChiTietImpl;
import service.impl.HoaDonServiceImpl;
import service.impl.KhachHangServiceImpl;
import java.sql.Date;
import javax.swing.JOptionPane;
import service.impl.GioHangChiTietImpl;
import service.impl.GioHangServiceImpl;
import viewModel.KhachHangViewModel;

/**
 *
 * @author Duongntt
 */
public class ViewKhachHang extends javax.swing.JFrame {
    
    private DefaultTableModel dtmKhachHang = new DefaultTableModel();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private List<KhachHang> listKhachHangs = new ArrayList<>();
    private KhachHangServiceImpl khachHangServiceImpl = new KhachHangServiceImpl();
    private HoaDonServiceImpl hoaDonServiceImpl = new HoaDonServiceImpl();
    private HoaDonChiTietImpl hoaDonChiTietImpl = new HoaDonChiTietImpl();
    private GioHangServiceImpl gioHangServiceImpl = new GioHangServiceImpl();
    private GioHangChiTietImpl gioHangChiTietImpl = new GioHangChiTietImpl();
    
    public ViewKhachHang() {
        initComponents();
        tblKhachHang.setModel(dtmKhachHang);
        String headers[] = {"Mã KH", "Họ tên", "Ngày sinh", "SDT", "Địa chỉ"};
        dtmKhachHang.setColumnIdentifiers(headers);
        listKhachHangs = khachHangServiceImpl.getAllKH();
        showData(listKhachHangs);
    }
    
    private void showData(List<KhachHang> listKH) {
        dtmKhachHang.setRowCount(0);
        List<KhachHangViewModel> listKHView = khachHangServiceImpl.convertOb(listKH);
        for (KhachHangViewModel khachHangViewModel : listKHView) {
            dtmKhachHang.addRow(khachHangViewModel.toDataRow());
        }
    }
    
    private void fill(int index, List<KhachHang> listKH) {
        KhachHang khachHang = listKH.get(index);
        txtMaKH.setText(khachHang.getMaKH());
        txtTenKH.setText(khachHang.getTenKH());
        txtTenDemKH.setText(khachHang.getTenDemKH());
        txtHoKH.setText(khachHang.getHoKH());
        dateNgaySinh.setDate(khachHang.getNgaySinhKH());
        txtSDT.setText(khachHang.getSdtKH());
        txtDiaChi.setText(khachHang.getDiaChiKH());
        txtThanhPho.setText(khachHang.getThanhPhoKH());
        txtQuocGia.setText(khachHang.getQuocGiaKH());
        txtMatKhau.setText(khachHang.getMatKhau());
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
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtTenDemKH = new javax.swing.JTextField();
        txtHoKH = new javax.swing.JTextField();
        dateNgaySinh = new com.toedter.calendar.JDateChooser();
        txtDiaChi = new javax.swing.JTextField();
        txtThanhPho = new javax.swing.JTextField();
        txtQuocGia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel2.setText("Mã KH:");

        jLabel3.setText("Tên KH:");

        jLabel4.setText("Tên Đệm:");

        jLabel5.setText("Họ:");

        jLabel6.setText("Ngày sinh");

        jLabel7.setText("SDT:");

        jLabel8.setText("Địa chỉ:");

        jLabel9.setText("Thành phố:");

        jLabel10.setText("Quốc gia:");

        jLabel11.setText("Mật khẩu:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaKH)
                    .addComponent(txtTenKH)
                    .addComponent(txtTenDemKH)
                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(txtHoKH))
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(txtDiaChi)
                    .addComponent(txtThanhPho)
                    .addComponent(txtQuocGia)
                    .addComponent(txtMatKhau))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(txtTenDemKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThanhPho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Khách hàng:");

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnAdd)
                .addGap(87, 87, 87)
                .addComponent(btnUpdate)
                .addGap(77, 77, 77)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClear)
                .addGap(63, 63, 63)
                .addComponent(btnExit)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtTenDemKH.setText("");
        txtHoKH.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        txtThanhPho.setText("");
        txtQuocGia.setText("");
        txtMatKhau.setText("");
    }//GEN-LAST:event_btnClearActionPerformed
    private KhachHang newKhachHang() {
        String maKH = txtMaKH.getText();
        String tenKH = txtTenKH.getText();
        String tenDem = txtTenDemKH.getText();
        String hoKH = txtHoKH.getText();
        Date ngaySinh = Date.valueOf(dateFormat.format(dateNgaySinh.getDate()));
        String sdt = txtSDT.getText();
        String diaChi = txtDiaChi.getText();
        String thanhPho = txtThanhPho.getText();
        String quocGia = txtQuocGia.getText();
        String matKhau = txtMatKhau.getText();
        KhachHang khachHang = new KhachHang("", maKH, tenKH, tenDem, hoKH, ngaySinh, sdt, diaChi, thanhPho, quocGia, matKhau);
        return khachHang;
    }
    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int index = tblKhachHang.getSelectedRow();
        fill(index, listKhachHangs);
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        KhachHang khachHang = newKhachHang();
        JOptionPane.showMessageDialog(this, khachHangServiceImpl.addKhachHang(khachHang));
        listKhachHangs = khachHangServiceImpl.getAllKH();
        showData(listKhachHangs);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int index = tblKhachHang.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
        } else {
            String idKH = listKhachHangs.get(index).getIdKH();
            KhachHang khachHang = newKhachHang();
            JOptionPane.showMessageDialog(this, khachHangServiceImpl.updateKhachHang(khachHang, idKH));
            listKhachHangs = khachHangServiceImpl.getAllKH();
            showData(listKhachHangs);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblKhachHang.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xoá!");
        } else {
            String idKH = listKhachHangs.get(index).getIdKH();
            String deleteHDCT = hoaDonChiTietImpl.deleteHDCTbyIdKH(idKH);
            String deleteHD = hoaDonServiceImpl.deleteHoaDonByIdKH(idKH);
            String deleteGHCT = gioHangChiTietImpl.deleteGHCTByKH(idKH);
            String deleteGH = gioHangServiceImpl.deleteGHByIdKH(idKH);
            JOptionPane.showMessageDialog(this, khachHangServiceImpl.deleteKhachHang(idKH));
            listKhachHangs = khachHangServiceImpl.getAllKH();
            showData(listKhachHangs);
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
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser dateNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoKH;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtQuocGia;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenDemKH;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtThanhPho;
    // End of variables declaration//GEN-END:variables
}
