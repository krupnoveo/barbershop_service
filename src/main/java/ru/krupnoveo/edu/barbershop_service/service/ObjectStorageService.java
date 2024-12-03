package ru.krupnoveo.edu.barbershop_service.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ObjectStorageService {

    InputStreamResource downloadBarbershopPhoto(String photoName);

    String uploadBarbershopPhoto(String oldPhotoName, MultipartFile photo);

    void deleteBarbershopPhoto(String photoName);
}
