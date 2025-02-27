package InheritanceAndPolymorphism_10;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 2/22/2025, Saturday
 **/

class One {
    public int add(int x) {
        return x + 1;
    }

    public static int subtract(int x) {
        return x - 1;
    }
}

class Two extends One {
    @Override
    public int add(int x) {
        return x + 2;
    }

    public static int subtract(int x) {
        return x - 2;
    }
}
class Three extends One {
    public int add(int x) {
        return x + 3;
    }
}
class Four extends One {

}

public class Overriding {
    public static void main(String[] args) {
        One one = new One();
        Two two = new Two();
        Three three = new Three();
        Four four = new Four();

//        System.out.println(one.add(1));
//        System.out.println(two.add(1));
//        System.out.println(three.add(1));
//        System.out.println(four.add(1));

        System.out.println(One.subtract(1));
        System.out.println(Two.subtract(1));
        System.out.println(Three.subtract(1));
    }
}
