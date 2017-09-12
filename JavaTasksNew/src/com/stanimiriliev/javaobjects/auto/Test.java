package com.stanimiriliev.chaptertwo.auto;

import com.stanimiriliev.chaptertwo.auto.Automobiles.Color;

import java.util.Date;

/**
 * Test functionality of the classes VW, Mercedes and Opel
 * @author Stanimir Iliev
 * @since 22.07.2017
 */
public class Test {
    public static void main(String[] args){

        VW golf = new VW(180, Color.BLUE, new Date());
        Mercedes eClass = new Mercedes(240, Color.BLACK, new Date());
        Opel astra = new Opel(190, Color.GREY, new Date(), 1100, 5);

        System.out.println("VW Golf is color " + golf.color);
    }
}
