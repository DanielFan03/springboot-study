package org.transformers.aop.demo.interceptor.impl;

import org.transformers.aop.demo.interceptor.Interceptor;
import org.transformers.aop.demo.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("MyInterceptor.before");
        return true;
    }

    @Override
    public void after() {
        System.out.println("MyInterceptor.after");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("MyInterceptor.around - before");
        Object obj = invocation.proceed();
        System.out.println("MyInterceptor.around - after");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("MyInterceptor.afterReturning");
    }

    @Override
    public void afterThrowing() {
        System.out.println("MyInterceptor.afterThrowing");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
