package ru.fkjob.delivery.rest.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import ru.fkjob.delivery.rest.dto.file.FileMetadataDto;

@Component
public class FileClientImpl implements FileClient {

    @Value("${file-store.auth.username}")
    private String fileStoreUsername;
    @Value("${file-store.auth.password}")
    private String fileStorePassword;
    private String token;

    private final WebClient fileWebClient;

    public FileClientImpl(WebClient fileWebClient) {
        this.fileWebClient = fileWebClient;
    }

    @Override
    public FileMetadataDto uploadFile(Resource resource) {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("file", resource);
        return fileWebClient
                .post()
                .uri("/file/save")
//                .header(HttpHeaders.AUTHORIZATION, getAuthToken())
                .body(BodyInserters.fromMultipartData(builder.build()))
                .retrieve()
                .bodyToMono(FileMetadataDto.class)
                .block();
    }

    @Override
    public Resource downloadFile(String fileId) {
        return fileWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/file/{fileId}")
                        .build(fileId))
//                .header(HttpHeaders.AUTHORIZATION,  getAuthToken())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        clientResponse -> Mono.just(new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Не удалось получить файл. Возможно, он был удален.")))
                .bodyToMono(Resource.class)
                .block();
    }

    @Override
    public String deleteFile(String fileId) {
        return fileWebClient
                .delete()
                .uri(uriBuilder -> uriBuilder
                        .path("/file/{fileId}")
                        .build(fileId))
//                .header(HttpHeaders.AUTHORIZATION, getAuthToken())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        clientResponse -> Mono.just(new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Не удалось получить файл. Возможно, он был удален.")))
                .bodyToMono(String.class)
                .block();
    }

//TODO: включить как будет секурити

//    private String getAuthToken() {
//        if (token == null || token.isBlank()) {
//            AuthRequestDto authRequest = new AuthRequestDto(fileStoreUsername, fileStorePassword);
//            token = fileWebClient
//                    .post()
//                    .uri("/auth/login")
//                    .body(Mono.just(authRequest), AuthRequestDto.class)
//                    .retrieve()
//                    .bodyToMono(String.class)
//                    .block();
//        }
//        return "Basic " + token;
//    }
}
