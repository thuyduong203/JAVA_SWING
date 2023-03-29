/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 *
 * @author Admin
 */
public class DongSP {

    private String IdDongSP;
    private String maDongSP;
    private String tenDongSP;

    public DongSP() {
    }

    public DongSP(String IdDongSP, String maDongSP, String tenDongSP) {
        this.IdDongSP = IdDongSP;
        this.maDongSP = maDongSP;
        this.tenDongSP = tenDongSP;
    }

    public DongSP(String IdDongSP, String tenDongSP) {
        this.IdDongSP = IdDongSP;
        this.tenDongSP = tenDongSP;
    }

    public DongSP(String IdDongSP) {
        this.IdDongSP = IdDongSP;
    }

    public String getIdDongSP() {
        return IdDongSP;
    }

    public void setIdDongSP(String IdDongSP) {
        this.IdDongSP = IdDongSP;
    }

    public String getMaDongSP() {
        return maDongSP;
    }

    public void setMaDongSP(String maDongSP) {
        this.maDongSP = maDongSP;
    }

    public String getTenDongSP() {
        return tenDongSP;
    }

    public void setTenDongSP(String tenDongSP) {
        this.tenDongSP = tenDongSP;
    }

    @Override
    public String toString() {
        return "DongSP{" + "IdDongSP=" + IdDongSP + ", maDongSP=" + maDongSP + ", tenDongSP=" + tenDongSP + '}';
    }

}
