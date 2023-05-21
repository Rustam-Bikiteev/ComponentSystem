package com.aston.componentsystem.controller;
import com.aston.componentsystem.dto.AuthResponseDTO;
import com.aston.componentsystem.dto.LoginDto;
import com.aston.componentsystem.dto.RegisterDto;
import com.aston.componentsystem.model.User;
import com.aston.componentsystem.model.UserRole;
import com.aston.componentsystem.repository.UserRepository;
import com.aston.componentsystem.repository.UserRoleRepository;
import com.aston.componentsystem.security.JwtGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    private final UserRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtGenerator jwtGenerator;

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getLogin(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByLogin(registerDto.getLogin())) {
            return ResponseEntity.badRequest().body("Такой логин уже занят!");
        }
        User user = new User();
        user.setLogin(registerDto.getLogin());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        UserRole roles = roleRepository.findByName(registerDto.getUserRole().getName())
                .orElseThrow(() -> new RuntimeException("Роль не найдена"));
        user.setRoles(Collections.singleton(roles));
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setSurName(registerDto.getSurName());
        user.setEmail(registerDto.getEmail());
        userRepository.save(user);
        return ResponseEntity.ok("Пользователь успешно зарегистрирован!");
    }
}
