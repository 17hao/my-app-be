package xyz.shiqihao.common.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("xyz.shiqihao")
@Log4j2
public class MyBatisConfig {
    @Bean
    public SqlSessionFactoryBean buildSqlSessionFactoryBean(
            @Value("${db.my_db.url}") String url,
            @Value("${db.my_db.username}") String username,
            @Value("${db.my_db.password}") String password
    ) {
        // TODO: SqlSessionFactoryBean vs SqlSessionFactory
        log.info("MySQL configuration: url={}, username={}, password={}", url, username, password);

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ds);
        return sqlSessionFactoryBean;
    }
}
