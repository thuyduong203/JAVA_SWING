/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.math.BigDecimal;
import domainModel.HoaDonChiTiet;

/**
 *
 * @author Duongntt
 */
public class FrmHDCT {

    private String idCTSP;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private BigDecimal donGia;

    public FrmHDCT() {
    }

    public FrmHDCT(String idCTSP, String maSP, String tenSP, int soLuong, BigDecimal donGia) {
        this.idCTSP = idCTSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
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

    public Object[] toDataRow(int stt) {
        return new Object[]{stt, maSP, tenSP, soLuong, donGia, thanhTien(soLuong, donGia)};
    }

    private BigDecimal thanhTien(int soLuong, BigDecimal donGia) {
        String donGia2 = String.valueOf(donGia);
        Double thanhTien = soLuong * Double.valueOf(donGia2);
        return BigDecimal.valueOf(thanhTien);
    }

}
