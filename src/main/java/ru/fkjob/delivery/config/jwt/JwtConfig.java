package ru.fkjob.delivery.config.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.fkjob.delivery.filter.jwt.JwtFilter;

@RequiredArgsConstructor
public class JwtConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final JwtProvider jwtProvider;
    private final UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity builder) {
        JwtFilter jwtFilter = new JwtFilter(jwtProvider, userDetailsService);
        builder.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
