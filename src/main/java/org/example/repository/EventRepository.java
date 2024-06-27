package org.example.repository;

import org.example.entity.Event;

import javax.persistence.EntityTransaction;
import static org.example.util.Global.em;

public class EventRepository {
    public static void create(Event event){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
    }

    public static Event getById(int id) {
        return em.find(Event.class,id);
    }

}
