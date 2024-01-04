package ru.fkjob.delivery.rest.client;

import org.springframework.core.io.Resource;
import ru.fkjob.delivery.rest.dto.file.FileMetadataDto;

public interface FileClient {

    FileMetadataDto uploadFile(Resource resource);

    Resource downloadFile(String fileId);

    String deleteFile(String fileId);
}
