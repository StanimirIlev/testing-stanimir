package com.stanimiriliev.chaptertwo.auto;

import java.util.Date;

/**
 * Represents cars of the make Opel
 * @author Stanimir Iliev
 * @since 22.07.2017
 */
public class Opel extends Automobiles {

    public final int weight;
    public final int passengers;

    public Opel(int maxVelocity, Color color, Date dateOfManufacture, int weight, int passengers){
        super(maxVelocity, color, dateOfManufacture);
        this.weight = weight;
        this.passengers = passengers;
    }
}
