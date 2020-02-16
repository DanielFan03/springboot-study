package org.transformers.aop.demo;

import org.junit.jupiter.api.Test;
import org.transformers.aop.demo.interceptor.impl.MyInterceptor;
import org.transformers.aop.demo.proxy.ProxyBean;
import org.transformers.aop.demo.service.HelloService;
import org.transformers.aop.demo.service.impl.HelloServiceImpl;

public class TestProxy {
    @Test
    public void testProxy() {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("John");
        System.out.println("************");
        proxy.sayHello(null);

        /*
         * MyInterceptor.before
         * MyInterceptor.around - before
         * hello John
         * MyInterceptor.around - after
         * MyInterceptor.after
         * MyInterceptor.afterReturning
         * ************
         * MyInterceptor.before
         * MyInterceptor.around - before
         * MyInterceptor.after
         * MyInterceptor.afterThrowing
         */
    }

}
