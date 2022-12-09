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
import lps.sistemalocacaoimpressora.model.Impressora;

public class ImpressoraDAO implements IDao {

    EntityManager entityManager;
    EntityManagerFactory factory;
    Query qry;
    String sql;

    public ImpressoraDAO() {
        this.factory = Persistence.createEntityManagerFactory("sistema-impressora");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public void save(Object obj) {
        Impressora impressora = (Impressora) obj;
        
        this.entityManager.getTransaction().begin();
        if (impressora != null && impressora.getId() > 0) {
            this.entityManager.merge(impressora);
        } else {
            this.entityManager.persist(impressora);
        }
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Object obj) {
        Impressora impressora = (Impressora) obj;
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(impressora);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Object find(int id) {
        sql = " SELECT i "
                + " FROM Impressora i "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);

        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Impressora) lst.get(0);
        }
    }

    public List<Impressora> findAll() {
        sql = " SELECT i "
                + " FROM Impressora i ";

        qry = this.entityManager.createQuery(sql);

        List lst = qry.getResultList();
        return (List<Impressora>) lst;
    }


    public Object findByNome(String nome) {
        sql = " SELECT i "
                + " FROM Impressora i "
                + " WHERE nome like :nome ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("nome", nome);
        List lst = qry.getResultList();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Impressora) lst.get(0);
        }
    }
}
