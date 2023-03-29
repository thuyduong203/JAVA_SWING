/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import domainModel.ChiTietSP;
import domainModel.HoaDon;
import domainModel.HoaDonChiTiet;
import service.impl.ChiTietSPServiceImpl;
import service.impl.HoaDonChiTietImpl;
import service.impl.HoaDonServiceImpl;
import javax.swing.JOptionPane;
import domainModel.NhanVien;
import service.impl.BanHangServiceImpl;
import service.impl.NhanVienServiceImpl;
import viewModel.FrmHDCT;
import viewModel.SanPhamViewBanHang;

/**
 *
 * @author Duongntt
 */
public class ViewBanHang extends javax.swing.JFrame {

    private DefaultTableModel dtmHoaDon = new DefaultTableModel();
    private DefaultTableModel dtmHDCT = new DefaultTableModel();
    private DefaultTableModel dtmSanPham = new DefaultTableModel();
    private DefaultComboBoxModel dcbmMaNV = new DefaultComboBoxModel();
    private List<HoaDon> listHD = new ArrayList<>();
    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    private List<ChiTietSP> listCTSP = new ArrayList<>();
    private HoaDonServiceImpl hoaDonServiceImpl = new HoaDonServiceImpl();
    private HoaDonChiTietImpl hoaDonChiTietImpl = new HoaDonChiTietImpl();
    private ChiTietSPServiceImpl chiTietSPServiceImpl = new ChiTietSPServiceImpl();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private List<FrmHDCT> lstFrmHDCTs = new ArrayList<>();
    private BanHangServiceImpl banHangServiceImpl = new BanHangServiceImpl();
    private List<NhanVien> listNV = new ArrayList<>();
    private NhanVienServiceImpl nhanVienServiceImpl = new NhanVienServiceImpl();

    public ViewBanHang() {
        initComponents();
        tblHDCT.setModel(dtmHDCT);
        tblHoaDon.setModel(dtmHoaDon);
        tblSanPham.setModel(dtmSanPham);
        cbbMaNV.setModel(dcbmMaNV);
        String headersHD[] = {"STT", "Mã HD", "Ngày Tạo", "Mã NV", "Trạng thái"};
        String headersHDCT[] = {"STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"};
        String headersSP[] = {"STT", "Mã SP", "Tên SP", "Năm BH", "Mô tả", "Số lượng SP", "Giá Nhập", "Giá Bán"};
        dtmHDCT.setColumnIdentifiers(headersHDCT);
        dtmHoaDon.setColumnIdentifiers(headersHD);
        dtmSanPham.setColumnIdentifiers(headersSP);
        rdoTatCa.setSelected(true);
        listCTSP = chiTietSPServiceImpl.getAllCTSP();
        showDataTblSP(listCTSP, 1);
        listHD = hoaDonServiceImpl.getAllHDKoJoin();
        showDataTblHD(listHD, 1);
        loadCbbNV();
        java.util.Date date = new java.util.Date();
        dateNgayTao.setDate(date);
        //
    }

    private void showDataTblHD(List<HoaDon> listHD, int stt) {
        dtmHoaDon.setRowCount(0);
        for (HoaDon hoaDon : listHD) {
            dtmHoaDon.addRow(hoaDon.toDataRowBanHang(stt));
            stt++;
        }
    }

    public void showDataTblHDCT(List<HoaDonChiTiet> listHDCT, int stt) {
        dtmHDCT.setRowCount(0);
        List<FrmHDCT> listHDCTViewBH = hoaDonChiTietImpl.convertObView(listHDCT);
        for (FrmHDCT hoaDonChiTietView : listHDCTViewBH) {
            dtmHDCT.addRow(hoaDonChiTietView.toDataRow(stt));
            stt++;
        }
    }

    private void showDataFormHDCT(List<FrmHDCT> lstFrmHDCTs, int stt) {
        dtmHDCT.setRowCount(0);
        for (FrmHDCT lstFrmHDCT : lstFrmHDCTs) {
            dtmHDCT.addRow(lstFrmHDCT.toDataRow(stt));
            stt++;
        }
    }

    public void showDataTblSP(List<ChiTietSP> listCTSP, int stt) {
        dtmSanPham.setRowCount(0);
        List<SanPhamViewBanHang> listSPViewBH = chiTietSPServiceImpl.convertObSanPhamBanHang(listCTSP);
        for (SanPhamViewBanHang sanPhamViewBanHang : listSPViewBH) {
            dtmSanPham.addRow(sanPhamViewBanHang.toDataRow(stt));
            stt++;
        }
    }

