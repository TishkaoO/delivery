package ru.fkjob.delivery.service.auth.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.domain.auth.CustomUserDetails;
import ru.fkjob.delivery.service.auth.UserService;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final UserService baseUserService;

    public CustomUserDetailsServiceImpl(@Lazy UserService baseUserService) {
        this.baseUserService = baseUserService;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return baseUserService.getByUsername(username)
            .map(u -> CustomUserDetails.builder()
                .username(username)
                .password(u.getPassword())
                .grantedAuthorities(Arrays.stream(u.getRoles().split(";"))
                    .map(SimpleGrantedAuthority::new).collect(Collectors.toList()))
                .build()
            ).orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь не найдет с username = %s", username)));
    }
}
