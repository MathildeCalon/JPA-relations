package org.example.repository;

import org.example.entity.Client;
import org.example.entity.Ticket;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.List;

import static org.example.util.Global.em;

public class TicketRepository {
    public void create(Ticket ticket){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ticket);
        transaction.commit();
    }

    public Ticket getById(int id) {
        return em.find(Ticket.class,id);
    }

    public void getTicketByEvent(int eventId){
        Query query = em.createQuery("select t from Ticket t where id_event= :eventId");
        query.setParameter("eventId", eventId);
        List<Ticket> resultList = query.getResultList();
        for(Object ticket : resultList){
            System.out.println(ticket);
        }
    }
}
