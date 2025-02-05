package ElementaryProgramming_2;

public class ComputeArea {
    public static void main(String[] args) {
        double radius;
        double area;

        // Assign a radius
        radius = 30;

        // Compute area
        area = radius * radius * Math.PI; // Math.pow(radius, 2);

        // Display results
        System.out.println("The area for a circle of radius " +radius+ " is " +area+ ".");
    }
}
