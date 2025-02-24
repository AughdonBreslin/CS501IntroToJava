package Arrays_6;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/8/2025, Saturday
 **/
public class Swap {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        for (int num : arr) {
            System.out.print(num+ " ");
        }
        System.out.println();

        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;

        for (int num : arr) {
            System.out.print(num+ " ");
        }
    }
}
