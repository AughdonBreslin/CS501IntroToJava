package Loops_4;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/2/2025, Sunday
 **/
import java.util.Scanner;

public class AdditionQuiz {
    public static void main(String[] args) {
        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);

        Scanner scan = new Scanner(System.in);
        System.out.printf("What is %d + %d?\n", number1, number2);
        int answer = scan.nextInt();

        while (number1 + number2 != answer) {
            System.out.printf("Wrong. Try again, what is %d + %d?\n", number1, number2);
            answer = scan.nextInt();
        }

        System.out.println("Yay! Congrats you got it right.");
    }
}
