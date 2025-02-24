package Objects_8;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/11/2025, Tuesday
 **/
import java.time.LocalDate;

public class Student {
    private int id;
    private LocalDate birthDate;


    public Student(int id, int year, int month, int day) {
        this.id = id;
        birthDate = LocalDate.of(year, month, day);
    }

    public int getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public static void main(String[] args) {
        Student bob = new Student(1, 2000, 1, 1);
        System.out.println(bob.birthDate);
    }
}
