package org.example.controllers;

import org.example.entity.Address;
import org.example.entity.Client;
import org.example.repository.ClientRepository;

public class ClientController {
    public void newClient(String firstname, String lastname, int age, String telephone, Address address){
        Client client = Client.builder()
                .firstname(firstname)
                .lastname(lastname)
                .age(age)
                .telephone(telephone)
                .address(address)
                .build();

        ClientRepository.create(client);
    }
}
