package org.transformers.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.transformers.di", lazyInit = true)
public class LifeCycleConfig {

}
