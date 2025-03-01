package AbstractClassesAndInterfaces_12;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/1/2025, Saturday
 **/
interface Flyable {
    void fly();
    void land();
}

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

    }
}
