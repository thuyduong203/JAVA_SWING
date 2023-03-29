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
public class NhanVienViewModel {

    private String maNV;
    private String tenNV;
    private String tenDem;
    private String hoNV;
    private String gioiTinh;
    private String sdt;
    private String matKhau;
    private String tenCH;
    private String tenCV;
    private String maNguoiGuiBC;
    private int trangThai;
    private Date ngaySinh;
    private String diaChi;

    public NhanVienViewModel() {
    }

    public NhanVienViewModel(String maNV, String tenNV, String tenDem, String hoNV, String gioiTinh, String sdt, String matKhau, String tenCH, String tenCV, String maNguoiGuiBC, int trangThai, Date ngaySinh, String diaChi) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tenDem = tenDem;
        this.hoNV = hoNV;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.tenCH = tenCH;
        this.tenCV = tenCV;
        this.maNguoiGuiBC = maNguoiGuiBC;
        this.trangThai = trangThai;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getHoNV() {
        return hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenCH() {
        return tenCH;
    }

    public void setTenCH(String tenCH) {
        this.tenCH = tenCH;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getMaNguoiGuiBC() {
        return maNguoiGuiBC;
    }

    public void setMaNguoiGuiBC(String maNguoiGuiBC) {
        this.maNguoiGuiBC = maNguoiGuiBC;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "NhanVienViewModel{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", matKhau=" + matKhau + ", tenCH=" + tenCH + ", tenCV=" + tenCV + ", maNguoiGuiBC=" + maNguoiGuiBC + ", ngaySinh=" + ngaySinh + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{maNV, (hoNV + " " + tenDem + " " + tenNV), tenCH, tenCV, maNguoiGuiBC, ngaySinh};
    }
}
