package xyz.shiqihao.app.beans;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Reader;

@Configuration
@MapperScan("xyz.shiqihao.app.dao")
public class MyBatis {
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
