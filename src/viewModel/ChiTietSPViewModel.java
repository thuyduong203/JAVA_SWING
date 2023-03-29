/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import domainModel.MauSac;
import java.math.BigDecimal;

/**
 *
 * @author Duongntt
 */
public class ChiTietSPViewModel {

    private String idCTSP;
    private String tenSP;
    private String tenNSX;
    private String tenMauSac;
    private String tenDongSP;
    private int namBH;
    private String moTa;
    private int slTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;

    public ChiTietSPViewModel() {
    }

    public ChiTietSPViewModel(String idCTSP, String tenSP, String tenNSX, String tenMauSac, String tenDongSP, int namBH, String moTa, int slTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.idCTSP = idCTSP;
        this.tenSP = tenSP;
        this.tenNSX = tenNSX;
        this.tenMauSac = tenMauSac;
        this.tenDongSP = tenDongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.slTon = slTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getTenDongSP() {
        return tenDongSP;
    }

    public void setTenDongSP(String tenDongSP) {
        this.tenDongSP = tenDongSP;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSlTon() {
        return slTon;
    }

    public void setSlTon(int slTon) {
        this.slTon = slTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public Object[] toDataRow() {
        return new Object[]{idCTSP, tenSP, tenNSX, tenMauSac, tenDongSP, namBH, moTa, slTon, giaNhap, giaBan};
    }
}
