package org.example.controllers;

import org.example.entity.Client;
import org.example.entity.Event;
import org.example.entity.Ticket;
import org.example.repository.ClientRepository;
import org.example.repository.EventRepository;
import org.example.repository.TicketRepository;
import org.example.util.Type;

import java.util.Scanner;

public class TicketController {
    private TicketRepository ticketRepository;
    private EventController eventController;
    private EventRepository eventRepository;
    private ClientRepository clientRepository;

    private Scanner scanner;

    public TicketController(){
        ticketRepository = new TicketRepository();
        eventController = new EventController();
        eventRepository = new EventRepository();
        clientRepository = new ClientRepository();
        scanner = new Scanner(System.in);
    }

    public void newTicket(){
        System.out.println("Quel type ?");
        System.out.println("1- Gold");
        System.out.println("2- Standard");
        System.out.println("3- VIP");
        int choice = scanner.nextInt();
        Enum<Type> type = null;
        switch (choice){
            case(1): type = Type.GOLD; break;
            case(2): type = Type.STANDARD; break;
            case(3): type = Type.VIP; break;
        }

        System.out.println("Quel numéro ?");
        int number = scanner.nextInt();

        System.out.println("Quel évènement ?");
        eventController.displayAllEvent();
        int eventId = scanner.nextInt();
        Event event = eventRepository.getById(eventId);

        System.out.println("Quel client ?");
        int clientId = scanner.nextInt();
        Client client = clientRepository.getById(clientId);

        Ticket ticket = Ticket.builder()
                .type(type)
                .ticketNumber(number)
                .event(event)
                .client(client)
                .build();

        ticketRepository.create(ticket);
    }
}
