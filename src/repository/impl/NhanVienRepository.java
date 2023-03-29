/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import java.util.List;
import domainModel.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import jdbc.DBContext;
import domainModel.ChucVu;
import domainModel.CuaHang;
import domainModel.KhachHang;
import repository.ICRUD;
import repository.INhanVienRepository;

/**
 *
 * @author Admin
 */
public class NhanVienRepository implements ICRUD<NhanVien>, INhanVienRepository {

    @Override
    public List<NhanVien> getAll() {
        String query = "SELECT NhanVien.Id, NhanVien.Ma, NhanVien.Ten, TenDem, Ho, GioiTinh, NgaySinh, NhanVien.DiaChi, Sdt, MatKhau, IdCH, IdCV,IdGuiBC,TrangThai\n"
                + "FROM NhanVien \n";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            List<NhanVien> listNV = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //ChucVu chucVu = new ChucVu(rs.getString(12), rs.getString(16));
                ChucVu chucVu = new ChucVu(rs.getString(12));
                //CuaHang cuaHang = new CuaHang(rs.getString(11), rs.getString(15));
                CuaHang cuaHang = new CuaHang(rs.getString(11));
                NhanVien nguoiGuiBC = new NhanVien(rs.getString(13));
                NhanVien nhanVien = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), cuaHang, chucVu, nguoiGuiBC, rs.getInt(14));
                listNV.add(nhanVien);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NhanVien getOneNV(String idNV) {
        String query = " SELECT NhanVien.Id, NhanVien.Ma, NhanVien.Ten, TenDem, Ho, GioiTinh, NgaySinh, NhanVien.DiaChi, Sdt, MatKhau, IdCH, IdCV,IdGuiBC,TrangThai\n"
                + "FROM NhanVien WHERE Id = ?  \n";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //ChucVu chucVu = new ChucVu(rs.getString(12), rs.getString(16));
                ChucVu chucVu = new ChucVu(rs.getString(12));
                //CuaHang cuaHang = new CuaHang(rs.getString(11), rs.getString(15));
                CuaHang cuaHang = new CuaHang(rs.getString(11));
                NhanVien nguoiGuiBC = new NhanVien(rs.getString(13));
                NhanVien nhanVien = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), cuaHang, chucVu, nguoiGuiBC, rs.getInt(14));
                return nhanVien;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(NhanVien nhanVien) {
        int check = 0;
        String query = "INSERT INTO NhanVien (Ma,Ten,TenDem,Ho,GioiTinh,NgaySinh,DiaChi,Sdt,MatKhau,IdCH,IdCV,IdGuiBC,TrangThai)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, nhanVien.getMaNV());
            ps.setObject(2, nhanVien.getTenNV());
            ps.setObject(3, nhanVien.getTenDemNV());
            ps.setObject(4, nhanVien.getHoNV());
            ps.setObject(5, nhanVien.getGioiTinhNV());
            ps.setObject(6, nhanVien.getNgaySinhNV());
            ps.setObject(7, nhanVien.getDiaChiNV());
            ps.setObject(8, nhanVien.getSdtNV());
            ps.setObject(9, nhanVien.getMatKhauNV());
            ps.setObject(10, nhanVien.getCuaHang().getIdCH());
            ps.setObject(11, nhanVien.getChucVu().getIdCV());
            ps.setObject(12, nhanVien.getNguoiGuiBC().getIdNV());
            ps.setObject(13, nhanVien.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(NhanVien nhanVien, String idNV) {
        int check = 0;
        String query = "UPDATE NhanVien\n"
                + "SET Ma = ?, Ten = ?, TenDem = ?, Ho = ?, GioiTinh = ?,\n"
                + "	NgaySinh = ?, DiaChi = ?, Sdt = ?, MatKhau = ?, \n"
                + "	IdCH = ?, IdCV = ?, IdGuiBC = ?,\n"
                + "	TrangThai = ? WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, nhanVien.getMaNV());
            ps.setObject(2, nhanVien.getTenNV());
            ps.setObject(3, nhanVien.getTenDemNV());
            ps.setObject(4, nhanVien.getHoNV());
            ps.setObject(5, nhanVien.getGioiTinhNV());
            ps.setObject(6, nhanVien.getNgaySinhNV());
            ps.setObject(7, nhanVien.getDiaChiNV());
            ps.setObject(8, nhanVien.getSdtNV());
            ps.setObject(9, nhanVien.getMatKhauNV());
            ps.setObject(10, nhanVien.getCuaHang().getIdCH());
            ps.setObject(11, nhanVien.getChucVu().getIdCV());
            ps.setObject(12, nhanVien.getNguoiGuiBC().getIdNV());
            ps.setObject(13, nhanVien.getTrangThai());
            ps.setObject(14, idNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String idNV) {
        int check = 0;
        String query = "DELETE FROM NhanVien WHERE Id = ? ";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteNVByIdCV(String idCV) {
        int check = 0;
        String query = "DELETE FROM NhanVien WHERE IdCV = ? ";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idCV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteNVByIdCH(String idCH) {
        int check = 0;
        String query = "DELETE FROM NhanVien WHERE IdCH = ? ";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idCH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean deleteNVByIdGuiBC(String idNVBC) {
        int check = 0;
        String query = "DELETE FROM NhanVien WHERE IdGuiBC = ? ";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idNVBC);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public NhanVien getNV(String maNV, String matKhau) {
        String query = " SELECT NhanVien.Id, NhanVien.Ma, NhanVien.Ten, TenDem, Ho, GioiTinh, NgaySinh, NhanVien.DiaChi, Sdt, MatKhau, IdCH, IdCV,IdGuiBC,TrangThai\n"
                + "FROM NhanVien WHERE Ma = ? AND MatKhau = ?  \n";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, maNV);
            ps.setObject(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //ChucVu chucVu = new ChucVu(rs.getString(12), rs.getString(16));
                ChucVu chucVu = new ChucVu(rs.getString(12));
                //CuaHang cuaHang = new CuaHang(rs.getString(11), rs.getString(15));
                CuaHang cuaHang = new CuaHang(rs.getString(11));
                NhanVien nguoiGuiBC = new NhanVien(rs.getString(13));
                NhanVien nhanVien = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), cuaHang, chucVu, nguoiGuiBC, rs.getInt(14));
                return nhanVien;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        List<NhanVien> listNV = new NhanVienRepository().getAllNV();
//        for (NhanVien nhanVien : listNV) {
//            System.out.println(nhanVien.toString());
//        }
        NhanVien nv = new NhanVienRepository().getOneNV("3A1ABAAC-444A-4604-B6C7-0BF1EC15F13E");
        System.out.println(nv.toString());
//        CuaHang ch = new CuaHang("C01623E1-AC9D-41D2-BF10-C1E82279C137");
//        ChucVu chucVu = new ChucVu("01D31496-7316-4E28-9250-51CF4AFEE299");
//        NhanVien nhanVien = new NhanVien("22B86894-DCC9-42D4-BABE-5ECFA1281619");
//        NhanVien nhanVienAdd = new NhanVien("", "abcUpdate", "abc", "abc", "abc", "Nam", Date.valueOf("2003-11-29"), "Tuyên Quang", "34567890", "123456", ch, chucVu, nhanVien, 0);
//        System.out.println(new NhanVienRepository().updateNV(nhanVienAdd, "abc"));
//        System.out.println(new NhanVienRepository().deleteNV("update"));
    }

    @Override
    public NhanVien getOneNVByMa(String maNV) {
        String query = " SELECT NhanVien.Id, NhanVien.Ma, NhanVien.Ten, TenDem, Ho, GioiTinh, NgaySinh, NhanVien.DiaChi, Sdt, MatKhau, IdCH, IdCV,IdGuiBC,TrangThai\n"
                + "FROM NhanVien WHERE Ma = ?  \n";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //ChucVu chucVu = new ChucVu(rs.getString(12), rs.getString(16));
                ChucVu chucVu = new ChucVu(rs.getString(12));
                //CuaHang cuaHang = new CuaHang(rs.getString(11), rs.getString(15));
                CuaHang cuaHang = new CuaHang(rs.getString(11));
                NhanVien nguoiGuiBC = new NhanVien(rs.getString(13));
                NhanVien nhanVien = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), cuaHang, chucVu, nguoiGuiBC, rs.getInt(14));
                return nhanVien;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
