package com.clouway;

public class Dog {
    public final String name;

    public Dog(String name) {
        this.name = name;
    }

    public void bark(){
        System.out.println(name + " say Bau.");
    }
}
