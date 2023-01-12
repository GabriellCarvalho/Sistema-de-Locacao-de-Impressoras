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
import lps.sistemalocacaoimpressora.model.PessoaJuridica;

public class PJuridicaDAO implements IDao {

    EntityManager entityManager;
    EntityManagerFactory factory;
    Query qry;
    String sql;

    public PJuridicaDAO() {
        this.factory = Persistence.createEntityManagerFactory("sistema-impressora");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public void save(Object obj) {
        PessoaJuridica clienteJ = (PessoaJuridica) obj;
        this.entityManager.getTransaction().begin();
        if (clienteJ != null && clienteJ.getId() > 0) {
            this.entityManager.merge(clienteJ);
        } else {
            this.entityManager.persist(clienteJ);
        }
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Object obj) {
        PessoaJuridica clienteJ = (PessoaJuridica) obj;
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(clienteJ);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Object find(int id) {
        sql = " SELECT pj "
                + " FROM PessoaJuridica pj "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);

        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (PessoaJuridica) lst.get(0);
        }
    }
    
    public List<PessoaJuridica> findAll() {
        sql = " SELECT pj "
                + " FROM PessoaJuridica pj ";

        qry = this.entityManager.createQuery(sql);

        List lst = qry.getResultList();
        return (List<PessoaJuridica>) lst;
    }
    
     public Object findByCnpj(String cnpj) {
        sql = " SELECT pj "
                + " FROM PessoaJuridica pj "
                + " WHERE cnpj like :cnpj ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("cnpj", cnpj);
        List lst = qry.getResultList();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (PessoaJuridica) lst.get(0);
        }
    }

}
