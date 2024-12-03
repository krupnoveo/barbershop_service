package ru.krupnoveo.edu.barbershop_service.api.dto.response;

import java.util.List;

public record ListServiceResponse(
        List<ServiceResponse> services
) {
}
