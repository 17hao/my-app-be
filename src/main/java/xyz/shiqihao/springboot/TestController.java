package xyz.shiqihao.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public String test() {
        String res = "hello, world!";
        log.info("parameter: {}", res);
        return res;
    }
}
