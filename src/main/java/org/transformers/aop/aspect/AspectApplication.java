package org.transformers.aop.aspect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.transformers.aop.aspect.aspect.MyAspect;
import org.transformers.aop.aspect.aspect.MyAspect1;
import org.transformers.aop.aspect.aspect.MyAspect2;
import org.transformers.aop.aspect.aspect.MyAspect3;

@SpringBootApplication(scanBasePackages = {"org.transformers.aop.aspect"})
public class AspectApplication {

    // 定义切面
    @Bean(name = "myAspect")
    public MyAspect initMyAspect() {
        return new MyAspect();
    }

    public static void main(String[] args) {
        SpringApplication.run(AspectApplication.class, args);
    }

    /**
     * http://localhost:8080/user/print?id=3&userName=Anna&note=note222
     * <p>
     * MyAspect.before
     * User{id=3, userName='Anna', note='note222'}
     * MyAspect.after
     * MyAspect.afterReturning
     * <p>
     * http://localhost:8080/user/print
     * <p>
     * MyAspect.around - before
     * MyAspect.before
     * MyAspect.after
     * MyAspect.afterThrowing
     * 2020-02-16 18:50:48.291 DEBUG 3687 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Failed to complete request: java.lang.IllegalArgumentException: check user parameter is null
     * 2020-02-16 18:50:48.294 ERROR 3687 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.IllegalArgumentException: check user parameter is null] with root cause
     * <p>
     * java.lang.IllegalArgumentException: check user parameter is null
     */

    /**
     * MyAspect3.before
     * MyAspect1.before
     * MyAspect2.before
     * UserServiceImpl.manyAspects
     * MyAspect2.after
     * MyAspect2.afterReturning
     * MyAspect1.after
     * MyAspect1.afterReturning
     * MyAspect3.after
     * MyAspect3.afterReturning
     */

    @Bean("myAspect1")
    public MyAspect1 initMyAspect1() {
        return new MyAspect1();
    }

    @Bean("myAspect2")
    public MyAspect2 initMyAspect2() {
        return new MyAspect2();
    }

    @Bean("myAspect3")
    public MyAspect3 initMyAspect3() {
        return new MyAspect3();
    }

}
