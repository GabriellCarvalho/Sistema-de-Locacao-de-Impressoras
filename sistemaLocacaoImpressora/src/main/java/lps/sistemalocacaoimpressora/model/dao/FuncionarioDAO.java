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
import lps.sistemalocacaoimpressora.model.Funcionario;

public class FuncionarioDAO implements IDao {

    EntityManager entityManager;
    EntityManagerFactory factory;
    Query qry;
    String sql;

    public FuncionarioDAO() {
        this.factory = Persistence.createEntityManagerFactory("sistema-impressora");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public void save(Object obj) {
        Funcionario funcionario = (Funcionario) obj;
        this.entityManager.getTransaction().begin();
        if (funcionario != null && funcionario.getId() > 0) {
            this.entityManager.merge(funcionario);
        } else {
            this.entityManager.persist(funcionario);
        }
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Object obj) {
        Funcionario funcionario = (Funcionario) obj;
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(funcionario);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Object find(int id) {
        sql = " SELECT f "
                + " FROM Funcionario f "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);

        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Funcionario) lst.get(0);
        }
    }

    public List<Funcionario> findAll() {
        sql = " SELECT f "
                + " FROM Funcionario f ";

        qry = this.entityManager.createQuery(sql);

        List lst = qry.getResultList();
        return (List<Funcionario>) lst;
    }

    public Object findByCpf(String cpf) {
        sql = " SELECT f "
                + " FROM Funcionario f "
                + " WHERE cpf like :cpf ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("cpf", cpf);
        List lst = qry.getResultList();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Funcionario) lst.get(0);
        }
    }
    public void update(Object obj) {
        ///
    }
}
