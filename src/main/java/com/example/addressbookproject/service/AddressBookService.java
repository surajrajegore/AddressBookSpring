package com.example.addressbookproject.service;

import com.example.addressbookproject.dto.AddressBookDTO;
import com.example.addressbookproject.entity.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    private List<AddressBookData> addressBookList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {
       return addressBookList;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return addressBookList.get(personId-1);
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookList.size()+1, addressBookDTO);
        addressBookList.add(addressBookData);
        return addressBookData;
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
