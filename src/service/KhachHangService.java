/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import domainModel.KhachHang;

/**
 *
 * @author Duongntt
 */
public interface KhachHangService {

    List<KhachHang> getAllKH();

    String addKhachHang(KhachHang khachHang);

    String updateKhachHang(KhachHang khachHang, String idKH);

    String deleteKhachHang(String idKH);
}
