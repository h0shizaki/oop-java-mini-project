package EggClass;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.* ;

public class HugeEgg extends Egg {
    Random rn = new Random();
    public double ranDis = rn.nextInt(3) + 9 ;

    public HugeEgg(double dis) {
        super(dis);
    }

    public HugeEgg() {
        super();
        // assign random egg distance between 9.0 to 12.0 
        super.setEggDistance(ranDis);
    }

    @Override
    public String getEggInfo() {
        return ("Egg size : Huge egg \nEgg Distance: " + super.getEggDistance() + " km\nCurrent Distance: "
                + super.getCurrentEggDistance());
    }

    //Randomly return pokemon name from the list
    @Override
    public String eggHatch() {
        File file = new File("PokemonList/HugePokemonList.txt");

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
