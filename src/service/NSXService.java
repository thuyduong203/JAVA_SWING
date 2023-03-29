/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import domainModel.NSX;

/**
 *
 * @author Duongntt
 */
public interface NSXService {

    List<NSX> getAllNSX();

    String themNsx(NSX nsx);

    String updateNSX(NSX nsx, String idNSX);

    String deleteNsx(String idNsx);
}
