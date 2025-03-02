package Generics_13;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description: Credit to https://www.geeksforgeeks.org/wildcards-in-java/
 * @date: 3/2/2025, Sunday
 **/
public class UpperBoundedWildcard {
    public static void main(String[] args)
    {

        // Upper Bounded Integer List
        List<Integer> list1 = Arrays.asList(4, 5, 6, 7);

        // printing the sum of elements in list
        System.out.println("Total sum is:" + sum(list1));

        // Double list
        List<Double> list2 = Arrays.asList(4.1, 5.1, 6.1, 7.1);

        // printing the sum of elements in list
        System.out.print("Total sum is:" + sum(list2));
    }

    private static double sum(List<? extends Number> list)
    {
        double sum = 0.0;
        for (Number i : list) {
            sum += i.doubleValue();
        }

        return sum;
    }
}
