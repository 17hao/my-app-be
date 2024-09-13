package xyz.shiqihao;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Log4j2
public class MyApplication {

    public static void main(String[] args) {
        String springProfilesActive = System.getProperty("spring.profiles.active");
        if (springProfilesActive == null || springProfilesActive.isBlank()) {
            log.error("spring.profiles.active is null");
            System.exit(1);
        }

        SpringApplication.run(MyApplication.class, args);
    }

}
