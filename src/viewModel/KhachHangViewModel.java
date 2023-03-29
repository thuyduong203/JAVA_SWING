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
public class KhachHangViewModel {

    private String maKH;
    private String tenKH;
    private String tenDem;
    private String hoKH;
    private Date ngaySinh;
    private String sdt;
    private String diaChi;

    public KhachHangViewModel() {
    }

    public KhachHangViewModel(String maKH, String tenKH, String tenDem, String hoKH, Date ngaySinh, String sdt, String diaChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.tenDem = tenDem;
        this.hoKH = hoKH;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getHoKH() {
        return hoKH;
    }

    public void setHoKH(String hoKH) {
        this.hoKH = hoKH;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Object[] toDataRow() {
        return new Object[]{maKH, (hoKH + " " + tenDem + " " + tenKH), ngaySinh, sdt, diaChi};
    }
}
