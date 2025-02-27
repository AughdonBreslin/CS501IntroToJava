package InheritanceAndPolymorphism_10;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/
class Super {
    String name;

    public Super(String name) {
        System.out.println("Super constructor called");
        this.name = name;
    }

    public String getName() {
        System.out.println("Super getName called");
        return name;
    }

    public void setName(String name) {
        System.out.println("Super setName called");
        this.name = name;
    }
}

class Sub extends Super {
    public Sub(String name) {
        super(name);
        System.out.println("Sub constructor called");
    }

    @Override
    public String getName() {
        System.out.println("Sub getName called");
        return super.getName() + "Sub";
    }

    @Override
    public void setName(String name) {
        System.out.println("Sub setName called");
        super.setName(name + "Sub");
    }
}
public class SuperKeyword {
    public static void main(String[] args) {
        Sub sub = new Sub("Super");
        System.out.println("------------------");
        System.out.println(sub.getName());
        System.out.println("------------------");
        sub.setName("Tub");
        System.out.println("------------------");
        System.out.println(sub.getName());
    }
}
