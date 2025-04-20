package Sorting_18;

import java.util.Arrays;
/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/19/2025, Saturday
 **/
public class IntermediateSorting {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // Partitioning index
            int partition_index = partition(arr, left, right);

            // Recursively sort elements before and after partition
            quickSort(arr, left, partition_index - 1);
            quickSort(arr, partition_index + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        // Pivot (last element)
        int pivot = arr[right];
        int i = (left - 1); // Index of smaller element

        for (int j = left; j < right; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++; // Increment index of smaller element
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[right] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        long avgMergeTime = 0;
        long avgQuickTime = 0;
        long avgBuiltInTime = 0;
        int numTrials = 10;

        for (int i = 0; i < numTrials; i++) {
            System.out.println("\nTrial " + (i + 1) + ":");
            // Generate random array of integers
            int[] arr1 = new int[10000];
            for (int j = 0; j < arr1.length; j++) {
                arr1[j] = (int) (Math.random() * 10000);
            }
            int[] arr2 = arr1.clone();

            // Measure time taken by merge sort
            long startTime = System.nanoTime();
            mergeSort(arr1);
            long endTime = System.nanoTime();
            avgMergeTime += (endTime - startTime);
            System.out.printf("Merge Sort: %,d ns\n", (endTime - startTime));

            // Measure time taken by quick sort
            startTime = System.nanoTime();
            quickSort(arr2);
            endTime = System.nanoTime();
            avgQuickTime += (endTime - startTime);
            System.out.printf("Quick Sort: %,d ns\n", (endTime - startTime));

            // Measure time taken by built-in sort
            startTime = System.nanoTime();
            Arrays.sort(arr1);
            endTime = System.nanoTime();
            avgBuiltInTime += (endTime - startTime);
            System.out.printf("Built-in Sort: %,d ns\n", (endTime - startTime));
        }

        System.out.println("\nAverage times over " + numTrials + " trials:");
        System.out.printf("Average Merge Sort Time: %,d ns\n", avgMergeTime / numTrials);
        System.out.printf("Average Quick Sort Time: %,d ns\n", avgQuickTime / numTrials);
        System.out.printf("Average Built-in Sort Time: %,d ns\n", avgBuiltInTime / numTrials);
    }
}
