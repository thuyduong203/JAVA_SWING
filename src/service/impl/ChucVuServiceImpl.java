/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import jdbc.DBContext;
import domainModel.ChucVu;
import domainModel.CuaHang;
import domainModel.NhanVien;
import java.util.ArrayList;
import java.util.stream.Collectors;
import repository.impl.ChucVuRepository;
import service.ChucVuService;
import service.ConvertObject;
import util.ThongBao;
import viewModel.ChucVuViewModel;

/**
 *
 * @author Admin
 */
public class ChucVuServiceImpl implements ChucVuService<ChucVu>, ConvertObject<ChucVuViewModel, ChucVu> {

    private ChucVuRepository chucVuRep = new ChucVuRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<ChucVu> getAllCV() {
        return chucVuRep.getAll();
    }

    @Override
    public String addCV(ChucVu chucVu) {
        return thongBao.thongBaoKqThem(chucVuRep.add(chucVu));
    }

    @Override
    public String updateCV(ChucVu chucVu, String idCV) {
        return thongBao.thongBaoKqUpdate(chucVuRep.update(chucVu, idCV));
    }

    @Override
    public String deleteCV(String idCV) {
        return thongBao.thongBaoKqDelete(chucVuRep.delete(idCV));
    }

//    public NhanVien getNV(String maNV, String matKhau) {
//        String query = " SELECT NhanVien.Id, NhanVien.Ma, NhanVien.Ten, TenDem, Ho, GioiTinh, NgaySinh, NhanVien.DiaChi, Sdt, MatKhau, IdCH, IdCV,IdGuiBC,TrangThai\n"
//                + "FROM NhanVien WHERE Ma = ? AND MatKhau = ?  \n";
//        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
//            ps.setObject(1, maNV);
//            ps.setObject(2, matKhau);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                //ChucVu chucVu = new ChucVu(rs.getString(12), rs.getString(16));
//                ChucVu chucVu = new ChucVu(rs.getString(12));
//                //CuaHang cuaHang = new CuaHang(rs.getString(11), rs.getString(15));
//                CuaHang cuaHang = new CuaHang(rs.getString(11));
//                NhanVien nguoiGuiBC = new NhanVien(rs.getString(13));
//                NhanVien nhanVien = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
//                        rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), cuaHang, chucVu, nguoiGuiBC, rs.getInt(14));
//                return nhanVien;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public List<ChucVuViewModel> convertOb(List<ChucVu> listCV) {
        List<ChucVuViewModel> listCVView = new ArrayList<>();
        listCVView = listCV.stream().map((ChucVu chucVu) -> new ChucVuViewModel(chucVu.getMaCV(), chucVu.getTenCV())).collect(Collectors.toList());
        return listCVView;
    }
}
