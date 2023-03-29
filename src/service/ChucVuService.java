/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import domainModel.ChucVu;
import viewModel.ChucVuViewModel;

/**
 *
 * @author Admin
 */
public interface ChucVuService<T> {

    List<T> getAllCV();

    String addCV(T chucVu);

    String updateCV(T chucVu, String maCV);

    String deleteCV(String maCV);

    
}
