package ru.krupnoveo.edu.barbershop_service.service;

import ru.krupnoveo.edu.barbershop_service.api.dto.request.CreateServiceRequest;
import ru.krupnoveo.edu.barbershop_service.api.dto.response.ServiceResponse;

import java.util.List;
import java.util.UUID;

public interface ServiceService {

    ServiceResponse getServiceById(UUID id);

    List<ServiceResponse> getAllServices();

    ServiceResponse createService(CreateServiceRequest request);

    ServiceResponse updateService(UUID id, CreateServiceRequest request);

    ServiceResponse deleteService(UUID id);
}
