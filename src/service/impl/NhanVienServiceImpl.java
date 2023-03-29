/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import domainModel.NhanVien;
import java.util.ArrayList;
import java.util.stream.Collectors;
import repository.impl.NhanVienRepository;
import service.ConvertObject;
import service.NhanVienService;
import util.ThongBao;
import viewModel.NhanVienViewModel;

/**
 *
 * @author Admin
 */
public class NhanVienServiceImpl implements NhanVienService, ConvertObject<NhanVienViewModel, NhanVien> {

    private NhanVienRepository nhanVienRep = new NhanVienRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<NhanVien> getAllNV() {
        return nhanVienRep.getAll();
    }

    @Override
    public String addNhanVien(NhanVien nhanVien) {
        return thongBao.thongBaoKqThem(nhanVienRep.add(nhanVien));
    }

    @Override
    public String updateNV(NhanVien nhanVien, String idNV) {
        return thongBao.thongBaoKqUpdate(nhanVienRep.update(nhanVien, idNV));
    }

    @Override
    public String deleteNV(String idNV) {
        return thongBao.thongBaoKqDelete(nhanVienRep.delete(idNV));
    }

    @Override
    public String deleteNVByIdCV(String idCV) {
        return thongBao.thongBaoKqDelete(nhanVienRep.deleteNVByIdCV(idCV));
    }

    @Override
    public String deleteNVByIdCH(String idCH) {
        return thongBao.thongBaoKqDelete(nhanVienRep.deleteNVByIdCH(idCH));
    }

    @Override
    public String deleteNVByIDGuiBC(String idGuiBC) {
        return thongBao.thongBaoKqDelete(nhanVienRep.deleteNVByIdGuiBC(idGuiBC));
    }

    @Override
    public boolean getNV(String maNV, String matKhau) {
        if (nhanVienRep.getNV(maNV, matKhau) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public NhanVien getOneNV(String idNV) {
        return nhanVienRep.getOneNV(idNV);
    }

    @Override
    public NhanVien getOneNVByMa(String maNV) {
        return nhanVienRep.getOneNVByMa(maNV);
    }

    public static void main(String[] args) {
        List<NhanVien> listNV = new NhanVienRepository().getAll();
        List<NhanVienViewModel> list = new NhanVienServiceImpl().convertOb(listNV);
        for (NhanVienViewModel nhanVienViewModel : list) {
            System.out.println(nhanVienViewModel.toString());
        }
    }

    @Override
    public List<NhanVienViewModel> convertOb(List<NhanVien> listNV) {
        List<NhanVienViewModel> listNVView = new ArrayList<>();
        listNVView = listNV.stream().map((NhanVien nhanVien) -> new NhanVienViewModel(nhanVien.getMaNV(), nhanVien.getTenNV(),
                nhanVien.getTenDemNV(), nhanVien.getHoNV(), nhanVien.getGioiTinhNV(), nhanVien.getSdtNV(), nhanVien.getMatKhauNV(),
                nhanVien.getCuaHang().getIdCH(), nhanVien.getChucVu().getIdCV(), nhanVien.getNguoiGuiBC().getIdNV(), nhanVien.getTrangThai(),
                nhanVien.getNgaySinhNV(), nhanVien.getDiaChiNV())).collect(Collectors.toList());
        return listNVView;
    }
}
