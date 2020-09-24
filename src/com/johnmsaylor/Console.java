package com.johnmsaylor;

import java.util.Scanner;

public class Console {

    public static String enterDamageDice() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter Damage Dice");
        return scanner.next();
    }

    public static void out(String string) {
        System.out.println(string);
    }
}
