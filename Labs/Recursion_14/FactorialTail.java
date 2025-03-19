package Recursion_14;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/19/2025, Wednesday
 **/
public class FactorialTail {
    public static int factorialTail(int n, int accumulator) {
        // Base case
        if (n <= 1) {
            return accumulator;
        }

        // Tail recursive call
        return factorialTail(n - 1, n * accumulator);
    }

    // Wrapper method
    public static int factorial(int n) {
        return factorialTail(n, 1);
    }
    public static void main(String[] args) {

    }
}
