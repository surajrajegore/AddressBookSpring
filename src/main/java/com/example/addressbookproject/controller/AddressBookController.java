package com.example.addressbookproject.controller;

import com.example.addressbookproject.dto.AddressBookDTO;
import com.example.addressbookproject.dto.AddressBookResponseDTO;
import com.example.addressbookproject.entity.AddressBookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressBookController")
public class AddressBookController {

    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Hello Welcome to the address book";
    }

    @RequestMapping(value = {"","/","/get"})
    ResponseEntity<AddressBookResponseDTO> getAddressBookData(){
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(1,new AddressBookDTO("Suraj", "Rajegore", "Shelgaon", "Nanded", "Maharashtra", 42292, 12345678L, "akanksha@gmail.com"));
        AddressBookResponseDTO addressBookResponseDTO = new AddressBookResponseDTO("Getting Details Successfull",addressBookData);
        return new ResponseEntity<AddressBookResponseDTO>( addressBookResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<AddressBookResponseDTO> createAddressBookData(@RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(1,addressBookDTO);
        AddressBookResponseDTO addressBookResponseDTO = new AddressBookResponseDTO("created data successfull",addressBookData);
        return new ResponseEntity<AddressBookResponseDTO>(addressBookResponseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    ResponseEntity<AddressBookResponseDTO> deleteAddressBookData(@PathVariable("personId") int personId){
        AddressBookResponseDTO addressBookResponseDTO = new AddressBookResponseDTO("deleted record successfully","record id "+personId );
        return new ResponseEntity<AddressBookResponseDTO>(addressBookResponseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    ResponseEntity<AddressBookResponseDTO> updateAddressBookData(@PathVariable("personId")int personId,@RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(personId,addressBookDTO);
        AddressBookResponseDTO addressBookResponseDTO = new AddressBookResponseDTO("Updated record successfully ",addressBookData);
        return new ResponseEntity<AddressBookResponseDTO>(addressBookResponseDTO,HttpStatus.OK);
    }

}
