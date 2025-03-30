package SetsAndMaps_15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/29/2025, Saturday
 **/
public class MissingNumber {
    public static int missingNumber(List<Integer> nums) {
        Set<Integer> numSet = new HashSet<>(nums);
        for (int i = 0; i <= nums.size(); i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }
        return -1; // This line should never be reached if the input is valid
    }
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            numbers.add(i); // Adding numbers from 0 to 9
        }
        numbers.remove(5); // Removing the number 5
        System.out.println("Original List: " + numbers);
        int missing = missingNumber(numbers);
        System.out.println("Missing number: " + missing);
    }
}
