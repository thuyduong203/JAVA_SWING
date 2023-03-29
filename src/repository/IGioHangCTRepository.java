/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

/**
 *
 * @author Duongntt
 */
public interface IGioHangCTRepository {

    boolean deleteGHCTByKH(String idKH);

    boolean deleteGHCTByIdCTSP(String idCTSP);

    boolean deleteGHCT(String idCTSP, String idGH);

    boolean deleteGHCTByDongSP(String idDongSP);

    boolean deleteGHCTByMauSac(String idMauSac);

    boolean deleteGHCTByNSX(String idNSX);

    boolean deleteGHCTBySanPham(String idSP);
}
