/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import domainModel.SanPham;

/**
 *
 * @author Duongntt
 */
public interface SanPhamService {

    List<SanPham> getAllSP();

    String themSP(SanPham sanPham);

    String updateSP(SanPham sanPham, String idSP);

    String deleteSP(String idSP);

    SanPham getOneSP(String idSP);
}
