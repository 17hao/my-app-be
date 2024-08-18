package xyz.shiqihao.app.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.shiqihao.app.dto.UserDto;
import xyz.shiqihao.app.form.UserForm;
import xyz.shiqihao.app.service.UserService;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService service;

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/deleted-users")
    public List<UserDto> getDeletedUsers() {
        return service.findAllDeletedUsers();
    }

    @PostMapping("/users")
    public UserDto addUser(@RequestBody UserForm userForm) {
        return service.insert(userForm);
    }
}
