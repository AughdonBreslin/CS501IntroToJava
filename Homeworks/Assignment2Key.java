/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/9/2025, Sunday
 **/
public class Assignment2Key {
    /**
     * Given the coefficients of a quadratic equation, find the
     * array of roots of the equation. Round to three decimal
     * places and return the roots in an array of size 2. If
     * imaginary, set roots to Double.NaN (Not a Number).
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static double[] quadraticEquation(double a, double b, double c) {
        double[] roots = new double[2];
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            // No real roots, return NaN
            roots[0] = Double.NaN;
            roots[1] = Double.NaN;
        } else {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            roots[0] = (-b + sqrtDiscriminant) / (2 * a);
            roots[1] = (-b - sqrtDiscriminant) / (2 * a);

            // Round to 3 decimal places
            roots[0] = Math.round(roots[0] * 1000.0) / 1000.0;
            roots[1] = Math.round(roots[1] * 1000.0) / 1000.0;
        }

        return roots;
    }

    /**
     * Given an array, find the max, min, average, and sum.
     * Return the answers in an array of size 4 in the order above.
     * @param arr
     * @return
     */
    public static double[] arrayOperations(double[] arr) {
        if (arr.length == 0) return new double[]{0, 0, 0, 0}; // Edge case for empty array

        double max = arr[0];
        double min = arr[0];
        double sum = 0;

        for (double num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
            sum += num;
        }

        double avg = sum / arr.length;
        return new double[]{max, min, avg, sum};
    }

    /**
     * Reverse the elements in arr.
     * @param arr
     */
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Remove all duplicates from an array. The result should
     * have a length corresponding to the number of unique elements.
     * @param arr
     * @return
     */
    public static int[] removeDuplicates(int[] arr) {
        if (arr.length == 0) return arr; // Edge case for empty array

        int[] temp = new int[arr.length]; // Temporary array to store unique elements
        int uniqueCount = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;

            // Check if arr[i] is already in temp
            for (int j = 0; j < uniqueCount; j++) {
                if (arr[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            // If it's not a duplicate, add it to temp
            if (!isDuplicate) {
                temp[uniqueCount] = arr[i];
                uniqueCount++;
            }
        }

        // Manually create the result array with the correct size
        int[] result = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i]; // Copy values one by one
        }

        return result;
    }

    /**
     * Move all zeros to the end of the array while maintaining the order of other elements.
     * @param arr The input array.
     */
    public static void moveZeros(int[] arr) {
        int index = 0; // Pointer for non-zero elements

        // Move non-zero elements forward
        for (int num : arr) {
            if (num != 0) {
                arr[index++] = num;
            }
        }

        // Fill the remaining positions with zero
        while (index < arr.length) {
            arr[index++] = 0;
        }
    }

    /**
     * Find the second-largest element in an array without sorting.
     * @param arr The input array.
     * @return The second-largest element, or Integer.MIN_VALUE if it doesn't exist.
     */
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) return Integer.MIN_VALUE; // Not enough elements

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest; // Update second largest
                largest = num; // Update largest
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }

    /**
     * Transpose a square matrix (swaps rows and columns in-place).
     * @param matrix The input square matrix.
     */
    public static void transposeMatrix(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * Rotate a matrix 90 degrees clockwise.
     * @param matrix The input matrix
     * @return The rotated matrix
     */
    public static int[][] rotate90Clockwise(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rotated = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[j][rows - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    /**
     * Return a 1D array path that traverses the matrix in a clockwise spiral starting from the top left.
     * Ex:
     *  { {1, 2, 3},
     *    {4, 5, 6},
     *    {7, 8, 9}
     *  } -> {1, 2, 3, 6, 9, 8, 7, 4, 5}
     * @param matrix The input matrix
     * @return The spiral path
     */
    public static int[] spiralPath(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int[] path = new int[matrix.length*matrix[0].length];
        int pos = 0;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                path[pos++] = matrix[top][i];
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                path[pos++] = matrix[i][right];
            }
            right--;

            // Traverse from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    path[pos++] = matrix[bottom][i];
                }
                bottom--;
            }

            // Traverse from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    path[pos++] = matrix[i][left];
                }
                left++;
            }
        }
        return path;
    }

    /**
     * Given a 3D array, check if it contains a given 2D subarray.
     * Hint: Try solving in lower dimensions first, then move up.
     * @param array The input 3D array
     * @param subarray The input 2D array
     * @return Boolean whether the subarray exists within the array
     */
    public static boolean containsSubarray(int[][][] array, int[][] subarray) {
        int subRows = subarray.length;
        int subCols = subarray[0].length;

        for (int i = 0; i <= array.length - subRows; i++) {
            for (int j = 0; j <= array[0].length - subCols; j++) {
                if (matchesSubarray(array, subarray, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean matchesSubarray(int[][][] array, int[][] subarray, int startRow, int startCol) {
        for (int i = 0; i < subarray.length; i++) {
            for (int j = 0; j < subarray[0].length; j++) {
                if (array[startRow + i][startCol + j][0] != subarray[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        for (int num : spiralPath(matrix)) {
            System.out.printf("%2d ", num);
        }
    }
}
