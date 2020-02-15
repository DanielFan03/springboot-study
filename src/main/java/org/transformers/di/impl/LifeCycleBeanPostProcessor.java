package org.transformers.di.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("LifeCycleBeanPostProcessor.postProcessBeforeInitialization ["
                + bean.getClass().getName() + "][" + beanName + "]");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("LifeCycleBeanPostProcessor.postProcessAfterInitialization["
                + bean.getClass().getName() + "][" + beanName + "]");
        return bean;
    }
}
