/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import java.util.List;
import domainModel.NSX;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import jdbc.DBContext;

/**
 *
 * @author Duongntt
 */
public class NSXRepository {

    public List<NSX> getAllNSX() {
        String query = "(SELECT NSX.Id, Ma,Ten FROM NSX)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            List<NSX> listNSX = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listNSX.add(new NSX(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listNSX;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addNSX(NSX nsx) {
        int check = 0;
        String query = "INSERT INTO NSX(Ma,Ten) VAlUES (?,?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, nsx.getMaNSX());
            ps.setObject(2, nsx.getTenNSX());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateNSX(NSX nsx, String idNSX) {
        int check = 0;
        String query = "UPDATE NSX SET Ma = ?, Ten = ? WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, nsx.getMaNSX());
            ps.setObject(2, nsx.getTenNSX());
            ps.setObject(3, idNSX);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean deleteNSX(String idNSX) {
        int check = 0;
        String query = "DELETE FROM NSX WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idNSX);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        System.out.println(new NSXRepository().deleteNSX("NSX2"));
        List<NSX> listNSX = new NSXRepository().getAllNSX();
        for (NSX nsx : listNSX) {
            System.out.println(nsx.toString());
        }
//        NSX nsx = new NSX("", "NSX2", "Nhà Sản Xuất 2");
//        System.out.println(new NSXRepository().updateNSX(nsx, "NSX2_Update"));
    }
}
