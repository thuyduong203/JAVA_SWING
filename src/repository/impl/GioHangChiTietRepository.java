/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import domainModel.ChiTietSP;
import domainModel.GioHang;
import domainModel.GioHangChiTiet;
import repository.ICRUD;
import repository.IGioHangCTRepository;

/**
 *
 * @author Duongntt
 */
public class GioHangChiTietRepository implements ICRUD<GioHangChiTiet>, IGioHangCTRepository {

    @Override
    public List<GioHangChiTiet> getAll() {
        String query = "SELECT GioHangChiTiet.IdGioHang, GioHangChiTiet.IdChiTietSP, GioHangChiTiet.SoLuong,GioHangChiTiet.DonGia, DonGiaKhiGiam\n"
                + "FROM GioHangChiTiet INNER JOIN GioHang ON GioHangChiTiet.IdGioHang = GioHang.Id\n"
                + "					INNER JOIN ChiTietSP ON GioHangChiTiet.IdChiTietSP = ChiTietSP.Id";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<GioHangChiTiet> listGHCT = new ArrayList<>();
            while (rs.next()) {
                GioHang gh = new GioHang(rs.getString(1));
                ChiTietSP chiTietSP = new ChiTietSP(rs.getString(2));
                GioHangChiTiet ghct = new GioHangChiTiet(gh, chiTietSP, rs.getInt(3), rs.getBigDecimal(4), rs.getBigDecimal(5));
                listGHCT.add(ghct);
            }
            return listGHCT;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(GioHangChiTiet gioHangChiTiet) {
        int check = 0;
        String query = "INSERT INTO GioHangChiTiet (IdGioHang,IdChiTietSP,SoLuong,DonGia,DonGiaKhiGiam)\n"
                + "VALUES (?,?,\n"
                + "		?,?,?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, gioHangChiTiet.getGioHang().getIdGioHang());
            ps.setObject(2, gioHangChiTiet.getChiTietSP().getIdCTSP());
            ps.setObject(3, gioHangChiTiet.getSoLuong());
            ps.setObject(4, gioHangChiTiet.getDonGia());
            ps.setObject(5, gioHangChiTiet.getDonGiaKhiGiam());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String idGH) {
        int check = 0;
        String query = "DELETE FROM GioHangChiTiet WHERE IdGioHang = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idGH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteGHCTByKH(String idKH) {
        int check = 0;
        String query = "DELETE FROM GioHangChiTiet WHERE IdGioHang IN (SELECT IdGioHang FROM GioHang WHERE IdKH = ?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idKH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteGHCTByIdCTSP(String idCTSP) {
        int check = 0;
        String query = "DELETE FROM GioHangChiTiet WHERE IdChiTietSP = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idCTSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteGHCT(String idCTSP, String idGH) {
        int check = 0;
        String query = "DELETE FROM GioHangChiTiet WHERE IdChiTietSP = ? AND IdGioHang = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idCTSP);
            ps.setObject(2, idGH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteGHCTByDongSP(String idDongSP) {
        int check = 0;
        String query = "DELETE FROM GioHangChiTiet WHERE IdChiTietSP IN (SELECT IdChiTietSP FROM ChiTietSP WHERE IdDongSP = ?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idDongSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteGHCTByMauSac(String idMauSac) {
        int check = 0;
        String query = "DELETE FROM GioHangChiTiet WHERE IdChiTietSP IN (SELECT ChiTietSP.Id FROM ChiTietSP WHERE IdMauSac = ?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idMauSac);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteGHCTByNSX(String idNSX) {
        int check = 0;
        String query = "DELETE FROM GioHangChiTiet WHERE IdChiTietSP IN (SELECT ChiTietSP.Id FROM ChiTietSP WHERE IdNsx = ?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idNSX);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteGHCTBySanPham(String idSP) {
        int check = 0;
        String query = "DELETE FROM GioHangChiTiet WHERE IdChiTietSP IN (SELECT ChiTietSP.Id FROM ChiTietSP WHERE IdSP = ?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(GioHangChiTiet t, String id) {
        return false;
    }

}
