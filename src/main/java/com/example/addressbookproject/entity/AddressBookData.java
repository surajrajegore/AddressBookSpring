package com.example.addressbookproject.entity;

import com.example.addressbookproject.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public @Data class AddressBookData {

    @Id
    public int personId;
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zipCode;
    public String phoneNumber;
    public String emailId;

    public AddressBookData() {

    }
    public AddressBookData(int personId, AddressBookDTO addressBookDTO) {
        this.personId = personId;
        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipCode = addressBookDTO.zipCode;
        this.phoneNumber = addressBookDTO.phoneNumber;
        this.emailId = addressBookDTO.emailId;
    }

}
