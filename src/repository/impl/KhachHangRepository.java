/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import domainModel.KhachHang;
import repository.ICRUD;

/**
 *
 * @author Duongntt
 */
public class KhachHangRepository implements ICRUD<KhachHang> {

    @Override
    public List<KhachHang> getAll() {
        String query = "SELECT Id,Ma,Ten,TenDem, Ho, NgaySinh, Sdt, DiaChi, ThanhPho, QuocGia, MatKhau FROM KhachHang";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> listKH = new ArrayList<>();
            while (rs.next()) {
                listKH.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(KhachHang khachHang) {
        int check = 0;
        String query = "INSERT INTO KhachHang(Ma,Ten,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) VALUES\n"
                + "(?,?,?,?,?,?,?,?,?,?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, khachHang.getMaKH());
            ps.setObject(2, khachHang.getTenKH());
            ps.setObject(3, khachHang.getTenDemKH());
            ps.setObject(4, khachHang.getHoKH());
            ps.setObject(5, khachHang.getNgaySinhKH());
            ps.setObject(6, khachHang.getSdtKH());
            ps.setObject(7, khachHang.getDiaChiKH());
            ps.setObject(8, khachHang.getThanhPhoKH());
            ps.setObject(9, khachHang.getQuocGiaKH());
            ps.setObject(10, khachHang.getMatKhau());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(KhachHang khachHang, String idKH) {
        int check = 0;
        String query = "UPDATE KhachHang \n"
                + "SET Ma = ?, Ten = ?, TenDem = ?,Ho = ?,NgaySinh = ?, \n"
                + "Sdt = ?,DiaChi = ?,ThanhPho = ?,QuocGia = ?,MatKhau = ?\n"
                + "WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, khachHang.getMaKH());
            ps.setObject(2, khachHang.getTenKH());
            ps.setObject(3, khachHang.getTenDemKH());
            ps.setObject(4, khachHang.getHoKH());
            ps.setObject(5, khachHang.getNgaySinhKH());
            ps.setObject(6, khachHang.getSdtKH());
            ps.setObject(7, khachHang.getDiaChiKH());
            ps.setObject(8, khachHang.getThanhPhoKH());
            ps.setObject(9, khachHang.getQuocGiaKH());
            ps.setObject(10, khachHang.getMatKhau());
            ps.setObject(11, idKH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String idKH) {
        int check = 0;
        String query = "DELETE FROM KhachHang WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idKH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
