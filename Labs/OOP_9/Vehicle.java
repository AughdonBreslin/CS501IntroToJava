package OOP_9;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/11/2025, Tuesday
 **/
// Superclass (Parent)
public class Vehicle {
    String brand;
    int year;

    // Constructor
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Method to display vehicle details
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}