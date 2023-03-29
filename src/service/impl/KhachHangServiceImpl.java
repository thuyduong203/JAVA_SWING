/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import domainModel.KhachHang;
import java.util.ArrayList;
import java.util.stream.Collectors;
import repository.impl.KhachHangRepository;
import service.ConvertObject;
import service.KhachHangService;
import util.ThongBao;
import viewModel.KhachHangViewModel;

/**
 *
 * @author Duongntt
 */
public class KhachHangServiceImpl implements KhachHangService, ConvertObject<KhachHangViewModel, KhachHang> {

    private KhachHangRepository khachHangRep = new KhachHangRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<KhachHang> getAllKH() {
        return khachHangRep.getAll();
    }

    @Override
    public String addKhachHang(KhachHang khachHang) {
        return thongBao.thongBaoKqThem(khachHangRep.add(khachHang));
    }

    @Override
    public String updateKhachHang(KhachHang khachHang, String idKH) {
        return thongBao.thongBaoKqUpdate(khachHangRep.update(khachHang, idKH));
    }

    @Override
    public String deleteKhachHang(String idKH) {
        return thongBao.thongBaoKqDelete(khachHangRep.delete(idKH));
    }

    @Override
    public List<KhachHangViewModel> convertOb(List<KhachHang> listKH) {
        List<KhachHangViewModel> listKHView = new ArrayList<>();
        listKHView = listKH.stream().map((KhachHang khachHang) -> new KhachHangViewModel(khachHang.getMaKH(),
                khachHang.getTenKH(), khachHang.getTenDemKH(), khachHang.getHoKH(),
                khachHang.getNgaySinhKH(), khachHang.getSdtKH(), khachHang.getDiaChiKH())).collect(Collectors.toList());
        return listKHView;
    }

}
