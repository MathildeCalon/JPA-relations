package org.example.controllers;

import org.example.entity.Address;
import org.example.entity.Client;
import org.example.repository.ClientRepository;

import java.util.List;
import java.util.Scanner;

public class ClientController {
    private ClientRepository clientRepository;
    private Scanner scanner;

    public ClientController(){
        clientRepository = new ClientRepository();
        scanner = new Scanner(System.in);
    }

    public void newClient(){
        System.out.println("Quel prénom ?");
        String firstname = scanner.next();
        System.out.println("Quel nom ?");
        String lastname = scanner.next();
        System.out.println("Quel âge ?");
        int age = scanner.nextInt();
        System.out.println("Quel numéro de téléphone ?");
        String telephone = scanner.next();
        System.out.println("Quelle addresse ?");
        System.out.println("Quelle rue ?");
        String street = scanner.next();
        System.out.println("Quelle ville ?");
        String city = scanner.next();
        Address address = Address.builder()
                .street(street)
                .city(city)
                .build();

        Client client = Client.builder()
                .firstname(firstname)
                .lastname(lastname)
                .age(age)
                .telephone(telephone)
                .address(address)
                .build();

        clientRepository.create(client);
    }

    public void displayClient(int clientId){
        System.out.println(clientRepository.getById(clientId));
    }

    public void displayAllClient(){
        List<Client> list = clientRepository.getAll();
        for(Object client : list){
            System.out.println(client);
        }
    }

    public void deleteClient(){
        System.out.println("Quel id ?");
        int clientId = scanner.nextInt();
        clientRepository.removeClient(clientId);
    }
}
