package org.example.controllers;

import org.example.entity.Address;
import org.example.repository.AddressRepository;
import org.example.repository.ClientRepository;

import java.util.List;

public class AddressController {
    private AddressRepository addressRepository;

    public AddressController(){
        addressRepository = new AddressRepository();
    }


    public void newAddress(String street, String city){
        Address address = Address.builder()
                .city(city)
                .street(street)
                .build();

        addressRepository.create(address);
    }

    public void displayAddress(int addressId){
        System.out.println(addressRepository.getById(addressId));
    }

    public void displayAllAddress(){
        List<Address> list = addressRepository.getAll();
        for(Object address : list){
            System.out.println(address);
        }
    }

//    public void updateAddress(){
//
//    }

    public void deleteAddress(int addressId){
        addressRepository.removeAddress(addressId);
    }
}