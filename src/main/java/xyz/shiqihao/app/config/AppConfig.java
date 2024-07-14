package xyz.shiqihao.app.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class AppConfig {
    private String env;

    @Bean(name = "devConfig")
    public AppConfig devConfig() {
        AppConfig conf = new AppConfig();
        conf.env = "dev";
        return conf;
    }

    @Bean(name = "prodConfig")
    public AppConfig prodConfig() {
        AppConfig conf = new AppConfig();
        conf.env = "prod";
        return conf;
    }
}
