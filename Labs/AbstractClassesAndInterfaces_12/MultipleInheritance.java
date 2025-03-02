package AbstractClassesAndInterfaces_12;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/1/2025, Saturday
 **/
interface Walkable {
    default void move() {
        System.out.println("Walking...");
    }
}

// Adding a 2 because I've implemented the same
// interface name in another file
interface Flyable2 {
    default void move() {
        System.out.println("Flying...");
    }
}

// Class implementing both interfaces (inherits behavior from both)
class Bird2 implements Walkable, Flyable2 {
    // Must override the conflicting default methods
    @Override
    public void move() {
        System.out.println("I can both walk and fly!");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        Bird2 bird = new Bird2();
        bird.move(); // Output: I can both walk and fly!
    }
}