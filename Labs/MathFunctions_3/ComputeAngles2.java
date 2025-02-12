package MathFunctions_3;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/5/2025, Wednesday
 **/
import java.util.Scanner;

public class ComputeAngles2 {

    public static double computeSides(double x1, double y1, double x2, double y2) {
        double squaredDifferenceX = Math.pow(x1-x2, 2);
        double squaredDifferenceY = Math.pow(y1-y2, 2);

        return Math.sqrt(squaredDifferenceX + squaredDifferenceY);
    }

    public static double computeAngles(double a, double b, double c) {
        return Math.toDegrees(Math.acos((a*a - b*b - c*c) / (-2 * b * c)));
    }

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);


        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        double x3 = Double.parseDouble(args[4]);
        double y3 = Double.parseDouble(args[5]);

        double a = ComputeAngles2.computeSides(x2, y2, x3, y3);
        double b = ComputeAngles2.computeSides(x1, y1, x3, y3);
        double c = ComputeAngles2.computeSides(x1, y1, x2, y2);

        System.out.println("a: " +a+ ", b: " +b+ ", c: " +c);

        double A = ComputeAngles2.computeAngles(a, b, c);
        double B = ComputeAngles2.computeAngles(b, a, c);
        double C = ComputeAngles2.computeAngles(c, b, a);

        System.out.println("A: " +A+ ", B: " +B+ ", C: " +C);

    }
}
