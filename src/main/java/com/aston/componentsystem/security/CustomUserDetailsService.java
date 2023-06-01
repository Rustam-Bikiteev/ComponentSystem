package com.aston.componentsystem.security;

import com.aston.componentsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        log.info("Получение пользователя по username: {}", login);
        return new CustomUserDetails(userRepository.findByLogin(login).orElseThrow(
                () -> new UsernameNotFoundException("Пользователь с логином <" + login + "> не найден")));
    }
}
