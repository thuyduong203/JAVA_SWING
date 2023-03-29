/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import domainModel.HoaDon;
import domainModel.KhachHang;
import domainModel.NhanVien;
import repository.ICRUD;
import repository.IGioHangHoaDonRepository;
import repository.IHoaDonRepository;

/**
 *
 * @author Duongntt
 */
public class HoaDonRepository implements ICRUD<HoaDon>, IGioHangHoaDonRepository, IHoaDonRepository {

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<HoaDon> getAll() {
        String query = "SELECT HoaDon.Id,KhachHang.Id,NhanVien.Id,HoaDon.Ma, NgayTao,NgayThanhToan, NgayShip,NgayNhan,\n"
                + "	HoaDon.TinhTrang,TenNguoiNhan, HoaDon.DiaChi,HoaDon.Sdt\n"
                + "FROM HoaDon INNER JOIN KhachHang ON HoaDon.IdKH = KhachHang.Id\n"
                + "			INNER JOIN NhanVien ON HoaDon.IdNV = NhanVien.Id";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> listHD = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(2));
                String idNV = rs.getString(3);
                NhanVien nv = nhanVienRepository.getOneNV(idNV);
                HoaDon hoaDon = new HoaDon(rs.getString(1), kh, nv, rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getDate(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
                listHD.add(hoaDon);
            }
            return listHD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(HoaDon hoaDon) {
        int check = 0;
        String query = "INSERT INTO HoaDon (IdKH,IdNV,Ma,NgayTao,NgayThanhToan,NgayShip,NgayNhan,TinhTrang,TenNguoiNhan,DiaChi,Sdt)\n"
                + "VALUES(?,?,\n"
                + "		?,?,?,?,?,?,?,?,?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, hoaDon.getKhachHang().getIdKH());
            ps.setObject(2, hoaDon.getNhanVien().getIdNV());
            ps.setObject(3, hoaDon.getMaHoaDon());
            ps.setObject(4, hoaDon.getNgayTao());
            ps.setObject(5, hoaDon.getNgayThanhToan());
            ps.setObject(6, hoaDon.getNgayShip());
            ps.setObject(7, hoaDon.getNgayNhan());
            ps.setObject(8, hoaDon.getTinhTrangHD());
            ps.setObject(9, hoaDon.getTenNguoiNhan());
            ps.setObject(10, hoaDon.getDiaChiNguoiNhan());
            ps.setObject(11, hoaDon.getSdtNguoiNhan());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(HoaDon hoaDon, String idHD) {
        int check = 0;
        String query = "UPDATE HoaDon\n"
                + "SET IdKH = ?, IdNV = ?,\n"
                + "	Ma = ?, NgayTao = ?, NgayThanhToan = ?, NgayShip = ?, \n"
                + "	NgayNhan = ?, TinhTrang = ?, TenNguoiNhan = ?, DiaChi = ?, Sdt = ?\n"
                + "WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, hoaDon.getKhachHang().getIdKH());
            ps.setObject(2, hoaDon.getNhanVien().getIdNV());
            ps.setObject(3, hoaDon.getMaHoaDon());
            ps.setObject(4, hoaDon.getNgayTao());
            ps.setObject(5, hoaDon.getNgayThanhToan());
            ps.setObject(6, hoaDon.getNgayShip());
            ps.setObject(7, hoaDon.getNgayNhan());
            ps.setObject(8, hoaDon.getTinhTrangHD());
            ps.setObject(9, hoaDon.getTenNguoiNhan());
            ps.setObject(10, hoaDon.getDiaChiNguoiNhan());
            ps.setObject(11, hoaDon.getSdtNguoiNhan());
            ps.setObject(12, idHD);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String idHD) {
        int check = 0;
        String query = "DELETE FROM HoaDon WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idHD);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteByIdKH(String idKH) {
        int check = 0;
        String query = "DELETE FROM HoaDon WHERE IdKH = ?";
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
        String query = "DELETE FROM HoaDon WHERE IdNV = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public HoaDon getOne(String maHD) {
        String query = "SELECT Id, IdKH, IdNV, Ma, NgayTao, NgayThanhToan, NgayShip, NgayNhan,"
                + "TinhTrang, TenNguoiNhan, DiaChi, Sdt FROM HoaDon WHERE Ma = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new HoaDon(rs.getString(1), new KhachHang(rs.getString(2)), new NhanVien(rs.getString(3)),
                        rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getDate(7), rs.getDate(8),
                        rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        HoaDon hd = new HoaDonRepository().getOne("HD1");
        System.out.println(hd.toString());
    }

    @Override
    public BigDecimal tongTien(String idHD) {
        String query = "SELECT SUM(SoLuong * DonGia) FROM HoaDonChiTiet WHERE IdHoaDon = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idHD);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDon> getHDByTrangThai(int trangThai) {
        List<HoaDon> listHD = new ArrayList<>();
        String query = "SELECT Id,IdKH,IdNV ,Ma ,NgayTao ,NgayThanhToan,NgayShip\n"
                + "       ,NgayNhan ,TinhTrang,TenNguoiNhan,DiaChi ,Sdt\n"
                + " FROM HoaDon WHERE TinhTrang = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listHD.add(new HoaDon(rs.getString(1), new KhachHang(rs.getString(2)), new NhanVien(rs.getString(3)),
                        rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getDate(7), rs.getDate(8),
                        rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12)));
            }
            return listHD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDon> getAllHDKoJoin() {
        String query = "SELECT HoaDon.Id,KhachHang.Id,NhanVien.Id,HoaDon.Ma, NgayTao,NgayThanhToan, NgayShip,NgayNhan,\n"
                + "             HoaDon.TinhTrang,TenNguoiNhan, HoaDon.DiaChi,HoaDon.Sdt\n"
                + "                FROM HoaDon LEFT JOIN KhachHang ON HoaDon.IdKH = KhachHang.Id\n"
                + "				LEFT JOIN NhanVien ON HoaDon.IdNV = NhanVien.Id";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> listHD = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(2));
                String idNV = rs.getString(3);
                NhanVien nv = nhanVienRepository.getOneNV(idNV);
                HoaDon hoaDon = new HoaDon(rs.getString(1), kh, nv, rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getDate(7), rs.getDate(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
                listHD.add(hoaDon);
            }
            return listHD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
