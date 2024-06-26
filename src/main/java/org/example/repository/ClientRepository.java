package org.example.repository;

import org.example.entity.Client;

import javax.persistence.EntityTransaction;
import static org.example.util.Global.em;
import static org.example.util.Global.emf;


public class ClientRepository {

    public static void create(Client client){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(client);
        transaction.commit();
    }

    public static Client getById(int id) {
        return em.find(Client.class,id);
    }
}
