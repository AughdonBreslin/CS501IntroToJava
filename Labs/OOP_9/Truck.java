package OOP_9;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/11/2025, Tuesday
 **/
public class Truck extends Vehicle {
    int numDoors;

    // Constructor
    public Truck(String brand, int year, int numDoors) {
        super(brand, year); // Calls the constructor of the superclass
        this.numDoors = numDoors;
    }

    // Method specific to Car
    public void honk() {
        System.out.println("BRRRRRMMMM! BRRRRRRRMMM!");
    }

    // Overriding the displayInfo() method
    @Override
    public void displayInfo() {
        super.displayInfo(); // Calls parent method
        System.out.println("I am a truck with number of Doors: " + numDoors);
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 2022, 4); // Creating an instance of Car

        myCar.displayInfo(); // Calls the overridden method
        myCar.honk();        // Calls method specific to Car
    }
}
