package xyz.shiqihao.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;

@Configuration
public class RedisConfig {
    @Bean
    public JedisPooled buildRedisClient(
            @Value("${redis.host}") String host,
            @Value("${redis.port}") int port,
            @Value("${redis.password}") String password
    ) {
        return new JedisPooled(host, port, "default", password);
    }
}
