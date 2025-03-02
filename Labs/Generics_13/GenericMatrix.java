package Generics_13;

import java.lang.reflect.Array;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/2/2025, Sunday
 **/

public abstract class GenericMatrix<E extends Number> {
    /** Abstract method for adding two elements of the matrices **/
    protected abstract E add(E o1, E o2);

    /** Abstract method for multiplying two elements of the matrices **/
    protected abstract E multiply(E o1, E o2);

    /** Abstract method for defining zero for the matrix element **/
    protected abstract E zero();

    /**
     * Add two matrices
     * @param m1 first matrix
     * @param m2 second matrix
     * @return the resulting matrix after addition
     * @throws IllegalArgumentException if matrices don't have compatible dimensions
     */
    public E[][] addMatrix(E[][] m1, E[][] m2) {
        // Validate input parameters
        if (m1 == null || m2 == null) {
            throw new IllegalArgumentException("Input matrices cannot be null");
        }

        // Check bounds of the two matrices
        if (m1.length == 0 || m2.length == 0 ||
                m1[0].length == 0 || m2[0].length == 0) {
            throw new IllegalArgumentException("Matrices cannot be empty");
        }

        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            throw new IllegalArgumentException(
                    String.format("Matrix dimensions don't match: %dx%d vs %dx%d",
                            m1.length, m1[0].length, m2.length, m2[0].length));
        }

        // Create result matrix using reflection to maintain generic type
        @SuppressWarnings("unchecked")
        E[][] result = (E[][]) Array.newInstance(m1[0][0].getClass(), m1.length, m1[0].length);

        // Perform addition
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = add(m1[i][j], m2[i][j]);
            }
        }

        return result;
    }

    /**
     * Multiply two matrices
     * @param m1 first matrix
     * @param m2 second matrix
     * @return the resulting matrix after multiplication
     * @throws IllegalArgumentException if matrices don't have compatible dimensions
     */
    public E[][] multiplyMatrix(E[][] m1, E[][] m2) {
        // Validate input parameters
        if (m1 == null || m2 == null) {
            throw new IllegalArgumentException("Input matrices cannot be null");
        }

        // Check bounds of the two matrices
        if (m1.length == 0 || m2.length == 0 ||
                m1[0].length == 0 || m2[0].length == 0) {
            throw new IllegalArgumentException("Matrices cannot be empty");
        }

        // Check if matrices have compatible dimensions for multiplication
        if (m1[0].length != m2.length) {
            throw new IllegalArgumentException(
                    String.format("Incompatible dimensions for multiplication: %dx%d and %dx%d",
                            m1.length, m1[0].length, m2.length, m2[0].length));
        }

        // Create result matrix using reflection to maintain generic type
        @SuppressWarnings("unchecked")
        E[][] result = (E[][]) Array.newInstance( m1[0][0].getClass(), m1.length, m2[0].length);

        // Perform multiplication of two matrices
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();

                for (int k = 0; k < m1[0].length; k++) {
                    result[i][j] = add(result[i][j], multiply(m1[i][k], m2[k][j]));
                }
            }
        }

        return result;
    }

    /**
     * Print matrices, the operator, and their operation result
     * @param m1 first matrix
     * @param m2 second matrix
     * @param m3 result matrix
     * @param op operator character ('+' for addition, '*' for multiplication)
     */
    public static void printResult(Number[][] m1, Number[][] m2, Number[][] m3, char op) {
        // Determine the max width needed for formatting
        int maxWidth = findMaxWidth(m1, m2, m3);
        String format = "%" + maxWidth + "s";

        // Print the matrices side by side
        for (int i = 0; i < Math.max(Math.max(m1.length, m2.length), m3.length); i++) {
            // Print elements from the first matrix
            if (i < m1.length) {
                printMatrixRow(m1[i], format);
            } else {
                printEmptySpace(m1[0].length, maxWidth);
            }

            // Print operator or space
            if (i == m1.length / 2) {
                System.out.printf(format, op);
            } else {
                System.out.printf(format, "");
            }

            // Print elements from the second matrix
            if (i < m2.length) {
                printMatrixRow(m2[i], format);
            } else {
                printEmptySpace(m2[0].length, maxWidth);
            }

            // Print equals sign or space
            if (i == m1.length / 2) {
                System.out.printf(format, "=");
            } else {
                System.out.printf(format, "");
            }

            // Print elements from the result matrix
            if (i < m3.length) {
                printMatrixRow(m3[i], format);
            }

            System.out.println();
        }
    }

    /**
     * Helper method to print a row of a matrix
     */
    private static void printMatrixRow(Number[] row, String format) {
        for (Number element : row) {
            System.out.printf(format, element);
        }
    }

    /**
     * Helper method to print empty spaces
     */
    private static void printEmptySpace(int columns, int width) {
        for (int j = 0; j < columns; j++) {
            System.out.printf("%" + width + "s", "");
        }
    }

    /**
     * Find the maximum width needed for formatting the output
     */
    private static int findMaxWidth(Number[][] m1, Number[][] m2, Number[][] m3) {
        int maxWidth = 0;

        // Check all elements in all matrices
        for (Number[][] matrix : new Number[][][] {m1, m2, m3}) {
            for (Number[] row : matrix) {
                for (Number element : row) {
                    maxWidth = Math.max(maxWidth, element.toString().length());
                }
            }
        }

        // Add padding
        return maxWidth + 2;
    }
}

class IntegerMatrix extends GenericMatrix<Integer> {
    @Override
    protected Integer add(Integer num1, Integer num2) {
        return num1 + num2;
    }

    @Override
    protected Integer multiply(Integer num1, Integer num2) {
        return num1 * num2;
    }

    @Override
    protected Integer zero() {
        return 0;
    }
}

class DoubleMatrix extends GenericMatrix<Double> {
    @Override
    protected Double add(Double num1, Double num2) {
        return num1 + num2;
    }

    @Override
    protected Double multiply(Double num1, Double num2) {
        return num1 * num2;
    }

    @Override
    protected Double zero() {
        return 0.0;
    }
}

class Runner {
    public static void main(String[] args) {
        Integer[][] m1 = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {1, 1, 1}};
        Integer[][] m2 = new Integer[][]{{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};

        IntegerMatrix intMatrix = new IntegerMatrix();

        Integer[][] m3 = intMatrix.addMatrix(m1, m2);

        GenericMatrix.printResult(m1, m2, m3, '+');

        m3 = intMatrix.multiplyMatrix(m1, m2);

        GenericMatrix.printResult(m1, m2, m3, '*');

    }
}