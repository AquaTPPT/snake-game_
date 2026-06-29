package com.aquatp.statics;

public class Random {

    public static int random(int startingNum, int lastNum) {
        return (int) Math.floor(startingNum + (Math.random() * lastNum));
    }

    public static int plusOne(int startingNum, int lastNum) {
        return random(startingNum, lastNum) + 1;
    }
}
