package com.aston.componentsystem.controller;

import com.aston.componentsystem.model.User;
import com.aston.componentsystem.model.UserRole;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@Setter
@Getter
@AllArgsConstructor
@SecurityRequirement(name = "component-system-user-api")
public class UserController {
    List<User> users;
    private UserRole UserRole;

    {
        users.add(new User(false, 1,"Component-system-user1", "ADMIN", Set.of(UserRole),
                "Joe", "Steve", "Smith", "user1@test.com", LocalDateTime.now()));
        users.add(new User(false, 2,"Component-system-user1", "USER", Set.of(UserRole),
                "Jim", "Liam", "Doe", "user1@test.com", LocalDateTime.now()));
        users.add(new User(false, 3,"Component-system-user1", "USER", Set.of(UserRole),
                "Tim", "Albert", "Drake", "user1@test.com", LocalDateTime.now()));
        users.add(new User(false, 4,"Component-system-user1", "USER", Set.of(UserRole),
                "Lin", "Walter", "Lloyd", "user1@test.com", LocalDateTime.now()));
    }

    @RequestMapping(value = "/getUsers")
    public List<User> getUsers() {
        return users;
    }

    @RequestMapping(value = "/getUser/{id}")
    public User getUserById(@PathVariable(value = "id") int id) {
        return users.stream().filter(x -> x.getId()==(id)).toList().get(0);
    }

    @RequestMapping(value = "/getUser/role/{role}")
    public List<User> getUserByRole(@PathVariable(value = "role")UserRole UserRole) {
        return users.stream().filter(x -> x.getRoles().equals(Set.of(UserRole)))
                .collect(Collectors.toList());
    }
}
