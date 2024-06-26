package org.example;

import org.example.entity.Address;
import org.example.entity.Client;
import org.example.repository.ClientRepository;

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
                .address(address1)
                .build();

        Client client2 = Client.builder()
                .firstname("Lea")
                .lastname("Delval")
                .age(2)
                .telephone("23456789")
                .address(address1)
                .build();

//            ClientRepository.create(client2);
            System.out.println(ClientRepository.getById(12));

    }
}