package xyz.shiqihao.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import xyz.shiqihao.app.dto.UserDto;
import xyz.shiqihao.app.form.UserForm;
import xyz.shiqihao.app.service.UserService;

import java.util.List;

@RestController
@Configuration
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return service.findAllUsers();
    }

    @PostMapping("/users")
    public UserDto addUser(@RequestBody UserForm userForm) {
        return service.insert(userForm);
    }
}
