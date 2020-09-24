package com.johnmsaylor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Dice {
    private List<Di> dice = new ArrayList<>();

    public Dice( int numberOfDice, int sides) {
        for (int i = 0; i < numberOfDice; i++) {
            Random random = new Random();
            dice.add(new Di(random, sides));
        }
    }

    public void roll() {
        for (var di : dice) {
            di.roll();
        }
    }

    public List<Integer> getDiceValues() {
        return dice.stream().map(di -> di.getValue()).collect(Collectors.toList());
    }
}
