package org.transformers.aop.aspect.service.impl;

import org.springframework.stereotype.Service;
import org.transformers.aop.aspect.pojo.User;
import org.transformers.aop.aspect.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if (null == user) {
            throw new IllegalArgumentException("check user parameter is null");
        }
        System.out.println(user);
    }
}
