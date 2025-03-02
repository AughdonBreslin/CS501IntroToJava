package AbstractClassesAndInterfaces_12;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/1/2025, Saturday
 **/

public class MoreComparables {
    public static void main(String[] args) {
        System.out.println(new BigInteger("3").compareTo(new BigInteger("5"))); // negative
        System.out.println("ABC".compareTo("ABE")); // negative
        LocalDate date1 = LocalDate.of(2013, 1, 1);
        LocalDate date2 = LocalDate.of(2012, 1, 1);
        System.out.println(date1.compareTo(date2)); // positive
    }
}
