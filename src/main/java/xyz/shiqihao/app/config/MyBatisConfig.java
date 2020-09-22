package xyz.shiqihao.app.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.Reader;

@Configuration
@MapperScan("xyz.shiqihao.app.dao")
public class MyBatisConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        return new SqlSessionFactoryBuilder().build(reader);
    }

    // @Bean
    // public SqlSessionFactory _sqlSessionFactory() throws Exception {
    //     SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    //     factoryBean.setDataSource(dataSource());
    //     return factoryBean.getObject();
    // }
    //
    // @Bean
    // @ConfigurationProperties("postgresql.datasource")
    // public DataSource dataSource() {
    //     return DataSourceBuilder.create().build();
    // }
}
