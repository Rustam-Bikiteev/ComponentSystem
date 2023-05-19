package com.aston.componentsystem.dto;

import com.aston.componentsystem.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;




@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterDto extends AbstractDto {

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotNull
    private UserRole userRole;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String surName;



    @Email
    private String email;
}