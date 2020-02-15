package org.transformers.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.transformers.config.AppConfig;

public class ScopeTest {
    @Test
    public void testScope() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ScopeBean bean1 = ctx.getBean(ScopeBean.class);
        ScopeBean bean2 = ctx.getBean(ScopeBean.class);
        System.out.println(bean1 == bean2);
    }
}
