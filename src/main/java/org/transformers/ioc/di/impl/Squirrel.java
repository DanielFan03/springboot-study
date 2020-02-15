package org.transformers.ioc.di.impl;

import org.transformers.ioc.di.Animal;

public class Squirrel implements Animal {
    @Override
    public void use() {
        System.out.println("squirrel can collect pinecone/松鼠可以采集松果");
    }
}
