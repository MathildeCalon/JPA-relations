package org.example.controllers;

import org.example.entity.Event;
import org.example.repository.EventRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EventController {
    private EventRepository eventRepository;
    private Scanner scanner;

    public EventController(){
        eventRepository = new EventRepository();
        scanner = new Scanner(System.in);
    }

    public void newEvent(){
        System.out.println("Quel nom ?");
        String name = scanner.next();
        System.out.println("Quelle date ?");
        String date = scanner.next();
        System.out.println("Quelle heure ?");
        String time = scanner.next();
        System.out.println("Combien de billets ?");
        int tickets = scanner.nextInt();

        Event event = Event.builder()
                .name(name)
                .date(LocalDate.parse(date))
                .hour(time)
                .ticketNumber(tickets)
                .build();

        eventRepository.create(event);
    }

    public void deleteEvent(){
        System.out.println("Quel id d'évènement ?");
        int eventId = scanner.nextInt();
        eventRepository.removeEvent(eventId);
    }

    public void displayOneEvent(){
        System.out.println("Quel id d'évènement");
        int eventId = scanner.nextInt();
        System.out.println(eventRepository.getById(eventId));
    }

    public void displayAllEvent(){
        List<Event> list = eventRepository.getAll();
        for(Object event : list){
            System.out.println(event);
        }
    }
}
