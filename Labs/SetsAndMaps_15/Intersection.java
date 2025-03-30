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
public class Intersection {
    public static Set<String> intersection(Set<String> set1, Set<String> set2) {
        if (set1 == null || set2 == null) {
            return null;
        }

        Set<String> result = new HashSet<>(set1);
        result.retainAll(set2); // Retain only elements that are in both sets
        return result;
    }

    public static Set<String> intersection(ArrayList<String> list1, ArrayList<String> list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);
        return intersection(set1, set2);
    }

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("Red");
        set1.add("Green");
        set1.add("Blue");

        Set<String> set2 = new HashSet<>();
        set2.add("Green");
        set2.add("Yellow");
        set2.add("Blue");

        Set<String> result = intersection(set1, set2);
        System.out.println("Intersection: " + result);

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Aardvark");
        list1.add("Bear");
        list1.add("Cat");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Bear");
        list2.add("Dog");
        list2.add("Elephant");

        Set<String> resultList = intersection(list1, list2);
        System.out.println("Intersection of lists: " + resultList);
    }
}
