package com.example.markethub1.customer.exceptions;

public class NoSuchCustomerExistsException extends RuntimeException{
    public NoSuchCustomerExistsException() {
        super();
    }

    public NoSuchCustomerExistsException(String message) {
        super(message);
    }
}
