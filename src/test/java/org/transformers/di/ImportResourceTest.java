package org.transformers.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.transformers.config.AppConfig;
import org.transformers.di.impl.Squirrel;

public class ImportResourceTest {
    @Test
    public void testImport() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Squirrel squirrel = ctx.getBean(Squirrel.class);
        System.out.println(squirrel);
    }
}
