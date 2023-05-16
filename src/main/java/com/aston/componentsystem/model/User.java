package com.aston.componentsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import java.time.LocalDateTime;
import java.util.Set;



@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@SQLDelete(sql = "UPDATE users SET is_removed = true WHERE id=?")
@Where(clause = "is_removed=false")
public class User extends AbstractEntity  {


    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<UserRole> roles;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "sur_name", nullable = false)
    private String surName;


    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "last_visit", nullable = false)
    private LocalDateTime lastVisit;



}
