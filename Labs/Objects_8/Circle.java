package Objects_8;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/11/2025, Tuesday
 **/
class Circle {

    double radius = 1;
    static int objectCount = 0;

    public Circle() {
        System.out.println("Default constructor!");
        objectCount++;
    }

    public Circle(double radius) {
        System.out.println("Other constructor!");
        this.radius = radius;
        objectCount++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = (radius > 0) ? radius : 1;
    }

    public static int getObjectCount() {
        return objectCount;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("Object count: " +Circle.objectCount);
        Circle specificCircle = new Circle(10);
        System.out.println("Object count: " +Circle.objectCount);
        System.out.println(circle.getArea());
        System.out.println(specificCircle.getArea());
//
        System.out.println(Circle.getObjectCount());

        // generally not recommended, implies function is tied to instance
        // compiler implicitly resolves this to Circle.getObjectCount()
        System.out.println(specificCircle.getObjectCount());
    }
}
