package ru.fkjob.delivery.rest.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.rest.client.FileClient;
import ru.fkjob.delivery.rest.dto.file.FileMetadataDto;
import ru.fkjob.delivery.rest.service.FileService;

@Service
public class FileServiceImpl implements FileService {

    private final FileClient fileClient;

    public FileServiceImpl(FileClient fileClient) {
        this.fileClient = fileClient;
    }

    @Override
    public FileMetadataDto uploadFile(Resource resource) {
        return fileClient.uploadFile(resource);
    }

    @Override
    public Resource downloadFile(String fileId) {
        return fileClient.downloadFile(fileId);
    }

    @Override
    public String deleteFile(String fileId) {
        return fileClient.deleteFile(fileId);
    }
}
