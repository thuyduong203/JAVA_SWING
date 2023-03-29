/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.math.BigDecimal;
import java.util.List;
import domainModel.HoaDon;

/**
 *
 * @author Duongntt
 */
public interface HoaDonService {

    List<HoaDon> getAllHD();

    String addHoaDon(HoaDon hoaDon);

    String updateHoaDon(HoaDon hoaDon, String idHD);

    String deleteHoaDon(String idHD);

    String deleteHoaDonByIdKH(String idKH);

    String deleteHoaDonByIdNV(String idNV);

    HoaDon getOne(String maHD);

    BigDecimal tongTien(String idHD);

    List<HoaDon> getHDByTrangThai(int trangThai);

    List<HoaDon> getAllHDKoJoin();
}
