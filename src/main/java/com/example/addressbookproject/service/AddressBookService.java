package com.example.addressbookproject.service;

import com.example.addressbookproject.dto.AddressBookDTO;
import com.example.addressbookproject.entity.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{
    @Override
    public List<AddressBookData> getAddressBookData() {
        List<AddressBookData> addressBookList = new ArrayList<>();
        addressBookList.add(new AddressBookData(1,new AddressBookDTO("Suraj", "Rajegore", "Shelgaon", "Pune", "Maharashtra", 431704, 766378377L, "rajegoresuraj2880@gmail.com")));
        return addressBookList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(1,new AddressBookDTO("Suraj", "Rajegore", "Shelgaon", "Pune", "Maharashtra", 431704, 766378377L, "rajegoresuraj2880@gmail.com"));
        return addressBookData;
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(1, addressBookDTO);
        return addressBookData;
    }

    @Override
    public void deleteAddressBookData(int personId) {

    }

    @Override
    public AddressBookData updateAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(1, addressBookDTO);
        return addressBookData;
    }
}
