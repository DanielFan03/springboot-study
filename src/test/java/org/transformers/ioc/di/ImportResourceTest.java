package org.transformers.ioc.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.transformers.ioc.config.AppConfig;
import org.transformers.ioc.di.impl.Squirrel;

public class ImportResourceTest {
    @Test
    public void testImport() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Squirrel squirrel = ctx.getBean(Squirrel.class);
        System.out.println(squirrel);
    }
}
