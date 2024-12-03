package ru.krupnoveo.edu.barbershop_service.api.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.krupnoveo.edu.barbershop_service.api.dto.request.CreateBarbershopRequest;
import ru.krupnoveo.edu.barbershop_service.api.dto.request.UpdateBarbershopRequest;
import ru.krupnoveo.edu.barbershop_service.api.dto.response.BarbershopResponse;
import ru.krupnoveo.edu.barbershop_service.api.dto.response.ListBarbershopResponse;
import ru.krupnoveo.edu.barbershop_service.service.BarbershopService;

import java.util.UUID;

@RestController
@RequestMapping("/barbershop")
@RequiredArgsConstructor
public class BarbershopController {

    private final BarbershopService barbershopService;

    @GetMapping("/{id}")
    public ResponseEntity<BarbershopResponse> getBarbershopById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(barbershopService.getBarbershopById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<ListBarbershopResponse> getAllBarbershops() {
        return ResponseEntity.ok().body(
                new ListBarbershopResponse(barbershopService.getAllBarbershops())
        );
    }

    @PostMapping("/new")
    public ResponseEntity<BarbershopResponse> createBarbershop(
            @RequestBody CreateBarbershopRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(barbershopService.createBarbershop(request));
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<BarbershopResponse> updateBarbershop(
            @PathVariable UUID id,
            @RequestBody UpdateBarbershopRequest request
    ) {
        return ResponseEntity.ok().body(barbershopService.updateBarbershop(id, request));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<BarbershopResponse> deleteBarbershop(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(barbershopService.deleteBarbershop(id));
    }

    @GetMapping("/{id}/photo")
    public ResponseEntity<InputStreamResource> getBarbershopPhoto(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(barbershopService.getBarbershopPhoto(id));
    }

    @PostMapping("/{id}/photo")
    public ResponseEntity<Void> setBarbershopPhoto(
            @PathVariable UUID id,
            @RequestParam(value = "photo") MultipartFile photo
    ) {
        barbershopService.uploadBarbershopPhoto(id, photo);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/photo")
    public ResponseEntity<Void> deleteBarbershopPhoto(
            @PathVariable UUID id
    ) {
        barbershopService.deleteBarbershopPhoto(id);
        return ResponseEntity.ok().build();
    }
}
