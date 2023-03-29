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
public class KhachHang {

    private String idKH;
    private String maKH;
    private String tenKH;
    private String tenDemKH;
    private String hoKH;
    private Date ngaySinhKH;
    private String sdtKH;
    private String diaChiKH;
    private String thanhPhoKH;
    private String quocGiaKH;
    private String matKhau;

    public KhachHang() {
    }

    public KhachHang(String idKH, String maKH, String tenKH, String tenDemKH, String hoKH, Date ngaySinhKH, String sdtKH, String diaChiKH, String thanhPhoKH, String quocGiaKH, String matKhau) {
        this.idKH = idKH;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.tenDemKH = tenDemKH;
        this.hoKH = hoKH;
        this.ngaySinhKH = ngaySinhKH;
        this.sdtKH = sdtKH;
        this.diaChiKH = diaChiKH;
        this.thanhPhoKH = thanhPhoKH;
        this.quocGiaKH = quocGiaKH;
        this.matKhau = matKhau;
    }

    public KhachHang(String idKH, String maKH) {
        this.idKH = idKH;
        this.maKH = maKH;
    }

    public String getIdKH() {
        return idKH;
    }

    public KhachHang(String idKH) {
        this.idKH = idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
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

    public String getTenDemKH() {
        return tenDemKH;
    }

    public void setTenDemKH(String tenDemKH) {
        this.tenDemKH = tenDemKH;
    }

    public String getHoKH() {
        return hoKH;
    }

    public void setHoKH(String hoKH) {
        this.hoKH = hoKH;
    }

    public Date getNgaySinhKH() {
        return ngaySinhKH;
    }

    public void setNgaySinhKH(Date ngaySinhKH) {
        this.ngaySinhKH = ngaySinhKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public String getThanhPhoKH() {
        return thanhPhoKH;
    }

    public void setThanhPhoKH(String thanhPhoKH) {
        this.thanhPhoKH = thanhPhoKH;
    }

    public String getQuocGiaKH() {
        return quocGiaKH;
    }

    public void setQuocGiaKH(String quocGiaKH) {
        this.quocGiaKH = quocGiaKH;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "idKH=" + idKH + ", maKH=" + maKH + ", tenKH=" + tenKH + ", tenDemKH=" + tenDemKH + ", hoKH=" + hoKH + ", ngaySinhKH=" + ngaySinhKH + ", sdtKH=" + sdtKH + ", diaChiKH=" + diaChiKH + ", thanhPhoKH=" + thanhPhoKH + ", quocGiaKH=" + quocGiaKH + ", matKhau=" + matKhau + '}';
    }

}
