package ElementaryProgramming_2;

import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scan.nextLine();
        System.out.println("Hello, " +name+ "!");

        System.out.println("I want to add two numbers, give me the first:");
        String num1 = scan.nextLine();
        System.out.println("Now the second:");
        String num2 = scan.nextLine();
        System.out.print("Result: " + num1+num2);
        System.out.println(". or should it be " + (Integer.parseInt(num1) + Integer.parseInt(num2)) + "? I forget.");
    }
}
