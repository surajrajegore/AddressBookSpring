package com.example.addressbookproject.exception;

import com.example.addressbookproject.dto.AddressBookResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class AddressBookExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AddressBookResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        List<ObjectError> errorList = methodArgumentNotValidException.getBindingResult().getAllErrors();
        List<String> errorMessage = errorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        AddressBookResponseDTO addressBookResponseDTO = new AddressBookResponseDTO("Exception occure while processing the request",errorMessage);
        return new ResponseEntity<AddressBookResponseDTO>(addressBookResponseDTO, HttpStatus.BAD_REQUEST);
    }
}
