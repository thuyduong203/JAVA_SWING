/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.sql.Date;
import service.impl.NhanVienServiceImpl;

/**
 *
 * @author Admin
 */
public class HoaDon {

    private String idHoaDon;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private String maHoaDon;
    private Date ngayTao;
    private Date ngayThanhToan;
    private Date ngayShip;
    private Date ngayNhan;
    private int tinhTrangHD;
    private String tenNguoiNhan;
    private String diaChiNguoiNhan;
    private String sdtNguoiNhan;

    public HoaDon() {
    }

    public HoaDon(KhachHang khachHang, NhanVien nhanVien, String maHoaDon, Date ngayTao, int tinhTrangHD) {
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.tinhTrangHD = tinhTrangHD;
    }

    public HoaDon(String idHoaDon, KhachHang khachHang, NhanVien nhanVien, String maHoaDon, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int tinhTrangHD, String tenNguoiNhan, String diaChiNguoiNhan, String sdtNguoiNhan) {
        this.idHoaDon = idHoaDon;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrangHD = tinhTrangHD;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChiNguoiNhan = diaChiNguoiNhan;
        this.sdtNguoiNhan = sdtNguoiNhan;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Date getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(Date ngayShip) {
        this.ngayShip = ngayShip;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public int getTinhTrangHD() {
        return tinhTrangHD;
    }

    public void setTinhTrangHD(int tinhTrangHD) {
        this.tinhTrangHD = tinhTrangHD;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChiNguoiNhan() {
        return diaChiNguoiNhan;
    }

    public void setDiaChiNguoiNhan(String diaChiNguoiNhan) {
        this.diaChiNguoiNhan = diaChiNguoiNhan;
    }

    public String getSdtNguoiNhan() {
        return sdtNguoiNhan;
    }

    public void setSdtNguoiNhan(String sdtNguoiNhan) {
        this.sdtNguoiNhan = sdtNguoiNhan;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "idHoaDon=" + idHoaDon + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", maHoaDon=" + maHoaDon + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", ngayShip=" + ngayShip + ", ngayNhan=" + ngayNhan + ", tinhTrangHD=" + tinhTrangHD + ", tenNguoiNhan=" + tenNguoiNhan + ", diaChiNguoiNhan=" + diaChiNguoiNhan + ", sdtNguoiNhan=" + sdtNguoiNhan + '}';
    }

    public String trangThaoHD(int trangThai) {
        if (trangThai == 1) {
            return "Đã thanh toán";
        } else if (trangThai == 2) {
            return "Chờ thanh toán";
        } else if (trangThai == 0) {
            return "Đã huỷ";
        } else {
            return "??";
        }
    }

//    public Object[] todataRow() {
//        return new Object[]{idHoaDon, khachHang.getIdKH(), nhanVien.getIdNV(), maHoaDon, ngayTao, ngayThanhToan, ngayNhan, ngayShip, tenNguoiNhan, diaChiNguoiNhan, sdtNguoiNhan, trangThaoHD(tinhTrangHD)};
//    }

//    public NhanVien getNV(String idNV) {
//        return new NhanVienServiceImpl().getOneNV(nhanVien.getIdNV());
//    }

    public Object[] toDataRowBanHang(int stt) {
        return new Object[]{stt, maHoaDon, ngayTao, (nhanVien == null ? "" : nhanVien.getMaNV()), trangThaoHD(tinhTrangHD)};
    }
}
