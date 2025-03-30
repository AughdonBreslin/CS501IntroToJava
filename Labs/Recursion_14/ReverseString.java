package Recursion_14;

import java.util.ArrayList;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/19/2025, Wednesday
 **/
public class ReverseString {
    public static ArrayList<Integer> function(ArrayList<Integer> nums) {
        // Base case
        if (nums.size() <= 1) {
            return nums;
        }

        // Recursive case
        int num = nums.remove(0);
        function(nums).add(num);
        return nums;
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) {
            nums.add(i);
        }
        System.out.println(function(nums));
    }
}
