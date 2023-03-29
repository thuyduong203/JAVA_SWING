/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import domainModel.GioHangChiTiet;
import repository.impl.GioHangChiTietRepository;
import service.GioHangChiTietService;
import util.ThongBao;

/**
 *
 * @author Duongntt
 */
public class GioHangChiTietImpl implements GioHangChiTietService {

    private GioHangChiTietRepository ghctRep = new GioHangChiTietRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<GioHangChiTiet> getAllGHCT() {
        return ghctRep.getAll();
    }

    @Override
    public String themGHCT(GioHangChiTiet gioHangChiTiet) {
        return thongBao.thongBaoKqThem(ghctRep.add(gioHangChiTiet));
    }

    @Override
    public String deleteGHCTByIdGH(String idGH) {
        return thongBao.thongBaoKqDelete(ghctRep.delete(idGH));
    }

    @Override
    public String deleteGHCTByIdCTSP(String idCTSP) {
        return thongBao.thongBaoKqDelete(ghctRep.deleteGHCTByIdCTSP(idCTSP));
    }

    @Override
    public String deleteHdctByDongSp(String idDongSP) {
        return thongBao.thongBaoKqDelete(ghctRep.deleteGHCTByDongSP(idDongSP));
    }

    @Override
    public String deleteGHCT(String idCTSP, String idGH) {
        return thongBao.thongBaoKqDelete(ghctRep.deleteGHCT(idCTSP, idGH));
    }

    @Override
    public String deleteGHCTByKH(String idKH) {
        return thongBao.thongBaoKqDelete(ghctRep.deleteGHCTByKH(idKH));
    }

    @Override
    public String deleteGHCTByMauSac(String idMauSac) {
        return thongBao.thongBaoKqDelete(ghctRep.deleteGHCTByMauSac(idMauSac));
    }

    @Override
    public String deleteGHCTByNSX(String idNSX) {
        return thongBao.thongBaoKqDelete(ghctRep.deleteGHCTByNSX(idNSX));
    }

    @Override
    public String deleteGHCTBySanPham(String idSP) {
        return thongBao.thongBaoKqDelete(ghctRep.deleteGHCTByNSX(idSP));
    }

}
