/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.dao;

import java.util.ArrayList;


public class ClienteDAO implements IDao{

    @Override
    public void save(Object obj) {
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public Object find(Object obj) {
        return null;
    }

    @Override
    public ArrayList<Object> findAll() {
        return null;
    }
    
    public Object findByCpf(String cpf){
        return null;
    }
    
    
}
