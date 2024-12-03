package ru.krupnoveo.edu.barbershop_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.krupnoveo.edu.barbershop_service.api.dto.request.CreateBarbershopRequest;
import ru.krupnoveo.edu.barbershop_service.api.dto.request.UpdateBarbershopRequest;
import ru.krupnoveo.edu.barbershop_service.api.dto.response.BarbershopResponse;
import ru.krupnoveo.edu.barbershop_service.api.exception.BarbershopNotFoundException;
import ru.krupnoveo.edu.barbershop_service.domain.entity.BarbershopEntity;
import ru.krupnoveo.edu.barbershop_service.domain.repository.JpaBarbershopRepository;
import ru.krupnoveo.edu.barbershop_service.service.BarbershopService;
import ru.krupnoveo.edu.barbershop_service.service.ObjectStorageService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@Transactional
@RequiredArgsConstructor
public class BarbershopServiceImpl implements BarbershopService {
    private final JpaBarbershopRepository barbershopRepository;
    private final ObjectStorageService objectStorageService;

    @Override
    public BarbershopResponse getBarbershopById(UUID id) {
        return getBarbershop(id).toDto();
    }

    @Override
    public List<BarbershopResponse> getAllBarbershops() {
        return barbershopRepository.findAll().stream().map(BarbershopEntity::toDto).toList();
    }

    @Override
    public BarbershopResponse createBarbershop(CreateBarbershopRequest request) {
        BarbershopEntity barbershop = new BarbershopEntity();
        barbershop.setName(request.name());
        barbershop.setAddress(request.address());
        barbershop.setPhoneNumber(request.phoneNumber());
        barbershop.setWorkingTime(request.workingTime());
        return barbershopRepository.save(barbershop).toDto();
    }

    @Override
    public BarbershopResponse updateBarbershop(UUID id, UpdateBarbershopRequest request) {
        BarbershopEntity barbershop = getBarbershop(id);
        barbershop.setName(request.name());
        barbershop.setAddress(request.address());
        barbershop.setPhoneNumber(request.phoneNumber());
        barbershop.setWorkingTime(request.workingTime());
        return barbershopRepository.save(barbershop).toDto();
    }

    @Override
    public BarbershopResponse deleteBarbershop(UUID id) {
        BarbershopEntity barbershop = getBarbershop(id);
        barbershopRepository.delete(barbershop);
        return barbershop.toDto();
    }

    @Override
    public InputStreamResource getBarbershopPhoto(UUID id) {
        BarbershopEntity barbershop = getBarbershop(id);
        return objectStorageService.downloadBarbershopPhoto(barbershop.getPhoto());
    }

    @Override
    public void uploadBarbershopPhoto(UUID id, MultipartFile photo) {
        BarbershopEntity barbershop = getBarbershop(id);
        String fileName = objectStorageService.uploadBarbershopPhoto(barbershop.getPhoto(), photo);
        barbershop.setPhoto(fileName);
        barbershopRepository.save(barbershop);
    }

    @Override
    public void deleteBarbershopPhoto(UUID id) {
        BarbershopEntity barbershop = getBarbershop(id);
        objectStorageService.deleteBarbershopPhoto(barbershop.getPhoto());
        barbershop.setPhoto(null);
        barbershopRepository.save(barbershop);
    }

    private BarbershopEntity getBarbershop(UUID id) {
        Optional<BarbershopEntity> barbershop = barbershopRepository.findById(id);
        return barbershop.orElseThrow(() -> new BarbershopNotFoundException(id));
    }
}
