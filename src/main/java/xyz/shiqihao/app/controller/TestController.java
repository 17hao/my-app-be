package xyz.shiqihao.app.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class AddressDTO implements Serializable {
        String country;
        String city;
    }

    @GetMapping("/test")
    public List<AddressDTO> test() {
        List<AddressDTO> res = new ArrayList<>();
        res.add(new AddressDTO("CN", "HZ"));
        res.add(new AddressDTO("USA", "LA"));
        return res;
    }

    @GetMapping("/lyj")
    public String lyj() {
        return "hello, lyj!";
    }
}
