package ru.fkjob.delivery.rest.service.minio;

import io.minio.*;
import io.minio.http.Method;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URI;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class MinioService {
    private final MinioClient minioClient;
    private final String bucketName;

    String endpoint = "http://localhost:9000";
    String accessKey = "minioadmin";
    String secretKey = "minioadmin";
    String bucket = "delivery";


    public MinioService() {
        this.minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
        this.bucketName = bucket;
    }

    @SneakyThrows
    public String uploadFile(final MultipartFile file) {
        createBucketIfNotExists();
        String objectName = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        try (InputStream stream = file.getInputStream()) {
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .stream(stream, file.getSize(), -1)
                    .contentType(MediaType.IMAGE_JPEG_VALUE)
                    .build());
        }

        return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .method(Method.GET)
                .build());
    }

    @SneakyThrows
    public void deleteFile(final String url) {
        URI uri = new URI(url);
        String bucketName = uri.getHost();
        String objectName = uri.getPath().substring(1);

        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .build());
    }

    @SneakyThrows
    private void createBucketIfNotExists() {
        boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }
}

