package Loops_4;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/5/2025, Wednesday
 **/

import java.util.Scanner;

public class GuessTheNumber2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = (int)(Math.random()*101);

        System.out.println("Guess the number from 0 to 100");
        int guess = scan.nextInt();

        while (guess != number) {
            if (guess > number) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }
            guess = scan.nextInt();
        }
        System.out.println("Congrats! You got the number");
    }
}
