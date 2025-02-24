package Objects_8;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/19/2025, Wednesday
 **/
import java.util.Random;

public class RandomNums {
    public static void main(String[] args) {
        Random generator1 = new Random(501);
        for (int i = 0; i < 11; i++) {
            System.out.printf("%d ", generator1.nextInt(1000));
        }
        System.out.println();
        Random generator2 = new Random(501);
        for (int i = 0; i < 11; i++) {
            System.out.printf("%d ", generator2.nextInt(1000));
        }
    }
}
