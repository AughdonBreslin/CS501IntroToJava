package AbstractClassesAndInterfaces_12;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/1/2025, Saturday
 **/
interface Weighable {
    // All data fields are public final static
    double KG_TO_LBS = 2.20462;
    double LB_TO_KGS = 1 / KG_TO_LBS;

    // All methods are public abstract
    boolean heavierThan(Object other);
    boolean lighterThan(Object other);
    double massInKgs();
    default double massInLbs() {
        return massInKgs() * KG_TO_LBS;
    }
}

interface Rollable {
    void roll();
}

class Ball implements Weighable, Rollable {
    private double massKg; // Mass in kilograms

    public Ball(double massKg) {
        this.massKg = massKg;
    }

    @Override
    public boolean heavierThan(Object other) {
        if (other instanceof Weighable) {
            return this.massInKgs() > ((Weighable) other).massInKgs();
        }
        return false;
    }

    @Override
    public boolean lighterThan(Object other) {
        if (other instanceof Weighable) {
            return this.massInKgs() < ((Weighable) other).massInKgs();
        }
        return false;
    }

    @Override
    public double massInKgs() {
        return this.massKg;
    }

    @Override
    public double massInLbs() {
        return this.massKg * KG_TO_LBS;
    }

    @Override
    public void roll() {
        System.out.println("The ball is rolling...");
    }
}

public class InDepthInterface {
    public static void main(String[] args) {
        Ball ball1 = new Ball(2.5); // 2.5 kg
        Ball ball2 = new Ball(3.0); // 3.0 kg

        System.out.println("Ball 1 mass in lbs: " + ball1.massInLbs());
        System.out.println("Ball 2 mass in lbs: " + ball2.massInLbs());

        System.out.println("Is Ball 1 heavier than Ball 2? " + ball1.heavierThan(ball2));
        System.out.println("Is Ball 1 lighter than Ball 2? " + ball1.lighterThan(ball2));

        ball1.roll();

        System.out.println("Conversion from KG to LBS: " +Weighable.KG_TO_LBS);
        System.out.println("Conversion from LB to KGS: " +Weighable.LB_TO_KGS);
    }
}