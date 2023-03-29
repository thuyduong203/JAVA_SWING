/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 *
 * @author Admin
 */
public class CuaHang {

    private String idCH;
    private String maCH;
    private String TenCH;
    private String diaChi;
    private String ThanhPho;
    private String QuocGia;

    public CuaHang() {
    }

    public CuaHang(String idCH, String maCH, String TenCH, String diaChi, String ThanhPho, String QuocGia) {
        this.idCH = idCH;
        this.maCH = maCH;
        this.TenCH = TenCH;
        this.diaChi = diaChi;
        this.ThanhPho = ThanhPho;
        this.QuocGia = QuocGia;
    }

    public CuaHang(String idCH) {
        this.idCH = idCH;
    }

    public String getIdCH() {
        return idCH;
    }

    public CuaHang(String idCH, String TenCH) {
        this.idCH = idCH;
        this.TenCH = TenCH;
    }

    public void setIdCH(String idCH) {
        this.idCH = idCH;
    }

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public String getTenCH() {
        return TenCH;
    }

    public void setTenCH(String TenCH) {
        this.TenCH = TenCH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(String ThanhPho) {
        this.ThanhPho = ThanhPho;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String QuocGia) {
        this.QuocGia = QuocGia;
    }

    @Override
    public String toString() {
        return "CuaHang{" + "idCH=" + idCH + ", maCH=" + maCH + ", TenCH=" + TenCH + ", diaChi=" + diaChi + ", ThanhPho=" + ThanhPho + ", QuocGia=" + QuocGia + '}';
    }

//    public Object[] toDataRow() {
//        return new Object[]{maCH, TenCH, diaChi, ThanhPho, QuocGia};
//    }
}
