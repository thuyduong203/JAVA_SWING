/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import service.impl.*;
import java.util.List;
import domainModel.CuaHang;
import viewModel.CuaHangViewModel;

/**
 *
 * @author Admin
 */
public interface CuaHangService {

    List<CuaHang> getAllCH();

    String addCH(CuaHang ch);

    String updateCH(CuaHang ch, String idCH);

    String deleteCH(String idCH);

}
