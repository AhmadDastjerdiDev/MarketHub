package com.example.markethub1.product.exceptions;

public class NoSuchProductExistsException extends RuntimeException{
    public NoSuchProductExistsException() {
        super();
    }

    public NoSuchProductExistsException(String message) {
        super(message);
    }
}
