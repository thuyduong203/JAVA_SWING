/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.math.BigDecimal;
import java.util.List;
import domainModel.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.stream.Collectors;
import repository.impl.HoaDonChiTietRepository;
import service.ConvertObject;
import service.HoaDonChiTietService;
import util.ThongBao;
import viewModel.FrmHDCT;
import viewModel.HoaDonChiTietViewModel;

/**
 *
 * @author Duongntt
 */
public class HoaDonChiTietImpl implements HoaDonChiTietService, ConvertObject<HoaDonChiTietViewModel, HoaDonChiTiet> {

    private HoaDonChiTietRepository hoaDonChiTietRep = new HoaDonChiTietRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<HoaDonChiTiet> getAllHD() {
        return hoaDonChiTietRep.getAll();
    }

    @Override
    public String addHDCT(HoaDonChiTiet hoaDonChiTiet) {
        return thongBao.thongBaoKqThem(hoaDonChiTietRep.add(hoaDonChiTiet));
    }

    @Override
    public String deleteHDCTByIdHD(String idHD) {
        return thongBao.thongBaoKqDelete(hoaDonChiTietRep.deleteHDCTByIdHD(idHD));
    }

    @Override
    public String deleteHDCTByIdCTSP(String idCTSP) {
        return thongBao.thongBaoKqDelete(hoaDonChiTietRep.deleteHdctByIdCTSP(idCTSP));
    }

    @Override
    public String deleteHDCTByIdCTSP2(String idDongSP) {
        return thongBao.thongBaoKqDelete(hoaDonChiTietRep.deleteHdctByDongSp(idDongSP));
    }

    @Override
    public String deleteHDCT(String idHD, String idCTSP) {
        return thongBao.thongBaoKqDelete(hoaDonChiTietRep.deleteHDCT(idHD, idCTSP));
    }

    @Override
    public String updateHDCT(HoaDonChiTiet hdct, String idHD, String idCTSP) {
        return thongBao.thongBaoKqUpdate(hoaDonChiTietRep.updateHDCT(hdct, idHD, idCTSP));
    }

    @Override
    public String deleteHDCTbyIdKH(String idKH) {
        return thongBao.thongBaoKqDelete(hoaDonChiTietRep.deleteHDCTbyIdKH(idKH));
    }

    @Override
    public String deleteHdctByMauSac(String idMauSac) {
        return thongBao.thongBaoKqDelete(hoaDonChiTietRep.deleteHdctByMauSac(idMauSac));
    }

    @Override
    public String deleteHdctByNSX(String idNSX) {
        return thongBao.thongBaoKqDelete(hoaDonChiTietRep.deleteHdctByNSX(idNSX));
    }

    @Override
    public String deleteHdctBySanPham(String idSP) {
        return thongBao.thongBaoKqDelete(hoaDonChiTietRep.deleteHdctByNSX(idSP));
    }

    @Override
    public List<HoaDonChiTiet> getHDCTByIdHD(String idHD) {
        return hoaDonChiTietRep.getHDCTByIdHD(idHD);
    }

    @Override
    public BigDecimal tongThanhTienHD(String idHD) {
        return hoaDonChiTietRep.tongThanhTienHD(idHD);
    }

    @Override
    public List<HoaDonChiTietViewModel> convertOb(List<HoaDonChiTiet> listHDCT) {
        List<HoaDonChiTietViewModel> listHDCTView = new ArrayList<>();
        listHDCTView = listHDCT.stream().map((HoaDonChiTiet hoaDonChiTiet)
                -> new HoaDonChiTietViewModel(hoaDonChiTiet.getHoaDon().getIdHoaDon(), hoaDonChiTiet.getChiTietSP().getIdCTSP(),
                        hoaDonChiTiet.getSoLuong(), hoaDonChiTiet.getDonGia())).collect(Collectors.toList());
        return listHDCTView;
    }
////hàm này ko có trong service :v

    public List<FrmHDCT> convertObView(List<HoaDonChiTiet> listHDCT) {
        List<FrmHDCT> listHDCTView = new ArrayList<>();
        listHDCTView = listHDCT.stream().map((HoaDonChiTiet hoaDonChiTiet)
                -> new FrmHDCT(hoaDonChiTiet.getChiTietSP().getIdCTSP(), hoaDonChiTiet.getChiTietSP().getSanPham().getMaSP(),
                        hoaDonChiTiet.getChiTietSP().getSanPham().getTenSP(), hoaDonChiTiet.getSoLuong(), hoaDonChiTiet.getDonGia())).collect(Collectors.toList());
        return listHDCTView;
    }

    @Override
    public List<HoaDonChiTiet> getListHDCTViewBanHang(String idHoaDon) {
        return hoaDonChiTietRep.getListHDCTViewBanHang(idHoaDon);
    }

    @Override
    public HoaDonChiTiet getOne(String idCTSP, String idHD) {
        return hoaDonChiTietRep.getOne(idCTSP, idHD);
    }

}
