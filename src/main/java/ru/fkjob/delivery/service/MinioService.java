package ru.fkjob.delivery.service;

import org.springframework.web.multipart.MultipartFile;

public interface MinioService {
    String uploadFile(final MultipartFile file);

    void deleteFile(final String url);
}
