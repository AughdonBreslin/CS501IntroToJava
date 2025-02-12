package MathFunctions_3;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/5/2025, Wednesday
 **/

import java.util.Scanner;

public class SortCities2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter two cities:");
        String city1 = scan.next();
        String city2 = scan.next();

        if (city1.compareTo(city2) < 0) {
            System.out.println(city1 + ", " + city2);
        } else {
            System.out.println(city2 + ", " + city1);
        }
    }
}
