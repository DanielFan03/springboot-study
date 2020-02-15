package org.transformers.entity;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.transformers.config.AppConfig;
import org.transformers.di.Person;
import org.transformers.di.impl.BusinessPerson;
import org.transformers.service.impl.UserServiceImpl;

import javax.sql.DataSource;

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

    @Test
    public void testService() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserServiceImpl userService = ctx.getBean(UserServiceImpl.class);
        logger.info(userService.toString());
    }

    @Test
    public void testDataSource() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        DataSource dataSource = ctx.getBean(DataSource.class);
        logger.info(dataSource.toString());
    }

    @Test
    public void testDI() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = ctx.getBean(BusinessPerson.class);
        person.service();
    }

    @Test
    public void testSpringEL() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SpringELBean bean = ctx.getBean(SpringELBean.class);
        System.out.println(bean);
    }

}
