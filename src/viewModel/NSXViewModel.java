/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

/**
 *
 * @author Duongntt
 */
public class NSXViewModel {

    private String maNSX;
    private String tenNSX;

    public NSXViewModel(String maNSX, String tenNSX) {
        this.maNSX = maNSX;
        this.tenNSX = tenNSX;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public Object[] todataRow() {
        return new Object[]{maNSX, tenNSX};
    }
}
