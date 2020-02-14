package org.transformers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.transformers.entity.User;

@Configuration
// 将UserServiceImpl类排出在Spring IoC容器外
@ComponentScan(basePackages = "org.transformers.*",
        excludeFilters = {@Filter(classes = Service.class)})
public class AppConfig {

    @Bean(name = "user")
    public User initUser() {
        User user = new User();
        user.setId(1L);
        user.setUserName("Smith");
        user.setNote("note");
        return user;
    }

}
