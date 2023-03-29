/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import domainModel.ChiTietSP;
import domainModel.HoaDon;
import domainModel.KhachHang;
import domainModel.NhanVien;
import java.sql.Date;
import java.text.SimpleDateFormat;
import service.BanHangService;
import viewModel.FrmHDCT;
import service.impl.NhanVienServiceImpl;

/**
 *
 * @author Duongntt
 */
public class BanHangServiceImpl implements BanHangService {

//    private NhanVienServiceImpl nhanVienServiceImpl = new NhanVienServiceImpl();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void fill(int trangThai) {
        if (trangThai == 2) {

        }
    }

    @Override
    public FrmHDCT getFrmHDCT(ChiTietSP chiTietSP, String soLuong) {
        if (checkSoLuong(chiTietSP, soLuong)) {
            return new FrmHDCT(chiTietSP.getIdCTSP(), chiTietSP.getSanPham().getMaSP(),
                    chiTietSP.getSanPham().getTenSP(), Integer.valueOf(soLuong), chiTietSP.getGiaBan());
        } else {
            return null;
        }
    }

    @Override
    public BigDecimal tinhTongTien(List<FrmHDCT> listFrmHDCT) {
        long tongTien = 0;
        Double thanhTien;
        int sz = listFrmHDCT.size();
        for (int i = 0; i < sz; i++) {
            FrmHDCT frmHDCT = listFrmHDCT.get(i);
            Double soLuong = Double.valueOf(frmHDCT.getSoLuong());
            Double donGia = Double.valueOf(String.valueOf(frmHDCT.getDonGia()));
            thanhTien = (donGia * soLuong);
            tongTien += thanhTien;
        }
        return BigDecimal.valueOf(tongTien);
    }

    @Override
    public HoaDon hoaDonUpdate(HoaDon hoaDon, String maNV) {
        HoaDon hoaDonUpdate = new HoaDon();
        KhachHang khachHang = new KhachHang();
        hoaDonUpdate.setKhachHang(khachHang);
        hoaDonUpdate.setMaHoaDon(hoaDon.getMaHoaDon());
        hoaDonUpdate.setNgayTao(hoaDon.getNgayTao());
        if (maNV == null || maNV.isEmpty()) {
            NhanVien nhanVien = new NhanVien();
            hoaDonUpdate.setNhanVien(nhanVien);
        } else {
            NhanVien nhanVien = new NhanVienServiceImpl().getOneNVByMa(maNV);
            hoaDonUpdate.setNhanVien(nhanVien);
        }
        hoaDonUpdate.setTinhTrangHD(1);

        return hoaDonUpdate;
    }
//hàm đang dùng
//
//    @Override
//    public String maHDTuSinh() {
//        Random generator = new Random();
//        return "HD" + generator.nextInt();
//    }

    public String taoMaHDTuSinh(List<HoaDon> listHD) {
        int sz = listHD.size();
        String maHD = "";
        maHD = "HD" + (sz + 1);
        do {
            if (new HoaDonServiceImpl().getOne(maHD) != null) {
                maHD = "HD" + (sz + 1 + 1);
            }
        } while (new HoaDonServiceImpl().getOne(maHD) != null);
        return maHD;
    }

    @Override
    public boolean checkSoLuong(ChiTietSP chiTietSP, String soLuong) {
        boolean checkSL = false;
        if (soLuong == null) {
//            JOptionPane.showMessageDialog(null, "??");
            checkSL = false;
        } else if (soLuong.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "??");
            checkSL = false;
        } else if (!soLuong.matches("[0-9]+") || Integer.valueOf(soLuong) == 0) {
            JOptionPane.showMessageDialog(null, "??");
            checkSL = false;
        } else if (Integer.valueOf(soLuong) > chiTietSP.getSoLuongTon()) {
            JOptionPane.showMessageDialog(null, "Số lượng gì z?");
            checkSL = false;
        } else {
            checkSL = true;
        }
        return checkSL;
    }

    @Override
    public HoaDon CreateHDAuto(List<HoaDon> listHD) {
        java.util.Date date = new java.util.Date();
        Date ngayTao = (Date.valueOf(dateFormat.format(date)));
        KhachHang kh = new KhachHang();
        NhanVien nv = new NhanVien();
        //mã HD đang dùng
        // String maHD = banHangServiceImpl.maHDTuSinh();
        //fix
        listHD = new HoaDonServiceImpl().getAllHDKoJoin();
        String maHD = taoMaHDTuSinh(listHD);
        HoaDon hoaDon = new HoaDon(kh, nv, maHD, ngayTao, 2);
        return hoaDon;
    }

    @Override
    public void tinhTienThua(String tienKhachDua, String tongTien, JTextField txtTienThua) {
        double tienKhachDua1 = Double.valueOf(tienKhachDua);
        double tongTien1 = Double.valueOf(tongTien);
        if (tienKhachDua1 < tongTien1) {
            JOptionPane.showMessageDialog(null, "Tiền khách đưa nhỏ hơn tổng tiền cần thanh toán!");
        } else {
            double tienThua = tienKhachDua1 - tongTien1;
            txtTienThua.setText(String.valueOf(tienThua));
        }
    }

}
