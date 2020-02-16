package org.transformers.aop.service.impl;

import org.transformers.aop.service.HelloService;

/**
 * 2.接口实现类
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (null == name || name.trim() == "") {
            throw new RuntimeException("parameter is null.");
        }
        System.out.println("hello " + name);
    }
}
