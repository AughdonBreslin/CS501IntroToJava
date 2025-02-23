package InheritanceAndPolymorphism_10;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/
class A {
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    public B() {
        System.out.println("B");
    }
}

class C extends B {
    public C() {
        System.out.println("C");
    }
}

class D extends C {
    public D() {
        System.out.println("D");
    }
}

public class ConstructorChain {
    public static void main(String[] args) {
        D d = new D();
    }
}
