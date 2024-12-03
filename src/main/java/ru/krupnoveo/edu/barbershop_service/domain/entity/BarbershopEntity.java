package ru.krupnoveo.edu.barbershop_service.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.krupnoveo.edu.barbershop_service.api.dto.response.BarbershopResponse;

import java.util.UUID;

@Data
@Entity
@Table(name = "barbershops")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BarbershopEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "working_time", nullable = false)
    private String workingTime;

    @Column(name = "photo")
    private String photo;

    public BarbershopResponse toDto() {
        return new BarbershopResponse(
                id,
                name,
                address,
                phoneNumber,
                workingTime
        );
    }
}
