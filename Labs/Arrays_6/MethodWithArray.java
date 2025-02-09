package Arrays_6;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/8/2025, Saturday
 **/
public class MethodWithArray {
    public static void incArray(int[] arr) {
        System.out.println("The reference location received: " +arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 1;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println("The value of arr is reference location: " +arr);
        // Passes the value
        incArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
