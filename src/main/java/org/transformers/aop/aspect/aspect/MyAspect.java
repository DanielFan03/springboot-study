package org.transformers.aop.aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.transformers.aop.aspect.pojo.User;
import org.transformers.aop.aspect.validator.UserValidator;
import org.transformers.aop.aspect.validator.impl.UserValidatorImpl;

@Aspect
public class MyAspect {

    @Pointcut("execution(* org.transformers.aop.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("MyAspect.before");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("MyAspect.after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("MyAspect.afterReturning");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("MyAspect.afterThrowing");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("MyAspect.around - before");
        // 回调目标对象原有方法
        jp.proceed();
        System.out.println("MyAspect.around - after");
    }

    /**
     * 实际顺序：
     * MyAspect.around - before
     * MyAspect.before
     * User{id=3, userName='Anna', note='note222'}
     * MyAspect.around - after
     * MyAspect.after
     * MyAspect.afterReturning
     * 期待顺序：
     * MyAspect.before
     * MyAspect.around - before
     * User{id=3, userName='Anna', note='note222'}
     * MyAspect.around - after
     * MyAspect.after
     * MyAspect.afterReturning
     */

    @DeclareParents(
            value = "org.transformers.aop.aspect.service.impl.UserServiceImpl+",
            defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Before("pointCut() && args(user)")
    public void beforeParam(JoinPoint point, User user) {
        Object[] args = point.getArgs();
        System.out.println("MyAspect.beforeParam");
    }
}
