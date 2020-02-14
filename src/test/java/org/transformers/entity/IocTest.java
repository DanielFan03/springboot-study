package org.transformers.entity;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.transformers.config.AppConfig;

public class IocTest {

    private static Logger logger = LoggerFactory.getLogger(IocTest.class);

    @Test
    public void testUser() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean(User.class);
        logger.info(user.toString());
    }

    @Test
    public void testComponentUser() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ComponentUser componentUser = ctx.getBean(ComponentUser.class);
        logger.info(componentUser.toString());
    }
}
