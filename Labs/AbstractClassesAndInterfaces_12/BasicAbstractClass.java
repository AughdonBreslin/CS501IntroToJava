package AbstractClassesAndInterfaces_12;

import java.lang.annotation.Inherited;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/1/2025, Saturday
 **/
abstract class Animal {
    abstract void makeSound();

    void sleep() {
        System.out.println("Sleeping... zzZ");
    }
}

class Dog extends Animal {
    @Override
     void makeSound() {
        System.out.println("Woof!");
    }
}

public class BasicAbstractClass {
    public static void main(String[] args) {
//        Animal a = new Animal();
        Dog d = new Dog();
        d.makeSound();
        d.sleep();
    }
}
