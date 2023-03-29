/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domainModel.NhanVien;

/**
 *
 * @author Duongntt
 */
public interface INhanVienRepository {

    NhanVien getOneNV(String idNV);

    boolean deleteNVByIdCV(String idCV);

    boolean deleteNVByIdCH(String idCH);

    boolean deleteNVByIdGuiBC(String idNVBC);

    NhanVien getNV(String maNV, String matKhau);

    NhanVien getOneNVByMa(String maNV);
}
