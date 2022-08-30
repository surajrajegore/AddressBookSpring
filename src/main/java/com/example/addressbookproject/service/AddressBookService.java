package com.example.addressbookproject.service;

import com.example.addressbookproject.dto.AddressBookDTO;
import com.example.addressbookproject.entity.AddressBookData;
import com.example.addressbookproject.exception.AddressBookException;
import com.example.addressbookproject.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{

    @Autowired
    AddressBookRepository addressBookRepository;

    private List<AddressBookData> addressBookList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {
       return addressBookList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return addressBookList.stream()
                .filter(addressBookData -> addressBookData.getPersonId() == personId)
                .findFirst()
                .orElseThrow(() -> new          AddressBookException("User Not Found"));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookDTO);
        log.debug("AddressBook "+addressBookData.toString());
        addressBookList.add(addressBookData);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public void deleteAddressBookData(int personId) {
        addressBookList.remove(personId-1);
    }

    @Override
    public AddressBookData updateAddressBookData(int personId,AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookData.setFirstName(addressBookDTO.firstName);
        addressBookData.setLastName(addressBookDTO.lastName);
        addressBookData.setAddress(addressBookDTO.address);
        addressBookData.setCity(addressBookDTO.city);
        addressBookData.setState(addressBookDTO.state);
        addressBookData.setZipCode(addressBookDTO.zipCode);
        addressBookData.setPhoneNumber(addressBookDTO.phoneNumber);
        addressBookData.setEmailId(addressBookDTO.emailId);
        return addressBookData;
    }
}
