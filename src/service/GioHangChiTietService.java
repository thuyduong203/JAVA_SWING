/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import domainModel.GioHangChiTiet;

/**
 *
 * @author Duongntt
 */
public interface GioHangChiTietService {

    List<GioHangChiTiet> getAllGHCT();

    String themGHCT(GioHangChiTiet gioHangChiTiet);

    String deleteGHCTByIdGH(String idGH);

    String deleteGHCTByIdCTSP(String idCTSP);

    String deleteHdctByDongSp(String idDongSP);

    String deleteGHCT(String idCTSP, String idGH);

    String deleteGHCTByKH(String idKH);

    String deleteGHCTByMauSac(String idMauSac);

    String deleteGHCTByNSX(String idNSX);

    String deleteGHCTBySanPham(String idSP);
}
