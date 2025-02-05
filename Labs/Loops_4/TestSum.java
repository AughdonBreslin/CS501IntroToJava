package Loops_4;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/2/2025, Sunday
 **/
public class TestSum {
    public static void main(String[] args) {
        float sum = 0;

        for (float i = 0.01f; i <= 1.0f; i += 0.01f) {
            sum += i;
            System.out.println(sum);
        }
    }
}
