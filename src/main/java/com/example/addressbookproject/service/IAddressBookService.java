package com.example.addressbookproject.service;

import com.example.addressbookproject.dto.AddressBookDTO;
import com.example.addressbookproject.entity.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAddressBookData();
    AddressBookData getAddressBookDataById(int personId);
    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);
    void deleteAddressBookData(int personId);
    AddressBookData updateAddressBookData(AddressBookDTO addressBookDTO);

}
