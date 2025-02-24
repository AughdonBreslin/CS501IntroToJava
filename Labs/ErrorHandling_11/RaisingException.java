package ErrorHandling_11;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/

public class RaisingException {
    public static void myMethod(int num) throws IllegalArgumentException, ArithmeticException {
        if (num == 7) {
            // Ctrl + Click for definition
            throw new IllegalArgumentException("I don't like the number 7.");
        }
        if (num > 7) {
            throw new ArithmeticException("This number can be represented as 7 + x.");
        }
        System.out.println("Good.");
    }


    public static void main(String[] args) throws Exception{
        try {
            myMethod(5);
            myMethod(7);
            myMethod(8);
        } catch (IllegalArgumentException e) {
            System.err.println("Error1: " + e);
        } catch (ArithmeticException e) {
            System.err.println("Error2: " + e);
            throw new Exception("I dont want to deal with this.");
        } finally {
            System.out.println("Regardless of what happened, we're here now.");
        }
    }
}
