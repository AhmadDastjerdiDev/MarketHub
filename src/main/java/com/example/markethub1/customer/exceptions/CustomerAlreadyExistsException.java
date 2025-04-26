package com.example.markethub1.customer.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException{
    public CustomerAlreadyExistsException() {
        super();
    }

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
