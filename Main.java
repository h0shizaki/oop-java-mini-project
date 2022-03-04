
//642115003 Kan Katpark
import java.io.*;
import java.util.*;
import EggClass.*;

public class Main {
    final static long DELAY_TIME = 1000;

    public static void main(String[] args) {

        Queue<Egg> eggList = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        double count = 0;

        while (true) {

            menuUI();
            System.out.print("Enter: ");
            char input = in.nextLine().charAt(0);

            if (input == 'x' || input == 'X') {
                break;
            }

            switch (input) {
                case 'l', 'L': {
                    System.out.println("Pokemon list");
                    Vector<String> pokemonList = readPokemonList();
                    System.out.println("You have " + pokemonList.size() + " Pokemons");
                    System.out.println(pokemonList);
                    System.out.println("\n\n\n");
                    break;
                }

                case 'e', 'E': {
                    addEggToQueue(eggList, 1);
                    break;
                }

                case 'w', 'W': {
                    while (!eggList.isEmpty()) {
                        Egg currentEgg = eggList.remove();
                        System.out.println("Go to walk to hatch an egg");
                        delayTime(DELAY_TIME);
                        System.out.println(currentEgg.getEggInfo());
                        delayTime(DELAY_TIME);

                        while (true) {

                            delayTime(DELAY_TIME);
                            count += 0.5;
                            System.out.println("You walked for " + count + " km");
                            String temp = currentEgg.walkToHatch(0.5);

                            if (temp.compareTo("") != 0) {
                                eggHatchAlert(temp);
                                writePokemonToSave(temp);
                                break;
                            }
                        }
                    }

                    System.out.println("Your queue is empty\n");
                    break;
                }
            }

        }

        in.close();
    }

    // Menu UI
    public static void menuUI() {
        System.out.println("Enter e to Get more egg");
        System.out.println("Enter w to Go to walk");
        System.out.println("Enter l to See your pokemon list");
        System.out.println("Enter x to Exit");
    }

    // Add egg to queue
    public static void addEggToQueue(Queue<Egg> list, int i) {
        for (int j = 0; j < i; j++) {
            list.add(createEgg());
            delayTime(DELAY_TIME / 2);
        }
    }

    // Random create egg
    public static Egg createEgg() {
        Random rn = new Random();
        int temp = (rn.nextInt(3));

        switch (temp) {
            case (0): {
                System.out.println("You got huge egg");
                return new HugeEgg();
            }
            case (1): {
                System.out.println("You got meduim egg");
                return new MediumEgg();
            }
            default: {
                System.out.println("You got small egg");
                return new SmallEgg();
            }
        }

    }

    // Alert Notification When an egg is hatching
    public static void eggHatchAlert(String pokemonName) {
        delayTime(DELAY_TIME);
        System.out.println("!!!");
        delayTime(DELAY_TIME);
        System.out.println("Egg is hatching");

        for (int i = 0; i < 3; i++) {
            delayTime(DELAY_TIME);
            for (int j = 0; j < i + 1; j++) {
                System.out.print(".");
            }
            System.out.println();
            delayTime(DELAY_TIME);
        }

        System.out.println("You got \u001B[33m" + pokemonName + "\u001B[0m");
    }

    // Cooldown
    public static void delayTime(long millsec) {
        try {
            Thread.sleep(millsec);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // Write pokemon to save
    public static void writePokemonToSave(String name) {
        //
        try {
            Writer pw = new BufferedWriter(new FileWriter("save.txt", true));
            pw.append(name + "\n");
            pw.close();

        } catch (IOException err) {
            // System.out.println("Save file not found");
        }
    }

    // Read pokemon list
    public static Vector<String> readPokemonList() {
        Vector<String> list = new Vector<>();
        File file = new File("save.txt");

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                list.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException err) {
            // System.out.println(err);
        }

        return list;
    }

}
