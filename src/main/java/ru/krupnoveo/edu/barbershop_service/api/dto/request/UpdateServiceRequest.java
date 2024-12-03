package ru.krupnoveo.edu.barbershop_service.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateServiceRequest(
        String name,
        String description,
        @JsonProperty("first_grade_price") int firstGradePrice,
        @JsonProperty("second_grade_price") int secondGradePrice,
        @JsonProperty("third_grade_price") int thirdGradePrice,
        @JsonProperty("average_time") int averageTime
) {
}
