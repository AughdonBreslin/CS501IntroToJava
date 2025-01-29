package ElementaryProgramming;

import java.util.Scanner;

public class ClassScoreBad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your grade:");
        int grade = scan.nextInt();

        if (grade >= 60) {
            if (grade >= 70) {
                if (grade >= 80) {
                    if (grade >= 90) {
                        if (grade >= 100) {
                            System.out.println("You got a 100!");
                        } else {
                            System.out.println("You got an A!");
                        }
                    } else {
                        System.out.println("You got a B!");
                    }
                } else {
                    System.out.println("You got a C!");
                }
            } else {
                System.out.println("You got a D!");
            }
        } else {
            System.out.println("You got an F!");
        }
    }
}
