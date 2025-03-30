package SetsAndMaps_15;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/29/2025, Saturday
 **/
public class UniqueString {
    public static boolean isAlphabetical(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUniqueLetters(String str) {
        if (!isAlphabetical(str)) {
            return false; // Not all characters are letters
        }
        str = str.toLowerCase();
        Set<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!charSet.add(c)) {
                return false; // Duplicate found
            }
        }
        return true; // All characters are unique
    }

    public static void main(String[] args) {
        String testString1 = "abcdefg";
        String testString2 = "abcdeff";
        String testString3 = "abc123";

        System.out.println("Is \"" + testString1 + "\" unique? " + isUniqueLetters(testString1)); // true
        System.out.println("Is \"" + testString2 + "\" unique? " + isUniqueLetters(testString2)); // false
        System.out.println("Is \"" + testString3 + "\" unique? " + isUniqueLetters(testString3)); // false

        // What is the time complexity of this function?
        // Hint: This is a trick question.
    }
}
