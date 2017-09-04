package com.stanimiriliev.chaptertwo.auto;

import java.text.DateFormat;
import java.util.Date;

/**
 * Represent the common properties of the cars of several makes
 * @author Stanimir Iliev
 * @since 22.07.2017
 */
public class Automobiles {

    public enum Color{
        GREY, GREEN, BROWN, RED, BLUE, YELLOW,
        WHITE, BLACK, ORANGE
    }

    public final Color color;
    public final int maxVelocity;
    public final Date dateOfManufacture;

    public Automobiles(int maxVelocity, Color color, Date dateOfManufacture){
        this.maxVelocity = maxVelocity;
        this.color = color;
        this.dateOfManufacture = dateOfManufacture;
    }
}
