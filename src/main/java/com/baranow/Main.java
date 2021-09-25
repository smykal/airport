package com.baranow;

import com.baranow.airport.Airport;
import com.baranow.airport.Passenger;
import com.baranow.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("persistence_unit_name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Passenger asia = new Passenger(1,"Bodzow");
        asia.setCity("Cracow");
        asia.setStreet("Forum");
        asia.setNumber("2323");
        asia.setZipcode("23-123");

        entityManager.persist(asia);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
