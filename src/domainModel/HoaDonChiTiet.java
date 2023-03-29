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
public class HoaDonChiTiet {

    private HoaDon hoaDon;
    private ChiTietSP chiTietSP;
    private int soLuong;
    private BigDecimal donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(HoaDon hoaDon, ChiTietSP chiTietSP, int soLuong, BigDecimal donGia) {
        this.hoaDon = hoaDon;
        this.chiTietSP = chiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
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

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "hoaDon=" + hoaDon + ", chiTietSP=" + chiTietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

    public Object[] toDataRowBanHang(int stt) {
        return new Object[]{stt, chiTietSP.getSanPham().getMaSP(), chiTietSP.getSanPham().getTenSP(), soLuong, donGia, (donGia.doubleValue() * soLuong)};
    }
}
