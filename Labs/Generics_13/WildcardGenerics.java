package Generics_13;

import java.util.ArrayList;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/2/2025, Sunday
 **/


class NormalGenericPrinter<T> {
    public void printList(ArrayList<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }
}

class NormalGenerics {
    public static void main(String[] args) {
        NormalGenericPrinter<Number> printer = new NormalGenericPrinter<>();
        ArrayList<Integer> intNumbers = new ArrayList<>();
        intNumbers.add(10);
//        printer.printList(intNumbers);  // Compilation error, Integer cannot be converted to Number

        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add(10);
        printer.printList(numbers); // Works, Number from ArrayList matches Number from NormalGenericPrinter
    }
}

class WildcardPrinter<T> {
    // Flexible way - allows ArrayList<?> meaning an arraylist with any type
    // Unbounded wildcards should only be used when method can be handled
    //  by functionality provided by the Object class.
    public void printList(ArrayList<?> list) {
        for (Object item : list) { // Treated as Object
            System.out.println(item);
        }
    }
}

public class WildcardGenerics {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(13);

        WildcardPrinter<Number> wildcardPrinter = new WildcardPrinter<>();

        wildcardPrinter.printList(words);   // Works
        wildcardPrinter.printList(numbers); // Works

        // Raw types can be passed in, as each element is treated as an Object
        //   similar to old way of implementation. Use caution!
        ArrayList mixedArray = new ArrayList();
        mixedArray.add("Hello");
        mixedArray.add(10);

        wildcardPrinter.printList(mixedArray);
    }

}
