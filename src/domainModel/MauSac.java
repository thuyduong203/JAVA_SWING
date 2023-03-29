/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 *
 * @author Admin
 */
public class MauSac {

    private String idMauSac;
    private String maMauSac;
    private String tenMauSac;

    public MauSac() {
    }

    public MauSac(String idMauSac, String maMauSac, String tenMauSac) {
        this.idMauSac = idMauSac;
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
    }

    public MauSac(String idMauSac, String tenMauSac) {
        this.idMauSac = idMauSac;
        this.tenMauSac = tenMauSac;
    }

    public MauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    @Override
    public String toString() {
        return "MauSac{" + "idMauSac=" + idMauSac + ", maMauSac=" + maMauSac + ", tenMauSac=" + tenMauSac + '}';
    }

}
