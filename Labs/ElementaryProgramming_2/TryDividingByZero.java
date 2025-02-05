package ElementaryProgramming_2;

public class TryDividingByZero {
    public static void main(String[] args) {
        try {
            System.out.println(9/0);
        } catch (RuntimeException e) {
            System.err.println("Error: "+e);
        }
        System.out.println("Continue with the program");
    }
}
