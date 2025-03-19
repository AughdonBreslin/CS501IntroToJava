package Recursion_14;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/19/2025, Wednesday
 **/
public class Factorial {

    public static int factorial(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }

        // Recursive Case
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
