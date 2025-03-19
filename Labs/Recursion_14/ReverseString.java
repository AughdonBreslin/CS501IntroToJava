package Recursion_14;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/19/2025, Wednesday
 **/
public class ReverseString {
    public static String reverse(String str) {
        // Base case
        if (str.length() <= 1) {
            return str;
        }

        // Recursive case
        return reverse(str.substring(1)) + str.charAt(0);
    }
    public static void main(String[] args) {
        System.out.println(reverse("Hello, world!"));
    }
}
