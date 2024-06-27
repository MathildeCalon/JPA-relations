package org.example.repository;

import org.example.entity.Address;
import org.example.entity.Client;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

import static org.example.util.Global.em;


public class AddressRepository {
    public void create(Address address){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(address);
        transaction.commit();
    }

    public List<Address> getAll(){
        Query query = em.createQuery("select a from Address a");
        List<Address> resultList = query.getResultList();
        return resultList;
    }

    public Address getById(int id) {
        return em.find(Address.class,id);
    }

    public void removeAddress(int addressId) {
        Address addressToRemove = em.find(Address.class, addressId);
        em.remove(addressToRemove);
        em.getTransaction().commit();
    }
}