    private void clear() {
        txtMaHD.setText("");
        dateNgayTao.setDate(new java.util.Date());
        cbbMaNV.setSelectedIndex(0);
        txtTongTien.setText("");
        txtTienThua.setText("");
        txtTienKhachDua.setText("");
    }

    private void fill(int index, List<HoaDon> listHD) {
        HoaDon hoaDon = listHD.get(index);
        if (hoaDon.getTinhTrangHD() == 0 || hoaDon.getTinhTrangHD() == 1) {
            txtMaHD.setEnabled(false);
            txtMaHD.setText(hoaDon.getMaHoaDon());
            if (hoaDon.getNhanVien() != null) {
                cbbMaNV.setSelectedItem(hoaDon.getNhanVien().getMaNV());
            }
            cbbMaNV.setEnabled(false);
            dateNgayTao.setDate(hoaDon.getNgayTao());
            dateNgayTao.setEnabled(false);
            txtTienKhachDua.setEnabled(false);
            txtTienThua.setEnabled(false);
            btnThanhToan.setEnabled(false);
            BigDecimal tongTien = hoaDonServiceImpl.tongTien(hoaDon.getIdHoaDon());
            txtTongTien.setText(String.valueOf(tongTien));
        } else {
            txtMaHD.setEnabled(true);
            txtMaHD.setText(hoaDon.getMaHoaDon());
            if (hoaDon.getNhanVien() != null) {
                cbbMaNV.setSelectedItem(hoaDon.getNhanVien().getMaNV());
            } else {
                cbbMaNV.setSelectedIndex(0);
            }
            cbbMaNV.setEnabled(true);
            dateNgayTao.setDate(hoaDon.getNgayTao());
            dateNgayTao.setEnabled(true);
            txtTienKhachDua.setEnabled(true);
            txtTienThua.setEnabled(true);
            btnThanhToan.setEnabled(true);
            txtTongTien.setText("");
            BigDecimal tongTien = hoaDonServiceImpl.tongTien(hoaDon.getIdHoaDon());
            txtTongTien.setText(String.valueOf(tongTien));
        }
    }

