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
import domainModel.GioHang;
import domainModel.KhachHang;
import domainModel.NhanVien;
import repository.ICRUD;
import repository.IGioHangHoaDonRepository;

/**
 *
 * @author Duongntt
 */
public class GioHangRepository implements ICRUD<GioHang>, IGioHangHoaDonRepository {

    @Override
    public List<GioHang> getAll() {
        String query = "SELECT GioHang.Id, KhachHang.Id,NhanVien.Id,GioHang.Ma, NgayTao, NgayThanhToan, TenNguoiNhan,\n"
                + "		GioHang.DiaChi, GioHang.Sdt,GioHang.TinhTrang, KhachHang.Ma,NhanVien.Ma\n"
                + "FROM GioHang INNER JOIN KhachHang ON GioHang.IdKH = KhachHang.Id\n"
                + "			INNER JOIN NhanVien  ON GioHang.IdNV = NhanVien.Id";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            List<GioHang> listGH = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien(rs.getString(3), rs.getString(12));
                KhachHang khachHang = new KhachHang(rs.getString(2), rs.getString(11));
                GioHang gh = new GioHang(rs.getString(1), khachHang, nhanVien, rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
                listGH.add(gh);
            }
            return listGH;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(GioHang gioHang) {
        int check = 0;
        String query = "INSERT INTO GioHang (IdKH,IdNV,Ma,NgayTao, NgayThanhToan,TenNguoiNhan,DiaChi,Sdt,TinhTrang) VALUES\n"
                + "(?,?, \n"
                + "?,?,?,?,?,?,?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, gioHang.getKhachHang().getIdKH());
            ps.setObject(2, gioHang.getNhanVien().getIdNV());
            ps.setObject(3, gioHang.getMaGioHang());
            ps.setObject(4, gioHang.getNgayTao());
            ps.setObject(5, gioHang.getNgayThanhToan());
            ps.setObject(6, gioHang.getTenNguoiNhan());
            ps.setObject(7, gioHang.getDiaChiNN());
            ps.setObject(8, gioHang.getSoDienThoaiNN());
            ps.setObject(9, gioHang.getTinhTrang());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(GioHang gioHang, String idGH) {
        int check = 0;
        String query = "UPDATE GioHang\n"
                + "SET IdKH = ?, IdNV = ?,\n"
                + "	Ma = ?, NgayTao = ?, NgayThanhToan = ?, TenNguoiNhan = ?,\n"
                + "	DiaChi = ?, Sdt = ?, TinhTrang = ?\n"
                + "WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, gioHang.getKhachHang().getIdKH());
            ps.setObject(2, gioHang.getNhanVien().getIdNV());
            ps.setObject(3, gioHang.getMaGioHang());
            ps.setObject(4, gioHang.getNgayTao());
            ps.setObject(5, gioHang.getNgayThanhToan());
            ps.setObject(6, gioHang.getTenNguoiNhan());
            ps.setObject(7, gioHang.getDiaChiNN());
            ps.setObject(8, gioHang.getSoDienThoaiNN());
            ps.setObject(9, gioHang.getTinhTrang());
            ps.setObject(10, idGH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String idGH) {
        int check = 0;
        String query = "DELETE FROM GioHang WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idGH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteByIdKH(String idKH) {
        int check = 0;
        String query = "DELETE FROM GioHang WHERE IdKH = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idKH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteByIdNV(String idNV) {
        int check = 0;
        String query = "DELETE FROM GioHang WHERE IdNV = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
