package xyz.shiqihao.common.config;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan("xyz.shiqihao")
@Log4j2
public class MyBatisConfig {
    @Bean(name = "dataSource")
    public DataSource buildDataSource(
            @Value("${db.my_db.url}") String url,
            @Value("${db.my_db.username}") String username,
            @Value("${db.my_db.password}") String password
    ) {
        log.info("MySQL configuration: url={}, username={}, password={}", url, username, password);

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        return ds;
    }

    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean buildSqlSessionFactoryBean(@Qualifier("dataSource") DataSource ds) {
        // TODO: SqlSessionFactoryBean vs SqlSessionFactory
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ds);
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager buildTransactionTemplate(@Qualifier("dataSource") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}
