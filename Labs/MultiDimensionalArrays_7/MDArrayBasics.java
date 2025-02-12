package MultiDimensionalArrays_7;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/9/2025, Sunday
 **/
public class MDArrayBasics {
    public static void main(String[] args) {
        // 1. Direct Initialization
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // 2. Direct Initialization with new
        int[][] arr2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // 3. Declaration with fixed size
        int[][] arr3 = new int[3][3];
        // and initialize later:
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                arr[r][c] = (r+1)*(c+1);
            }
        }

        // 4. Declaration for jagged array
        int[][] arr4 = new int[3][];
        arr4[0] = new int[2];
        arr4[1] = new int[4];
        arr4[2] = new int[3];
    }
}
