/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.dao;

import java.util.ArrayList;

public interface IDao {

    public void save(Object obj);

    public boolean delete(Object obj);

    public Object find(Object obj);

    public ArrayList<Object> findAll();
}
