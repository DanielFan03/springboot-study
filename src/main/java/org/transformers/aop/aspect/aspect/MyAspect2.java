package org.transformers.aop.aspect.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Order(3)
public class MyAspect2 {

    @Pointcut("execution(* org.transformers.aop.aspect.service.impl.UserServiceImpl.manyAspects(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("MyAspect2.before");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("MyAspect2.after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("MyAspect2.afterReturning");
    }

}
