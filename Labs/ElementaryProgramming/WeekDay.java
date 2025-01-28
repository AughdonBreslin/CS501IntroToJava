package ElementaryProgramming;

import java.util.Scanner;

public class WeekDay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer for the day: ");
        int day = input.nextInt() % 7;

        if (day == 1) {
            System.out.println("Monday");
        } else if (day == 2) {
            System.out.println("Tuesday");
        } else if (day == 3) {
            System.out.println("Wednesday");
        } else if (day == 4) {
            System.out.println("Thursday");
        } else if (day == 5) {
            System.out.println("Friday");
        } else if (day == 6) {
                System.out.println("Saturday");
        } else {
            System.out.println("Sunday");
        }
    }
}
