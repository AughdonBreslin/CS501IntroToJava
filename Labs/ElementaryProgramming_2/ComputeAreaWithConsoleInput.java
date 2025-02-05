package ElementaryProgramming_2;

import java.util.Scanner;

public class ComputeAreaWithConsoleInput {
    public static void main(String[] args) {
        double radius = -1;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number for radius: ");
        radius = input.nextDouble();
        System.out.println("The radius of the circle is " + radius);
        double area = Math.pow(radius, 2) * Math.PI;
        System.out.println("The area for the circle of radius " + radius + " is " + area);
    }
}
