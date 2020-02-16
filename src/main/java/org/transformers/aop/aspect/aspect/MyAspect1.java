package org.transformers.aop.aspect.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class MyAspect1 {

    @Pointcut("execution(* org.transformers.aop.aspect.service.impl.UserServiceImpl.manyAspects(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("MyAspect1.before");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("MyAspect1.after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("MyAspect1.afterReturning");
    }
}
