package ru.krupnoveo.edu.barbershop_service.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.krupnoveo.edu.barbershop_service.domain.entity.BarbershopEntity;

import java.util.UUID;

@Repository
public interface JpaBarbershopRepository extends JpaRepository<BarbershopEntity, UUID> {
}
