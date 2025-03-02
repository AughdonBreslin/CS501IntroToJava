package AbstractClassesAndInterfaces_12;

import java.io.*;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/1/2025, Saturday
 **/
class A implements Serializable {
    public int num = 5;
}

// Ctrl click these interfaces to check them out
class Thing implements Serializable, Cloneable {
    @Serial
    private static final long serialVersionUID = 1L; // Helps with versioning
    private int importantNumber = 1234567890;
    public A a = new A();

    public int getImportantNumber() {
        return importantNumber;
    }

    public void setImportantNumber(int num) {
        importantNumber = num;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Info: %d".formatted(importantNumber);
    }
}
public class MarkerInterfaces {
    public static void main(String[] args) throws CloneNotSupportedException {
        Thing s = new Thing();
        // Serialize the object (Write to file)
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Labs/AbstractClassesAndInterfaces_12/thing.dat"))) {
            out.writeObject(s);
            System.out.println("SuperImportantThing object serialized!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object (Read from file)
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Labs/AbstractClassesAndInterfaces_12/thing.dat"))) {
            Thing deserializedThing = (Thing) in.readObject();
            System.out.println("Deserialized SuperImportantThing: " + deserializedThing);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Try to clone the Thing into another
        Thing s2;
        try {
            s2 = (Thing) s.clone();
            System.out.println("S2: " +s2);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Shallow copy -- s.a is the same as s2.a:");
        System.out.println(s.a.num + " " + s2.a.num);
        s2.a.num = 7;
        System.out.println(s.a.num + " " + s2.a.num);
    }
}
