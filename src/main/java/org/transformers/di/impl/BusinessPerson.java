package org.transformers.di.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.transformers.di.Animal;
import org.transformers.di.Person;

@Component
public class BusinessPerson implements Person {
    @Autowired
    private Animal animal;

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
