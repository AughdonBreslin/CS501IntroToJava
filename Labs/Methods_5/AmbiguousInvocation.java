package Methods_5;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/8/2025, Saturday
 **/
public class AmbiguousInvocation {
    public static double max(int a, double b) {
        return (a > b) ? a : b;
    }

    public static double max(double a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
//        System.out.println(AmbiguousInvocation.max(1, 2));
    }
}
