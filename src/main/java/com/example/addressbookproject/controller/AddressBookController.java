package com.example.addressbookproject.controller;

import com.example.addressbookproject.dto.AddressBookDTO;
import com.example.addressbookproject.dto.AddressBookResponseDTO;
import com.example.addressbookproject.entity.AddressBookData;
import com.example.addressbookproject.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressBookController")
public class AddressBookController {
    @Autowired
    private IAddressBookService addressBookService;
    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Hello Welcome to the address book";
    }

    @RequestMapping(value = {"","/","/get"})
    ResponseEntity<AddressBookResponseDTO> getAddressBookData(){
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressBookData();
        AddressBookResponseDTO addressBookResponseDTO = new AddressBookResponseDTO("Getting data..", addressBookDataList);
        return new ResponseEntity<AddressBookResponseDTO>(addressBookResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<AddressBookResponseDTO> getAddressBookData(@PathVariable("personId")int personId){
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.getAddressBookDataById(personId);
        AddressBookResponseDTO addressBookResponseDTO = new AddressBookResponseDTO("Getting Id data Successful...", addressBookData);
        return new ResponseEntity<AddressBookResponseDTO>(addressBookResponseDTO, HttpStatus.OK);    }

    @PostMapping("/create")
    ResponseEntity<AddressBookResponseDTO> createAddressBookData(@RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.createAddressBookData(addressBookDTO);
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
        addressBookData = addressBookService.updateAddressBookData(addressBookDTO);
        AddressBookResponseDTO addressBookResponseDTO = new AddressBookResponseDTO("Updated record successfully ",addressBookData);
        return new ResponseEntity<AddressBookResponseDTO>(addressBookResponseDTO,HttpStatus.OK);
    }

}
