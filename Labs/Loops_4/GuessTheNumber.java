package Loops_4;

import java.util.Scanner;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/2/2025, Sunday
 **/
public class GuessTheNumber {
    public static void main(String[] args) {
        int number = (int)(Math.random() * 101);

        Scanner scan = new Scanner(System.in);
        System.out.println("Guess a number between 0 and 100 (inclusive):");
        int guess;

        while ((guess = scan.nextInt()) != number) {
            if (guess > number) {
                System.out.println("Too high; try again:");
            } else {
                System.out.println("Too low; try again:");
            }
        }
        System.out.println("Perfect! The number was " +number+ "!");
    }
}
