package Methods_5;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/8/2025, Saturday
 **/

import MathFunctions_3.Person;

public class PassByValue {
    public static void inc(int num) {
        num++;
        System.out.println("inside the inc function, num is: " +num);
    }

//    public static void inc(Person person) {
//        System.out.println(person);
//        person.incAge();
//    }
//
//    public static Person reset(Person person) {
//        person = new Person("Phil", 28);
//        return person;
//    }

    public static void main(String[] args) {
        int i = 5;

        PassByValue.inc(i);
        System.out.println("i is still: " +i);

//        Person bob = new Person("Bob", 25);
//        PassByValue.inc(bob);
//        System.out.println(bob);
//
//        System.out.println(PassByValue.reset(bob));
//        System.out.println(bob);
    }
}
