package ru.fkjob.delivery.service.impl;

import io.minio.*;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.fkjob.delivery.service.MinioService;

import java.io.InputStream;

import java.net.URL;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {
    private final MinioClient minioClient;

    @Value("${spring.minio.bucket}")
    private String bucket;


    @SneakyThrows
    @Override
    public String uploadFile(final MultipartFile file) {
        createBucketIfNotExists();
        String objectName = UUID.randomUUID().toString();
        InputStream stream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucket)
                    .object(objectName)
                    .stream(stream, file.getSize(), -1)
                    .build());
        return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                .bucket(bucket)
                .object(objectName)
                .method(Method.GET)
                .build());
    }

    @SneakyThrows
    @Override
    public void deleteFile(final String url) {
        URL url1 = new URL(url);
        String fileName = url1.getPath().substring(url1.getPath().lastIndexOf('/') + 1);
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(bucket)
                .object(fileName)
                .build());
    }

    @SneakyThrows
    private void createBucketIfNotExists() {
        boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
        }
    }
}

