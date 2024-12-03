package ru.krupnoveo.edu.barbershop_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.krupnoveo.edu.barbershop_service.api.dto.request.CreateServiceRequest;
import ru.krupnoveo.edu.barbershop_service.api.dto.response.ServiceResponse;
import ru.krupnoveo.edu.barbershop_service.api.exception.ServiceNotFoundException;
import ru.krupnoveo.edu.barbershop_service.domain.entity.ServiceEntity;
import ru.krupnoveo.edu.barbershop_service.domain.repository.JpaServiceRepository;
import ru.krupnoveo.edu.barbershop_service.service.ServiceService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final JpaServiceRepository serviceRepository;

    @Override
    public ServiceResponse getServiceById(UUID id) {
        return getService(id).toDto();
    }

    @Override
    public List<ServiceResponse> getAllServices() {
        return serviceRepository.findAll().stream().map(ServiceEntity::toDto).toList();
    }

    @Override
    public ServiceResponse createService(CreateServiceRequest request) {
        ServiceEntity service = new ServiceEntity();
        return getServiceResponse(request, service);
    }

    private ServiceResponse getServiceResponse(CreateServiceRequest request, ServiceEntity service) {
        service.setName(request.name());
        service.setDescription(request.description());
        service.setFirstGradePrice(request.firstGradePrice());
        service.setSecondGradePrice(request.secondGradePrice());
        service.setThirdGradePrice(request.thirdGradePrice());
        service.setAverageTime(request.averageTime());
        return serviceRepository.save(service).toDto();
    }

    @Override
    public ServiceResponse updateService(UUID id, CreateServiceRequest request) {
        ServiceEntity service = getService(id);
        return getServiceResponse(request, service);
    }

    @Override
    public ServiceResponse deleteService(UUID id) {
        ServiceEntity service = getService(id);
        serviceRepository.delete(service);
        return service.toDto();
    }

    private ServiceEntity getService(UUID id) {
        Optional<ServiceEntity> service = serviceRepository.findById(id);
        return service.orElseThrow(() -> new ServiceNotFoundException(id));
    }
}
