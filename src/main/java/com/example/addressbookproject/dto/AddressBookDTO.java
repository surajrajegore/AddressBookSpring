package com.example.addressbookproject.dto;


import lombok.Data;

public @Data class AddressBookDTO {
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public int zipCode;
    public Long phoneNumber;
    public String emailId;

}
