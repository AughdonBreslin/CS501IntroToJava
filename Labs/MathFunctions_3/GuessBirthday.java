package MathFunctions_3;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/2/2025, Sunday
 **/
import java.util.Scanner;

public class GuessBirthday {
    public static void main(String[] args) {
        String set1 = " 1  3  5  7\n 9 11 13 15\n17 19 21 23\n25 27 29 31";
        String set2 = " 2  3  6  7\n10 11 14 15\n18 19 22 23\n26 27 30 31";
        String set3 = " 4  5  6  7\n12 13 14 15\n20 21 22 23\n28 29 30 31";
        String set4 = " 8  9 10 11\n12 13 14 15\n24 25 26 27\n28 29 30 31";
        String set5 = "16 17 18 19\n20 21 22 23\n24 25 26 27\n28 29 30 31";

        int day = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println("Is your birthday in set1?\n" +set1+ "\nEnter 0 for no, 1 for yes.");
        int answer = scan.nextInt();

        if (answer == 1) {
            day += 1;
        }

        System.out.println("Is your birthday in set2?\n" +set2+ "\nEnter 0 for no, 1 for yes.");
        answer = scan.nextInt();

        if (answer == 1) {
            day += 2;
        }

        System.out.println("Is your birthday in set3?\n" +set3+ "\nEnter 0 for no, 1 for yes.");
        answer = scan.nextInt();

        if (answer == 1) {
            day += 4;
        }

        System.out.println("Is your birthday in set4?\n" +set4+ "\nEnter 0 for no, 1 for yes.");
        answer = scan.nextInt();

        if (answer == 1) {
            day += 8;
        }

        System.out.println("Is your birthday in set5?\n" +set5+ "\nEnter 0 for no, 1 for yes.");
        answer = scan.nextInt();

        if (answer == 1) {
            day += 16;
        }
        System.out.println("Your birthday: " +day+ "!");
    }
}
