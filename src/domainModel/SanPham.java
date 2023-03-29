/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 *
 * @author Admin
 */
public class SanPham {

    private String idSP;
    private String maSP;
    private String tenSP;

    public SanPham() {
    }

    public SanPham(String idSP, String maSP, String tenSP) {
        this.idSP = idSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public SanPham(String idSP, String tenSP) {
        this.idSP = idSP;
        this.tenSP = tenSP;
    }

    public SanPham(String idSP) {
        this.idSP = idSP;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
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

    @Override
    public String toString() {
        return "SanPham{" + "idSP=" + idSP + ", maSP=" + maSP + ", tenSP=" + tenSP + '}';
    }

}
