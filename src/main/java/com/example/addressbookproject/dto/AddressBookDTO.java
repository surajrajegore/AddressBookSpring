package com.example.addressbookproject.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public @Data class AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = " first name is Invalid")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\\\s]{2,}$", message = "last Name is Invalid")
    public String lastName;
    @NotBlank(message = "Address not be empty")
    public String address;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "city name must be valid")
    public String city;
    @NotBlank(message = "state name not be empty")
    public String state;
    @Pattern(regexp = "\\d{6}",message = "Enter valid zipcode")
    public String zipCode;
    @Pattern(regexp = "^[789][0-9]{9}$",message = "Enter valid mobile number")
    public String phoneNumber;
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "Email Id Is Invalid")
    public String emailId;

}
