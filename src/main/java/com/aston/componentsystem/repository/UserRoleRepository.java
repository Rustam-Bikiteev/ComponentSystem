package com.aston.componentsystem.repository;
import com.aston.componentsystem.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public abstract class UserRoleRepository implements JpaRepository<UserRole, Integer> {
    public abstract Optional<UserRole> findByName(String name);
}
