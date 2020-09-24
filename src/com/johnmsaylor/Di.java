package com.johnmsaylor;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Di {
    private int value;
    private int sides;
    private Random random;

    public Di(Random random, int sides) {
        this.random = random;
        this.sides = sides;
    }

    public void roll() {
//        try {
//            TimeUnit.MILLISECONDS.sleep(random.nextLong());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        value = random.nextInt(10) + 1;
    }

    public int getValue() {
        return value;
    }
}
