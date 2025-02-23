package Methods_5;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/8/2025, Saturday
 **/
public class Overload {

    public static int max(int a, int b) {
        System.out.println("Int!");
        return (a > b) ? a : b;
    }

//    public static String max(int a, int b) {
//        return (a > b) ? a+"" : b+"";
//    }

    public static char max(char a, char b) {
        System.out.println("Char!");
        return (a > b) ? a : b;
    }

    public static double max(double a, double b) {
        System.out.println("double!");
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        // Compiler tries to choose which to use.
        // Can get complicated, but tries to find function that most specifically fits the parameters.
        System.out.println(Overload.max(1, 2));
        System.out.println(Overload.max((char)1, 2));
        System.out.println(Overload.max((char)1, (char)2));

        System.out.println(Overload.max('a', 'b'));
        System.out.println(Overload.max((int)'a', 'b'));
        System.out.println(Overload.max((int)'a', (int)'b'));

        System.out.println(Overload.max(1.0, 2));
        System.out.println(Overload.max(1, (double)2));

    }
}
