/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.math.BigDecimal;
import java.util.List;
import domainModel.HoaDon;
import java.util.ArrayList;
import java.util.stream.Collectors;
import repository.impl.HoaDonRepository;
import service.ConvertObject;
import service.HoaDonService;
import util.ThongBao;
import viewModel.HoaDonViewModel;

/**
 *
 * @author Duongntt
 */
public class HoaDonServiceImpl implements HoaDonService, ConvertObject<HoaDonViewModel, HoaDon> {

    private HoaDonRepository hoaDonRep = new HoaDonRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<HoaDon> getAllHD() {
        return hoaDonRep.getAll();
    }

    @Override
    public String addHoaDon(HoaDon hoaDon) {
        return thongBao.thongBaoKqThem(hoaDonRep.add(hoaDon));
    }

    @Override
    public String updateHoaDon(HoaDon hoaDon, String idHD) {
        return thongBao.thongBaoKqUpdate(hoaDonRep.update(hoaDon, idHD));
    }

    @Override
    public String deleteHoaDon(String idHD) {
        return thongBao.thongBaoKqDelete(hoaDonRep.delete(idHD));
    }

    @Override
    public String deleteHoaDonByIdKH(String idKH) {
        return thongBao.thongBaoKqDelete(hoaDonRep.deleteByIdKH(idKH));
    }

    @Override
    public String deleteHoaDonByIdNV(String idNV) {
        return thongBao.thongBaoKqDelete(hoaDonRep.deleteByIdNV(idNV));
    }

    @Override
    public HoaDon getOne(String maHD) {
        return hoaDonRep.getOne(maHD);
    }

    @Override
    public BigDecimal tongTien(String idHD) {
        return hoaDonRep.tongTien(idHD);
    }

    @Override
    public List<HoaDon> getHDByTrangThai(int trangThai) {
        return hoaDonRep.getHDByTrangThai(trangThai);
    }

    @Override
    public List<HoaDon> getAllHDKoJoin() {
        return hoaDonRep.getAllHDKoJoin();
    }

    @Override
    public List<HoaDonViewModel> convertOb(List<HoaDon> listHD) {
        List<HoaDonViewModel> listHDView = new ArrayList<>();
        listHDView = listHD.stream().map((HoaDon hoaDon) -> new HoaDonViewModel(hoaDon.getIdHoaDon(), hoaDon.getKhachHang().getIdKH(),
                hoaDon.getNhanVien().getIdNV(), hoaDon.getMaHoaDon(), hoaDon.getNgayTao(), hoaDon.getNgayThanhToan(),
                hoaDon.getNgayShip(), hoaDon.getNgayNhan(), hoaDon.getTenNguoiNhan(),
                hoaDon.getDiaChiNguoiNhan(), hoaDon.getSdtNguoiNhan(), hoaDon.getTinhTrangHD())).collect(Collectors.toList());
        return listHDView;
    }

}
