package xyz.shiqihao.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.shiqihao.app.dto.LdapDto;

@RestController
public class LdapController {
    @GetMapping("/")
    public LdapDto login() {
        return new LdapDto(1, "test");
    }
}
