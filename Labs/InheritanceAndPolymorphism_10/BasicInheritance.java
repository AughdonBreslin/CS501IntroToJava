package InheritanceAndPolymorphism_10;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Generic sound!");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "   / \\__\n" +
                "  (    @\\___\n" +
                "  /         O\n" +
                " /   (_____/\n" +
                "/_____/   U";
    }
}

public class BasicInheritance {
    public static void main(String[] args) {
        Dog bill = new Dog("Bill");
        bill.makeSound();
        System.out.println(bill.name);
        System.out.println(bill);
    }
}
