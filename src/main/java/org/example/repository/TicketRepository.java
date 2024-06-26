package org.example.repository;

import org.example.entity.Client;
import org.example.entity.Ticket;

import javax.persistence.EntityTransaction;
import static org.example.util.Global.em;

public class TicketRepository {
    public static void create(Ticket ticket){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ticket);
        transaction.commit();
    }

    public static Ticket getById(int id) {
        return em.find(Ticket.class,id);
    }
}
