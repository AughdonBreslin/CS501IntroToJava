package SetsAndMaps_15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/29/2025, Saturday
 **/
public class RemoveDuplicates {
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> arr) {
        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        return arr;
    }
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i % 5); // Adding duplicates
        }
        System.out.println("Original List: " + numbers);
        ArrayList<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("List after removing duplicates: " + uniqueNumbers);
    }
}
