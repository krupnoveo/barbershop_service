package ru.krupnoveo.edu.barbershop_service.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateBarbershopRequest(
    String name,
    String address,
    @JsonProperty("phone_number") String phoneNumber,
    @JsonProperty("working_time") String workingTime
) {
}
