package ru.krupnoveo.edu.barbershop_service.api.exception;

import java.util.UUID;

public class BarbershopNotFoundException extends RuntimeException {

    public BarbershopNotFoundException(UUID id) {
        super("Барбершоп с id " + id + " не найден");
    }
}
