/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainModel.ChiTietSP;
import java.util.List;

/**
 *
 * @author Duongntt
 */
public interface IChiTietSPRepository {

    boolean deleteCTSPByIdDongSP(String idDongSP);

    boolean deleteCTSPByMauSac(String idMauSac);

    boolean deleteCTSPByNSX(String idNSX);

    boolean deleteCTSPBySanPham(String idSP);

    ChiTietSP getOne(String idCTSP);

    List<ChiTietSP> searchCTSPByTenSP(String tenSearch);
}
