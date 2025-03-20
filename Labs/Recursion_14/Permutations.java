package Recursion_14;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/20/2025, Thursday
 **/
public class Permutations {
    private static String swap(String str, int i, int j) {
        if (i == j) return str;

        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return String.valueOf(charArray);
    }

    private static void permute(String str, int left, int right) {
        // Base case: If we've fixed all positions, print the permutation
        if (left == right) {
            System.out.println(str);
            return;
        }

        // Recursive case: Try all possible characters at the current position
        for (int i = left; i <= right; i++) {
            // Swap characters at positions left and i
            str = swap(str, left, i);

            // Recursively generate permutations for the rest of the string
            permute(str, left + 1, right);

            // Backtrack: restore the original order (swap back)
            str = swap(str, left, i);
        }
    }

    public static void generatePermutations(String str) {
        // Call the recursive helper function
        permute(str, 0, str.length() - 1);
    }

    public static void main(String[] args) {
        String str = "ABC";
        System.out.println("All permutations of " + str + ":");
        generatePermutations(str);
    }
}
