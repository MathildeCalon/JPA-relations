package org.example;

import org.example.controllers.AddressController;
import org.example.controllers.ClientController;
import org.example.controllers.EventController;
import org.example.controllers.TicketController;


public class Main {
    public static void main(String[] args) {
        new EventController().newEvent();
        new TicketController().newTicket();
    }

    public void ihm(){
        System.out.println("1. Créer un utilisateur");
        System.out.println("2. Réserver un ticket");
        System.out.println("3. Consulter les évènements");
        System.out.println("4. ");

    }
}