package Generics_13;

import java.util.Arrays;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/2/2025, Sunday
 **/

public class BubbleSort {
    // Generic Bubble Sort method
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) { // Swap if out of order
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            // If no swaps occurred, the array is already sorted
            if (!swapped) break;
        }
    }

    // Swap method
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Main method for testing
    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 9, 1, 5, 6};
        bubbleSort(numbers);
        System.out.println("Sorted Integers: " + Arrays.toString(numbers));

        String[] words = {"dog", "cat", "elephant", "bear"};
        bubbleSort(words);
        System.out.println("Sorted Strings: " + Arrays.toString(words));
    }
}
