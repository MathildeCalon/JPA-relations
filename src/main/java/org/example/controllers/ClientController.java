package org.example.controllers;

import org.example.entity.Address;
import org.example.entity.Client;
import org.example.repository.ClientRepository;

import java.util.List;

public class ClientController {
    private ClientRepository clientRepository;

    public ClientController(){
        clientRepository = new ClientRepository();
    }

    public void newClient(String firstname, String lastname, int age, String telephone, Address address){
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

    public void deleteClient(int clientId){
        clientRepository.removeClient(clientId);
    }
}
