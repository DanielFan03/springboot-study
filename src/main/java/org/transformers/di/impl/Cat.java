package org.transformers.di.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.transformers.di.Animal;

@Component
@Primary
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("cat[" + Cat.class.getSimpleName() + "] is used to catch mouse.");
    }
}
