package Arrays_6;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/8/2025, Saturday
 **/
public class BinarySearch {

    public static int binarySearch(int[] list, int elem) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (list[mid] > elem) {
                high = mid - 1;
            } else if (list[mid] < elem) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] list = new int[]{0, 1, 2, 4, 7, 105, 610, 798987, 800000};
//        System.out.println(BinarySearch.binarySearch(list, 610));
        for(int i = 0; i < list.length / 2; i++) {
            int temp = list[i];
            list[i] = list[list.length - 1 - i];
            list[list.length - 1 - i] = temp;
        }
        for (int num : list) {
            System.out.println(num);
        }
    }
}
