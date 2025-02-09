package Arrays_6;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/8/2025, Saturday
 **/
public class SelectionSort {

    /**
     * Takes a list of unsorted numbers and
     * moves the next smallest number to the next index.
     * @param list - a list of doubles
     */
    public void selectionSort(double[] list) {
        // Find the smallest element starting from i
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            swap(list, i, minIndex);

            System.out.printf("Iter %d: ", i);
            for (double num : list) {
                System.out.printf("%.1f ", num);
            }
            System.out.println();
        }
    }

    private void swap(double[] list, int index1, int index2) {
        double temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public static void main(String[] args) {
        double[] numbers = {7.2, 3.5, 9.8, 1.3, 5.6, 8.4, 4.9, 2.1, 6.7, 0.5};
        SelectionSort sorter = new SelectionSort();
        sorter.selectionSort(numbers);
        for (double num : numbers) {
            System.out.printf("%.1f ", num);
        }
    }
}
