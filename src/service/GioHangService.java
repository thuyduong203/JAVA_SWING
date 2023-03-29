/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import domainModel.GioHang;

/**
 *
 * @author Duongntt
 */
public interface GioHangService {

    List<GioHang> getAllGH();

    String themGH(GioHang gioHang);

    String updateGH(GioHang gh, String idGH);

    String deleteGH(String idGH);

    String deleteGHByIdKH(String idKH);

    String deleteGHByIdNV(String idNV);
}
