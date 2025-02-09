package Methods_5;

import java.util.Scanner;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/8/2025, Saturday
 **/
public class PrintCalendar {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int year, int month) {
        if (month < 1 || month > 12) {
            System.err.println("Invalid month.");
            return -1;
        }
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 31;
    }

    public static int getDaysSince1800(int year, int month) {
        int total = 0;

        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i)) {
                total += 366;
            } else {
                total += 365;
            }
        }

        for (int i = 1; i < month; i++) {
            total += getDaysInMonth(year, i);
        }

        return total;
    }

    public static int getStartDay(int year, int month) {
        final int JAN_1_1800 = 3;
        int totalDays = getDaysSince1800(year, month);

        return (totalDays + JAN_1_1800) % 7;
    }

    public static String monthName(int month) {
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            default -> "December";
        };
    }

    public static void printMonth(int year, int month) {
        System.out.println("         " + monthName(month) + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getStartDay(year, month);
        int numDays = getDaysInMonth(year, month);

        // Pad space before the first day
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print the days
        for (int i = 1; i <= numDays; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay)%7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your year and month as YYYY MM.");
        int year = scan.nextInt();
        int month = scan.nextInt();

        printMonth(year, month);
    }
}
