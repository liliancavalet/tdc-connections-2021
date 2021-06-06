package com.tdc.connections.javalevelup.GenericsExamples;

public class Person {
 
    String name;
    int height;

    public Person(String name, int height){
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person [height=" + height + ", name=" + name + "]";
    }
}

