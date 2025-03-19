package Recursion_14;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/19/2025, Wednesday
 **/
public class SpaceComplexityExamples {
    // O(1) - Constant space
    public int findMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // O(n) - Linear space
    public int[] duplicate(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    // O(n²) - Quadratic space
    public int[][] createMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = i * j;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {

    }
}
