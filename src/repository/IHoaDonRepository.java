/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.math.BigDecimal;
import java.util.List;
import domainModel.HoaDon;

/**
 *
 * @author Duongntt
 */
public interface IHoaDonRepository {

    HoaDon getOne(String maHD);

    BigDecimal tongTien(String idHD);

    List<HoaDon> getHDByTrangThai(int trangThai);

    List<HoaDon> getAllHDKoJoin();
}
