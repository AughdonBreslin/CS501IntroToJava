package Recursion_14;

import java.time.Instant;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/19/2025, Wednesday
 **/
public class Fibonacci {
    public static int fibonacci(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }

        // Recursive case (two calls)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        fibonacci(300);
        Instant end = Instant.now();
        System.out.println(end.compareTo(start));
    }
}
