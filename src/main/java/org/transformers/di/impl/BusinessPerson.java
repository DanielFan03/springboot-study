package org.transformers.di.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.transformers.di.Animal;
import org.transformers.di.Person;

@Component
public class BusinessPerson implements Person {

//    @Autowired
//    @Qualifier("dog")
    private Animal animal;

    public BusinessPerson(@Autowired @Qualifier("dog") Animal animal) {
        this.animal = animal;
    }

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
