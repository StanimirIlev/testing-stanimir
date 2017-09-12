package com.stanimiriliev.javaintro.arraysettings;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraySettingsTest {
    @org.junit.Test
    public void minElementOfPositiveNumbers(){
        assertEquals(1, new ArraySettings(new int[]{2, 1, 8, 3}).getMinElement());
    }

    @org.junit.Test
    public void minElementOfNegativeNumbers(){
        assertEquals(-2, new ArraySettings(new int[]
                {1, 2, 3, 6, 8, -2, -2, 5, 0, 11, 8}).getMinElement());
    }

    @org.junit.Test
    public void minElementWithZero(){
        assertEquals(0, new ArraySettings(new int[]{0, 0, 0, 3}).getMinElement());
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void minElementOfEmptyArray(){
        ArraySettings as = new ArraySettings(new int[]{});
        as.getMinElement();
    }

    @org.junit.Test
    public void sumOfNegativeNumbers(){
        assertEquals(40, new ArraySettings(new int[]
                {1, 2, 3, 6, 8, -2, -2, 5, 0, 11, 8}).getSum());
    }

    @org.junit.Test
    public void sumOfPositiveNumbers(){
        assertEquals(14, new ArraySettings(new int[]{2, 1, 8, 3}).getSum());
    }

    @org.junit.Test
    public void sumWithZero(){
        assertEquals(3, new ArraySettings(new int[]{0, 0, 0, 3}).getSum());
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void sumOfEmptyArray(){
        ArraySettings as = new ArraySettings(new int[]{});
        as.getSum();
    }

}