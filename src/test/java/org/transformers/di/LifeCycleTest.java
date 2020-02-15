package org.transformers.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.transformers.config.LifeCycleConfig;
import org.transformers.di.impl.LifeCyclePerson;

public class LifeCycleTest {

    @Test
    public void testLifeCycle() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        ctx.getBean(LifeCyclePerson.class);
        ctx.close();
    }

    /**
     * lazyInit=false
     * 10:39:10.119 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@7f77e91b
     * 10:39:10.145 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
     * 10:39:10.292 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/daniel/Documents/workspace/idea201903/springboot-study/target/classes/org/transformers/di/impl/BusinessPerson.class]
     * 10:39:10.293 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/daniel/Documents/workspace/idea201903/springboot-study/target/classes/org/transformers/di/impl/Cat.class]
     * 10:39:10.294 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/daniel/Documents/workspace/idea201903/springboot-study/target/classes/org/transformers/di/impl/Dog.class]
     * 10:39:10.295 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/daniel/Documents/workspace/idea201903/springboot-study/target/classes/org/transformers/di/impl/LifeCycleBeanPostProcessor.class]
     * 10:39:10.297 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/daniel/Documents/workspace/idea201903/springboot-study/target/classes/org/transformers/di/impl/LifeCyclePerson.class]
     * 10:39:10.474 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerProcessor'
     * 10:39:10.480 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerFactory'
     * 10:39:10.484 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
     * 10:39:10.490 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
     * 10:39:10.497 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'lifeCycleBeanPostProcessor'
     * 10:39:10.518 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'lifeCycleConfig'
     * LifeCycleBeanPostProcessor.postProcessBeforeInitialization [org.transformers.config.LifeCycleConfig$$EnhancerBySpringCGLIB$$476e9395][lifeCycleConfig]
     * LifeCycleBeanPostProcessor.postProcessAfterInitialization[org.transformers.config.LifeCycleConfig$$EnhancerBySpringCGLIB$$476e9395][lifeCycleConfig]
     * 10:39:10.527 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'businessPerson'
     * 10:39:10.624 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'dog'
     * LifeCycleBeanPostProcessor.postProcessBeforeInitialization [org.transformers.di.impl.Dog][dog]
     * LifeCycleBeanPostProcessor.postProcessAfterInitialization[org.transformers.di.impl.Dog][dog]
     * BusinessPerson.setAnimal
     * LifeCycleBeanPostProcessor.postProcessBeforeInitialization [org.transformers.di.impl.BusinessPerson][businessPerson]
     * LifeCycleBeanPostProcessor.postProcessAfterInitialization[org.transformers.di.impl.BusinessPerson][businessPerson]
     * 10:39:10.627 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'cat'
     * LifeCycleBeanPostProcessor.postProcessBeforeInitialization [org.transformers.di.impl.Cat][cat]
     * LifeCycleBeanPostProcessor.postProcessAfterInitialization[org.transformers.di.impl.Cat][cat]
     * 10:39:10.628 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'lifeCyclePerson'
     * LifeCyclePerson.setBeanName BeanNameAware#setBeanName
     * LifeCyclePerson.setBeanFactory BeanFactoryAware#setBeanFactory
     * LifeCyclePerson.setApplicationContext ApplicationContextAware#setApplicationContext
     * LifeCycleBeanPostProcessor.postProcessBeforeInitialization [org.transformers.di.impl.LifeCyclePerson][lifeCyclePerson]
     * LifeCyclePerson.customInit @PostConstruct#customInit
     * LifeCyclePerson.afterPropertiesSet InitializingBean#afterPropertiesSet
     * LifeCycleBeanPostProcessor.postProcessAfterInitialization[org.transformers.di.impl.LifeCyclePerson][lifeCyclePerson]
     * 10:39:10.671 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@7f77e91b, started on Sat Feb 15 10:39:10 CST 2020
     * LifeCyclePerson.customDestroy @PreDestory#customDestroy
     * LifeCyclePerson.destroy DisposableBean#destroy
     *
     */

    /**
     * lazyInit=true
     * 10:41:07.125 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@7f77e91b
     * 10:41:07.155 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
     * 10:41:07.305 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/daniel/Documents/workspace/idea201903/springboot-study/target/classes/org/transformers/di/impl/BusinessPerson.class]
     * 10:41:07.306 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/daniel/Documents/workspace/idea201903/springboot-study/target/classes/org/transformers/di/impl/Cat.class]
     * 10:41:07.307 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/daniel/Documents/workspace/idea201903/springboot-study/target/classes/org/transformers/di/impl/Dog.class]
     * 10:41:07.307 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/daniel/Documents/workspace/idea201903/springboot-study/target/classes/org/transformers/di/impl/LifeCycleBeanPostProcessor.class]
     * 10:41:07.310 [main] DEBUG org.springframework.context.annotation.ClassPathBeanDefinitionScanner - Identified candidate component class: file [/Users/daniel/Documents/workspace/idea201903/springboot-study/target/classes/org/transformers/di/impl/LifeCyclePerson.class]
     * 10:41:07.486 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerProcessor'
     * 10:41:07.490 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerFactory'
     * 10:41:07.492 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
     * 10:41:07.495 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
     * 10:41:07.500 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'lifeCycleBeanPostProcessor'
     * 10:41:07.522 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'lifeCycleConfig'
     * LifeCycleBeanPostProcessor.postProcessBeforeInitialization [org.transformers.config.LifeCycleConfig$$EnhancerBySpringCGLIB$$476e9395][lifeCycleConfig]
     * LifeCycleBeanPostProcessor.postProcessAfterInitialization[org.transformers.config.LifeCycleConfig$$EnhancerBySpringCGLIB$$476e9395][lifeCycleConfig]
     * 10:41:07.622 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'lifeCyclePerson'
     * LifeCyclePerson.setBeanName BeanNameAware#setBeanName
     * LifeCyclePerson.setBeanFactory BeanFactoryAware#setBeanFactory
     * LifeCyclePerson.setApplicationContext ApplicationContextAware#setApplicationContext
     * LifeCycleBeanPostProcessor.postProcessBeforeInitialization [org.transformers.di.impl.LifeCyclePerson][lifeCyclePerson]
     * LifeCyclePerson.customInit @PostConstruct#customInit
     * LifeCyclePerson.afterPropertiesSet InitializingBean#afterPropertiesSet
     * LifeCycleBeanPostProcessor.postProcessAfterInitialization[org.transformers.di.impl.LifeCyclePerson][lifeCyclePerson]
     * 10:41:07.628 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@7f77e91b, started on Sat Feb 15 10:41:07 CST 2020
     * LifeCyclePerson.customDestroy @PreDestory#customDestroy
     * LifeCyclePerson.destroy DisposableBean#destroy
     */

}
