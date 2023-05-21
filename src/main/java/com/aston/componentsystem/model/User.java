package com.aston.componentsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.Builder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@AllArgsConstructor
@Table(name = "users")
@NoArgsConstructor
@SQLDelete(sql = "UPDATE users SET is_removed = true WHERE id=?")
@Where(clause = "is_removed=false")
public class User  {

    @Column(name = "is_removed", nullable = false)
    boolean isRemoved = Boolean.FALSE;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

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
