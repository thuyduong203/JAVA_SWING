/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import com.sun.tools.javac.Main;
import java.util.List;
import domainModel.MauSac;

/**
 *
 * @author Duongntt
 */
public interface MauSacService {

    List<MauSac> getAllMauSac();

    String themMauSac(MauSac mauSac);

    String updateMauSac(MauSac mauSac, String idMauSac);

    String deleteMauSac(String idMS);
}
