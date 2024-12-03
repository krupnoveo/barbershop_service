package ru.krupnoveo.edu.barbershop_service.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.krupnoveo.edu.barbershop_service.api.dto.request.CreateServiceRequest;
import ru.krupnoveo.edu.barbershop_service.api.dto.response.ListServiceResponse;
import ru.krupnoveo.edu.barbershop_service.api.dto.response.ServiceResponse;
import ru.krupnoveo.edu.barbershop_service.service.ServiceService;

import java.util.UUID;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> getServiceById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(serviceService.getServiceById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<ListServiceResponse> getAllServices() {
        return ResponseEntity.ok().body(
                new ListServiceResponse(serviceService.getAllServices())
        );
    }

    @PostMapping("/new")
    public ResponseEntity<ServiceResponse> createService(@RequestBody CreateServiceRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceService.createService(request));
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<ServiceResponse> updateService(@PathVariable UUID id, @RequestBody CreateServiceRequest request) {
        return ResponseEntity.ok().body(serviceService.updateService(id, request));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<ServiceResponse> deleteService(@PathVariable UUID id) {
        return ResponseEntity.ok().body(serviceService.deleteService(id));
    }
}