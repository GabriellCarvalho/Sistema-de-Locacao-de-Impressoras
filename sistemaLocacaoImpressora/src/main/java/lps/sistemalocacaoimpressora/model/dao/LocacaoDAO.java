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
import lps.sistemalocacaoimpressora.model.Locacao;
import lps.sistemalocacaoimpressora.model.LocacaoPJ;

public class LocacaoDAO implements IDao {

    EntityManager entityManager;
    EntityManagerFactory factory;
    Query qry;
    String sql;

    public LocacaoDAO() {
        this.factory = Persistence.createEntityManagerFactory("sistema-impressora");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public void save(Object obj) {
        Locacao locacao = (Locacao) obj;

        this.entityManager.getTransaction().begin();
        if (locacao != null && locacao.getId() > 0) {
            this.entityManager.merge(locacao);
        } else {
            this.entityManager.persist(locacao);
        }
        this.entityManager.getTransaction().commit();
    }
    
    public void savePJ(Object obj) {
        LocacaoPJ locacao = (LocacaoPJ) obj;

        this.entityManager.getTransaction().begin();
        if (locacao != null && locacao.getId() > 0) {
            this.entityManager.merge(locacao);
        } else {
            this.entityManager.persist(locacao);
        }
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Object obj) {
        Locacao locacao = (Locacao) obj;
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(locacao);
        this.entityManager.getTransaction().commit();
    }
    
    public void deletePJ(Object obj) {
        LocacaoPJ locacao = (LocacaoPJ) obj;
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(locacao);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Object find(int id) {
        sql = " SELECT l "
                + " FROM Locacao l "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);

        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Locacao) lst.get(0);
        }
    }
    
    public List<Locacao> findAll() {
        sql = " SELECT l "
                + " FROM Locacao l ";

        qry = this.entityManager.createQuery(sql);

        List lst = qry.getResultList();
        return (List<Locacao>) lst;
    }
    
    public List<LocacaoPJ> findAllPJ() {
        sql = " SELECT l "
                + " FROM LocacaoPJ l ";

        qry = this.entityManager.createQuery(sql);

        List lst = qry.getResultList();
        return (List<LocacaoPJ>) lst;
    }
}
