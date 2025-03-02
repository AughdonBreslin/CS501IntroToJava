package Generics_13;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/2/2025, Sunday
 **/
import java.util.ArrayList;

public class LowerBoundedWildcards {
    public static void addNumbers(ArrayList<? super Integer> list) { // Accepts Integer or superclasses
        list.add(10);
        list.add(20);
        System.out.println("List updated: " + list);
    }

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<Number> numList = new ArrayList<>();
        ArrayList<Object> objList = new ArrayList<>();

        addNumbers(intList);
        addNumbers(numList);
        addNumbers(objList);
    }
}