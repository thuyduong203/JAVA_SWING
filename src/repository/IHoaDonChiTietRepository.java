/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.math.BigDecimal;
import java.util.List;
import domainModel.HoaDonChiTiet;

/**
 *
 * @author Duongntt
 */
public interface IHoaDonChiTietRepository {

    List<HoaDonChiTiet> getHDCTByIdHD(String idHD);

    boolean deleteHDCTByIdHD(String idHD);

    boolean deleteHDCT(String idHD, String idCTSP);

    boolean updateHDCT(HoaDonChiTiet hoaDonChiTiet, String idHD, String idCTSP);

    boolean deleteHdctByIdCTSP(String idChiTietSP);

    boolean deleteHdctByDongSp(String idDongSP);

    boolean deleteHdctByMauSac(String idMauSac);

    boolean deleteHdctByNSX(String idNSX);

    boolean deleteHdctBySanPham(String idSP);

    boolean deleteHDCTbyIdKH(String idKH);

    BigDecimal tongThanhTienHD(String idHD);

    List<HoaDonChiTiet> getListHDCTViewBanHang(String idHoaDon);

    HoaDonChiTiet getOne(String idCTSP, String idHD);
}
