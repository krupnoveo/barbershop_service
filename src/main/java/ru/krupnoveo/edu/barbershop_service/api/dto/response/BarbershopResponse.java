package ru.krupnoveo.edu.barbershop_service.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record BarbershopResponse(
        UUID id,
        String name,
        String description,
        String address,
        Double latitude,
        Double longitude,
        @JsonProperty("phone_number") String phoneNumber,
        @JsonProperty("working_time") String workingTime
) {
}
