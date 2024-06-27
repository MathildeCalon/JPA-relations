package org.example.repository;

import org.example.entity.Client;
import org.example.entity.Event;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

import static org.example.util.Global.em;

public class EventRepository {
    public void create(Event event){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
    }

    public Event getById(int id) {
        return em.find(Event.class,id);
    }

    public List<Event> getAll(){
        Query query = em.createQuery("select e from Event e");
        List<Event> resultList = query.getResultList();
        return resultList;
    }

    public void removeEvent(int eventId){
        Event eventToRemove = em.find(Event.class, eventId);
        em.remove(eventToRemove);
        em.getTransaction().commit();
    }

}
