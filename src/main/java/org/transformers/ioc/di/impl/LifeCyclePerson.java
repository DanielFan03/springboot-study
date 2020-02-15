package org.transformers.ioc.di.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.transformers.ioc.di.Animal;
import org.transformers.ioc.di.Person;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCyclePerson implements Person, BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean {

    private Animal animal;

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        System.out.println("LifeCyclePerson.setAnimal lazyInit flag.");
        this.animal = animal;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("LifeCyclePerson.setBeanName BeanNameAware#setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("LifeCyclePerson.setBeanFactory BeanFactoryAware#setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("LifeCyclePerson.setApplicationContext ApplicationContextAware#setApplicationContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifeCyclePerson.afterPropertiesSet InitializingBean#afterPropertiesSet");
    }

    @PostConstruct
    public void customInit() {
        System.out.println("LifeCyclePerson.customInit @PostConstruct#customInit");
    }

    @PreDestroy
    public void customDestroy() {
        System.out.println("LifeCyclePerson.customDestroy @PreDestory#customDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("LifeCyclePerson.destroy DisposableBean#destroy");
    }
}
