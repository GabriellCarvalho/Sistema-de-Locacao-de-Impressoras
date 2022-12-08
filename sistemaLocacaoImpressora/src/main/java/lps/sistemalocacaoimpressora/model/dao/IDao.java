/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.dao;

public interface IDao {

    public void save(Object obj);

    public void delete(Object obj);

    public Object find(int id);

}
