/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import domainModel.ChiTietSP;
import domainModel.DongSP;
import domainModel.GioHangChiTiet;
import domainModel.HoaDonChiTiet;
import java.util.stream.Collectors;
import repository.impl.ChiTietSpRepository;
import repository.impl.DongSpRepository;
import repository.impl.GioHangChiTietRepository;
import repository.impl.HoaDonChiTietRepository;
import service.ConvertObject;
import service.DongSPService;
import util.ThongBao;
import viewModel.DongSPViewModel;

/**
 *
 * @author Duongntt
 */
public class DongSPServiceImpl implements DongSPService, ConvertObject<DongSPViewModel, DongSP> {

    private DongSpRepository dongSprep = new DongSpRepository();
    private ThongBao thongBao = new ThongBao();
    private ChiTietSpRepository chiTietSPRep = new ChiTietSpRepository();
    private HoaDonChiTietRepository hoaDonChiTietRep = new HoaDonChiTietRepository();
    private GioHangChiTietRepository gioHangChiTietRep = new GioHangChiTietRepository();

    @Override
    public List<DongSP> getAllDongSP() {
        return dongSprep.getAll();
    }

    @Override
    public String themDongSP(DongSP dongSP) {
        return thongBao.thongBaoKqThem(dongSprep.add(dongSP));
    }

    @Override
    public String updateDongSP(DongSP dongSP, String idDongSP) {
        return thongBao.thongBaoKqUpdate(dongSprep.update(dongSP, idDongSP));
    }

    @Override
    public String deleteDongSP(String idDongSP) {
        return thongBao.thongBaoKqDelete(dongSprep.delete(idDongSP));
    }

    @Override
    public String deleteCTSPByIdDongSP(String idDongSP) {
        return thongBao.thongBaoKqDelete(chiTietSPRep.deleteCTSPByIdDongSP(idDongSP));
    }

    @Override
    public String deleteHDCTByIDCTSP(String idCTSP) {
        return thongBao.thongBaoKqDelete(hoaDonChiTietRep.deleteHdctByIdCTSP(idCTSP));
    }

    @Override
    public String deleteGHCTByIDCTSP(String idCTSP) {
        return thongBao.thongBaoKqDelete(gioHangChiTietRep.deleteGHCTByIdCTSP(idCTSP));
    }

    public static void main(String[] args) {
        List<DongSP> listDongSP = new DongSPServiceImpl().getAllDongSP();
        for (DongSP dongSP : listDongSP) {
            System.out.println(dongSP.toString());
        }
    }

    @Override
    public List<DongSPViewModel> convertOb(List<DongSP> listDongSP) {
        List<DongSPViewModel> listDongSPView = new ArrayList<>();
        listDongSPView = listDongSP.stream().map((DongSP dongSP)
                -> new DongSPViewModel(dongSP.getMaDongSP(), dongSP.getTenDongSP())).collect(Collectors.toList());
        return listDongSPView;
    }
}
