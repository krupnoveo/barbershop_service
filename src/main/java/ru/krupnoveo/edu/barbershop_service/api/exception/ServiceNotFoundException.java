package ru.krupnoveo.edu.barbershop_service.api.exception;

import java.util.UUID;

public class ServiceNotFoundException extends RuntimeException {

    public ServiceNotFoundException(UUID id) {
        super("Услуга с id " + id + " не найдена");
    }
}
