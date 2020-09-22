package xyz.shiqihao.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        String res = "hello, world!";
        return res;
    }

    @GetMapping("/lyj")
    public String lyj() {
        String res = "hello, lyj!";
        return res;
    }
}
