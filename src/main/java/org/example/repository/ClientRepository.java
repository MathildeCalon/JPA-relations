package org.example.repository;

import org.example.entity.Client;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.List;

import static org.example.util.Global.em;

public class ClientRepository {

    public void create(Client client){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(client);
        transaction.commit();
    }

    public void removeClient(int clientId){
        Client clientToRemove = em.find(Client.class, clientId);
        em.remove(clientToRemove);
        em.getTransaction().commit();
    }

    public Client getById(int id) {
        return em.find(Client.class,id);
    }

    public List<Client> getAll(){
        Query query = em.createQuery("select c from Client c");
        List<Client> resultList = query.getResultList();
        return resultList;
    }
}
