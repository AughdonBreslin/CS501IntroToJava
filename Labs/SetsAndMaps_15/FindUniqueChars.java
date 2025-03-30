package SetsAndMaps_15;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/29/2025, Saturday
 **/
public class FindUniqueChars {
    public static String nonRepeatingChars(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (frequency.get(c) == 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "swiss";
        String result = nonRepeatingChars(s);
        System.out.println("Nonrepeating characters: " + result); // Output: "w"

        s = "hello";
        result = nonRepeatingChars(s);
        System.out.println("Nonrepeating characters: " + result); // Output: "h"
    }
}
