package SetsAndMaps_15;

import java.util.*;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/29/2025, Saturday
 **/
public class FindSymmetricPairs {
    // Given an array of pairs, find all symmetric pairs
    // A symmetric pair is a pair (a, b) such that (b, a) also exists in the array
    public static List<List<Integer>> findSymmetricPairs(int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int[] pair : pairs) {
            int a = pair[0], b = pair[1];
            if (map.containsKey(b) && map.get(b) == a) {
                result.add(Arrays.asList(a, b));
            } else {
                map.put(a, b);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] pairs = {
                {1, 2},
                {2, 1},
                {3, 4},
                {4, 3},
                {5, 6}
        };
        List<List<Integer>> symmetricPairs = findSymmetricPairs(pairs);
        System.out.println("Symmetric pairs:");
        for (List<Integer> pair : symmetricPairs) {
            System.out.println(pair);
        }

    }
}
