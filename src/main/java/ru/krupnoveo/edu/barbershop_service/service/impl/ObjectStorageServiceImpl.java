package ru.krupnoveo.edu.barbershop_service.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.krupnoveo.edu.barbershop_service.service.ObjectStorageService;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@RequiredArgsConstructor
public class ObjectStorageServiceImpl implements ObjectStorageService {

    private final S3Client client;

    @Value("${cloud.aws.bucket.name}")
    private String bucketName;


    @Override
    public InputStreamResource downloadBarbershopPhoto(String photoName) {
        if (photoName == null) {
            return null;
        }
        GetObjectRequest getRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(photoName)
                .build();
        return new InputStreamResource(client.getObject(getRequest));
    }

    @Override
    @SneakyThrows
    public String uploadBarbershopPhoto(String oldPhotoName, MultipartFile photo) {
        if (oldPhotoName != null) {
            DeleteObjectRequest deleteRequest = DeleteObjectRequest.builder()
                    .bucket(bucketName)
                    .key(oldPhotoName)
                    .build();
            client.deleteObject(deleteRequest);
        }
        String fileName = System.currentTimeMillis() + "_" + photo.getOriginalFilename();
        PutObjectRequest putRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();
        client.putObject(putRequest, RequestBody.fromBytes(photo.getBytes()));
        return fileName;
    }

    @Override
    public void deleteBarbershopPhoto(String photoName) {
        if (photoName != null) {
            DeleteObjectRequest deleteRequest = DeleteObjectRequest.builder()
                    .bucket(bucketName)
                    .key(photoName)
                    .build();
            client.deleteObject(deleteRequest);
        }
    }
}