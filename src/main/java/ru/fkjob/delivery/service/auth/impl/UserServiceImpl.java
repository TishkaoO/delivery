package ru.fkjob.delivery.service.auth.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.domain.UserEntity;
import ru.fkjob.delivery.dto.baseuser.UserDto;
import ru.fkjob.delivery.exceptionhanding.customexception.BadRequestException;
import ru.fkjob.delivery.mappers.user.UserMapper;
import ru.fkjob.delivery.repository.UserRepository;
import ru.fkjob.delivery.service.auth.AuthService;
import ru.fkjob.delivery.service.auth.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, AuthService {
    private final UserMapper baseUserMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Boolean login(String username, String password) {
        return getByUsername(username)
            .map(u -> passwordEncoder.matches(password, u.getPassword()))
            .orElse(false);
    }

    @Override
    public Optional<UserEntity> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Long createOrUpdateUser(UserDto request) {
        return Optional.ofNullable(request.getUsername())
            .map(username ->
                    userRepository
                    .findByUsername(request.getUsername())
                    .map(user -> {
                        user.setRoles(request.getRoles());
                        user.setEmail(request.getEmail());
                        Optional.ofNullable(request.getPassword())
                            .ifPresent(p -> user.setPassword(passwordEncoder.encode(p)));
                        return userRepository.save(user).getId();
                    }).orElseGet(() -> {
                        UserEntity newUser = baseUserMapper.toEntity(request);
                        Optional.ofNullable(request.getPassword())
                            .ifPresentOrElse(p -> newUser.setPassword(passwordEncoder.encode(p)),
                                () -> { throw new BadRequestException("Пароль должен быть заполнен!"); });
                        return userRepository.save(newUser).getId();
                    })
                )
            .orElseThrow(() -> new BadRequestException("Логин должен быть заполнен!"));
    }

    @Override
    public void logout(String username) {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
