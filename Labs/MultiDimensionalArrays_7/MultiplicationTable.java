package MultiDimensionalArrays_7;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/9/2025, Sunday
 **/
public class MultiplicationTable {

    public static int[][] makeTable(int size) {
        int[][] table = new int[size][size];
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                table[r][c] = (r+1)*(c+1);
            }
        }
        return table;
    }

    public static void printTable(int[][] table) {
        System.out.print("   | ");
        for (int i = 0; i < table.length; i++) {
            System.out.printf("%4d", i+1);
        }
        System.out.println("\n---------------------------------------------");
        for (int r = 0; r < table.length; r++) {
            System.out.printf("%2d | ", r+1);
            for (int c = 0; c < table[r].length; c++) {
                System.out.printf("%4d", table[r][c]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] table = makeTable(20);
        printTable(table);
    }
}
