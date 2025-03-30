import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/2/2025, Sunday
 **/

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Assignment2Test {
    private final Assignment2Key test = new Assignment2Key();


    @BeforeAll
    static void setup() {
        System.out.println("Starting test suite...");
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        System.out.println("\nRunning test: " + testInfo.getDisplayName());
    }

    @AfterEach
    void countAssertions(TestInfo testInfo) {
        System.out.println("Finished: " + testInfo.getDisplayName());
    }

    @AfterAll
    static void summary() {
        System.out.println("\n=== Test Summary ===");
        System.out.println("Total assertions in test suite: " + 80);
    }

    @Test
    @DisplayName("Test quadraticEquation: real roots 1, -3, 2")
    void testQuadraticEquation1() {
        double[] roots = test.quadraticEquation(1, -3, 2);
        assertArrayEquals(new double[]{2.0, 1.0}, roots, 0.001);
    }

    @Test
    @DisplayName("Test quadraticEquation: real roots 1, 2, 1")
    void testQuadraticEquation2() {
        double[] roots = test.quadraticEquation(1, 2, 1);
        assertArrayEquals(new double[]{-1.0, -1.0}, roots, 0.001);
    }

    @Test
    @DisplayName("Test quadraticEquation: imaginary roots 1, 2, 5")
    void testQuadraticEquation3() {
        double[] roots = test.quadraticEquation(1, 2, 5);
        assertArrayEquals(new double[]{Double.NaN, Double.NaN}, roots, 0.001);
    }

    @Test
    @DisplayName("Test quadraticEquation: real roots 2, -4, -6")
    void testQuadraticEquation4() {
        double[] roots = test.quadraticEquation(2, -4, -6);
        assertArrayEquals(new double[]{3.0, -1.0}, roots, 0.001);
    }

    @Test
    @DisplayName("Test quadraticEquation: real roots 1, 0, -4")
    void testQuadraticEquation5() {
        double[] roots = test.quadraticEquation(1, 0, -4);
        assertArrayEquals(new double[]{2.0, -2.0}, roots, 0.001);
    }

    @Test
    @DisplayName("Test quadraticEquation: real roots 1, -5, 6")
    void testQuadraticEquation6() {
        double[] roots = test.quadraticEquation(1, -5, 6);
        assertArrayEquals(new double[]{3.0, 2.0}, roots, 0.001);
    }

    @Test
    @DisplayName("Test quadraticEquation: real roots 1, 0, 0")
    void testQuadraticEquation7() {
        double[] roots = test.quadraticEquation(1, 0, 0);
        assertArrayEquals(new double[]{0.0, 0.0}, roots, 0.001);
    }

    @Test
    @DisplayName("Test quadraticEquation: imaginary roots 1, 0, 1")
    void testQuadraticEquation8() {
        double[] roots = test.quadraticEquation(1, 0, 1);
        assertArrayEquals(new double[]{Double.NaN, Double.NaN}, roots, 0.001);
    }

    @Test
    @DisplayName("Test arrayOperations: array {1, 2, 3, 4, 5}")
    void testArrayOperations1() {
        double[] result = test.arrayOperations(new double[]{1, 2, 3, 4, 5});
        assertArrayEquals(new double[]{5.0, 1.0, 3.0, 15.0}, result, 0.001);
    }

    @Test
    @DisplayName("Test arrayOperations: array {10, 20, 30}")
    void testArrayOperations2() {
        double[] result = test.arrayOperations(new double[]{10, 20, 30});
        assertArrayEquals(new double[]{30.0, 10.0, 20.0, 60.0}, result, 0.001);
    }

    @Test
    @DisplayName("Test arrayOperations: array {-1, -2, -3}")
    void testArrayOperations3() {
        double[] result = test.arrayOperations(new double[]{-1, -2, -3});
        assertArrayEquals(new double[]{-1.0, -3.0, -2.0, -6.0}, result, 0.001);
    }

    @Test
    @DisplayName("Test arrayOperations: array {0, 0, 0}")
    void testArrayOperations4() {
        double[] result = test.arrayOperations(new double[]{0, 0, 0});
        assertArrayEquals(new double[]{0.0, 0.0, 0.0, 0.0}, result, 0.001);
    }

    @Test
    @DisplayName("Test arrayOperations: array {5}")
    void testArrayOperations5() {
        double[] result = test.arrayOperations(new double[]{5});
        assertArrayEquals(new double[]{5.0, 5.0, 5.0, 5.0}, result, 0.001);
    }

    @Test
    @DisplayName("Test arrayOperations: array {1.5, 2.5, 3.5}")
    void testArrayOperations6() {
        double[] result = test.arrayOperations(new double[]{1.5, 2.5, 3.5});
        assertArrayEquals(new double[]{3.5, 1.5, 2.5, 7.5}, result, 0.001);
    }

    @Test
    @DisplayName("Test arrayOperations: array {-10, 0, 10}")
    void testArrayOperations7() {
        double[] result = test.arrayOperations(new double[]{-10, 0, 10});
        assertArrayEquals(new double[]{10.0, -10.0, 0.0, 0.0}, result, 0.001);
    }

    @Test
    @DisplayName("Test arrayOperations: empty array - Can also be intentional throw")
    void testArrayOperations8() {
        double[] result = test.arrayOperations(new double[]{});
        assertArrayEquals(new double[]{0.0, 0.0, 0.0, 0.0}, result, 0.001);
    }

    @Test
    @DisplayName("Test reverseArray: array {1, 2, 3, 4, 5}")
    void testReverseArray1() {
        int[] arr = {1, 2, 3, 4, 5};
        test.reverseArray(arr);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr);
    }

    @Test
    @DisplayName("Test reverseArray: array {10, 20, 30}")
    void testReverseArray2() {
        int[] arr = {10, 20, 30};
        test.reverseArray(arr);
        assertArrayEquals(new int[]{30, 20, 10}, arr);
    }

    @Test
    @DisplayName("Test reverseArray: array {1}")
    void testReverseArray3() {
        int[] arr = {1};
        test.reverseArray(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    @DisplayName("Test reverseArray: array {5, 4, 3, 2, 1}")
    void testReverseArray4() {
        int[] arr = {5, 4, 3, 2, 1};
        test.reverseArray(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    @DisplayName("Test reverseArray: array {0, 0, 0}")
    void testReverseArray5() {
        int[] arr = {0, 0, 0};
        test.reverseArray(arr);
        assertArrayEquals(new int[]{0, 0, 0}, arr);
    }

    @Test
    @DisplayName("Test reverseArray: array {-1, -2, -3}")
    void testReverseArray6() {
        int[] arr = {-1, -2, -3};
        test.reverseArray(arr);
        assertArrayEquals(new int[]{-3, -2, -1}, arr);
    }

    @Test
    @DisplayName("Test reverseArray: array {1, 3, 5, 7}")
    void testReverseArray7() {
        int[] arr = {1, 3, 5, 7};
        test.reverseArray(arr);
        assertArrayEquals(new int[]{7, 5, 3, 1}, arr);
    }

    @Test
    @DisplayName("Test reverseArray: empty array - should not throw, empty is valid")
    void testReverseArray8() {
        int[] arr = {};
        test.reverseArray(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    @DisplayName("Test removeDuplicates: array {1, 2, 3, 2, 1}")
    void testRemoveDuplicates1() {
        int[] result = test.removeDuplicates(new int[]{1, 2, 3, 2, 1});
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    @DisplayName("Test removeDuplicates: array {5, 5, 5}")
    void testRemoveDuplicates2() {
        int[] result = test.removeDuplicates(new int[]{5, 5, 5});
        assertArrayEquals(new int[]{5}, result);
    }

    @Test
    @DisplayName("Test removeDuplicates: array {1, 2, 3}")
    void testRemoveDuplicates3() {
        int[] result = test.removeDuplicates(new int[]{1, 2, 3});
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    @DisplayName("Test removeDuplicates: array {1, 1, 1, 1}")
    void testRemoveDuplicates4() {
        int[] result = test.removeDuplicates(new int[]{1, 1, 1, 1});
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    @DisplayName("Test removeDuplicates: array {10, 20, 10, 30}")
    void testRemoveDuplicates5() {
        int[] result = test.removeDuplicates(new int[]{10, 20, 10, 30});
        assertArrayEquals(new int[]{10, 20, 30}, result);
    }

    @Test
    @DisplayName("Test removeDuplicates: array {0, 0, 0, 0}")
    void testRemoveDuplicates6() {
        int[] result = test.removeDuplicates(new int[]{0, 0, 0, 0});
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    @DisplayName("Test removeDuplicates: array {-1, -2, -1}")
    void testRemoveDuplicates7() {
        int[] result = test.removeDuplicates(new int[]{-1, -2, -1});
        assertArrayEquals(new int[]{-1, -2}, result);
    }

    @Test
    @DisplayName("Test removeDuplicates: empty array - should not throw, empty is valid")
    void testRemoveDuplicates8() {
        int[] result = test.removeDuplicates(new int[]{});
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    @DisplayName("Test moveZeros: array {0, 1, 0, 3, 12}")
    void testMoveZeros1() {
        int[] arr = {0, 1, 0, 3, 12};
        test.moveZeros(arr);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, arr);
    }

    @Test
    @DisplayName("Test moveZeros: array {0, 0, 0}")
    void testMoveZeros2() {
        int[] arr = {0, 0, 0};
        test.moveZeros(arr);
        assertArrayEquals(new int[]{0, 0, 0}, arr);
    }

    @Test
    @DisplayName("Test moveZeros: array {1, 2, 3}")
    void testMoveZeros3() {
        int[] arr = {1, 2, 3};
        test.moveZeros(arr);
        assertArrayEquals(new int[]{1, 2, 3}, arr);
    }

    @Test
    @DisplayName("Test moveZeros: array {0, 0, 1}")
    void testMoveZeros4() {
        int[] arr = {0, 0, 1};
        test.moveZeros(arr);
        assertArrayEquals(new int[]{1, 0, 0}, arr);
    }

    @Test
    @DisplayName("Test moveZeros: array {1, 0, 2, 0, 3}")
    void testMoveZeros5() {
        int[] arr = {1, 0, 2, 0, 3};
        test.moveZeros(arr);
        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, arr);
    }

    @Test
    @DisplayName("Test moveZeros: array {0}")
    void testMoveZeros6() {
        int[] arr = {0};
        test.moveZeros(arr);
        assertArrayEquals(new int[]{0}, arr);
    }

    @Test
    @DisplayName("Test moveZeros: array {1, 0, 0, 2}")
    void testMoveZeros7() {
        int[] arr = {1, 0, 0, 2};
        test.moveZeros(arr);
        assertArrayEquals(new int[]{1, 2, 0, 0}, arr);
    }

    @Test
    @DisplayName("Test moveZeros: empty array - should not throw, empty is valid")
    void testMoveZeros8() {
        int[] arr = {};
        test.moveZeros(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    @DisplayName("Test findSecondLargest: array {1, 2, 3, 4, 5}")
    void testFindSecondLargest1() {
        assertEquals(4, test.findSecondLargest(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("Test findSecondLargest: array {10, 20, 30}")
    void testFindSecondLargest2() {
        assertEquals(20, test.findSecondLargest(new int[]{10, 20, 30}));
    }

    @Test
    @DisplayName("Test findSecondLargest: array {5, 5, 5} - Can also be intentional throw (not AssertionFailedError)")
    void testFindSecondLargest3() {
        assertEquals(5, test.findSecondLargest(new int[]{5, 5, 5}));
    }

    @Test
    @DisplayName("Test findSecondLargest: array {1} - Should be handled or intentional throw (not AssertionFailedError)")
    void testFindSecondLargest4() {
        // TODO: Please let me know if theres a better way to check this throws
        assertEquals(Integer.MIN_VALUE, test.findSecondLargest(new int[]{1}));
    }

    @Test
    @DisplayName("Test findSecondLargest: array {-1, -2, -3}")
    void testFindSecondLargest5() {
        assertEquals(-2, test.findSecondLargest(new int[]{-1, -2, -3}));
    }

    @Test
    @DisplayName("Test findSecondLargest: array {0, 0, 0} - Can also be intentional throw (not AssertionFailedError)")
    void testFindSecondLargest6() {
        assertEquals(0, test.findSecondLargest(new int[]{0, 0, 0}));
    }

    @Test
    @DisplayName("Test findSecondLargest: array {1, 3, 2}")
    void testFindSecondLargest7() {
        assertEquals(2, test.findSecondLargest(new int[]{1, 3, 2}));
    }

    @Test
    @DisplayName("Test findSecondLargest: empty array - Should be handled or intentional throw")
    void testFindSecondLargest8() {
        // TODO: Please let me know if theres a better way to check this
        assertEquals(Integer.MIN_VALUE, test.findSecondLargest(new int[]{}));
    }

    @Test
    @DisplayName("Test transposeMatrix: 2x2 square matrix")
    void testTransposeMatrix1() {
        int[][] matrix = {{1, 2}, {3, 4}};
        test.transposeMatrix(matrix);
        assertArrayEquals(new int[][]{{1, 3}, {2, 4}}, matrix);
    }

    @Test
    @DisplayName("Test transposeMatrix: 3x3 square matrix")
    void testTransposeMatrix2() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        test.transposeMatrix(matrix);
        assertArrayEquals(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}, matrix);
    }

    @Test
    @DisplayName("Test transposeMatrix: 1x1 square matrix")
    void testTransposeMatrix3() {
        int[][] matrix = {{1}};
        test.transposeMatrix(matrix);
        assertArrayEquals(new int[][]{{1}}, matrix);
    }

    @Test
    @DisplayName("Test transposeMatrix: 4x4 square matrix")
    void testTransposeMatrix4() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        test.transposeMatrix(matrix);
        assertArrayEquals(new int[][]{{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 16}}, matrix);
    }

    @Test
    @DisplayName("Test transposeMatrix: empty matrix")
    void testTransposeMatrix5() {
        int[][] matrix = {};
        test.transposeMatrix(matrix);
        assertArrayEquals(new int[][]{}, matrix);
    }

    @Test
    @DisplayName("Test transposeMatrix: 2x2 square matrix with negative numbers")
    void testTransposeMatrix6() {
        int[][] matrix = {{-1, -2}, {-3, -4}};
        test.transposeMatrix(matrix);
        assertArrayEquals(new int[][]{{-1, -3}, {-2, -4}}, matrix);
    }

    @Test
    @DisplayName("Test transposeMatrix: 3x3 square matrix with zeros")
    void testTransposeMatrix7() {
        int[][] matrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        test.transposeMatrix(matrix);
        assertArrayEquals(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, matrix);
    }

    @Test
    @DisplayName("Test transposeMatrix: 2x2 square matrix with mixed positive and negative numbers")
    void testTransposeMatrix8() {
        int[][] matrix = {{1, -2}, {-3, 4}};
        test.transposeMatrix(matrix);
        assertArrayEquals(new int[][]{{1, -3}, {-2, 4}}, matrix);
    }

    @Test
    @DisplayName("Test rotate90Clockwise: 2x2 matrix")
    void testRotate90Clockwise1() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[][] result = test.rotate90Clockwise(matrix);
        assertArrayEquals(new int[][]{{3, 1}, {4, 2}}, result);
    }

    @Test
    @DisplayName("Test rotate90Clockwise: 3x3 matrix")
    void testRotate90Clockwise2() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = test.rotate90Clockwise(matrix);
        assertArrayEquals(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}, result);
    }

    @Test
    @DisplayName("Test rotate90Clockwise: 1x1 matrix")
    void testRotate90Clockwise3() {
        int[][] matrix = {{1}};
        int[][] result = test.rotate90Clockwise(matrix);
        assertArrayEquals(new int[][]{{1}}, result);
    }

    @Test
    @DisplayName("Test rotate90Clockwise: 2x3 matrix")
    void testRotate90Clockwise4() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[][] result = test.rotate90Clockwise(matrix);
        assertArrayEquals(new int[][]{{4, 1}, {5, 2}, {6, 3}}, result);
    }

    @Test
    @DisplayName("Test rotate90Clockwise: 3x2 matrix")
    void testRotate90Clockwise5() {
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result = test.rotate90Clockwise(matrix);
        assertArrayEquals(new int[][]{{5, 3, 1}, {6, 4, 2}}, result);
    }

    @Test
    @DisplayName("Test rotate90Clockwise: empty matrix - should not throw, empty is valid")
    void testRotate90Clockwise6() {
        int[][] matrix = {};
        int[][] result = test.rotate90Clockwise(matrix);
        assertArrayEquals(new int[][]{}, result);
    }

    @Test
    @DisplayName("Test rotate90Clockwise: single row matrix")
    void testRotate90Clockwise7() {
        int[][] matrix = {{1, 2, 3}};
        int[][] result = test.rotate90Clockwise(matrix);
        assertArrayEquals(new int[][]{{1}, {2}, {3}}, result);
    }

    @Test
    @DisplayName("Test rotate90Clockwise: single column matrix")
    void testRotate90Clockwise8() {
        int[][] matrix = {{1}, {2}, {3}};
        int[][] result = test.rotate90Clockwise(matrix);
        assertArrayEquals(new int[][]{{3, 2, 1}}, result);
    }

    @Test
    @DisplayName("Test spiralPath: 3x3 matrix")
    void testSpiralPath1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = test.spiralPath(matrix);
        assertArrayEquals(new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5}, result);
    }

    @Test
    @DisplayName("Test spiralPath: 2x2 matrix")
    void testSpiralPath2() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[] result = test.spiralPath(matrix);
        assertArrayEquals(new int[]{1, 2, 4, 3}, result);
    }

    @Test
    @DisplayName("Test spiralPath: 1x1 matrix")
    void testSpiralPath3() {
        int[][] matrix = {{1}};
        int[] result = test.spiralPath(matrix);
        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    @DisplayName("Test spiralPath: 2x3 matrix")
    void testSpiralPath4() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[] result = test.spiralPath(matrix);
        assertArrayEquals(new int[]{1, 2, 3, 6, 5, 4}, result);
    }

    @Test
    @DisplayName("Test spiralPath: 3x2 matrix")
    void testSpiralPath5() {
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        int[] result = test.spiralPath(matrix);
        assertArrayEquals(new int[]{1, 2, 4, 6, 5, 3}, result);
    }

    @Test
    @DisplayName("Test spiralPath: empty matrix - should not throw, empty is valid")
    void testSpiralPath6() {
        int[][] matrix = {};
        int[] result = test.spiralPath(matrix);
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    @DisplayName("Test spiralPath: single row matrix")
    void testSpiralPath7() {
        int[][] matrix = {{1, 2, 3}};
        int[] result = test.spiralPath(matrix);
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    @DisplayName("Test spiralPath: single column matrix")
    void testSpiralPath8() {
        int[][] matrix = {{1}, {2}, {3}};
        int[] result = test.spiralPath(matrix);
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    @DisplayName("Test containsSubarray: 3D array contains 2D subarray")
    void testContainsSubarray1() {
        int[][][] array = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};
        int[][] subarray = {{3, 4}};
        assertTrue(test.containsSubarray(array, subarray));
    }

    @Test
    @DisplayName("Test containsSubarray: 3D array does not contain 2D subarray")
    void testContainsSubarray2() {
        int[][][] array = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};
        int[][] subarray = {{9, 10}};
        assertFalse(test.containsSubarray(array, subarray));
    }

    @Test
    @DisplayName("Test containsSubarray: empty 3D array")
    void testContainsSubarray3() {
        int[][][] array = {};
        int[][] subarray = {{1, 2}};
        assertFalse(test.containsSubarray(array, subarray));
    }

    @Test
    @DisplayName("Test containsSubarray: empty 2D subarray")
    void testContainsSubarray4() {
        int[][][] array = {{{1, 2}, {3, 4}}};
        int[][] subarray = {};
        assertFalse(test.containsSubarray(array, subarray));
    }

    @Test
    @DisplayName("Test containsSubarray: 3D array contains subarray at different depth")
    void testContainsSubarray5() {
        int[][][] array = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};
        int[][] subarray = {{5, 6}};
        assertTrue(test.containsSubarray(array, subarray));
    }

    @Test
    @DisplayName("Test containsSubarray: 3D array contains subarray with multiple rows")
    void testContainsSubarray6() {
        int[][][] array = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};
        int[][] subarray = {{6}, {8}};
        assertTrue(test.containsSubarray(array, subarray));
    }

    @Test
    @DisplayName("Test containsSubarray: 3D array does not contain subarray with multiple rows")
    void testContainsSubarray7() {
        int[][][] array = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};
        int[][] subarray = {{5, 6}, {7, 9}};
        assertFalse(test.containsSubarray(array, subarray));
    }

    @Test
    @DisplayName("Test containsSubarray: 3D array contains subarray with single element")
    void testContainsSubarray8() {
        int[][][] array = {{{1}}, {{2}}};
        int[][] subarray = {{1}};
        assertTrue(test.containsSubarray(array, subarray));
    }
}