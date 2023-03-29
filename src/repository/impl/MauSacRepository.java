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
import domainModel.MauSac;
import repository.ICRUD;

/**
 *
 * @author Duongntt
 */
public class MauSacRepository implements ICRUD<MauSac>{

    @Override
    public List<MauSac> getAll() {
        String query = "(SELECT MauSac.Id, Ma,Ten FROM MauSac)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            List<MauSac> listMauSac = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listMauSac.add(new MauSac(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listMauSac;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(MauSac mauSac) {
        int check = 0;
        String query = "INSERT INTO MauSac(Ma,Ten) VALUES (?,?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, mauSac.getMaMauSac());
            ps.setObject(2, mauSac.getTenMauSac());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(MauSac mauSac, String idMS) {
        int check = 0;
        String query = "UPDATE MauSac SET Ma = ?, Ten = ? WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, mauSac.getMaMauSac());
            ps.setObject(2, mauSac.getTenMauSac());
            ps.setObject(3, idMS);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String idMS) {
        int check = 0;
        String query = "DELETE FROM MauSac WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idMS);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
