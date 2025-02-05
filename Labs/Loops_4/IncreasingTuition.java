package Loops_4;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/2/2025, Sunday
 **/
public class IncreasingTuition {
    public static void main(String[] args) {
        double tuition = 10000;
        int year = 0;
        while (tuition < 20000) {
            tuition *= 1.07;
            year++;
        }
        System.out.printf("In %d years, tuition will be %f.\n", year, tuition);
    }
}
