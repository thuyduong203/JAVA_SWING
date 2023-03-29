/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import domainModel.ChiTietSP;
import viewModel.ChiTietSPViewModel;

/**
 *
 * @author Duongntt
 */
public interface ChiTietSPService {

    List<ChiTietSP> getAllCTSP();

    String addCTSP(ChiTietSP chiTietSP);

    String addUpdateCTSP(ChiTietSP chiTietSP, String Id);

    String deleteCTSP(String idCTSP);

    String deleteCTSPByIdDongSP(String idDongSP);

    String deleteCTSPByIdSP(String idSP);

    String deleteCTSPByIdNSX(String idNSX);

    String deleteCTSPByIdMauSac(String idMauSac);

    ChiTietSP getOne(String idCTSP);

    int tinhSoLuongTon(int soLuong, int daBan);

    List<ChiTietSP> searchCTSPByTenSP(String tenSearch);
}
