package Recursion_14;

import java.util.HashMap;
import java.util.Map;
import java.time.Instant;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/20/2025, Thursday
 **/
public class MemoFibonacci {
    private static int memoFibonacci(int n, Map<Integer, Integer> memo) {
        // Check if we've already calculated this value
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Base cases
        if (n <= 1) {
            return n;
        }

        // Calculate and store the result
        int result = memoFibonacci(n - 1, memo) + memoFibonacci(n - 2, memo);
        memo.put(n, result);

        return result;
    }

    // Usage
    public static int memoFibonacci(int n) {
        return memoFibonacci(n, new HashMap<>());
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        memoFibonacci(300);
        Instant end = Instant.now();
        System.out.println(end.compareTo(start));
    }
}
