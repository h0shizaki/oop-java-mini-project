
import java.util.*;

import EggClass.*;

public class TestMain {
    public static void main(String[] args) {

        Egg e1 = new SmallEgg();
        String temp = "";
        double count = 0;

        System.out.println(e1.getEggInfo());
        
        for (int i = 0; i < 9; i++) {
            cooldown(1000);
            count += 0.5;
            System.out.println("You walked for " + count + " km");
            temp = e1.walkToHatch(0.5);
            if (temp.compareTo("") != 0) {

                eggHatchAlert(temp);
                break;
            }

        }

    }

    // Alert Notification When an egg is hatching
    public static void eggHatchAlert(String pokemonName) {
        cooldown(1000);
        System.out.println("!!!");
        cooldown(800);
        System.out.println("Egg is hatching");

        for (int i = 0; i < 3; i++) {
            cooldown(1000);
            for (int j = 0; j < i + 1; j++) {
                System.out.print(".");
            }
            System.out.println();
            cooldown(800);
        }

        System.out.println("You got \u001B[33m" + pokemonName + "\u001B[30m");
    }

    // Cooldown
    public static void cooldown(long millsec) {
        try {
            Thread.sleep(millsec);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
