/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import domainModel.NhanVien;

/**
 *
 * @author Admin
 */
public interface NhanVienService {

    List<NhanVien> getAllNV();

    String addNhanVien(NhanVien nhanVien);

    String updateNV(NhanVien nhanVien, String maNV);

    String deleteNV(String maNV);

    String deleteNVByIdCV(String idCV);

    String deleteNVByIdCH(String idCH);

    String deleteNVByIDGuiBC(String idGuiBC);

    boolean getNV(String maNV, String matKhau);

    NhanVien getOneNV(String idNV);

    NhanVien getOneNVByMa(String maNV);

}
