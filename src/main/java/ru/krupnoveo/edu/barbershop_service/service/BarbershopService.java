package ru.krupnoveo.edu.barbershop_service.service;


import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;
import ru.krupnoveo.edu.barbershop_service.api.dto.request.CreateBarbershopRequest;
import ru.krupnoveo.edu.barbershop_service.api.dto.request.UpdateBarbershopRequest;
import ru.krupnoveo.edu.barbershop_service.api.dto.response.BarbershopResponse;

import java.util.List;
import java.util.UUID;

public interface BarbershopService {

    BarbershopResponse getBarbershopById(UUID id);

    List<BarbershopResponse> getAllBarbershops();

    BarbershopResponse createBarbershop(CreateBarbershopRequest request);

    BarbershopResponse updateBarbershop(UUID id, UpdateBarbershopRequest request);

    BarbershopResponse deleteBarbershop(UUID id);

    InputStreamResource getBarbershopPhoto(UUID id);

    void uploadBarbershopPhoto(UUID id, MultipartFile photo);

    void deleteBarbershopPhoto(UUID id);
}
