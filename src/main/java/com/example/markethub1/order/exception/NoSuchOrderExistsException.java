package com.example.markethub1.order.exception;

public class NoSuchOrderExistsException extends RuntimeException{
    public NoSuchOrderExistsException() {
        super();
    }

    public NoSuchOrderExistsException(String message) {
        super(message);
    }
}
