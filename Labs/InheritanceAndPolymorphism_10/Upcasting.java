package InheritanceAndPolymorphism_10;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/
class ParentClass {
    public void overridenMethod() {
        System.out.println("ParentClass overridenMethod");
    }

    @Override
    public String toString() {
        return "ParentClass toString";
    }
}

class ChildClass extends ParentClass {
    @Override
    public void overridenMethod() {
        System.out.println("ChildClass overridenMethod");
    }

    public void childExclusiveMethod() {
        System.out.println("ChildClass childExclusiveMethod");
    }

    @Override
    public String toString() {
        return "ChildClass toString";
    }
}

public class Upcasting {
    public static void main(String[] args) {
        ParentClass parentClass = new ChildClass();
        parentClass.overridenMethod();
        // Only inherited or overriden functions are available!
//        parentClass.childExclusiveMethod();

        System.out.println("------------------------------");

        // Downcasting: Regain access to subclass-specific functionality. Use with caution!
        if (parentClass instanceof ChildClass) {
            ChildClass childClass = (ChildClass) parentClass;
            childClass.childExclusiveMethod();
        }

        System.out.println("------------------------------");

        Object superParent = new ChildClass();
        System.out.println(superParent);
    }
}
