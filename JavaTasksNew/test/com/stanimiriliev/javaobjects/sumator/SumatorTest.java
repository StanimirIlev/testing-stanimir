package com.stanimiriliev.javaobjects.sumator;

import static org.junit.Assert.*;

public class SumatorTest {
    @org.junit.Test
    public void sumTwoNumbers(){
        assertEquals(19, com.stanimiriliev.javaobjects.sumator.Sumator.sum("15", "4"));
    }

    @org.junit.Test(expected = NumberFormatException.class)
    public void sumWithInvalidInput(){
        Sumator.sum("a", "b");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void sumWithNullInput(){
        Sumator.sum(null, "b");
    }

}