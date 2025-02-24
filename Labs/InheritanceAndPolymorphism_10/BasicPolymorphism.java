package InheritanceAndPolymorphism_10;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/

class Vehicle {
    public void move() {
        System.out.println("Vehicle move");
    }

    @Override
    public String toString() {
        return "Vehicle";
    }
}

class Truck extends Vehicle {
    @Override
    public void move() {
        System.out.println("Truck move");
    }

    @Override
    public String toString() {
        return "Truck";
    }
}

class Car extends Vehicle {
    @Override
    public void move() {
        System.out.println("Car move");
    }

    @Override
    public String toString() {
        return "Car";
    }
}

class DMV {
    public void register(Vehicle vehicle) {
        System.out.printf("DMV registering %s \n", vehicle);
    }
}


public class BasicPolymorphism {
    public static void main(String[] args) {
        DMV dmv = new DMV();
        Car car = new Car();
        Truck truck = new Truck();

        dmv.register(truck);
        dmv.register(car);

        // Cool: We know Truck IS A Vehicle
        Vehicle vehicle = new Truck();
        dmv.register(vehicle);

        // BAD: Though Truck IS A Vehicle,
        //   we cannot say Vehicle IS A Truck
//        Truck truck2 = new Vehicle();
//        dmv.register(truck2);
    }
}
