package ru.krupnoveo.edu.barbershop_service.api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.krupnoveo.edu.barbershop_service.api.dto.response.ApiErrorResponse;
import ru.krupnoveo.edu.barbershop_service.api.exception.BarbershopNotFoundException;
import ru.krupnoveo.edu.barbershop_service.api.exception.ServiceNotFoundException;

@ControllerAdvice
public class BarbershopExceptionHandler {

    @ExceptionHandler(BarbershopNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiErrorResponse> handleBarbershopNotFoundException(BarbershopNotFoundException ex) {
        return new ResponseEntity<>(new ApiErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiErrorResponse> handleServiceNotFoundException(ServiceNotFoundException ex) {
        return new ResponseEntity<>(new ApiErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
