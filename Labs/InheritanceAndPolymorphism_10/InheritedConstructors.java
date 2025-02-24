package InheritanceAndPolymorphism_10;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/
class Parent {
    String name;

    public Parent() {
        name = "Eleanor";
        System.out.printf("No Arg Parent Constructor: %s, ", name);
    }

    public Parent(String name) {
        this.name = name;
        System.out.printf("Unary Parent Constructor: %s, ", name);
    }
}

class Child extends Parent {
    public Child() {
        System.out.printf("No Arg Child Constructor %s, ", name);
    }

    public Child(String name) {
        System.out.printf("Unary Child Constructor: %s, ", name);
    }
}


public class InheritedConstructors {
    public static void main(String[] args) {
        Parent p = new Parent();
        System.out.println();

        Parent p2 = new Parent("Elizabeth");
        System.out.println();

        Child c = new Child();
        System.out.println();

        Child c2 = new Child("Tommy");
        System.out.println();

    }
}
