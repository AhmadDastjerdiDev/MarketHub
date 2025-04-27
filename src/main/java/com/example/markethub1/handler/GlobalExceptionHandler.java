package com.example.markethub1.handler;

import com.example.markethub1.customer.exceptions.CustomerAlreadyExistsException;
import com.example.markethub1.customer.exceptions.NoSuchCustomerExistsException;
import com.example.markethub1.order.exception.NoSuchOrderExistsException;
import com.example.markethub1.order.exception.OrderAlreadyExistsException;
import com.example.markethub1.product.exceptions.NoSuchProductExistsException;
import com.example.markethub1.product.exceptions.ProductAlreadyExistsException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchCustomerExistsException.class)
    public ResponseEntity<GeneralResponseDTO> handleCustomerNotFoundException(NoSuchCustomerExistsException exception, HttpServletRequest request) {
        GeneralResponseDTO generalResponseDTO = new GeneralResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(generalResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchOrderExistsException.class)
    public ResponseEntity<GeneralResponseDTO> handleOrderNotFoundException(NoSuchOrderExistsException exception, HttpServletRequest request){
        GeneralResponseDTO generalResponseDTO = new GeneralResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(generalResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchProductExistsException.class)
    public ResponseEntity<GeneralResponseDTO> handleProductNotFoundException(NoSuchProductExistsException exception, HttpServletRequest request){
        GeneralResponseDTO generalResponseDTO = new GeneralResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(generalResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<GeneralResponseDTO> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception, HttpServletRequest request){
        GeneralResponseDTO generalResponseDTO = new GeneralResponseDTO(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(generalResponseDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(OrderAlreadyExistsException.class)
    public ResponseEntity<GeneralResponseDTO> handleOrderAlreadyExistsException(OrderAlreadyExistsException exception, HttpServletRequest request){
        GeneralResponseDTO generalResponseDTO = new GeneralResponseDTO(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(generalResponseDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<GeneralResponseDTO> handleProductAlreadyExistsException(ProductAlreadyExistsException exception, HttpServletRequest request){
        GeneralResponseDTO generalResponseDTO = new GeneralResponseDTO(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(generalResponseDTO, HttpStatus.CONFLICT);
    }

}
