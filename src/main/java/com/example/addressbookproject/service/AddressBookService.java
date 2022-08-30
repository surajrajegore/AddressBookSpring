package com.example.addressbookproject.service;

import com.example.addressbookproject.dto.AddressBookDTO;
import com.example.addressbookproject.entity.AddressBookData;
import com.example.addressbookproject.exception.AddressBookException;
import com.example.addressbookproject.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{

    @Autowired
    AddressBookRepository addressBookRepository;



    @Override
    public List<AddressBookData> getAddressBookData() {
       return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
       return addressBookRepository.findById(personId).orElseThrow(()->new AddressBookException("personid does not exist "+personId));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookDTO);
        log.debug("AddressBook "+addressBookData.toString());
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public void deleteAddressBookData(int personId) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookRepository.delete(addressBookData);

    }

    @Override
    public AddressBookData updateAddressBookData(int personId,AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);


    }
}
