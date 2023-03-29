/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

/**
 *
 * @author Duongntt
 */
public class MauSacViewModel {

    private String maMau;
    private String tenMau;

    public MauSacViewModel() {
    }

    public MauSacViewModel(String maMau, String tenMau) {
        this.maMau = maMau;
        this.tenMau = tenMau;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public Object[] toDataRow() {
        return new Object[]{maMau, tenMau};
    }
}
