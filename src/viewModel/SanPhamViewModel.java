/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

/**
 *
 * @author Duongntt
 */
public class SanPhamViewModel {

    private String maSP;
    private String tenSP;

    public SanPhamViewModel(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public SanPhamViewModel() {
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

    public Object[] toDataRow() {
        return new Object[]{maSP, tenSP};
    }
}
