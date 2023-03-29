/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class GioHangChiTiet {

    private GioHang gioHang;
    private ChiTietSP chiTietSP;
    private int soLuong;
    private BigDecimal donGia;
    private BigDecimal donGiaKhiGiam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(GioHang gioHang, ChiTietSP chiTietSP, int soLuong, BigDecimal donGia, BigDecimal donGiaKhiGiam) {
        this.gioHang = gioHang;
        this.chiTietSP = chiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
    }

    public ChiTietSP getChiTietSP() {
        return chiTietSP;
    }

    public void setChiTietSP(ChiTietSP chiTietSP) {
        this.chiTietSP = chiTietSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(BigDecimal donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    @Override
    public String toString() {
        return "GioHangChiTiet{" + "gioHang=" + gioHang + ", chiTietSP=" + chiTietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", donGiaKhiGiam=" + donGiaKhiGiam + '}';
    }

    public Object[] todataRow() {
        return new Object[]{gioHang.getIdGioHang(), chiTietSP.getIdCTSP(), soLuong, donGia, donGiaKhiGiam};
    }
}
