package AbstractClassesAndInterfaces_12;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/1/2025, Saturday
 **/
abstract class Shape {
    // Instance variables of all visibilities are acceptable
    public double area;
    int numSides;
    protected double perimeter;
    private double[] radii;

    // Static variables are treated as normal
    public static int shapeCount = 0;

    // Can have constructors (which get called by subclasses)
    public Shape() {
        shapeCount++;
        System.out.printf("Shape no-arg constructor called: %d\n", shapeCount);
    }

    public Shape(int numSides) {
        shapeCount++;
        this.numSides = numSides;
        System.out.printf("Shape unary arg constructor called: %d\n", shapeCount);
    }

    public Shape(double... radii) {
        shapeCount++;
        if (radii.length == 1) {
            System.out.println("This must be a circle!");
        } else if (radii.length == 2) {
            System.out.println("This must be an ellipse!");
        } else {
            System.out.println("I don't know what this is.");
        }
        this.radii = radii;
    }

    // Contains abstract methods
    public abstract double getArea();
    public abstract void setPerimeter(double perimeter);
    public abstract double getPerimeter();

    // Contains implemented methods
    public double[] getRadii() {
        return radii;
    }
    public int getNumSides() {
        return numSides;
    }
}

/**
 * Abstract classes can extend other abstract classes
 */
abstract class Polygon extends Shape {
    // Inherits instance variables

    // New instance variables
    private double sideLength;

    public Polygon() {
        // Implicitly calls super
    }
    public Polygon(int sides, int sideLength) {
        super(sides);
        this.sideLength = sideLength;
    }

    // Can leave abstract functions unimplemented
    // bc this is also abstract class

    // Can implement abstract functions
    @Override
    public double getPerimeter() {
        return numSides*sideLength;
    }

    // And new functions
    public int sumOfInteriorAngles() {
        return (numSides - 2) * 180;
    }
}

class Circle extends Shape {
    private double radius = 0;

    public Circle() {
        radius = 1;
    }

    public Circle(double radius) {
        super(radius);
        this.radius = getRadii()[0];
    }

    // Non-abstract class can have new functions
    public void setArea(double area) {
        this.area = area;
        this.radius = Math.sqrt(this.area/Math.PI);
    }

    // Non-abstract class must implement all previously-abstract methods!
    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius, 2);
    }

    @Override
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    // Override Object toString() implementation
    @Override
    public String toString() {
        return "Circle(%.2f)".formatted(radius);
    }
}

class Rectangle extends Shape {
    // New instance variables
    private double width;
    private double height;

    // Can invoke abstract super
    public Rectangle(double width, double height) {
        super(4);
        this.width = width;
        this.height = height;
    }

    // Can implement new functions
    public void setArea(double area) {
        this.area = area;
    }

    // Must implement abstracted functions
    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String toString() {
        return "Rectangle(w:%.1f, h:%.1f)".formatted(width, height);
    }
}

public class InDepthAbstractClass {
    public static void main(String[] args) {
        // Good
        Shape[] shapes = new Shape[10];
        for (int i = 0; i < shapes.length; i++) {
            if ((i&1) == 0) {
                shapes[i] = new Rectangle(i+1, i+2);
            } else {
                shapes[i] = new Circle(i + 1);
            }
            System.out.println(shapes[i]);
        }
        // Bad
//        Shape shape = new Shape();
    }
}
