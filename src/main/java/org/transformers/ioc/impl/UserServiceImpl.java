package org.transformers.ioc.impl;

import org.springframework.stereotype.Component;
import org.transformers.ioc.entity.User;

/**
 * 使用@Service就不会被扫描到Spring IoC容器中；
 * 而使用@Component就会被Spring IoC托管；
 */
//@Service
@Component
public class UserServiceImpl {

    public void printUser(User user) {
        System.out.println("id:" + user.getId());
        System.out.println("userName:" + user.getUserName());
        System.out.println("note" + user.getNote());
    }

}
