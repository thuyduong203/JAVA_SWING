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
public class NhanVien {

    private String idNV;
    private String maNV;
    private String tenNV;
    private String tenDemNV;
    private String hoNV;
    private String gioiTinhNV;
    private Date ngaySinhNV;
    private String diaChiNV;
    private String sdtNV;
    private String matKhauNV;
    private CuaHang cuaHang;
    private ChucVu chucVu;
    private NhanVien nguoiGuiBC;
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(String idNV, String maNV, String tenNV, String tenDemNV, String hoNV, String gioiTinhNV, Date ngaySinhNV, String diaChiNV, String sdtNV, String matKhauNV, CuaHang cuaHang, ChucVu chucVu, NhanVien nguoiGuiBC, int trangThai) {
        this.idNV = idNV;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tenDemNV = tenDemNV;
        this.hoNV = hoNV;
        this.gioiTinhNV = gioiTinhNV;
        this.ngaySinhNV = ngaySinhNV;
        this.diaChiNV = diaChiNV;
        this.sdtNV = sdtNV;
        this.matKhauNV = matKhauNV;
        this.cuaHang = cuaHang;
        this.chucVu = chucVu;
        this.nguoiGuiBC = nguoiGuiBC;
        this.trangThai = trangThai;
    }

    public NhanVien(String idNV) {
        this.idNV = idNV;
    }

    public NhanVien(String idNV, String maNV) {
        this.idNV = idNV;
        this.maNV = maNV;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
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

    public String getTenDemNV() {
        return tenDemNV;
    }

    public void setTenDemNV(String tenDemNV) {
        this.tenDemNV = tenDemNV;
    }

    public String getHoNV() {
        return hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public String getGioiTinhNV() {
        return gioiTinhNV;
    }

    public void setGioiTinhNV(String gioiTinhNV) {
        this.gioiTinhNV = gioiTinhNV;
    }

    public Date getNgaySinhNV() {
        return ngaySinhNV;
    }

    public void setNgaySinhNV(Date ngaySinhNV) {
        this.ngaySinhNV = ngaySinhNV;
    }

    public String getDiaChiNV() {
        return diaChiNV;
    }

    public void setDiaChiNV(String diaChiNV) {
        this.diaChiNV = diaChiNV;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }

    public String getMatKhauNV() {
        return matKhauNV;
    }

    public void setMatKhauNV(String matKhauNV) {
        this.matKhauNV = matKhauNV;
    }

    public CuaHang getCuaHang() {
        return cuaHang;
    }

    public void setCuaHang(CuaHang cuaHang) {
        this.cuaHang = cuaHang;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public NhanVien getNguoiGuiBC() {
        return nguoiGuiBC;
    }

    public void setNguoiGuiBC(NhanVien nguoiGuiBC) {
        this.nguoiGuiBC = nguoiGuiBC;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "idNV=" + idNV + ", maNV=" + maNV + ", tenNV=" + tenNV + ", tenDemNV=" + tenDemNV + ", hoNV=" + hoNV + ", gioiTinhNV=" + gioiTinhNV + ", ngaySinhNV=" + ngaySinhNV + ", diaChiNV=" + diaChiNV + ", sdtNV=" + sdtNV + ", matKhauNV=" + matKhauNV + ", cuaHang=" + cuaHang + ", chucVu=" + chucVu + ", nguoiGuiBC=" + nguoiGuiBC + ", trangThai=" + trangThai + '}';
    }

}
