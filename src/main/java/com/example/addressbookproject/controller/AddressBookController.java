package com.example.addressbookproject.controller;

import com.example.addressbookproject.dto.AddressBookDTO;
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
    ResponseEntity<String> getAddressBookData(){
        return new ResponseEntity<String>("Get call success ", HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<String> createAddressBookData(@RequestBody AddressBookDTO addressBookDTO){
        return new ResponseEntity<String>("Data created Successfully "+addressBookDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteAddressBookData(@PathVariable("personId") int personId){
        return new ResponseEntity<String>("Data deleted for id "+personId,HttpStatus.OK);
    }

    @PutMapping("/update")
    ResponseEntity<String> updateAddressBookData(@RequestBody AddressBookDTO addressBookDTO){
        return new ResponseEntity<String>("Update data Successfully" +addressBookDTO,HttpStatus.OK);
    }

}
