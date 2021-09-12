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

        Airport airport1 = new Airport(1, "Balice");

        Passenger alicja = new Passenger(1, "Alicja Alicja");
        Passenger monika = new Passenger(2, "Monika Ruda");

        alicja.setAirport(airport1);
        monika.setAirport(airport1);

        airport1.addPassanger(alicja);
        airport1.addPassanger(monika);

        Ticket ticket1 = new Ticket(1, "abc1234");
        Ticket ticket2 = new Ticket(2, "def5678");
        Ticket ticket3 = new Ticket(3, "ghi9101");

        monika.addTicket(ticket1);
        monika.addTicket(ticket2);
        alicja.addTicket(ticket3);

        entityManager.persist(airport1);
        entityManager.persist(alicja);
        entityManager.persist(monika);
        entityManager.persist(ticket1);
        entityManager.persist(ticket2);
        entityManager.persist(ticket3);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
