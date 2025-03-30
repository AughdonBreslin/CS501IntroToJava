import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Assignment 3: Simplified Object-Oriented Programming
 *
 * This assignment tests your ability to write classes, implement object-oriented principles,
 * create abstract classes and interfaces, and use basic generics.
 */
public class Assignment3Key {

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
     * - Provides a constructor to initialize these fields.
     * - Provides getters and setters for all fields.
     * - Overrides `toString()` to return a string representation of the person.
     */
    public static class Person {
        private int id;
        public String name;
        protected LocalDate birthdate;

        // Constructor
        public Person(int id, String name, LocalDate birthdate) {
            this.id = id;
            this.name = name;
            this.birthdate = birthdate;
        }

        // Getters and Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
        }

        // Override toString()
        @Override
        public String toString() {
            return "Person[id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
        }
    }

    /**
     * Subclass `Student` representing a student.
     * - Inherits from `Person`.
     * - Adds a list of enrolled courses.
     * - Provides methods to enroll in and drop courses.
     */
    public static class Student extends Person {
        private List<Course> enrolledCourses;

        // Constructor
        public Student(int id, String name, LocalDate birthdate) {
            super(id, name, birthdate);
            this.enrolledCourses = new ArrayList<>();
        }

        // Enroll in a course
        public void enroll(Course course) {
            if (!enrolledCourses.contains(course)) {
                enrolledCourses.add(course);
                course.addStudent(this);
            }
        }

        // Drop a course
        public void drop(Course course) {
            if (enrolledCourses.contains(course)) {
                enrolledCourses.remove(course);
                course.removeStudent(this);
            }
        }

        // Get list of enrolled courses
        public List<Course> getEnrolledCourses() {
            return enrolledCourses;
        }

        // Override toString()
        @Override
        public String toString() {
            return "Student[id=" + getId() + ", name=" + name + ", birthdate=" + birthdate +
                    ", enrolledCourses=" + enrolledCourses.size() + "]";
        }
    }

    /**
     * Subclass `Professor` representing a professor.
     * - Inherits from `Person`.
     * - Adds a list of courses they teach.
     * - Provides methods to add and remove courses they teach.
     */
    public static class Professor extends Person {
        private List<Course> taughtCourses;

        // Constructor
        public Professor(int id, String name, LocalDate birthdate) {
            super(id, name, birthdate);
            this.taughtCourses = new ArrayList<>();
        }

        // Add a course to teach
        public void addCourse(Course course) {
            if (!taughtCourses.contains(course)) {
                taughtCourses.add(course);
                course.setProfessor(this);
            }
        }

        // Remove a course they teach
        public void removeCourse(Course course) {
            if (taughtCourses.contains(course)) {
                taughtCourses.remove(course);
                course.setProfessor(null);
            }
        }

        // Get list of taught courses
        public List<Course> getTaughtCourses() {
            return taughtCourses;
        }

        // Override toString()
        @Override
        public String toString() {
            return "Professor[id=" + getId() + ", name=" + name + ", birthdate=" + birthdate +
                    ", taughtCourses=" + taughtCourses.size() + "]";
        }
    }

    /**
     * Class `Course` representing a course.
     * - Contains fields: `curriculum` (String), `assignedRoom` (String), `students` (List<Student>), `professor` (Professor).
     * - Provides methods to add/remove students and set/remove the professor.
     */
    public static class Course {
        private String curriculum;
        private String assignedRoom;
        private List<Student> students;
        private Professor professor;

        // Constructor
        public Course(String curriculum, String assignedRoom) {
            this.curriculum = curriculum;
            this.assignedRoom = assignedRoom;
            this.students = new ArrayList<>();
            this.professor = null;
        }

        // Add a student to the course
        public void addStudent(Student student) {
            if (!students.contains(student)) {
                students.add(student);
            }
        }

        // Remove a student from the course
        public void removeStudent(Student student) {
            students.remove(student);
        }

        // Set the professor for the course
        public void setProfessor(Professor professor) {
            this.professor = professor;
        }

        // Remove the professor from the course
        public void removeProfessor() {
            this.professor = null;
        }

        // Getters
        public String getCurriculum() {
            return curriculum;
        }

        public String getAssignedRoom() {
            return assignedRoom;
        }

        public List<Student> getStudents() {
            return students;
        }

        public Professor getProfessor() {
            return professor;
        }

        // Override toString()
        @Override
        public String toString() {
            return "Course[curriculum=" + curriculum + ", assignedRoom=" + assignedRoom +
                    ", students=" + students.size() + ", professor=" + (professor != null ? professor.getName() : "None") + "]";
        }
    }


    /**
     * Problem 2: Shape Hierarchy with Abstract Classes and Generics
     *
     * Implement an abstract class `Shape<T extends Number>` that implements the `AreaCalculable<T>` interface.
     * Add an abstract method `calcPerimeter()` to calculate the perimeter of the shape.
     * Create concrete classes `Circle`, `Triangle`, and `Rectangle` that extend `Shape<T>`.
     */

    /**
     * Interface `AreaCalculable<T>` defines a method to calculate the area of a shape.
     */
    public interface AreaCalculable<T extends Number> {
        double calculateArea();
    }

    /**
     * Abstract class `Shape<T>` represents a geometric shape.
     * - Implements the `AreaCalculable<T>` interface.
     * - Contains a field `unit` of type `T` to represent the unit of measurement.
     * - Provides a constructor to initialize the unit.
     * - Provides getters and setters for the unit.
     * - Adds an abstract method `calcPerimeter()` to calculate the perimeter of the shape.
     */
    public abstract static class Shape<T extends Number> implements AreaCalculable<T> {
        protected T unit;

        // Constructor
        public Shape(T unit) {
            this.unit = unit;
        }

        // Getter for unit
        public T getUnit() {
            return unit;
        }

        // Setter for unit
        public void setUnit(T unit) {
            this.unit = unit;
        }

        // Abstract method to calculate the perimeter of the shape
        public abstract double calcPerimeter();
    }

    /**
     * Class `Circle` represents a circle.
     * - Extends `Shape<T>`.
     * - Adds a field `radius` of type `T`.
     * - Provides getters and setters for `radius`.
     * - Implements the `calculateArea()` method for a circle.
     * - Implements the `calcPerimeter()` method for a circle.
     */
    public static class Circle<T extends Number> extends Shape<T> {
        private T radius;

        // Constructor
        public Circle(T radius, T unit) {
            super(unit);
            this.radius = radius;
        }

        // Getter for radius
        public T getRadius() {
            return radius;
        }

        // Setter for radius
        public void setRadius(T radius) {
            this.radius = radius;
        }

        // Implement calculateArea()
        @Override
        public double calculateArea() {
            double r = radius.doubleValue();
            return Math.PI * r * r;
        }

        // Implement calcPerimeter()
        @Override
        public double calcPerimeter() {
            double r = radius.doubleValue();
            return 2 * Math.PI * r;
        }

        // Override toString()
        @Override
        public String toString() {
            return "Circle[radius=" + radius + ", unit=" + getUnit() + "]";
        }
    }

    /**
     * Class `Triangle` represents a triangle.
     * - Extends `Shape<T>`.
     * - Adds fields `base`, `height`, and `side` of type `T`.
     * - Provides getters and setters for `base`, `height`, and `side`.
     * - Implements the `calculateArea()` method for a triangle.
     * - Implements the `calcPerimeter()` method for a triangle.
     */
    public static class Triangle<T extends Number> extends Shape<T> {
        private T base;
        private T height;
        private T side;

        // Constructor
        public Triangle(T base, T height, T side, T unit) {
            super(unit);
            this.base = base;
            this.height = height;
            this.side = side;
        }

        // Getter for base
        public T getBase() {
            return base;
        }

        // Setter for base
        public void setBase(T base) {
            this.base = base;
        }

        // Getter for height
        public T getHeight() {
            return height;
        }

        // Setter for height
        public void setHeight(T height) {
            this.height = height;
        }

        // Getter for side
        public T getSide() {
            return side;
        }

        // Setter for side
        public void setSide(T side) {
            this.side = side;
        }

        // Implement calculateArea()
        @Override
        public double calculateArea() {
            double b = base.doubleValue();
            double h = height.doubleValue();
            return 0.5 * b * h;
        }

        // Implement calcPerimeter()
        @Override
        public double calcPerimeter() {
            double b = base.doubleValue();
            double s = side.doubleValue();
            return b + 2 * s; // Perimeter of an isosceles triangle
        }

        // Override toString()
        @Override
        public String toString() {
            return "Triangle[base=" + base + ", height=" + height + ", side=" + side + ", unit=" + getUnit() + "]";
        }
    }

    /**
     * Class `Rectangle` represents a rectangle.
     * - Extends `Shape<T>`.
     * - Adds fields `length` and `width` of type `T`.
     * - Provides getters and setters for `length` and `width`.
     * - Implements the `calculateArea()` method for a rectangle.
     * - Implements the `calcPerimeter()` method for a rectangle.
     */
    public static class Rectangle<T extends Number> extends Shape<T> {
        private T length;
        private T width;

        // Constructor
        public Rectangle(T length, T width, T unit) {
            super(unit);
            this.length = length;
            this.width = width;
        }

        // Getter for length
        public T getLength() {
            return length;
        }

        // Setter for length
        public void setLength(T length) {
            this.length = length;
        }

        // Getter for width
        public T getWidth() {
            return width;
        }

        // Setter for width
        public void setWidth(T width) {
            this.width = width;
        }

        // Implement calculateArea()
        @Override
        public double calculateArea() {
            double l = length.doubleValue();
            double w = width.doubleValue();
            return l * w;
        }

        // Implement calcPerimeter()
        @Override
        public double calcPerimeter() {
            double l = length.doubleValue();
            double w = width.doubleValue();
            return 2 * (l + w);
        }

        // Override toString()
        @Override
        public String toString() {
            return "Rectangle[length=" + length + ", width=" + width + ", unit=" + getUnit() + "]";
        }
    }

    /**
     * Problem 3: Employee Management System
     *
     * Implement an `Employee` class that implements `Payable`, `Trainable`, and `Reportable`.
     * The `Employee` class should calculate salary based on performance and maintain a list of certifications.
     */

    /**
     * Interface `Payable` defines a method to calculate salary and includes a base pay constant.
     */
    public interface Payable {
        double BASE_PAY = 50000.0; // Base pay for all employees

        double calculateSalary(int performanceScore);
    }

    /**
     * Interface `Trainable` defines a method to add certifications.
     */
    public interface Trainable {
        void addCertification(String certification);
    }

    /**
     * Interface `Reportable` defines a method to generate a performance score.
     */
    public interface Reportable {
        int generatePerformanceScore();
    }

    /**
     * Class `Employee` represents an employee in the organization.
     * - Implements `Payable`, `Trainable`, and `Reportable`.
     * - Maintains a list of certifications.
     * - Calculates salary based on performance score.
     */
    public static class Employee implements Payable, Trainable, Reportable {
        private String name;
        private int id;
        private List<String> certifications;

        // Constructor
        public Employee(String name, int id) {
            this.name = name;
            this.id = id;
            this.certifications = new ArrayList<>();
        }

        // Getter for name
        public String getName() {
            return name;
        }

        // Getter for id
        public int getId() {
            return id;
        }

        // Getter for certifications
        public List<String> getCertifications() {
            return certifications;
        }

        // Implement calculateSalary() from Payable
        @Override
        public double calculateSalary(int performanceScore) {
            // Salary is base pay plus a bonus based on performance score (0-100)
            double bonus = BASE_PAY * (performanceScore / 100.0);
            return BASE_PAY + bonus;
        }

        // Implement addCertification() from Trainable
        @Override
        public void addCertification(String certification) {
            certifications.add(certification);
        }

        // Implement generatePerformanceScore() from Reportable
        @Override
        public int generatePerformanceScore() {
            // Simulate a performance score based on the number of certifications
            int score = certifications.size() * 10; // Each certification adds 10 points
            return Math.min(score, 100); // Cap the score at 100
        }

        // Override toString()
        @Override
        public String toString() {
            return "Employee[name=" + name + ", id=" + id + ", certifications=" + certifications + "]";
        }
    }
}