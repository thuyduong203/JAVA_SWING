/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.sql.Date;
import java.util.List;
import domainModel.GioHang;
import domainModel.KhachHang;
import domainModel.NhanVien;
import repository.impl.GioHangRepository;
import service.GioHangService;
import util.ThongBao;

/**
 *
 * @author Duongntt
 */
public class GioHangServiceImpl implements GioHangService {

    private GioHangRepository gioHangRep = new GioHangRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<GioHang> getAllGH() {
        return gioHangRep.getAll();
    }

    @Override
    public String themGH(GioHang gioHang) {
        return thongBao.thongBaoKqThem(gioHangRep.add(gioHang));
    }

    @Override
    public String updateGH(GioHang gh, String idGH) {
        return thongBao.thongBaoKqUpdate(gioHangRep.update(gh, idGH));
    }

    @Override
    public String deleteGH(String idGH) {
        return thongBao.thongBaoKqDelete(gioHangRep.delete(idGH));
    }

    @Override
    public String deleteGHByIdKH(String idKH) {
        return thongBao.thongBaoKqDelete(gioHangRep.deleteByIdKH(idKH));
    }

    @Override
    public String deleteGHByIdNV(String idNV) {
        return thongBao.thongBaoKqDelete(gioHangRep.deleteByIdNV(idNV));
    }

}
