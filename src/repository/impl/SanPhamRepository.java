/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import domainModel.ChucVu;
import domainModel.SanPham;
import repository.ICRUD;

/**
 *
 * @author Duongntt
 */
public class SanPhamRepository implements ICRUD<SanPham> {

    @Override
    public List<SanPham> getAll() {
        String query = "SELECT SanPham.Id, Ma, Ten FROM SanPham";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            List<SanPham> listSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listSP.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listSP;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SanPham getOneSP(String idSP) {
        String query = "SELECT SanPham.Id, Ma, Ten FROM SanPham WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idSP);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new SanPham(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(SanPham sp) {
        int check = 0;
        String query = "INSERT INTO SanPham(Ma, Ten) VALUES (?,?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(SanPham sp, String idSP) {
        int check = 0;
        String query = "UPDATE SanPham SET Ma = ?, Ten = ? WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String idSP) {
        int check = 0;
        String query = "DELETE FROM SanPham WHERE Id  = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        SanPham sp = new SanPhamRepository().getOneSP("80BB9926-BCD4-42A9-9357-19D2A6E9F504");
        System.out.println(sp.toString());
//        System.out.println(new SanPhamRepository().deleteSp("SP2_Update"));
//        List<SanPham> listSP = new SanPhamRepository().getAllSP();
//        for (SanPham sanPham : listSP) {
//            System.out.println(sanPham.toString());
//        }
    }
}
