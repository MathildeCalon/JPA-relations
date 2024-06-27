package org.example;

import org.example.entity.Address;
import org.example.entity.Client;
import org.example.entity.Event;
import org.example.entity.Ticket;
import org.example.repository.AddressRepository;
import org.example.repository.ClientRepository;
import org.example.repository.EventRepository;
import org.example.repository.TicketRepository;
import org.example.util.Type;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Address address1 = Address.builder()
                .city("Thumeries")
                .street("Thélus")
                .build();


        Client client1 = Client.builder()
                .firstname("Adele")
                .lastname("Delval")
                .age(4)
                .telephone("12345678")
                .address(Address.builder()
                        .street("Pierre Brossolette")
                        .city("Thumeries")
                        .build())
                .build();

        Client client2 = Client.builder()
                .firstname("Lea")
                .lastname("Delval")
                .age(2)
                .telephone("23456789")
                .address(address1)
                .build();

        Ticket ticket1 = Ticket.builder()
                .type(Type.GOLD)
                .ticketNumber(31)
                .event(Event.builder()
                        .address(Address.builder()
                                .street("stade")
                                .city("Arras")
                                .build())
                        .name("Mainsquare")
                        .date(LocalDate.now())
                        .hour("midi")
                        .ticketNumber(10000)
                        .build())
                .client(client2)
                .build();

        Ticket ticket2 = Ticket.builder()
                .type(Type.GOLD)
                .ticketNumber(32)
                .event(EventRepository.getById(1))
                .client(client2)
                .build();


        AddressRepository.create(address1);
        ClientRepository.create(client1);
        ClientRepository.create(client2);
        TicketRepository.create(ticket1);
        TicketRepository.create(ticket2);
        TicketRepository.getTicketByEvent(1);
    }

    public void ihm(){
        System.out.println("1. Créer un utilisateur");
        System.out.println("2. Réserver un ticket");
        System.out.println("3. Consulter les évènements");
        System.out.println("4. ");

    }
}