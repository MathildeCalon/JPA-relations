package org.example.repository;

import org.example.entity.Address;
import org.example.entity.Client;

import javax.persistence.EntityTransaction;
import static org.example.util.Global.em;


public class AddressRepository {
    public static void create(Address address){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(address);
        transaction.commit();
    }

    public static Address getById(int id) {
        return em.find(Address.class,id);
    }
}
