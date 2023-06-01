//package com.aston.componentsystem.security;
//
//import com.aston.componentsystem.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        return new CustomUserDetails(userRepository.findByLogin(login).orElseThrow(
//                () -> new UsernameNotFoundException("Пользователь с логином <" + login + "> не найден")));
//    }
//}
