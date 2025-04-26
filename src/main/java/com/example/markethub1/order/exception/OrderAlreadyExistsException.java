package com.example.markethub1.order.exception;

public class OrderAlreadyExistsException extends RuntimeException{
    public OrderAlreadyExistsException() {
        super();
    }

    public OrderAlreadyExistsException(String message) {
        super(message);
    }
}
