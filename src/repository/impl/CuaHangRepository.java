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
import domainModel.ChiTietSP;
import domainModel.CuaHang;
import repository.ICRUD;

/**
 *
 * @author Admin
 */
public class CuaHangRepository implements ICRUD<CuaHang> {

    @Override
    public List<CuaHang> getAll() {
        String query = "SELECT CuaHang.Id, CuaHang.Ma, CuaHang.Ten, CuaHang.DiaChi, CuaHang.ThanhPho, CuaHang.QuocGia "
                + "FROM CuaHang";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            List<CuaHang> listAllCH = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listAllCH.add(new CuaHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            return listAllCH;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(CuaHang cuaHang) {
        int check = 0;
        String query = "INSERT INTO CuaHang (Ma, Ten, DiaChi, ThanhPho, QuocGia) VALUES\n"
                + "	(?,?,?,?,?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, cuaHang.getMaCH());
            ps.setObject(2, cuaHang.getTenCH());
            ps.setObject(3, cuaHang.getDiaChi());
            ps.setObject(4, cuaHang.getThanhPho());
            ps.setObject(5, cuaHang.getQuocGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(CuaHang cuaHang, String idCH) {
        int check = 0;
        String query = "UPDATE CuaHang SET Ma = ?, Ten = ?, DiaChi = ?,ThanhPho = ?, QuocGia = ?\n"
                + "WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, cuaHang.getMaCH());
            ps.setObject(2, cuaHang.getTenCH());
            ps.setObject(3, cuaHang.getDiaChi());
            ps.setObject(4, cuaHang.getThanhPho());
            ps.setObject(5, cuaHang.getQuocGia());
            ps.setObject(6, idCH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        String query = "DELETE FROM CuaHang WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
