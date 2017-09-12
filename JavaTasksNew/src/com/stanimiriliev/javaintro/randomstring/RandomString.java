package com.stanimiriliev.chapterone.randomstring;

import java.util.Random;

/**
 * This class creates random string with specific length
 * @author  Stanimir
 * @since   18.7.2017
 */

public class RandomString {

    /**
     * Generates random string with specified length
     * @param length -> The length of the string
     * @return random string
     */
    public String randomString(int length){
        if(length <= 0)
            return "";
        Random rnd = new Random();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < length; i++){
            str.append((char)rnd.nextInt(128));
        }
        return str.toString();
    }
}
