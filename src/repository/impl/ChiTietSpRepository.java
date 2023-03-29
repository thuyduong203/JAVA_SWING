/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

/**
 *
 * @author Duongntt
 */
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import domainModel.ChiTietSP;
import domainModel.DongSP;
import domainModel.MauSac;
import domainModel.NSX;
import domainModel.SanPham;
import repository.ICRUD;
import repository.IChiTietSPRepository;

public class ChiTietSpRepository implements ICRUD<ChiTietSP>, IChiTietSPRepository {

    @Override
    public boolean deleteCTSPByIdDongSP(String idDongSP) {
        int check = 0;
        String query = "DELETE FROM ChiTietSP WHERE IdDongSP = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idDongSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteCTSPByMauSac(String idMauSac) {
        int check = 0;
        String query = "DELETE FROM ChiTietSP WHERE IdMauSac = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idMauSac);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteCTSPByNSX(String idNSX) {
        int check = 0;
        String query = "DELETE FROM ChiTietSP WHERE IdNsx = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idNSX);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteCTSPBySanPham(String idSP) {
        int check = 0;
        String query = "DELETE FROM ChiTietSP WHERE IdSP = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public List<ChiTietSP> getAll() {
        String query = "SELECT ChiTietSP.Id,ChiTietSP.IdSP,ChiTietSP.IdNsx,ChiTietSP.IdMauSac,"
                + "ChiTietSP.IdDongSP,NamBH,MoTa,SoLuongTon,GiaNhap,GiaBan\n"
                + "		,SanPham.Ten,NSX.Ten,MauSac.Ma,DongSP.Ten\n"
                + "FROM ChiTietSP  LEFT JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id"
                + "\n LEFT JOIN NSX ON ChiTietSP.IdNsx = NSX.Id"
                + "\n LEFT JOIN MauSac ON ChiTietSP.IdMauSac = MauSac.Id"
                + "\n LEFT JOIN DongSP ON ChiTietSP.IdDongSP = DongSP.Id";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            List<ChiTietSP> listCTSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idSP = rs.getString(2);
                SanPham sp = new SanPhamRepository().getOneSP(idSP);
                NSX nsx = new NSX(rs.getString(3), rs.getString(12));
                MauSac mauSac = new MauSac(rs.getString(4), rs.getString(13));
                DongSP dongSP = new DongSP(rs.getString(5), rs.getString(14));
                ChiTietSP chiTietSP = new ChiTietSP(rs.getString(1), sp, nsx, mauSac, dongSP, rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getBigDecimal(9), rs.getBigDecimal(10));
                listCTSP.add(chiTietSP);
            }
            return listCTSP;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(ChiTietSP chiTietSP) {
        int check = 0;
        String query = "INSERT INTO ChiTietSP (IdSP,IdNsx,IdMauSac, IdDongSP, NamBH, MoTa, SoLuongTon,GiaNhap, GiaBan) VALUES\n"
                + "	(\n"
                + "		?,?,?,\n"
                + "		?,?,?,?,?,?\n"
                + "	)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, chiTietSP.getSanPham().getIdSP());
            ps.setObject(2, chiTietSP.getNsx().getIdNSX());
            ps.setObject(3, chiTietSP.getMauSac().getIdMauSac());
            ps.setObject(4, chiTietSP.getDongSP().getIdDongSP());
            ps.setObject(5, chiTietSP.getNamBH());
            ps.setObject(6, chiTietSP.getMoTa());
            ps.setObject(7, chiTietSP.getSoLuongTon());
            ps.setObject(8, chiTietSP.getGiaNhap());
            ps.setObject(9, chiTietSP.getGiaBan());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(ChiTietSP chiTietSP, String id) {
        int check = 0;
        String query = "UPDATE ChiTietSP\n"
                + "SET IdSP = ?,\n"
                + "	IdNsx = ?,\n"
                + "	IdMauSac = ?,\n"
                + "	IdDongSP = ?,\n"
                + "	NamBH = ?, MoTa = ?, SoLuongTon = ?, GiaNhap = ?, GiaBan = ?\n"
                + "WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, chiTietSP.getSanPham().getIdSP());
            ps.setObject(2, chiTietSP.getNsx().getIdNSX());
            ps.setObject(3, chiTietSP.getMauSac().getIdMauSac());
            ps.setObject(4, chiTietSP.getDongSP().getIdDongSP());
            ps.setObject(5, chiTietSP.getNamBH());
            ps.setObject(6, chiTietSP.getMoTa());
            ps.setObject(7, chiTietSP.getSoLuongTon());
            ps.setObject(8, chiTietSP.getGiaNhap());
            ps.setObject(9, chiTietSP.getGiaBan());
            ps.setObject(10, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        String query = "DELETE FROM ChiTietSP WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public ChiTietSP getOne(String idCTSP) {
        String query = "SELECT Id, IdSP,IdNsx,IdMauSac, IdDongSP, NamBH,MoTa,SoLuongTon,GiaNhap,GiaBan\n"
                + "FROM ChiTietSP WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idCTSP);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String idSP = rs.getString(2);
                SanPham sp = new SanPhamRepository().getOneSP(idSP);
                NSX nsx = new NSX(rs.getString(3));
                MauSac mauSac = new MauSac(rs.getString(4));
                DongSP dongSP = new DongSP(rs.getString(5));
                ChiTietSP chiTietSP = new ChiTietSP(rs.getString(1), sp, nsx, mauSac, dongSP, rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getBigDecimal(9), rs.getBigDecimal(10));
                return chiTietSP;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChiTietSP> searchCTSPByTenSP(String tenSearch) {
        String query = "SELECT ChiTietSP.Id,ChiTietSP.IdSP,ChiTietSP.IdNsx,ChiTietSP.IdMauSac,\n"
                + "                ChiTietSP.IdDongSP,NamBH,MoTa,SoLuongTon,GiaNhap,GiaBan\n"
                + "                ,SanPham.Ten,NSX.Ten,MauSac.Ma,DongSP.Ten\n"
                + "                FROM ChiTietSP  LEFT JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id\n"
                + "                LEFT JOIN NSX ON ChiTietSP.IdNsx = NSX.Id\n"
                + "                LEFT JOIN MauSac ON ChiTietSP.IdMauSac = MauSac.Id\n"
                + "                LEFT JOIN DongSP ON ChiTietSP.IdDongSP = DongSP.Id\n"
                + "WHERE SanPham.Ten like ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            List<ChiTietSP> listCTSP = new ArrayList<>();
            ps.setObject(1, "%" + tenSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idSP = rs.getString(2);
                SanPham sp = new SanPhamRepository().getOneSP(idSP);
                NSX nsx = new NSX(rs.getString(3), rs.getString(12));
                MauSac mauSac = new MauSac(rs.getString(4), rs.getString(13));
                DongSP dongSP = new DongSP(rs.getString(5), rs.getString(14));
                ChiTietSP chiTietSP = new ChiTietSP(rs.getString(1), sp, nsx, mauSac, dongSP, rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getBigDecimal(9), rs.getBigDecimal(10));
                listCTSP.add(chiTietSP);
            }
            return listCTSP;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