    private void loadCbbNV() {
        listNV = nhanVienServiceImpl.getAllNV();
        dcbmMaNV.addElement("");
        for (NhanVien nhanVien : listNV) {
            dcbmMaNV.addElement(nhanVien.getMaNV());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoChoTT = new javax.swing.JRadioButton();
        rdoDaTT = new javax.swing.JRadioButton();
        rdoDaHuy = new javax.swing.JRadioButton();
        btnTaoHD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        txtTienKhachDua = new javax.swing.JTextField();
        txtMaHD = new javax.swing.JTextField();
        dateNgayTao = new com.toedter.calendar.JDateChooser();
        cbbMaNV = new javax.swing.JComboBox<>();
        txtTongTien = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoChoTT);
        rdoChoTT.setText("Chờ thanh toán");
        rdoChoTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChoTTActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDaTT);
        rdoDaTT.setText("Đã thanh toán");
        rdoDaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaTTActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDaHuy);
        rdoDaHuy.setText("Đã huỷ");
        rdoDaHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaHuyActionPerformed(evt);
            }
        });

        btnTaoHD.setText("Tạo Hoá Đơn");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoá Đơn Chi Tiết"));

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
        jScrollPane3.setViewportView(tblHDCT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoá Đơn"));

        jLabel1.setText("Mã HD:");

        jLabel2.setText("Ngày Tạo:");

        jLabel3.setText("Mã NV:");

        jLabel4.setText("Tổng tiền:");

        jLabel5.setText("Tiền khách đưa:");

        jLabel6.setText("Tiền thừa:");

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        cbbMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaHD)
                    .addComponent(dateNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(cbbMaNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTongTien)
                    .addComponent(txtTienKhachDua)
                    .addComponent(txtTienThua))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan)
                .addGap(56, 56, 56))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(dateNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(rdoTatCa)
                        .addGap(48, 48, 48)
                        .addComponent(rdoChoTT)
                        .addGap(53, 53, 53)
                        .addComponent(rdoDaTT)
                        .addGap(26, 26, 26)
                        .addComponent(rdoDaHuy)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoTatCa)
                    .addComponent(rdoChoTT)
                    .addComponent(rdoDaTT)
                    .addComponent(rdoDaHuy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaoHD)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed

        //TH mà chọn sp lên giỏ hàng trước rồi mới bấm tạo HD
        if (lstFrmHDCTs != null) {
            //tạo hd mới
            listHD = hoaDonServiceImpl.getAllHDKoJoin();
            HoaDon hoaDon = banHangServiceImpl.CreateHDAuto(listHD);
            String themHD = hoaDonServiceImpl.addHoaDon(hoaDon);
            //duyệt for giỏ hàng đã có
            //lấy hoaDonMoithem trong db
            HoaDon hoaDonMoiThem1 = hoaDonServiceImpl.getOne(hoaDon.getMaHoaDon());
            for (FrmHDCT lstFrmHDCT : lstFrmHDCTs) {
                //////lấy hoá đơn, ctsp để tạo mới hdct
                //Lần lượt lấy ctsp
                ChiTietSP chiTietSP = chiTietSPServiceImpl.getOne(lstFrmHDCT.getIdCTSP());
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(hoaDonMoiThem1, chiTietSP, lstFrmHDCT.getSoLuong(), lstFrmHDCT.getDonGia());
                //thêm hdct
                String themHDCT = hoaDonChiTietImpl.addHDCT(hoaDonChiTiet);
                //update số lượngn sp trong db
                int soLuongBanDau = chiTietSP.getSoLuongTon();
                chiTietSP.setSoLuongTon(chiTietSPServiceImpl.tinhSoLuongTon(soLuongBanDau, lstFrmHDCT.getSoLuong()));
                String updateCTSP = chiTietSPServiceImpl.addUpdateCTSP(chiTietSP, lstFrmHDCT.getIdCTSP()); //update day
            }
            //thêm xong delete list giỏ hàng đó
            lstFrmHDCTs.removeAll(lstFrmHDCTs);
            JOptionPane.showMessageDialog(this, themHD);
            listHD = hoaDonServiceImpl.getAllHDKoJoin();
            showDataTblHD(listHD, 1);
            rdoTatCa.setSelected(true);
            //TH giỏ hàng chưa chọn sp nào chỉ tạo 1 HD mới rỗng:
        } else {
            //tạo HD mới
            listHD = hoaDonServiceImpl.getAllHDKoJoin();
            HoaDon hoaDon = banHangServiceImpl.CreateHDAuto(listHD);
            JOptionPane.showMessageDialog(this, hoaDonServiceImpl.addHoaDon(hoaDon));
            listHD = hoaDonServiceImpl.getAllHDKoJoin();
            showDataTblHD(listHD, 1);
            rdoTatCa.setSelected(true);
        }
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        listHDCT.removeAll(listHDCT);
        int index = tblHoaDon.getSelectedRow();
        String maHD = listHD.get(index).getMaHoaDon();
        HoaDon hoaDonMouclick = hoaDonServiceImpl.getOne(maHD);
        String idHD = listHD.get(index).getIdHoaDon();
        listHDCT = hoaDonChiTietImpl.getHDCTByIdHD(idHD);
        showDataTblHDCT(listHDCT, 1);
        fill(index, listHD);
        if (hoaDonMouclick.getTinhTrangHD() == 2) {
            listHDCT = hoaDonChiTietImpl.getHDCTByIdHD(idHD);
            lstFrmHDCTs = hoaDonChiTietImpl.convertObView(listHDCT);
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void rdoChoTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChoTTActionPerformed
        listHD = hoaDonServiceImpl.getHDByTrangThai(2);
        showDataTblHD(listHD, 1);
    }//GEN-LAST:event_rdoChoTTActionPerformed

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        listHD = hoaDonServiceImpl.getAllHDKoJoin();
        showDataTblHD(listHD, 1);
        listCTSP = chiTietSPServiceImpl.getAllCTSP();
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void rdoDaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaTTActionPerformed
        listHD = hoaDonServiceImpl.getHDByTrangThai(1);
        showDataTblHD(listHD, 1);
    }//GEN-LAST:event_rdoDaTTActionPerformed

    private void rdoDaHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaHuyActionPerformed
        listHD = hoaDonServiceImpl.getHDByTrangThai(0);
        showDataTblHD(listHD, 1);
    }//GEN-LAST:event_rdoDaHuyActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int row = tblSanPham.getSelectedRow();
        ChiTietSP chiTietSP = listCTSP.get(row);
        String soLuong = JOptionPane.showInputDialog("Mời nhập số lượng: ");
        if (banHangServiceImpl.checkSoLuong(chiTietSP, soLuong)) {
            FrmHDCT frmHDCT = new FrmHDCT(chiTietSP.getIdCTSP(), chiTietSP.getSanPham().getMaSP(),
                    chiTietSP.getSanPham().getTenSP(), Integer.valueOf(soLuong), chiTietSP.getGiaBan());
            lstFrmHDCTs.add(frmHDCT);
            showDataFormHDCT(lstFrmHDCTs, 1);
            int soLuongConLai = chiTietSP.getSoLuongTon() - frmHDCT.getSoLuong();
            tblSanPham.setValueAt(soLuongConLai, row, 5);
            txtTongTien.setText(String.valueOf(banHangServiceImpl.tinhTongTien(lstFrmHDCTs)));
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        //laays hoas don hien tai
        HoaDon hoaDon = hoaDonServiceImpl.getOne(txtMaHD.getText());
        listHDCT = hoaDonChiTietImpl.getHDCTByIdHD(hoaDon.getIdHoaDon());
        for (HoaDonChiTiet hoaDonChiTiet : listHDCT) {
            ChiTietSP ctsp = chiTietSPServiceImpl.getOne(hoaDonChiTiet.getChiTietSP().getIdCTSP());
            int soluongSP = ctsp.getSoLuongTon() + hoaDonChiTiet.getSoLuong();
            ctsp.setSoLuongTon(soluongSP);
            String updateCTSP = chiTietSPServiceImpl.addUpdateCTSP(ctsp, hoaDonChiTiet.getChiTietSP().getIdCTSP()); //update day 
            String deleteHDCT = hoaDonChiTietImpl.deleteHDCTByIdHD(hoaDon.getIdHoaDon());
        }
        if (hoaDon != null) {
            for (int i = 0; i < lstFrmHDCTs.size(); i++) {
                //lấy chi tiết sp theo từng hoá đơn chi tiết tạm htoiw
                FrmHDCT lstFrmHDCT = lstFrmHDCTs.get(i);
                ChiTietSP chiTietSP = chiTietSPServiceImpl.getOne(lstFrmHDCT.getIdCTSP());
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(hoaDon, chiTietSP, lstFrmHDCT.getSoLuong(), lstFrmHDCT.getDonGia());
                //thêm hdct vào db (sau khi ktra số lượng)
                String themHDCT = hoaDonChiTietImpl.addHDCT(hoaDonChiTiet);
                //update số lượngn sp trong db
                int soLuongBanDau = chiTietSP.getSoLuongTon();
                chiTietSP.setSoLuongTon(chiTietSPServiceImpl.tinhSoLuongTon(soLuongBanDau, lstFrmHDCT.getSoLuong()));
                String updateCTSP = chiTietSPServiceImpl.addUpdateCTSP(chiTietSP, lstFrmHDCT.getIdCTSP()); //update day 
                //lstFrmHDCTs.remove(lstFrmHDCT);
            }
            lstFrmHDCTs.removeAll(lstFrmHDCTs);
            //update HD:
            if (hoaDonServiceImpl.tongTien(hoaDon.getIdHoaDon()) != null) {
                HoaDon hoaDonUpdate = banHangServiceImpl.hoaDonUpdate(hoaDon, cbbMaNV.getSelectedItem().toString());
                String updateHD = hoaDonServiceImpl.updateHoaDon(hoaDonUpdate, hoaDon.getIdHoaDon());
                listHD = hoaDonServiceImpl.getAllHDKoJoin();
                showDataTblHD(listHD, 1);
                listCTSP = chiTietSPServiceImpl.getAllCTSP();
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                showDataTblSP(listCTSP, 1);
            } else {
                JOptionPane.showMessageDialog(this, "??");
            }
        }

//

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        String tenSearch = txtTimKiem.getText();
        listCTSP = chiTietSPServiceImpl.searchCTSPByTenSP(tenSearch);
        showDataTblSP(listCTSP, 1);
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        banHangServiceImpl.tinhTienThua(txtTienKhachDua.getText(), txtTongTien.getText(), txtTienThua);

    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        for (int i = 0; i < lstFrmHDCTs.size(); i++) {
            lstFrmHDCTs.remove(i);
        }
        //lstFrmHDCTs.remove(lstFrmHDCTs);
        dtmHDCT.setRowCount(0);
        txtMaHD.setText("");
        txtTienKhachDua.setText("");
        txtTongTien.setText("");
        txtTienThua.setText("");
        listCTSP = chiTietSPServiceImpl.getAllCTSP();
        showDataTblSP(listCTSP, 1);
        listHD = hoaDonServiceImpl.getAllHDKoJoin();
        showDataTblHD(listHD, 1);
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void tblSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamMouseEntered

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
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbMaNV;
    private com.toedter.calendar.JDateChooser dateNgayTao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdoChoTT;
    private javax.swing.JRadioButton rdoDaHuy;
    private javax.swing.JRadioButton rdoDaTT;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

}
