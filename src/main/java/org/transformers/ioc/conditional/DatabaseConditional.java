package org.transformers.ioc.conditional;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DatabaseConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 取出环境配置
        Environment environment = context.getEnvironment();
        // 判断属性文件是否存在对应的数据库配置
        return environment.containsProperty("database.driverName")
                && environment.containsProperty("database.url")
                && environment.containsProperty("database.username")
                && environment.containsProperty("database.password");
    }
}
