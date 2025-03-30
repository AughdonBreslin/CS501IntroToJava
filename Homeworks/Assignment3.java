import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Assignment 3: Simplified Object-Oriented Programming
 *
 * This assignment tests your ability to write classes, implement object-oriented principles,
 * create abstract classes and interfaces, and use basic generics.
 */
public class Assignment3 {

    /**
     * Problem 1: School Hierarchy
     *
     * Design a school hierarchy with the following classes:
     * - `Person`: A superclass for `Student` and `Professor`.
     * - `Student`: Represents a student with a private ID, public name, protected birthdate, and a list of enrolled courses.
     * - `Professor`: Represents a professor with a private ID, public name, protected birthdate, and a list of courses they teach.
     * - `Course`: Represents a course with a curriculum, assigned room, list of students, and a professor.
     */

    /**
     * Superclass `Person` representing a person in the school.
     * - Contains fields: `id` (private), `name` (public), `birthdate` (protected) LocalDate.
     * - Provides a constructor to initialize these fields in the order above.
     * - Provides getters for all fields. You should not be able to set your id, name, or birthdate.
     * - Overrides `toString()` to return a string representation of the person.
     *    - Must match Person[id=###, name=XYZ, birthdate=YYYY-MM-DD]
     *    - id and name can be any reasonable length > 0 and will fit within their data type.
     *       - This goes for all fields included in toStrings
     *    - where # represents a number, XYZ represents alphabetical characters, YMD is year month date
     */
    public static class Person {

        // Constructor

        // Getters and Setters
        public int getId() {
            return 0;
        }

        public String getName() {
            return null;
        }

        public LocalDate getBirthdate() {
            return null;
        }

        // Override toString()
    }

    /**
     * Subclass `Student` representing a student.
     * - Inherits from `Person`.
     * - Adds a private list of `enrolledCourses`
     * - Constructor should continue off Person and create an empty list of enrolled courses.
     * - Provides methods to enroll in and drop courses.
     * - Provides getter for enrolled courses
     * - Overrides toString()
     *    - Must match Student[id=###, name=XYZ, birthdate=YYYY-MM-DD, enrolledCourses=##]
     *    - Same rules as above, enrolledCourses= num of enrolled courses
     */
    public static class Student {

        // Constructor

        // Enroll in a course
        public void enroll(Course course) {
        }

        // Drop a course
        public void drop(Course course) {
        }

        // Get list of enrolled courses
        public List<Course> getEnrolledCourses() {
            return null;
        }

        // Override toString()
    }

    /**
     * Subclass `Professor` representing a professor.
     * - Inherits from `Person`.
     * - Adds a private list of `taughtCourses`
     * - Constructor should continue off Person and create an empty list of taught courses.
     * - Provides methods to add and remove courses they teach.\
     * - Provides getter for taught courses
     * - Overrides toString()
     *    - Must match Student[id=###, name=XYZ, birthdate=YYYY-MM-DD, taughtCourses=##]
     *    - Same rules as above, taughtCourses= num of taught courses
     */
    public static class Professor {

        // Constructor

        // Add a course to teach
        public void addCourse(Course course) {
        }

        // Remove a course they teach
        public void removeCourse(Course course) {
        }

        // Get list of taught courses
        public List<Course> getTaughtCourses() {
            return null;
        }

        // Override toString()
    }

    /**
     * Class `Course` representing a course.
     * - Contains all private fields: `curriculum` (String), `assignedRoom` (String), `students` (List<Student>), `professor` (Professor).
     * - Constructor takes in two args: String curriculum, String assignedRoom
     *    - Also sets an empty list of students and a placeholder value for professor
     * - Provides methods to add/remove students and set/remove the professor.
     */
    public static class Course {

        // Constructor

        // Add a student to the course
        public void addStudent(Student student) {
        }

        // Remove a student from the course
        public void removeStudent(Student student) {
        }

        // Set the professor for the course
        public void setProfessor(Professor professor) {
        }

        // Remove the professor from the course
        public void removeProfessor() {
        }

        // Getters
        public String getCurriculum() {
            return null;
        }

        public String getAssignedRoom() {
            return null;
        }

        public List<Student> getStudents() {
            return null;
        }

        public Professor getProfessor() {
            return null;
        }

        // Override toString()
    }


    /**
     * Problem 2: Shape Hierarchy with Abstract Classes and Generics
     *
     * Implement an abstract class `Shape<T extends Number>` that implements the `AreaCalculable<T>` interface.
     * Add an abstract method `calcPerimeter()` to calculate the perimeter of the shape.
     * Create concrete classes `Circle`, `Triangle`, and `Rectangle` that extend `Shape<T>`.
     */

