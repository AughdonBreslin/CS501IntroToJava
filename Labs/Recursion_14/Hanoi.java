package Recursion_14;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/19/2025, Wednesday
 **/
public class Hanoi {
    public static void hanoi(int n, char source, char auxiliary, char target) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }

        hanoi(n - 1, source, target, auxiliary);

        System.out.println("Move disk " + n + " from " + source + " to " + target);

        hanoi(n - 1, auxiliary, source, target);
    }
    // Wrapper method (kicks off the recursion so the user doesn't need to specify peg names)
    public static void towersOfHanoi(int numDisks) {
        hanoi(numDisks, '1', '2', '3');
    }

    public static void main(String[] args) {
        towersOfHanoi(4);
    }
}
