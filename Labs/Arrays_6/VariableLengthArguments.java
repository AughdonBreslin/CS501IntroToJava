package Arrays_6;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/8/2025, Saturday
 **/
public class VariableLengthArguments {

    public static double max(double... numbers) {
        if (numbers.length == 0) {
            System.out.print("No arguments passed. ");
            return -1;
        }
        double result = Integer.MIN_VALUE;
        for (double num : numbers) {
            if (num > result) {
                result = num;
            }
        }
        return result;
    }
    public static void main(String[] args) {
       System.out.println(max(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
