package EggClass;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.* ;

public class MediumEgg extends Egg {
    Random rn = new Random();
    public double ranDis = rn.nextInt(4) + 5 ;

    public MediumEgg(double dis) {
        super(dis);
    }

    public MediumEgg() {
        super();
        // assign random egg distance between 5.0 to 9.0 
        super.setEggDistance(ranDis);
    }

    @Override
    public String getEggInfo() {
        return ("Egg size : Meduim egg \nEgg Distance: " + super.getEggDistance() + " km\nCurrent Distance: "
                + super.getCurrentEggDistance());
    }

    //Randomly return pokemon name from the list
    @Override
    public String eggHatch() {
        File file = new File("PokemonList/MediumPokemonList.txt");

        Vector<String> list = readPokemonList(file);

        return list.get(rn.nextInt(list.size()));
    }

    //Read pokemon from list 
    private Vector<String> readPokemonList(File file) {
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
