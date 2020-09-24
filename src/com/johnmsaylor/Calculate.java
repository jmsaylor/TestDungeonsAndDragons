package com.johnmsaylor;

import java.util.List;

public class Calculate {

    public static int calculateDamage(Dice dice){
//        return dice.getDiceValues().stream().reduce(0, Integer::sum);
        int total = 0;
        for (var di : dice.getDiceValues()) {
            total += di;
        }
        return total;
    }

    public static int attack(int ac, int defenseMod, int attackModifier, String damageDice) {
        int damage = 0;

        var startDice = new Dice(1,20);
        startDice.roll();

        int startValue = startDice.getDiceValues().get(0) + attackModifier;

        if(startValue == 1) {
            Console.out("Critical Miss - 0 damage dealt");
        }

        if (startValue > ac + defenseMod) {
            int[] damageDiceParams = parseDamageDice(damageDice);
            var dice = new Dice(damageDiceParams[0], damageDiceParams[1]);
            dice.roll();
            damage = calculateDamage(dice);
        }

        if (startValue == 20) {
            Console.out("Critical Hit! Damage x2");
            damage *= 2;
        }

        System.out.println("Damage dealt: " + damage);
        return damage;

    }

    public static int[] parseDamageDice(String string) {
        int[] damageDice = new int[2];
        if (string.charAt(0) == 'd') {
            damageDice[0] = 1;
        } else {
            damageDice[0] = Integer.parseInt(string.substring(0, string.indexOf('d')));
        }
        damageDice[1] = Integer.parseInt(string.substring(string.indexOf('d') + 1));

        return damageDice;
    }
}
