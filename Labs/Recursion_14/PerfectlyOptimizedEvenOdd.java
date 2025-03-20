package Recursion_14;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/20/2025, Thursday
 **/
public class PerfectlyOptimizedEvenOdd {
    public static boolean isEven(int n) {
        if (n == 0) {
            System.out.println("Zero is even.");
            return true;
        }
        System.out.println("Is " +n+ " even? Will need to check if " +(n-1)+ " is odd.");
        return isOdd(n - 1);
    }

    public static boolean isOdd(int n) {
        if (n == 0) {
            System.out.println("Zero is not odd.");
            return false;
        }
        System.out.println("Is " +n+ " odd? Will need to check if " +(n-1)+ " is even.");
        return isEven(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(isOdd(100));
    }
}
