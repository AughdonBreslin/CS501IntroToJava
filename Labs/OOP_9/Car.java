package OOP_9;

// Subclass (Child) that inherits from Vehicle
public class Car extends Vehicle {
    int numDoors;

    // Constructor
    public Car(String brand, int year, int numDoors) {
        super(brand, year); // Calls the constructor of the superclass
        this.numDoors = numDoors;
    }

    // Method specific to Car
    public void honk() {
        System.out.println("Beep! Beep!");
    }

    // Overriding the displayInfo() method
    @Override
    public void displayInfo() {
        super.displayInfo(); // Calls parent method
        System.out.println("Number of Doors: " + numDoors);
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 2022, 4);

        myCar.displayInfo(); // Calls the overridden method
        myCar.honk();        // Calls method specific to Car

        Truck myTruck = new Truck("Ford", 2007, 2);
        myTruck.displayInfo();
        myTruck.honk();

    }
}
