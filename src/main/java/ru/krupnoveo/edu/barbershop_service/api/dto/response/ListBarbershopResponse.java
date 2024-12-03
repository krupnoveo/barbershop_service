package ru.krupnoveo.edu.barbershop_service.api.dto.response;

import java.util.List;

public record ListBarbershopResponse(
        List<BarbershopResponse> barbershops
) {
}
