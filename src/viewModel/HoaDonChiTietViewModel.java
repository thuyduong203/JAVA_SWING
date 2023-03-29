/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.math.BigDecimal;

/**
 *
 * @author Duongntt
 */
public class HoaDonChiTietViewModel {

    private String idHoaDon;
    private String idCTSP;
    private int soLuong;
    private BigDecimal donGia;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(String idHoaDon, String idCTSP, int soLuong, BigDecimal donGia) {
        this.idHoaDon = idHoaDon;
        this.idCTSP = idCTSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
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

    public Object[] toDataRow() {
        return new Object[]{idHoaDon, idCTSP, soLuong, donGia};
    }
}
