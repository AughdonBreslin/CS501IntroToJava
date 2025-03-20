package Recursion_14;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/20/2025, Thursday
 **/
public class Combinatorics {
    public static void generateCombinations(int[] set, int k) {
        // Create an array to store the current combination
        int[] combination = new int[k];

        // Call the recursive helper function
        combineHelper(set, combination, 0, 0, k);
    }

    private static void combineHelper(int[] set, int[] combination, int start, int currentPosition, int k) {
        // Base case: If we've filled all k positions in our combination
        if (currentPosition == k) {
            // Print the current combination
            for (int i = 0; i < k; i++) {
                System.out.print(combination[i] + " ");
            }
            System.out.println();
            return;
        }

        // Try all possible elements for the current position, starting from 'start'
        for (int i = start; i < set.length; i++) {
            // Add current element to the combination
            combination[currentPosition] = set[i];

            // Recursively generate combinations for the next positions
            // Note: we pass i+1 to ensure we only use elements that come after
            // the current one (avoiding duplicates and maintaining order)
            combineHelper(set, combination, i + 1, currentPosition + 1, k);
        }
    }

    public static void main(String[] args) {
        // Example: Generate all combinations of size 2 from the set {1, 2, 3, 4, 5}
        int[] set = {1, 2, 3};
        int k = 3;

        System.out.println("All combinations of size " + k + " from the set:");
        generateCombinations(set, k);

        System.out.println("All combinations from the set:");
        for (int i = 0; i <= set.length; i++) {
            generateCombinations(set, i);
        }
    }
}
