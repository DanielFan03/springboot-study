package org.transformers.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Service;
import org.transformers.conditional.DatabaseConditional;
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

    // Conditional Bean
    @Bean(name = "dataSourceConditional", destroyMethod = "close")
    @Conditional(DatabaseConditional.class)
    public BasicDataSource getDataSourceConditional(
            @Value("database.driverName") String driver,
            @Value("database.url") String url,
            @Value("database.username") String username,
            @Value("database.password") String password
    ) {
        Properties props = new Properties();
        props.setProperty("driverClassName", driver);
        props.setProperty("url", url);
        props.setProperty("username", username);
        props.setProperty("password", password);
        BasicDataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "dataSource1")
    @Profile("dev")
    public DataSource getDevDataSource() {
        return null;
    }

    @Bean(name = "dataSource1")
    @Profile("test")
    public DataSource getTestDataSource() {
        return null;
    }

}
