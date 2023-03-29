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
public class ChiTietSP {

    private String idCTSP;
    private SanPham sanPham;
    private NSX nsx;
    private MauSac mauSac;
    private DongSP dongSP;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(String idCTSP, SanPham sanPham, NSX nsx, MauSac mauSac, DongSP dongSP, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.idCTSP = idCTSP;
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public NSX getNsx() {
        return nsx;
    }

    public void setNsx(NSX nsx) {
        this.nsx = nsx;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public DongSP getDongSP() {
        return dongSP;
    }

    public void setDongSP(DongSP dongSP) {
        this.dongSP = dongSP;
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

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
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

    @Override
    public String toString() {
        return "ChiTietSP{" + "idCTSP=" + idCTSP + ", sanPham=" + sanPham + ", nsx=" + nsx + ", mauSac=" + mauSac + ", dongSP=" + dongSP + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }

}
