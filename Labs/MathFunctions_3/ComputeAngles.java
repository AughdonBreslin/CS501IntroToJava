package MathFunctions_3;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/2/2025, Sunday
 **/

public class ComputeAngles {
    public double computeSides(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

    public double computeAngles(double a, double b, double c) {
        return Math.toDegrees(Math.acos((a*a - b*b - c*c) / (-2 * b * c)));
    }

    public static void main(String[] args) {
        // Check for valid input
        if (args.length != 6) {
            System.err.println("Error: Must have 6 arguments. Usage: x1 y1 x2 y2 x3 y3");
            return;
        }

        // Declare our variables
        double x1, y1, x2, y2, x3, y3;

        // Try to parse
        try {
            x1 = Double.parseDouble(args[0]);
            y1 = Double.parseDouble(args[1]);
            x2 = Double.parseDouble(args[2]);
            y2 = Double.parseDouble(args[3]);
            x3 = Double.parseDouble(args[4]); // Show ctrl click for source code
            y3 = Double.parseDouble(args[5]);
        } catch (Exception e) {
            System.err.println("Error: " + e);
            return;
        }

        // Compute
        ComputeAngles ca = new ComputeAngles();
        double a = ca.computeSides(x2, y2, x3, y3);
        double b = ca.computeSides(x1, y1, x3, y3);
        double c = ca.computeSides(x1, y1, x2, y2);

        double A = ca.computeAngles(a, b, c);
        double B = ca.computeAngles(b, c, a);
        double C = ca.computeAngles(c, a, b);

        // Result
        System.out.printf("A: %f, B: %f, C: %f, a: %f, b: %f, c: %f", A, B, C, a, b, c);
    }
}
