package Loops_4;

import java.util.Scanner;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/2/2025, Sunday
 **/
public class AdditionQuizExtended {
    public static void main(String[] args) {
        int numQuestions = 5;
        int correctCount = 0;

        for(int i = 0; i < numQuestions; i++) {
            int number1 = (int)(Math.random() * 10);
            int number2 = (int)(Math.random() * 10);

            Scanner scan = new Scanner(System.in);
            System.out.printf("What is %d + %d?\n", number1, number2);
            int answer = scan.nextInt();

            if (number1 + number2 == answer) {
                System.out.println(" Correct!");
                correctCount++;
            } else {
                System.out.println(" Wrong, its " +(number1 + number2));
            }
        }
        System.out.println("Your score: " +(correctCount/5.0)*100+ "%");
    }
}
