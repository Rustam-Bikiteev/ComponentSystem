package com.aston.componentsystem.repository;
import com.aston.componentsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
public abstract class UserRepository implements JpaRepository<User, Integer> {

    public abstract Optional<User> findByLogin(String username);

    public abstract Boolean existsByLogin(String username);
}
