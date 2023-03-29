/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Duongntt
 */
public interface ICRUD<T> {

    List<T> getAll();

    boolean add(T t);

    boolean update(T t, String id);

    boolean delete(String id);
}
