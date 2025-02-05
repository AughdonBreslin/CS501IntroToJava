package MathFunctions_3;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/2/2025, Sunday
 **/
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("Person(%s, %d)", name, age);
    }

    public static void main(String[] args) {
        Person bob = new Person("Bob", 24);
        System.out.println(bob.toString());
        bob.setName("Bobby");
        System.out.println(bob.toString());
    }
}
