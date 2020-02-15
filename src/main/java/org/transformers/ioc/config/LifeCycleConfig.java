package org.transformers.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.transformers.ioc.di", lazyInit = true)
public class LifeCycleConfig {

}
