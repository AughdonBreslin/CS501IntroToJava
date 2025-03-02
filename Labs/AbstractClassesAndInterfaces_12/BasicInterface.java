package AbstractClassesAndInterfaces_12;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/1/2025, Saturday
 **/
// Keyword interface rather than class
interface Flyable {
    // all public and abstract by default, so can be omitted
    void fly();
    void land();
}

// Uses implements
class Plane implements Flyable {
    public void fly() {
        System.out.println("Pilot firing engines on runway!");
    }
    public void land() {
        System.out.println("Landing equipment engaged, approaching runway");
    }
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Flap my wings");
    }
    public void land() {
        System.out.println("Flap my wings more gently");
    }
}

public class BasicInterface {
    public static void main(String[] args) {
//        Flyable f = new Flyable();
        Bird b = new Bird();
        Plane p = new Plane();

        b.fly();
        b.land();
        p.fly();
        p.land();
    }
}
