/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.math.BigDecimal;
import java.util.List;
import javax.swing.JTextField;
import domainModel.ChiTietSP;
import domainModel.HoaDon;
import viewModel.FrmHDCT;

/**
 *
 * @author Duongntt
 */
public interface BanHangService {

    void fill(int trangThai);

    FrmHDCT getFrmHDCT(ChiTietSP chiTietSP, String soLuong);

    BigDecimal tinhTongTien(List<FrmHDCT> listFrmHDCT);

    HoaDon hoaDonUpdate(HoaDon hoaDon, String maNV);

    String taoMaHDTuSinh(List<HoaDon> listHD);

    boolean checkSoLuong(ChiTietSP chiTietSP, String soLuong);
//truyền list vào để có list check mã

    HoaDon CreateHDAuto(List<HoaDon> listHD);

    void tinhTienThua(String tienKhachDua, String tongTien, JTextField tienThua);
}
