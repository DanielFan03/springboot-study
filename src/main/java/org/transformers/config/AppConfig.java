package org.transformers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.transformers.entity.User;

@Configuration
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
