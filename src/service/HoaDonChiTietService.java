/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.math.BigDecimal;
import java.util.List;
import domainModel.HoaDonChiTiet;

/**
 *
 * @author Duongntt
 */
public interface HoaDonChiTietService {

    List<HoaDonChiTiet> getAllHD();

    String addHDCT(HoaDonChiTiet hoaDonChiTiet);

    String deleteHDCTByIdHD(String idHD);

    String deleteHDCTByIdCTSP(String idCTSP);

    String deleteHDCTByIdCTSP2(String idDongSP);

    String deleteHDCT(String idHD, String idCTSP);

    String updateHDCT(HoaDonChiTiet hdct, String idHD, String idCTSP);

    String deleteHDCTbyIdKH(String idKH);

    String deleteHdctByMauSac(String idMauSac);

    String deleteHdctByNSX(String idNSX);

    String deleteHdctBySanPham(String idSP);

    List<HoaDonChiTiet> getHDCTByIdHD(String idHD);

    BigDecimal tongThanhTienHD(String idHD);

    List<HoaDonChiTiet> getListHDCTViewBanHang(String idHoaDon);

    HoaDonChiTiet getOne(String idCTSP, String idHD);

}
