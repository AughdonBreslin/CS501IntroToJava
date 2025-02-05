package MathFunctions_3;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/2/2025, Sunday
 **/

import java.util.Scanner;

public class AlphabetizeCities {
    public static void main(String[] args) {
//        if (args.length != 3) {
//            System.err.println("Only works for 3 cities rn.");
//            return;
//        }
//        String city1 = args[0];
//        String city2 = args[1];
//        String city3 = args[2];

        Scanner scan = new Scanner(System.in);
        String city1 = scan.next();
        String city2 = scan.next();
        String city3 = scan.next();

        // if city1 before city2
        if (city1.compareTo(city2) < 0) {
            // if city1 after city3
            if (city1.compareTo(city3) > 0) {
                System.out.printf("%s, %s, %s", city3, city1, city2);
            // elif city2 before city3
            } else if (city2.compareTo(city3) < 0) {
                System.out.printf("%s, %s, %s", city1, city2, city3);
            // city2 must come last
            } else {
                System.out.printf("%s, %s, %s", city1, city3, city2);
            }
        // city2 before city1
        } else {
            // if city2 after city3
            if (city2.compareTo(city3) > 0) {
                System.out.printf("%s, %s, %s", city3, city2, city1);
            // elif city 1 before city3
            } else if (city1.compareTo(city3) < 0) {
                System.out.printf("%s, %s, %s", city2, city1, city3);
            // city1 must come last
            } else {
                System.out.printf("%s, %s, %s", city2, city3, city1);
            }
        }
    }
}
