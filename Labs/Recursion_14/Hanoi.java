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
        // If I have 6 pegs, I want to move the first 5 pegs to the middle peg,
        //   so I will use the target peg as my temporary holder,
        //   and my target is to put all 5 pegs on the aux peg
        hanoi(n - 1, source, target, auxiliary);
        // Once I've solved towers of hanoi for 5 pegs, I move peg 6 to the target
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        // Now I just need to solve towers of hanoi for 5 pegs,
        //   starting on the middle peg,
        //   using the first peg as my temporary holder,
        //   and keeping that third target peg as my target
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
