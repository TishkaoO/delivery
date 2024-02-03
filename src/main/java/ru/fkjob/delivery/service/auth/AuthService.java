package ru.fkjob.delivery.service.auth;

public interface AuthService {
    Boolean login(String username, String password);
    void logout(String username);
}
