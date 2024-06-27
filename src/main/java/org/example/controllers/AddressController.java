package org.example.controllers;

import org.example.entity.Address;
import org.example.repository.AddressRepository;
import org.example.repository.ClientRepository;

import java.util.List;
import java.util.Scanner;

public class AddressController {
    private AddressRepository addressRepository;
    private Scanner scanner;

    public AddressController(){
        addressRepository = new AddressRepository();
        scanner = new Scanner(System.in);
    }


    public void newAddress(){
        System.out.println("Quelle rue ?");
        String street = scanner.next();
        System.out.println("Quelle ville ?");
        String city = scanner.next();
        Address address = Address.builder()
                .city(city)
                .street(street)
                .build();

        addressRepository.create(address);
    }

    public void displayAddress(){
        System.out.println("Quel id d'adresse ?");
        int addressId = scanner.nextInt();
        System.out.println(addressRepository.getById(addressId));
    }

    public void displayAllAddress(){
        List<Address> list = addressRepository.getAll();
        for(Object address : list){
            System.out.println(address);
        }
    }

    public void deleteAddress(){
        System.out.println("Quel id d'adresse ?");
        int addressId = scanner.nextInt();
        addressRepository.removeAddress(addressId);
    }
}