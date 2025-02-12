package Objects_8;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/11/2025, Tuesday
 **/
public class CircleMaker {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getArea());
        circle.radius = 100;
        System.out.println(circle.getArea());

        Circle[] circleArray = new Circle[10];
        for (int i = 0; i < circleArray.length; i++) {
            circleArray[i] = new Circle(i+1);
            System.out.println(circleArray[i].getArea());
        }



    }
}
