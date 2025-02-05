package Loops_4;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/2/2025, Sunday
 **/
public class TimeComplexityQuestion {
    public static void main(String[] args) {
        int sum = 0;
        int number = 0;
        while (number < 1000000000) {
            number++;
            sum += number;
            System.out.printf("Iteration: %d, sum: %d\n", number, sum);
            if (sum > 1000) {
                break;
            }
        }
        System.out.println("Thank you, that would have taken a while. But how long did this take?");
    }
}
