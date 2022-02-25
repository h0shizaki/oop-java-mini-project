package EggClass;

import java.util.InputMismatchException;

public abstract class Egg {

    private double eggDistance;
    private double currentDistance;

    // Constructor
    public Egg() {
        this.eggDistance = 1.0;
        this.currentDistance = 0.0;
    }

    public Egg(double dis) {
        this.eggDistance = dis;
        this.currentDistance = 0.0;
    }

    // Getter
    public double getEggDistance() {
        return this.eggDistance;
    }

    public double getCurrentEggDistance() {
        return this.currentDistance;
    }

    // Setter

    public void setEggDistance(double dis) {
        if (dis < 0) {
            throw new InputMismatchException("Invalid number");
        }

        this.eggDistance = dis;
    }

    protected void setCurrentDistance(double dis) {
        if (dis < 0) {
            throw new InputMismatchException("Invalid number");
        }
        this.currentDistance = dis;
    }

    // Add current distance
    private void addCurrnetDistance(double addDis) {
        if (addDis < 0) {
            throw new InputMismatchException("Invalid number");

        }

        this.currentDistance += addDis ;
    }

    //Walk to hatch an egg
    public String walkToHatch(double addDis){
        //Add distance
        addCurrnetDistance(addDis);

        //Egg is going to hatch
        if (getCurrentEggDistance() >= getEggDistance()){
            return eggHatch() ;
        }
        return "" ;
    }


    public abstract String getEggInfo();

    public abstract String eggHatch();

}