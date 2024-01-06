package ru.fkjob.delivery.rest.exception;

public class ImageUploadException extends RuntimeException {

    public ImageUploadException(final String message) {
        super(message);
    }

    public ImageUploadException(String message, Throwable cause) {
        super(message, cause);
    }
}
