package Recursion_14;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/19/2025, Wednesday
 **/
public class TimeComplexityExamples {
    // O(1) - Constant time
    public boolean isFirstElementNull(Integer[] array) {
        return array[0] == null;
    }

    // O(n) - Linear time
    public int sum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    // O(n²) - Quadratic time
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
