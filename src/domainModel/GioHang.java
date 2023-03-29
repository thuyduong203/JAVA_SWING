/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class GioHang {

    private String idGioHang;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private String maGioHang;
    private Date ngayTao;
    private Date ngayThanhToan;
    private String tenNguoiNhan;
    private String diaChiNN;
    private String soDienThoaiNN;
    private int tinhTrang;

    public GioHang() {
    }

    public GioHang(String idGioHang, KhachHang khachHang, NhanVien nhanVien, String maGioHang, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan, String diaChiNN, String soDienThoaiNN, int tinhTrang) {
        this.idGioHang = idGioHang;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.maGioHang = maGioHang;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChiNN = diaChiNN;
        this.soDienThoaiNN = soDienThoaiNN;
        this.tinhTrang = tinhTrang;
    }

    public GioHang(String idGioHang) {
        this.idGioHang = idGioHang;
    }

    public String getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        this.idGioHang = idGioHang;
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

    public String getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(String maGioHang) {
        this.maGioHang = maGioHang;
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

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChiNN() {
        return diaChiNN;
    }

    public void setDiaChiNN(String diaChiNN) {
        this.diaChiNN = diaChiNN;
    }

    public String getSoDienThoaiNN() {
        return soDienThoaiNN;
    }

    public void setSoDienThoaiNN(String soDienThoaiNN) {
        this.soDienThoaiNN = soDienThoaiNN;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "GioHang{" + "idGioHang=" + idGioHang + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", maGioHang=" + maGioHang + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", tenNguoiNhan=" + tenNguoiNhan + ", diaChiNN=" + diaChiNN + ", soDienThoaiNN=" + soDienThoaiNN + ", tinhTrang=" + tinhTrang + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{idGioHang, khachHang.getIdKH(), nhanVien.getIdNV(), maGioHang, ngayTao, ngayThanhToan, tenNguoiNhan, diaChiNN, soDienThoaiNN, tinhTrang};
    }
}
