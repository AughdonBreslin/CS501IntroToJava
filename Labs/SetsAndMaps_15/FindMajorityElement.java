package SetsAndMaps_15;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/29/2025, Saturday
 **/
public class FindMajorityElement {
    public static <E> E findMajorityElement(List<E> list) {
        Map<E, Integer> countMap = new HashMap<>();
        int majorityCount = list.size() / 2;

        for (E element : list) {
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
            if (countMap.get(element) > majorityCount) {
                return element;
            }
        }
        return null; // No majority element found
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);
        numbers.add(1);
        numbers.add(4);
        numbers.add(1);

        System.out.println("Original List: " + numbers);
        Integer majorityElement = findMajorityElement(numbers);
        if (majorityElement != null) {
            System.out.println("Majority element: " + majorityElement);
        } else {
            System.out.println("No majority element found.");
        }

    }
}
