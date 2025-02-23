package ErrorHandling_11;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/

public class Assertion {
    public static void main(String[] args) {
        // Assertion > Run Configuration > Edit > Modify Options
        // > Add VM options > type -ea > Apply
        try {
            assert 2 == 5 : "Two does not equal 5!";
        } catch (AssertionError e) {
            e.printStackTrace();
        }
    }
}
