package Assignment2;
import java.util.*;
/**
 * @author: Agnim Gupta
 * @class: CS501 Intro to Java
 * @description:
 * @date: 24-02-2025,Monday
 **/

//ask about docstrings
public class Assignment2 {
    /**
     * Given the coefficients of a quadratic equation, find the
     * array of roots of the equation. Round to three decimal
     * places and return the roots in an array of size 2. If
     * imaginary, set roots to Double.NaN (Not a Number).
     * The function uses quadratic equation and round function from math library to generate the roots.
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static double[] quadraticEquation(double a, double b, double c) {
        double[] result = new double[2];
        Double Discriminant = Math.pow(b, 2) - (4 * a * c);
        double sqrtDiscriminant = Math.sqrt(Discriminant);

        if (Discriminant > 0) {
            double root1 = (-b+sqrtDiscriminant)/2*a;
            double root2 = (-b-sqrtDiscriminant)/2*a;
            result[0] = Math.round(root1 * 1000) / 1000.0;
            result[1] = Math.round(root2 * 1000) / 1000.0;
        } else if (Discriminant < 0) {
            result[0] = Double.NaN;
            result[1] = Double.NaN;
        }else {
            double root = (-b-sqrtDiscriminant)/2*a;
            result[0] = Math.round(root * 1000) / 1000.0;
            result[1] = result[0];
        }
        return result;
    }

    /**
     * Given an array, find the max, min, average, and sum.
     * Return the answers in an array of size 4 in the order above.
     *Calculates the values using a single for loop
     *
     * @param arr
     * @return
     */
    public static double[] arrayOperations(double[] arr) {
        double[] result = new double[4];
        int size = arr.length;
        double max = arr[0];
        double min = arr[0];

        for(int i=0; i<size; i++){
            if(max<arr[i]){
                max = arr[i];
            }if(min>arr[i]){
                min = arr[i];
            }
            result[3] += arr[i];
        }
        result[0] = max;
        result[1] = min;
        result[2] = result[3]/size;
        return result;
    }

    /**
     * Reverse the elements in arr.
     *Uses 2 pointer approach to reverse the elements
     * @param arr
     */
    public static void reverseArray(int[] arr) {
        int start=0;
        int end = arr.length-1;
        int temp_int;

        while(start<end){
            temp_int = arr[start];
            arr[start] = arr[end];
            arr[end] = temp_int;
            start++;
            end--;
        }
    }

