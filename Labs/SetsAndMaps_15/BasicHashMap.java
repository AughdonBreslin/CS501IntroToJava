package SetsAndMaps_15;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/29/2025, Saturday
 **/

public class BasicHashMap {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 95);

        System.out.println(scores.get("Bob")); // Output: 85
        System.out.println(scores.containsKey("Alice")); // Output: true
        System.out.println(scores.values());
        // Iteration
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
