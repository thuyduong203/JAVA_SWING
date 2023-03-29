/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import domainModel.SanPham;
import java.util.ArrayList;
import java.util.stream.Collectors;
import repository.impl.SanPhamRepository;
import service.ConvertObject;
import service.SanPhamService;
import util.ThongBao;
import viewModel.SanPhamViewModel;

/**
 *
 * @author Duongntt
 */
public class SanPhamServiceImpl implements SanPhamService, ConvertObject<SanPhamViewModel, SanPham> {

    private SanPhamRepository sanPhamRep = new SanPhamRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<SanPham> getAllSP() {
        return sanPhamRep.getAll();
    }

    @Override
    public String themSP(SanPham sanPham) {
        return thongBao.thongBaoKqThem(sanPhamRep.add(sanPham));
    }

    @Override
    public String updateSP(SanPham sanPham, String idSP) {
        return thongBao.thongBaoKqUpdate(sanPhamRep.update(sanPham, idSP));
    }

    @Override
    public String deleteSP(String idSP) {
        return thongBao.thongBaoKqDelete(sanPhamRep.delete(idSP));
    }

    @Override
    public SanPham getOneSP(String idSP) {
        return sanPhamRep.getOneSP(idSP);
    }

    @Override
    public List<SanPhamViewModel> convertOb(List<SanPham> listSP) {
        List<SanPhamViewModel> listSPView = new ArrayList<>();
        listSPView = listSP.stream().map((SanPham sanPham) -> new SanPhamViewModel(sanPham.getMaSP(), sanPham.getTenSP())).collect(Collectors.toList());
        return listSPView;
    }

}
