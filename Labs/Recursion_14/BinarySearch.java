package Recursion_14;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/20/2025, Thursday
 **/
public class BinarySearch {
    private static int binarySearch(int[] arr, int target, int low, int high) {
        // Base case: element not found
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        // Found the target
        if (arr[mid] == target) {
            return mid;
        }

        // Search in left half
        if (arr[mid] > target) {
            return binarySearch(arr, target, low, mid - 1);
        }

        // Search in right half
        return binarySearch(arr, target, mid + 1, high);
    }

    public static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 5, 9, 14, 20, 25, 30, 35, 40};
        System.out.println(binarySearch(arr, 17));
    }
}
