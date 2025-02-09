package Arrays_6;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/8/2025, Saturday
 **/
public class ArrayBasics {
    public static void main(String[] args) {
        // 1. Declare and initialize later
        int[] list1;
        list1 = new int[5];

        // 2. Declare and initialize together
        int[] list2 = new int[5];

        // 3. Declare and assign values
        int[] list3 = {1, 2, 3, 4, 5};

        // 4. Declare and assign values later
        int[] list4;
        list4 = new int[]{1, 2, 3, 4, 5};
        list4 = new int[]{6, 7, 8};

        // 5. Declare and initialize with new
        int[] list5 = new int[]{1, 2, 3, 4, 5};
        list5 = new int[]{6, 7, 8};
    }
}
