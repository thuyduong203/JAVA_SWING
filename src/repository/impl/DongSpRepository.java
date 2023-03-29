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
import domainModel.DongSP;
import repository.ICRUD;

/**
 *
 * @author Duongntt
 */
public class DongSpRepository implements ICRUD<DongSP> {

    @Override
    public List<DongSP> getAll() {
        String query = "SELECT DongSP.Id, Ma, Ten FROM DongSP";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            List<DongSP> listDongSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listDongSP.add(new DongSP(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listDongSP;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(DongSP dongSP) {
        int check = 0;
        String query = "INSERT INTO DongSP(Ma, Ten) VALUES (?,?)";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, dongSP.getMaDongSP());
            ps.setObject(2, dongSP.getTenDongSP());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(DongSP dongSP, String idDongSP) {
        int check = 0;
        String query = "UPDATE DongSP SET Ma = ?, Ten = ? WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, dongSP.getMaDongSP());
            ps.setObject(2, dongSP.getTenDongSP());
            ps.setObject(3, idDongSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String idDongSP) {
        int check = 0;
        String query = "DELETE FROM DongSP WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, idDongSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
