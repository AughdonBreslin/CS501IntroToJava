package Methods_5;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/3/2025, Monday
 **/
public class SumFunction {
    public static int sum(int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; i++) {
            sum += i;
        }
        return sum;
    }
    public static int shortcut(int low, int high) {
        return high*(high+1)/2 - low*(low-1)/2;
    }
    public static void main(String[] args) {
        System.out.println(sum(52, 1957));
        System.out.println(shortcut(52, 1957));
    }
}
