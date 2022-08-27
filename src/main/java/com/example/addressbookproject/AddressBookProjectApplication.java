package com.example.addressbookproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookProjectApplication.class, args);
        System.out.println("Welcome to Address Book");
    }

}