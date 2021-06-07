package com.tdc.connections.javalevelup.GenericsExamples;

public class Child extends Person {
 
    public Child(String name, int height) {
        super(name, height);
    }

    @Override
    public String toString() {
        return "Child [height=" + height + ", name=" + name + "]";
    }
}

