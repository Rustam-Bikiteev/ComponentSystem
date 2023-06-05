package com.aston.componentsystem.dto;

import com.aston.componentsystem.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterDto {

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    private UserRole userRole;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String surName;

    @Email
    private String email;

    @NotBlank
    private LocalDateTime last_visit;
}