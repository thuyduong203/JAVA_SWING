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
import repository.ICRUD;

/**
 *
 * @author Admin
 */
public class ChucVuRepository implements ICRUD<ChucVu> {

    @Override
    public List<ChucVu> getAll() {
        String query = "SELECT ChucVu.Id, ChucVu.Ma, ChucVu.Ten FROM ChucVu";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            List<ChucVu> listCV = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCV.add(new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listCV;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(ChucVu chucVu) {
        int check = 0;
        String query = "INSERT INTO ChucVu (Ma, Ten) VALUES (?,?) ";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, chucVu.getMaCV());
            ps.setObject(2, chucVu.getTenCV());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(ChucVu chucVu, String idCV) {
        int check = 0;
        String query = "UPDATE ChucVu SET Ma = ?, Ten = ? WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, chucVu.getMaCV());
            ps.setObject(2, chucVu.getTenCV());
            ps.setObject(3, idCV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        String query = "DELETE FROM ChucVu WHERE Id = ?";
        try ( Connection cnn = DBContext.getConnection();  PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
    /////////----
    
}
