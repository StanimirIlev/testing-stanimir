package com.clouway;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class MyClass{

    private static final Logger logger = Logger.getLogger(MyClass.class);

    public static void main(String argv[]) {
        BasicConfigurator.configure();
        logger.debug("Hello world.");
        logger.info("What a beatiful day.");

        Dog dog = new Dog("Rex");
        dog.bark();
    }

}