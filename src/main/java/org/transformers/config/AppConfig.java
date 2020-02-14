package org.transformers.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.transformers.entity.User;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
// 将UserServiceImpl类排出在Spring IoC容器外
@ComponentScan(basePackages = "org.transformers.*",
        excludeFilters = {@Filter(classes = Service.class)},
        lazyInit = true)
public class AppConfig {

    @Bean(name = "user")
    public User initUser() {
        User user = new User();
        user.setId(1L);
        user.setUserName("Smith");
        user.setNote("note");
        return user;
    }

    // 自定义第三方Bean
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        Properties props = new Properties();
        props.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/spring");
        props.setProperty("username", "root");
        props.setProperty("password", "tiger");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}
