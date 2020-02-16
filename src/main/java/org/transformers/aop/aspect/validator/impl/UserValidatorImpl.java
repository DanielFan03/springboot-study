package org.transformers.aop.aspect.validator.impl;

import org.transformers.aop.aspect.pojo.User;
import org.transformers.aop.aspect.validator.UserValidator;

public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validate(User user) {
        System.out.println("introducing new interfaces " + UserValidator.class.getSimpleName());
        return null != user;
    }
}
