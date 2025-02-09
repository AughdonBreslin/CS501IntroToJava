package Methods_5;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/8/2025, Saturday
 **/
public class MaxFunction {

    public static int max(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }
        return num2;
    }

    public static void main(String[] args) {
        System.out.printf("Max of %d and %d is %d.", 55, 88, MaxFunction.max(55, 88));
    }
}
