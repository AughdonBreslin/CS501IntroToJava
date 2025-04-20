package Sorting_18;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 4/19/2025, Saturday
 **/
public class ElementarySorting {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0...i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        long avgBubbleTime = 0;
        long avgInsertionTime = 0;
        long avgSelectionTime = 0;
        int numTrials = 10;

        for (int i = 0; i < numTrials; i++) {
            System.out.println("\nTrial " + (i + 1) + ":");
            // Generate random array of integers
            int[] arr1 = new int[10000];
            for (int j = 0; j < arr1.length; j++) {
                arr1[j] = (int) (Math.random() * 10000);
            }
            int[] arr2 = arr1.clone();
            int[] arr3 = arr1.clone();

            // Measure time taken by each sorting algorithm
            long startTime = System.nanoTime();
            bubbleSort(arr1);
            long endTime = System.nanoTime();
            avgBubbleTime += (endTime - startTime);
            System.out.printf("Bubble Sort: %,d ns\n", (endTime - startTime));

            startTime = System.nanoTime();
            insertionSort(arr2);
            endTime = System.nanoTime();
            avgInsertionTime += (endTime - startTime);
            System.out.printf("Insertion Sort: %,d ns\n", (endTime - startTime));

            startTime = System.nanoTime();
            selectionSort(arr3);
            endTime = System.nanoTime();
            avgSelectionTime += (endTime - startTime);
            System.out.printf("Selection Sort: %,d ns\n", (endTime - startTime));
        }
        System.out.println("\nAverage times over " + numTrials + " trials:");
        System.out.printf("Average Bubble Sort Time: %,d ns\n", (avgBubbleTime / numTrials));
        System.out.printf("Average Insertion Sort Time: %,d ns\n", (avgInsertionTime / numTrials));
        System.out.printf("Average Selection Sort Time: %,d ns\n", (avgSelectionTime / numTrials));
    }
}
