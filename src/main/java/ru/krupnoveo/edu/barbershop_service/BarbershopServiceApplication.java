package ru.krupnoveo.edu.barbershop_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BarbershopServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarbershopServiceApplication.class, args);
    }

}
