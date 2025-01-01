package xyz.shiqihao.app.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.shiqihao.common.ControllerTemplate;
import xyz.shiqihao.common.HttpResponse;
import xyz.shiqihao.app.dto.UserDto;
import xyz.shiqihao.app.form.UserForm;
import xyz.shiqihao.app.service.UserService;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService service;

    @GetMapping("/users/{id}")
    public HttpResponse<UserDto> getUserById(@PathVariable("id") String id) {
        return new ControllerTemplate<UserDto>() {
            @Override
            public UserDto biz() {
                return service.findById(Long.parseLong(id));
            }
        }.exec();
    }

    @GetMapping("/users")
    public HttpResponse<List<UserDto>> getAllUsers() {
        return new ControllerTemplate<List<UserDto>>() {
            @Override
            public List<UserDto> biz() {
                return service.findAllUsers();
            }
        }.exec();
    }

    @PostMapping("/users")
    public HttpResponse<Long> createUser(@RequestBody UserForm userForm) {
        return new ControllerTemplate<Long>() {
            @Override
            public Long biz() {
                return service.insert(userForm);
            }
        }.exec();
    }
}
