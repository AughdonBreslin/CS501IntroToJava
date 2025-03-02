package Generics_13;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/2/2025, Sunday
 **/

class Util {
    // A generic method that returns the input value
    // Note: The <T> makes the method generic (rather than the whole class),
    //       the T is the generic return type,
    //       and the T[] is the generic input type
    public static <T> T getFirstElement(T[] array) {
        return array[0];
    }
}

public class GenericMethod {
    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Cherry"};
        Integer[] numbers = {10, 20, 30};

        System.out.println(Util.getFirstElement(words));  // Output: Apple
        System.out.println(Util.getFirstElement(numbers)); // Output: 10
    }
}