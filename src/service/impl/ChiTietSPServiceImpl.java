/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import domainModel.ChiTietSP;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;
import repository.impl.ChiTietSpRepository;
import service.ChiTietSPService;
import service.ConvertObject;
import util.ThongBao;
import viewModel.ChiTietSPViewModel;
import viewModel.SanPhamViewBanHang;

/**
 *
 * @author Duongntt
 */
public class ChiTietSPServiceImpl implements ChiTietSPService, ConvertObject<ChiTietSPViewModel, ChiTietSP> {

    private ChiTietSpRepository chiTietSPRep = new ChiTietSpRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<ChiTietSP> getAllCTSP() {
        return chiTietSPRep.getAll();
    }

    @Override
    public String addCTSP(ChiTietSP chiTietSP) {
        return thongBao.thongBaoKqThem(chiTietSPRep.add(chiTietSP));
    }

    @Override
    public String addUpdateCTSP(ChiTietSP chiTietSP, String IdCTSP) {
        return thongBao.thongBaoKqUpdate(chiTietSPRep.update(chiTietSP, IdCTSP));
    }

    @Override
    public String deleteCTSP(String idCTSP) {
        return thongBao.thongBaoKqDelete(chiTietSPRep.delete(idCTSP));
    }

    @Override
    public String deleteCTSPByIdDongSP(String idDongSP) {
        return thongBao.thongBaoKqDelete(chiTietSPRep.deleteCTSPByIdDongSP(idDongSP));
    }

    @Override
    public String deleteCTSPByIdSP(String idSP) {
        return thongBao.thongBaoKqDelete(chiTietSPRep.deleteCTSPBySanPham(idSP));
    }

    @Override
    public String deleteCTSPByIdNSX(String idNSX) {
        return thongBao.thongBaoKqDelete(chiTietSPRep.deleteCTSPByNSX(idNSX));
    }

    @Override
    public String deleteCTSPByIdMauSac(String idMauSac) {
        return thongBao.thongBaoKqDelete(chiTietSPRep.deleteCTSPByMauSac(idMauSac));
    }

    @Override
    public ChiTietSP getOne(String idCTSP) {
        return chiTietSPRep.getOne(idCTSP);
    }

    @Override
    public int tinhSoLuongTon(int soLuong, int daBan) {
        return soLuong - daBan;
    }

    @Override
    public List<ChiTietSPViewModel> convertOb(List<ChiTietSP> listCTSP) {
        List<ChiTietSPViewModel> listCTSPView = new ArrayList<>();
        listCTSPView = listCTSP.stream().map((ChiTietSP chiTietSP) -> new ChiTietSPViewModel(chiTietSP.getIdCTSP(),
                chiTietSP.getSanPham().getTenSP(), chiTietSP.getNsx().getTenNSX(), chiTietSP.getMauSac().getTenMauSac(),
                chiTietSP.getDongSP().getTenDongSP(), chiTietSP.getNamBH(), chiTietSP.getMoTa(), chiTietSP.getSoLuongTon(),
                chiTietSP.getGiaNhap(), chiTietSP.getGiaBan())).collect(Collectors.toList());
        return listCTSPView;
    }

    public List<SanPhamViewBanHang> convertObSanPhamBanHang(List<ChiTietSP> listCTSP) {
        List<SanPhamViewBanHang> listCTSPView = new ArrayList<>();
        listCTSPView = listCTSP.stream().map((ChiTietSP chiTietSP) -> new SanPhamViewBanHang(chiTietSP.getSanPham().getMaSP(),
                chiTietSP.getSanPham().getTenSP(), chiTietSP.getNamBH(), chiTietSP.getMoTa(), chiTietSP.getSoLuongTon(),
                chiTietSP.getGiaNhap(), chiTietSP.getGiaBan())).collect(Collectors.toList());
        return listCTSPView;
    }

    @Override
    public List<ChiTietSP> searchCTSPByTenSP(String tenSearch) {
        return chiTietSPRep.searchCTSPByTenSP(tenSearch);
    }
}
