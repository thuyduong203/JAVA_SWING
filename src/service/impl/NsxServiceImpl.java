/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import domainModel.NSX;
import java.util.ArrayList;
import java.util.stream.Collectors;
import repository.impl.NSXRepository;
import service.ConvertObject;
import service.NSXService;
import util.ThongBao;
import viewModel.NSXViewModel;

/**
 *
 * @author Duongntt
 */
public class NsxServiceImpl implements NSXService, ConvertObject<NSXViewModel, NSX> {

    private NSXRepository nsxRep = new NSXRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<NSX> getAllNSX() {
        return nsxRep.getAllNSX();
    }

    @Override
    public String themNsx(NSX nsx) {
        return thongBao.thongBaoKqThem(nsxRep.addNSX(nsx));
    }

    @Override
    public String updateNSX(NSX nsx, String idNSX) {
        return thongBao.thongBaoKqUpdate(nsxRep.updateNSX(nsx, idNSX));
    }

    @Override
    public String deleteNsx(String idNsx) {
        return thongBao.thongBaoKqDelete(nsxRep.deleteNSX(idNsx));
    }

    @Override
    public List<NSXViewModel> convertOb(List<NSX> listNSX) {
        List<NSXViewModel> listNSXView = new ArrayList<>();
        listNSXView = listNSX.stream().map((NSX nsx) -> new NSXViewModel(nsx.getMaNSX(), nsx.getTenNSX())).collect(Collectors.toList());
        return listNSXView;
    }

}
