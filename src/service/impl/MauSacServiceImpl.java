/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import domainModel.MauSac;
import java.util.ArrayList;
import java.util.stream.Collectors;
import repository.impl.MauSacRepository;
import service.ConvertObject;
import service.MauSacService;
import util.ThongBao;
import viewModel.MauSacViewModel;

/**
 *
 * @author Duongntt
 */
public class MauSacServiceImpl implements MauSacService, ConvertObject<MauSacViewModel, MauSac> {

    private MauSacRepository mauSacRep = new MauSacRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<MauSac> getAllMauSac() {
        return mauSacRep.getAll();
    }

    @Override
    public String themMauSac(MauSac mauSac) {
        return thongBao.thongBaoKqThem(mauSacRep.add(mauSac));
    }

    @Override
    public String updateMauSac(MauSac mauSac, String idMauSac) {
        return thongBao.thongBaoKqUpdate(mauSacRep.update(mauSac, idMauSac));
    }

    @Override
    public String deleteMauSac(String idMS) {
        return thongBao.thongBaoKqDelete(mauSacRep.delete(idMS));
    }

    @Override
    public List<MauSacViewModel> convertOb(List<MauSac> listMauSac) {
        List<MauSacViewModel> listMauSacView = new ArrayList<>();
        listMauSacView = listMauSac.stream().map((MauSac mauSac)
                -> new MauSacViewModel(mauSac.getMaMauSac(), mauSac.getTenMauSac())).collect(Collectors.toList());
        return listMauSacView;
    }

}
