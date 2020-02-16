package org.transformers.aop.aspect.validator;

import org.transformers.aop.aspect.pojo.User;

public interface UserValidator {
    // 检测用户对象是否为空
    boolean validate(User user);
}
