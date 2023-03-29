/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import domainModel.DongSP;

/**
 *
 * @author Duongntt
 */
public interface DongSPService {

    List<DongSP> getAllDongSP();

    String themDongSP(DongSP dongSP);

    String updateDongSP(DongSP dongSP, String idDongSP);

    String deleteDongSP(String idDongSP);

    String deleteCTSPByIdDongSP(String idDongSP);

    String deleteHDCTByIDCTSP(String idCTSP);

    String deleteGHCTByIDCTSP(String idCTSP);
}
