package ElementaryProgramming_2;

import java.util.Scanner;

public class ClassScoreGood {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your grade:");
        int grade = scan.nextInt();

        if (grade >= 100) {
            System.out.println("You got a 100!");
        } else if (grade >= 90){
            System.out.println("You got an A!");
        } else if (grade >= 80){
            System.out.println("You got a B!");
        } else if (grade >= 70) {
            System.out.println("You got a C!");
        } else if (grade >= 60) {
            System.out.println("You got a D!");
        } else {
            System.out.println("You got an F!");
        }
    }
}
