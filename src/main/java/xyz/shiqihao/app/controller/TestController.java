package xyz.shiqihao.app.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPooled;
import xyz.shiqihao.app.config.AppConfig;

@RestController
@AllArgsConstructor
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

    @Resource
    @Qualifier("devConfig")
    private AppConfig devConfig;

    @Resource
    @Qualifier("prodConfig")
    private AppConfig prodConfig;


    @GetMapping("/config/{env}")
    public AppConfig config(@PathVariable("env") String env) {
        if (env.equals("prod")) {
            return prodConfig;
        }
        return devConfig;
    }

    private final JedisPooled redisClient;

    @PostMapping("/redis/kv")
    public void setRedisValue(@RequestBody Map<String, String> request) {
        for (Map.Entry<String, String> kv : request.entrySet()) {
            redisClient.set(kv.getKey(), kv.getValue());
        }
    }

    @GetMapping("/redis/kv/{key}")
    public Map<String, String> getRedisValue(@PathVariable("key") String key) {
        Map<String, String> res = new HashMap<>();
        res.put(key, redisClient.get(key));
        return res;
    }
}
