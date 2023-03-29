/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import domainModel.CuaHang;
import java.util.ArrayList;
import java.util.stream.Collectors;
import repository.impl.CuaHangRepository;
import service.ConvertObject;
import service.CuaHangService;
import util.ThongBao;
import viewModel.CuaHangViewModel;

/**
 *
 * @author Admin
 */
public class CuaHangServiceImpl implements CuaHangService, ConvertObject<CuaHangViewModel, CuaHang> {

    private CuaHangRepository chRep = new CuaHangRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<CuaHang> getAllCH() {
        return chRep.getAll();
    }

    @Override
    public String addCH(CuaHang ch) {
        return thongBao.thongBaoKqThem(chRep.add(ch));
    }

    @Override
    public String updateCH(CuaHang ch, String idCH) {
        return thongBao.thongBaoKqUpdate(chRep.update(ch, idCH));
    }

    @Override
    public String deleteCH(String idCH) {
        return thongBao.thongBaoKqDelete(chRep.delete(idCH));
    }

    @Override
    public List<CuaHangViewModel> convertOb(List<CuaHang> listCH) {
        List<CuaHangViewModel> listCHView = new ArrayList<>();
        listCHView = listCH.stream().map((CuaHang cuaHang) -> new CuaHangViewModel(cuaHang.getMaCH(), cuaHang.getTenCH(),
                cuaHang.getDiaChi(), cuaHang.getThanhPho(), cuaHang.getQuocGia())).collect(Collectors.toList());
        return listCHView;
    }

}
