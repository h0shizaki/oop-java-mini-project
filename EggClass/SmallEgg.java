package EggClass;

import java.io.*;
import java.util.*;

public class SmallEgg extends Egg {
    Random rn = new Random(System.currentTimeMillis());
    public double ranDis = rn.nextInt(4) + 1.0 ;

    public SmallEgg(double dis) {
        super(dis);
    }

    public SmallEgg() {
        super();
        // assign random egg distance between 1.0 to 5.0 
        super.setEggDistance(ranDis);
    }

    @Override
    public String getEggInfo() {
        return ("Egg size : Small egg \nEgg Distance: " + super.getEggDistance() + "\nCurrent Distance: "
                + super.getCurrentEggDistance());
    }

    //Randomly return pokemon name from the list
    @Override
    public String eggHatch() {
        File file = new File("PokemonList/SmallPokemonList.txt");

        Vector<String> list = readSmallPokemonList(file);

        return list.get(rn.nextInt(list.size()));
    }

    //Read pokemon size small 
    private Vector<String> readSmallPokemonList(File file) {
        Vector<String> list = new Vector<>();
        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                list.add(in.nextLine());
            }
            in.close();

        } catch (FileNotFoundException err) {
            System.out.println(err);
            return null;
        }
        return list;
    }

}
