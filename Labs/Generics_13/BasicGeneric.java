package Generics_13;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/2/2025, Sunday
 **/

// Define a generic class with a type parameter T
class Box<T> {
    private T value;

    // Constructor
    public Box(T value) {
        this.value = value;
    }

    // Getter method
    public T getValue() {
        return value;
    }

    // Setter method
    public void setValue(T value) {
        this.value = value;
    }

    // Display method
    public void display() {
        System.out.println("Value: " + value);
    }
}

public class BasicGeneric {
    public static void main(String[] args) {
        // Create a Box for Integer
        Box<Integer> intBox = new Box<>(10);
        intBox.display();  // Output: Value: 10

        // Create a Box for String
        Box<String> strBox = new Box<>("Hello");
        strBox.display();  // Output: Value: Hello

        // Get and set values
        intBox.setValue(20);
        System.out.println("Updated Value: " + intBox.getValue()); // Output: Updated Value: 20'
    }
}
