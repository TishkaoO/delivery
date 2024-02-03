package ru.fkjob.delivery.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.fkjob.delivery.dto.baseuser.UserDto;
import ru.fkjob.delivery.service.auth.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/registration")
@Api(tags = "Регистрация")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService baseUserService;

    @ApiOperation("Создание (редактирование) пользователя")
    @PostMapping("/create")
    public Long createOrUpdateUser(@RequestBody UserDto request) {
        return baseUserService.createOrUpdateUser(request);
    }
}
