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
import domainModel.HoaDon;
import domainModel.HoaDonChiTiet;
import domainModel.SanPham;
import repository.ICRUD;
import repository.IHoaDonChiTietRepository;

/**
 *
 * @author Duongntt
 */
public class HoaDonChiTietRepository implements ICRUD<HoaDonChiTiet>, IHoaDonChiTietRepository {

    @Override
    public List<HoaDonChiTiet> getAll() {
        String query = "SELECT HoaDon.Id, ChiTietSP.Id, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia,SanPham.Ma, SanPham.Ten\n"
                + "FROM HoaDonChiTiet INNER JOiN HoaDon ON  HoaDonChiTiet.IdHoaDon = HoaDon.Id\n"
                + "                 INNER JOIN ChiTietSP ON HoaDonChiTiet.IdChiTietSP = ChiTietSP.Id"
                + "                INNER JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            List<HoaDonChiTiet> listHDCT = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(rs.getString(1));
                String idCTSP = rs.getString(2);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setIdCTSP(idCTSP);
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString(5));
                sp.setTenSP(rs.getString(6));
                chiTietSP.setSanPham(sp);
                HoaDonChiTiet hdct = new HoaDonChiTiet(hd, chiTietSP, rs.getInt(3), rs.getBigDecimal(4));
                listHDCT.add(hdct);
            }
            return listHDCT;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDonChiTiet> getHDCTByIdHD(String idHD) {
        String query = "SELECT HoaDon.Id, ChiTietSP.Id, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia,SanPham.Ma, SanPham.Ten\n"
                + "FROM HoaDonChiTiet INNER JOiN HoaDon ON  HoaDonChiTiet.IdHoaDon = HoaDon.Id\n"
                + "	INNER JOIN ChiTietSP ON HoaDonChiTiet.IdChiTietSP = ChiTietSP.Id "
                + " INNER JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id "
                + " WHERE IdHoaDon = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idHD);
            List<HoaDonChiTiet> listHDCT = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(rs.getString(1));
                String idCTSP = rs.getString(2);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setIdCTSP(idCTSP);
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString(5));
                sp.setTenSP(rs.getString(6));
                chiTietSP.setSanPham(sp);
                HoaDonChiTiet hdct = new HoaDonChiTiet(hd, chiTietSP, rs.getInt(3), rs.getBigDecimal(4));
                listHDCT.add(hdct);
            }
            return listHDCT;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(HoaDonChiTiet hdct) {
        int check = 0;
        String query = "INSERT INTO HoaDonChiTiet VALUES (?,?,?,?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, hdct.getHoaDon().getIdHoaDon());
            ps.setObject(2, hdct.getChiTietSP().getIdCTSP());
            ps.setObject(3, hdct.getSoLuong());
            ps.setObject(4, hdct.getDonGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteHDCTByIdHD(String idHD) {
        int check = 0;
        String query = "DELETE FROM HoaDonChiTiet WHERE IdHoaDon = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idHD);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteHDCT(String idHD, String idCTSP) {
        int check = 0;
        String query = "DELETE FROM HoaDonChiTiet WHERE IdHoaDon = ? AND IdChiTietSP = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idHD);
            ps.setObject(2, idCTSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean updateHDCT(HoaDonChiTiet hoaDonChiTiet, String idHD, String idCTSP) {
        int check = 0;
        String query = "UPDATE HoaDonChiTiet  \n"
                + "SET IdHoaDon = ?, IdChiTietSP = ?,\n"
                + "	SoLuong = ?, DonGia = ?\n"
                + "WHERE IdHoaDon = ? AND IdChiTietSP = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, hoaDonChiTiet.getHoaDon().getIdHoaDon());
            ps.setObject(2, hoaDonChiTiet.getChiTietSP().getIdCTSP());
            ps.setObject(3, hoaDonChiTiet.getSoLuong());
            ps.setObject(4, hoaDonChiTiet.getDonGia());
            ps.setObject(5, idHD);
            ps.setObject(6, idCTSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteHdctByIdCTSP(String idChiTietSP) {
        int check = 0;
        String query = "DELETE FROM HoaDonChiTiet WHERE IdChiTietSP = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idChiTietSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteHdctByDongSp(String idDongSP) {
        int check = 0;
        String query = "DELETE FROM HoaDonChiTiet WHERE IdChiTietSP IN (SELECT IdChiTietSP FROM ChiTietSP WHERE IdDongSP = ?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idDongSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteHdctByMauSac(String idMauSac) {
        int check = 0;
        String query = "DELETE FROM HoaDonChiTiet WHERE IdChiTietSP IN (SELECT ChiTietSP.Id FROM ChiTietSP WHERE IdMauSac = ?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idMauSac);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteHdctByNSX(String idNSX) {
        int check = 0;
        String query = "DELETE FROM HoaDonChiTiet WHERE IdChiTietSP IN (SELECT ChiTietSP.Id FROM ChiTietSP WHERE IdNsx = ?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idNSX);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteHdctBySanPham(String idSP) {
        int check = 0;
        String query = "DELETE FROM HoaDonChiTiet WHERE IdChiTietSP IN (SELECT ChiTietSP.Id FROM ChiTietSP WHERE IdSP = ?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteHDCTbyIdKH(String idKH) {
        int check = 0;
        String query = "DELETE FROM HoaDonChiTiet WHERE IdHoaDon IN (SELECT IdHoaDon FROM HoaDon WHERE IdKH = ?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idKH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(HoaDonChiTiet t, String id) {
        //hàm này ko viết
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) {
        //hàm  này ko viết
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public BigDecimal tongThanhTienHD(String idHD) {
        BigDecimal tongTien = null;
        String query = "SELECT SUM(SoLuong * DonGia) FROM HoaDonChiTiet  WHERE IdHoaDon = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idHD);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tongTien = rs.getBigDecimal(1);
            }
        } finally {
            return tongTien;
        }
    }

    public static void main(String[] args) {
        System.out.println(new HoaDonChiTietRepository().tongThanhTienHD("E57DE6CF-78EB-4E52-A50F-21D1690F87A1"));
    }

    @Override
    public List<HoaDonChiTiet> getListHDCTViewBanHang(String idHoaDon) {
        String query = "SELECT HoaDonChiTiet.IdChiTietSP,SanPham.Ten, SanPham.Ma, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia\n"
                + "FROM HoaDonChiTiet LEFT JOIN ChiTietSP ON HoaDonChiTiet.IdChiTietSP = ChiTietSP.Id\n"
                + "					LEFT JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id\n"
                + "WHERE IdHoaDon = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idHoaDon);
            List<HoaDonChiTiet> listHDCT = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(idHoaDon);
                String idCTSP = rs.getString(1);
                String tenSP = rs.getString(2);
                String maSP = rs.getString(3);
                SanPham sp = new SanPham();
                sp.setMaSP(maSP);
                sp.setTenSP(tenSP);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setIdCTSP(idCTSP);
                chiTietSP.setSanPham(sp);
                HoaDonChiTiet hdct = new HoaDonChiTiet(hd, chiTietSP, rs.getInt(4), rs.getBigDecimal(5));
                listHDCT.add(hdct);
            }
            return listHDCT;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HoaDonChiTiet getOne(String idCTSP, String idHD) {
        String query = "SELECT HoaDon.Id, ChiTietSP.Id, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia,SanPham.Ma, SanPham.Ten\n"
                + "FROM HoaDonChiTiet INNER JOiN HoaDon ON  HoaDonChiTiet.IdHoaDon = HoaDon.Id\n"
                + "                 INNER JOIN ChiTietSP ON HoaDonChiTiet.IdChiTietSP = ChiTietSP.Id"
                + "                INNER JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id "
                + " WHERE IdChiTietSP = ? AND IdHoaDon = ? ";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idCTSP);
            ps.setObject(2, idHD);
            List<HoaDonChiTiet> listHDCT = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(rs.getString(1));
                String idChiTietSP = rs.getString(2);
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setIdCTSP(idChiTietSP);
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString(5));
                sp.setTenSP(rs.getString(6));
                chiTietSP.setSanPham(sp);
                HoaDonChiTiet hdct = new HoaDonChiTiet(hd, chiTietSP, rs.getInt(3), rs.getBigDecimal(4));
                return hdct;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
