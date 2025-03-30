package SetsAndMaps_15;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/29/2025, Saturday
 **/
public class BasicHashSet {
    public static void main(String[] args) {
        Set<String> uniqueNames = new HashSet<>();

        uniqueNames.add("Alice");
        uniqueNames.add("Bob");
        uniqueNames.add("Charlie");
        uniqueNames.add("Alice"); // Duplicate, will not be added

        System.out.println(uniqueNames); // Output order is not guaranteed
        System.out.println("Contains Alice? " + uniqueNames.contains("Alice"));
        uniqueNames.remove("Bob");
        System.out.println(uniqueNames);

    }
}
