package Objects_8;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/11/2025, Tuesday
 **/
public class Date {
    public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
        System.out.println("The elapsed time since Jan 1, 1970 is " +
                date.getTime() + " milliseconds");
        System.out.println(date.toString());

    }
}
