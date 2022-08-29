package com.example.addressbookproject.dto;

import lombok.Data;

public @Data class AddressBookResponseDTO {
    private String message;
    private Object data;

    public AddressBookResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
