package ErrorHandling_11;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/

public class Assertion {
    public static void main(String[] args) {
        // Get Assertions for one file:
        // Assertion > Run Configuration > Edit > Modify Options
        // > Add VM options > type -ea > Apply

        // Get Assertions Globally:
        // From the top hamburger menu on Intellij, select
        // Run > Edit Configurations... > Edit Configuration Templates...
        // > make sure Application is selected, find VM Options underneath Build and Run and java 17 and type "-ea" without any quotes
        // > hit Apply
        //
        // Note: This will not affect pre-existing run configurations!
        //   If you want to reset these run configurations, select whichever
        //   ones and then hit the minus sign (-) to remove them. They will
        //   be created again next time you run your program.
        try {
            assert 2 == 5 : "Two does not equal 5!";
        } catch (AssertionError e) {
            e.printStackTrace();
        }
    }
}
