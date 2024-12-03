package ru.krupnoveo.edu.barbershop_service.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.krupnoveo.edu.barbershop_service.api.dto.response.ServiceResponse;

import java.util.UUID;

@Entity
@Table(name = "services")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "grade1_price", nullable = false)
    private int firstGradePrice;

    @Column(name = "grade2_price", nullable = false)
    private int secondGradePrice;

    @Column(name = "grade3_price", nullable = false)
    private int thirdGradePrice;

    @Column(name = "average_time", nullable = false)
    private int averageTime;

    public ServiceResponse toDto() {
        return new ServiceResponse(
                id,
                name,
                description,
                firstGradePrice,
                secondGradePrice,
                thirdGradePrice,
                averageTime
        );
    }
}
