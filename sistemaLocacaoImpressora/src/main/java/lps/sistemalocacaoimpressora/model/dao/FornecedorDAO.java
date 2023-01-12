/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lps.sistemalocacaoimpressora.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import lps.sistemalocacaoimpressora.model.Fornecedor;

public class FornecedorDAO implements IDao {

    EntityManager entityManager;
    EntityManagerFactory factory;
    Query qry;
    String sql;

    public FornecedorDAO() {
        this.factory = Persistence.createEntityManagerFactory("sistema-impressora");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public void save(Object obj) {
        Fornecedor fornecedor = (Fornecedor) obj;
        this.entityManager.getTransaction().begin();
        if (fornecedor != null && fornecedor.getId() > 0) {
            this.entityManager.merge(fornecedor);
        } else {
            this.entityManager.persist(fornecedor);
        }
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Object obj) {
        Fornecedor fornecedor = (Fornecedor) obj;
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(fornecedor);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Object find(int id) {
        sql = " SELECT f "
                + " FROM Fornecedor f "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);

        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Fornecedor) lst.get(0);
        }
    }
    
    public List<Fornecedor> findAll() {
        sql = " SELECT f "
                + " FROM Fornecedor f ";

        qry = this.entityManager.createQuery(sql);

        List lst = qry.getResultList();
        return (List<Fornecedor>) lst;
    }
    
    public Object findByCnpj(String cnpj) {
        sql = " SELECT f "
                + " FROM Fornecedor f "
                + " WHERE cnpj like :cnpj ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("cnpj", cnpj);
        List lst = qry.getResultList();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Fornecedor) lst.get(0);
        }
    }
 

}
