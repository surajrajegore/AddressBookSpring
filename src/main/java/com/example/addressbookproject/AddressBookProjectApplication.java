package com.example.addressbookproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressBookProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication
                .run(AddressBookProjectApplication.class, args);
        log.info("Address Book App Started In {} Environment", context.getEnvironment().getProperty("environment"));
        log.info("AddressBook    DB User name is {} ", context.getEnvironment().getProperty("spring.datasource.username"));
    }

}