/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.sql.Date;

/**
 *
 * @author Duongntt
 */
public class HoaDonViewModel {

    private String idHD;
    private String idKH;
    private String idNV;
    private String maHD;
    private Date ngayTao;
    private Date ngayTT;
    private Date ngayShip;
    private Date ngayNhan;
    private String tenNN;
    private String diaChi;
    private String sdt;
    private int trangThai;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String idHD, String idKH, String idNV, String maHD, Date ngayTao, Date ngayTT, Date ngayShip, Date ngayNhan, String tenNN, String diaChi, String sdt, int trangThai) {
        this.idHD = idHD;
        this.idKH = idKH;
        this.idNV = idNV;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.ngayTT = ngayTT;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tenNN = tenNN;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayTT() {
        return ngayTT;
    }

    public void setNgayTT(Date ngayTT) {
        this.ngayTT = ngayTT;
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

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String trangThaiHD(int trangThai) {
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

    public Object[] todataRow() {
        return new Object[]{idHD, idKH, idNV, maHD, ngayTao, ngayTT, ngayShip, ngayNhan, tenNN, diaChi, sdt, trangThaiHD(trangThai)};
    }

}
