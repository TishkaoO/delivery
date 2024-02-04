package ru.fkjob.delivery.controller;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fkjob.delivery.config.jwt.JwtProvider;
import ru.fkjob.delivery.dto.auth.AuthRequestDto;
import ru.fkjob.delivery.service.auth.AuthService;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
@Api(tags = "Авторизация")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtProvider jwtProvider;

    @ApiOperation("Авторизация пользователя")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequestDto request) {
        if (authService.login(request.getUsername(), request.getPassword())) {
            return ResponseEntity.ok(jwtProvider.generateToken(request.getUsername()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ApiOperation("Выход из системы")
    @GetMapping("/logout")
    public void logout(Principal principal) {
        authService.logout(principal.getName());
    }
}