    /**
     * Interface `AreaCalculable<T>` defines a method calculateArea() that should return a double.
     */
    public interface AreaCalculable<T extends Number> {
    }

    /**
     * Abstract class `Shape<T>` represents a geometric shape.
     * - Implements the `AreaCalculable<T>` interface.
     * - Contains a protected field `unit` of type `T` to represent the unit of measurement.
     * - Provides a constructor to initialize the unit.
     * - Provides getters and setters for the unit.
     * - Adds a public abstract method `calcPerimeter()` which should return a double.
     */
    public abstract static class Shape<T extends Number> {

        // Constructor

        // Getters and Setters

        // Abstract method to calculate the perimeter of the shape
    }

    /**
     * Class `Circle` represents a circle.
     * - Extends `Shape<T>`.
     * - Adds a private field `radius` of type `T`.
     * - Constructor should take in two args in order: T radius, T unit
     * - Provide getters and setters for `radius`.
     * - Implement the `calculateArea()` method for a circle.
     * - Implement the `calcPerimeter()` method for a circle.
     * - Override the toString()
     *    - Must match Circle[radius=###, unit=###]
     */
    public static class Circle<T extends Number>{
        // Constructor

        // Getters and setters

        // Implementations

        // Override toString()
    }

    /**
     * Class `Triangle` represents a triangle.
     * - Extends `Shape<T>`.
     * - Adds private fields `base`, `height`, and `side` of type `T`.
     * - Constructor takes in: T base, T height, T side, T unit
     * - Provides getters and setters for `base`, `height`, and `side`.
     * - Implements the `calculateArea()` method for a triangle.
     * - Implements the `calcPerimeter()` method for a triangle.
     * - Overrides toString()
     *    - Must match Triangle[base=###, height=###, side=###, unit=###]
     */
    public static class Triangle<T extends Number>{

        // Constructor

        // Getters and Setters

        // Implementations

        // Override toString()
    }

    /**
     * Class `Rectangle` represents a rectangle.
     * - Extends `Shape<T>`.
     * - Adds private fields `length` and `width` of type `T`.
     * - Constructor takes in: T length, T width, T unit
     * - Provides getters and setters for `length` and `width`.
     * - Implements the `calculateArea()` method for a rectangle.
     * - Implements the `calcPerimeter()` method for a rectangle.
     * - Override toString()
     *    - Must match Rectangle[length=###, width=###, unit=###]
     */
    public static class Rectangle<T extends Number> {

        // Constructor

        // Getters and Setters

        // Implementations

        // Override toString()
    }

    /**
     * Problem 3: Employee Management System
     *
     * Implement an `Employee` class that implements `Payable`, `Trainable`, and `Reportable`.
     * The `Employee` class should calculate salary based on performance and maintain a list of certifications.
     */

    /**
     * Interface `Payable` defines a method to calculate salary and includes a base pay constant.
     * BASE_PAY should be 50000, calculateSalary() should take in performanceScore (int) and return a double
     */
    public interface Payable {
    }

    /**
     * Interface `Trainable` defines a method to add certifications.
     * addCertification() should take in certification (String) and not return anything
     */
    public interface Trainable {
    }

    /**
     * Interface `Reportable` defines a method to generate a performance score.
     * generatePerformanceScore() should not take in anything and return an int
     */
    public interface Reportable {
    }

    /**
     * Class `Employee` represents an employee in the organization.
     * - Implements `Payable`, `Trainable`, and `Reportable`.
     * - Adds private fields `name` (String), `id` (int), and `certifications` which will be a list of strings
     *    - You should not be able to set name, id, or certifications
     * - Constructor takes in String name, int id
     *    - Starts with an empty list of certifications
     * - Implement the interface functions
     *    - For `calculateSalary()` your bonus should be your base_pay * (your_performance_score/100).
     *       - You should return your base pay + your bonus
     *    - For `addCertification()`, add in the certification
     *    - For `generatePerformanceScore()`, your score should be your num of certifications * 10, capped at 100
     * - Override toString()
     *    - Must match Employee[name=XYZ, id=###, certifications=[...]]
     *       - fields can be any length as with all other methods; certifications should show all of your certifications
     */
    public static class Employee {

        // Constructor

        // Getters and Setters
        public String getName() {
            return null;
        }

        public int getId() {
            return 0;
        }

        public List<String> getCertifications() {
            return null;
        }

        // Implementations

        // Override toString()
    }
}