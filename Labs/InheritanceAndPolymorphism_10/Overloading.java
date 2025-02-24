package InheritanceAndPolymorphism_10;

import org.w3c.dom.ls.LSOutput;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
**/

class ClassOne {
    public double sqrt(double i ) {
        System.out.println("double sqrt");
        return Math.sqrt(i);
    }
}

class ClassTwo extends ClassOne {
    public double sqrt(int i) {
        System.out.println("int sqrt");
        return Math.sqrt(i);
    }
}


public class Overloading {
    public static void main(String[] args) {
        ClassOne classOne = new ClassOne();
        ClassTwo classTwo = new ClassTwo();

        System.out.println(classOne.sqrt(10.0));
        System.out.println(classTwo.sqrt(10.0));
        System.out.println(classTwo.sqrt(10));
    }
}
