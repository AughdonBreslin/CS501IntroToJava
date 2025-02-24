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
        Truck myTruck = new Truck("Toyota", 2022, 2); // Creating an instance of Car

        myTruck.displayInfo(); // Calls the overridden method
        myTruck.honk();        // Calls method specific to Car
    }
}
