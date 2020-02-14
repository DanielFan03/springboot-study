package org.transformers.di.impl;

import org.springframework.stereotype.Component;
import org.transformers.di.Animal;

@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("dog[" + Dog.class.getSimpleName() + "] is used to watch door.");
    }
}
