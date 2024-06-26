package org.example.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Global {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_exercice02");
    public static EntityManager em = emf.createEntityManager();
}