    /**
     * Remove all duplicates from an array. The result should
     * have a length corresponding to the number of unique elements.
     *Uses 2 pointer approach to remove the duplicates.
     * @param arr
     * @return
     */
    public static int[] removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;         }
        java.util.Arrays.sort(arr);
        int unique_Count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                unique_Count++;
            }
        }

        int[] result = new int[unique_Count];
        result[0] = arr[0];
        int pos = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result[pos++] = arr[i];
            }
        }

        return result;
    }

    /**
     *Move all zeros to the end of the array while maintaining the order of other
     * elements.
     *Uses 2 pointer approach to move the elements with a value of 0 to the end.
     * @param arr
     */
    public static void moveZeros(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int arr_size = arr.length;
        int start_pointer = 0;
        int end_pointer = 0;
        int temp = 0;

        //
        while(end_pointer<arr_size){
            if(arr[end_pointer] != 0){
                temp = arr[start_pointer];
                arr[start_pointer] = arr[end_pointer];
                arr[end_pointer] = temp;

                start_pointer++;
            }
            end_pointer++;
        }
    }

    /**
     * Find the second-largest element in an array without sorting.
     *Uses variables and loop to find the second largest element.
     * @param arr
     * @return
     */
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return Integer.MIN_VALUE; // Or throw an exception
        }
        int max = arr[0];
        int second_max = max;
        int size = arr.length;

        for (int i=1; i < arr.length; i++) {
            if (arr[i]>max) {
                second_max = max;
                max = arr[i];
            } else if (arr[i] < max && arr[i] > second_max) {
                second_max = arr[i];
            }
        }
        return second_max;
    }

    /**
     * Transpose a square matrix (swaps rows and columns in-place).
     * Transposes the matrix using loops.
     * @param matrix
     */
    public static void transposeMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            System.out.println("Empty matrix. Nothing to transpose.");
            return;
        }
        int temp = 0;
        int size_rows = matrix.length;

        for(int i=0; i<size_rows; i++){
            for(int j=i; j<size_rows;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<size_rows; i++) {
            for (int j = 0; j < size_rows; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Rotate a matrix 90 degrees clockwise.
     * Uses another matrix to append the tranversed elements in clockwise order.
     * @param matrix
     * @return
     */
    public static int[][] rotate90Clockwise(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Empty matrix.");
            int arr[][] = {};
            return arr;
        }
        int size_rows = matrix.length;
        int size_column = matrix[0].length;
        int[][] matrix2 = new int[size_column][size_rows];

        for(int i=0; i<size_rows; i++){
            for(int j=0; j<size_column;j++){
                matrix2[j][size_rows-i-1] = matrix[i][j];
            }
        }
//        for(int i=0; i<size_rows; i++) {
//            for (int j = 0; j < size_rows; j++) {
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
        return matrix2;
    }

    /**
     * Return a 1D array path that traverses the matrix in a clockwise spiral
     * starting from the top left.
     * Ex:
     * { {1, 2, 3},
     * {4, 5, 6},
     * {7, 8, 9}
     * } -> {1, 2, 3, 6, 9, 8, 7, 4, 5}
     * Iterates using 4 variables as endpoints.
     * @param matrix The input matrix
     * @return The spiral path
     */
    public static int[] spiralPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Empty matrix.");
            int arr[]= {};
            return arr;
        }
        int row_size = matrix.length;
        int column_size = matrix[0].length;
        int left  = 0;
        int right = column_size-1;
        int top = 0;
        int bottom = row_size-1;

        int[] result = new int[row_size*column_size];
        int index_result = 0;

        while(left<=right && top<=bottom) {
            for (int i = left; i <= right; i++) {
                result[index_result++] = matrix[top][i];
            }
            top++;
//            System.out.println();
            for (int j = top; j <= bottom; j++) {
                result[index_result++] = matrix[j][right];
            }
            right--;
//            System.out.println();
            for (int i2 = right; i2 >= left; i2--) {
                result[index_result++] = matrix[bottom][i2];
            }
            bottom--;
//            System.out.println();
            for (int j2 = bottom; j2 >= top; j2--) {
                result[index_result++] = matrix[j2][left];
            }
            left++;
//            System.out.println();
        }
        return result;
    }

    /**
     * Helper function for containsSubarray function.
     * @param array
     * @param subarray
     * @param row_size
     * @param column_size
     * @return
     */
    public static boolean verifySubarray(int[][] array, int[][] subarray, int row_size, int column_size){
        int subRow_size = subarray.length;
        int subColumn_size = subarray[0].length;

        if (array == null || subarray == null || subRow_size == 0 || subColumn_size == 0) {
            return false;
        }

        if (row_size<0 || column_size<0 || row_size +subRow_size > array.length || column_size +subColumn_size > array[0].length) {
            return false;
        }

        for(int i=0; i<subRow_size; i++){
            for(int j=0; j<subColumn_size; j++){
                if(array[row_size+i][column_size+j] != subarray[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Given a 3D array, check if it contains a given 2D subarray.
     * Hint: Try solving in lower dimensions first, then move up.
     * Uses helper function above to verify the subarray
     * @param array
     * @param subarray
     * @return
     */
    public static boolean containsSubarray(int[][][] array, int[][] subarray) {
        if (array == null || subarray == null || array.length == 0 || array[0].length ==0 || array[0][0].length ==0 || subarray.length == 0 || subarray[0].length==0) {
            return false;
        }
        int height_size = array.length;
        int row_size = array[0].length;
        int column_size = array[0][0].length;

        int rowb_size = subarray.length;
        int columnb_size = subarray[0].length;

        if (rowb_size > row_size || columnb_size > column_size) {
            return false;
        }

        for(int i=0; i<height_size;i++){
            for(int j=0; j<=row_size-rowb_size; j++){
                for(int k=0; k<= column_size-columnb_size; k++){
                    if(verifySubarray(array[i], subarray, j, k)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        double[] a = Assignment2.quadraticEquation(1,-4,4);
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
        System.out.println();

        double[] input = {69.69, 0, 3.1, -1.7, 1};
        double[] b = Assignment2.arrayOperations(input);
        for(int i=0; i<b.length; i++){
            System.out.println(b[i]);
        }
        System.out.println();

        int[] input2 = {6969, 0, 31, -17, 1};
        Assignment2.reverseArray(input2);
        for(int i=0; i<input2.length; i++){
            System.out.println(input2[i]);
        }
        System.out.println();

        int[] input3 = {11, 11, 10, 12, 15, 20, 20, 11, 30, 31, 31};
        int[] ans = Assignment2.removeDuplicates(input3);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
        System.out.println();

        int[] input4 = {0,3,5,10,0,0,3,0};
        Assignment2.moveZeros(input4);
        for(int i=0; i<input4.length; i++){
            System.out.print(input4[i]+" ");
        }
        System.out.println();

        int c = Assignment2.findSecondLargest(input2);
        System.out.println("Second Largest: "+c);
        System.out.println();

        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        Assignment2.transposeMatrix(matrix);

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {6, 7, 8, 9},
                {11, 12, 13, 14},
                {16, 17, 18, 19},
                {21, 22, 23, 24}
        };
        matrix2 = Assignment2.rotate90Clockwise(matrix2);
        int size_rows = matrix2.length;
        int size_column = matrix2[0].length;
        for(int i=0; i<size_rows; i++) {
            for (int j = 0; j < size_column; j++) {
                System.out.print(matrix2[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        int[][] matrix3 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] mat = {};
        int[] result = Assignment2.spiralPath(matrix3);
        for(int i=0; i<result.length; i++)
            System.out.print(result[i]+" ");
        System.out.println();

        int[][][] matrix3d = {
                {
                        {2,4,6},
                        {4,8,12},
                        {6, 12, 18}
                },
                {
                        {3,6,9},
                        {6,12,18},
                        {9,18,27}
                },
                {
                        {4,8,12},
                        {8,16,24},
                        {12, 24, 36}
                }
        };
        int[][] matrixsub = {
                {12, 18},
                {16,24}
        };
        System.out.println(containsSubarray(matrix3d, matrixsub));
    }
}