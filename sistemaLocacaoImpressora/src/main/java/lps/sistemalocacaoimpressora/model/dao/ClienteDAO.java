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
import lps.sistemalocacaoimpressora.model.Cliente;

public class ClienteDAO implements IDao {

    EntityManager entityManager;
    EntityManagerFactory factory;
    Query qry;
    String sql;

    public ClienteDAO() {
        this.factory = Persistence.createEntityManagerFactory("sistema-impressora");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public void save(Object obj) {
        Cliente cliente = (Cliente) obj;
        this.entityManager.getTransaction().begin();
        if (cliente != null && cliente.getId() > 0) {
            this.entityManager.merge(cliente);
        } else {
            this.entityManager.persist(cliente);
        }
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Object obj) {
        Cliente cliente = (Cliente) obj;
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(cliente);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Object find(int id) {
        sql = " SELECT c "
                + " FROM Clinte c "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);

        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Cliente) lst.get(0);
        }
    }

    public List<Cliente> findAll() {
        sql = " SELECT c "
                + " FROM Cliente c ";

        qry = this.entityManager.createQuery(sql);

        List lst = qry.getResultList();
        return (List<Cliente>) lst;
    }

    public Object findByCpf(String cpf) {
        sql = " SELECT c "
                + " FROM Cliente c "
                + " WHERE cpf like :cpf ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("cpf", cpf);
        List lst = qry.getResultList();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Cliente) lst.get(0);
        }
    }

}
