package ErrorHandling_11;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/
import java.util.Scanner;
public class BasicExceptionHandling {

    public static int division(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void calculator(int a, int b) {
        try {
            System.out.printf("%d / %d = %d", a, b, division(a, b));
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two integers: ");
        int a = scan.nextInt();
        int b = scan.nextInt();
        calculator(a, b);
    }
}
