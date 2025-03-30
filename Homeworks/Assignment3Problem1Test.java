/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/2/2025, Sunday
 **/

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class Assignment3Problem1Test {


    private final Assignment3Key test = new Assignment3Key();

    @BeforeAll
    static void setup() {
        System.out.println("Starting test suite...");
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        System.out.println("\nRunning test: " + testInfo.getDisplayName());
    }

    @AfterEach
    void countAssertions(TestInfo testInfo) {
        System.out.println("Finished: " + testInfo.getDisplayName());
    }

    @AfterAll
    static void summary() {
        System.out.println("\n=== Test Summary ===");
        System.out.println("Total assertions in test suite: " + 12);
    }

    @Test
    @DisplayName("Test Student creation and toString()")
    void testStudentCreation() {
        Assignment3Key.Student student = new Assignment3Key.Student(1, "Alice", LocalDate.of(2005, 5, 10));
        assertEquals(1, student.getId());
        assertEquals("Alice", student.getName());
        assertEquals(LocalDate.of(2005, 5, 10), student.getBirthdate());
        assertEquals("Student[id=1, name=Alice, birthdate=2005-05-10, enrolledCourses=0]", student.toString());
    }

    @Test
    @DisplayName("Test Professor creation and toString()")
    void testProfessorCreation() {
        Assignment3Key.Professor professor = new Assignment3Key.Professor(101, "Dr. Smith", LocalDate.of(1980, 3, 20));
        assertEquals(101, professor.getId());
        assertEquals("Dr. Smith", professor.getName());
        assertEquals(LocalDate.of(1980, 3, 20), professor.getBirthdate());
        assertEquals("Professor[id=101, name=Dr. Smith, birthdate=1980-03-20, taughtCourses=0]", professor.toString());
    }

    @Test
    @DisplayName("Test Course creation and toString()")
    void testCourseCreation() {
        Assignment3Key.Course course = new Assignment3Key.Course("Mathematics", "Room 101");
        assertEquals("Mathematics", course.getCurriculum());
        assertEquals("Room 101", course.getAssignedRoom());
        assertEquals("Course[curriculum=Mathematics, assignedRoom=Room 101, students=0, professor=None]", course.toString());
    }

    @Test
    @DisplayName("Test Student enrollment in a course")
    void testStudentEnrollment() {
        Assignment3Key.Student student = new Assignment3Key.Student(1, "Alice", LocalDate.of(2005, 5, 10));
        Assignment3Key.Course course = new Assignment3Key.Course("Mathematics", "Room 101");

        student.enroll(course);
        assertEquals(1, student.getEnrolledCourses().size());
        assertEquals(1, course.getStudents().size());
        assertTrue(course.getStudents().contains(student));
    }

    @Test
    @DisplayName("Test Student dropping a course")
    void testStudentDropCourse() {
        Assignment3Key.Student student = new Assignment3Key.Student(1, "Alice", LocalDate.of(2005, 5, 10));
        Assignment3Key.Course course = new Assignment3Key.Course("Mathematics", "Room 101");

        student.enroll(course);
        student.drop(course);
        assertEquals(0, student.getEnrolledCourses().size());
        assertEquals(0, course.getStudents().size());
        assertFalse(course.getStudents().contains(student));
    }

    @Test
    @DisplayName("Test Professor adding a course")
    void testProfessorAddCourse() {
        Assignment3Key.Professor professor = new Assignment3Key.Professor(101, "Dr. Smith", LocalDate.of(1980, 3, 20));
        Assignment3Key.Course course = new Assignment3Key.Course("Mathematics", "Room 101");

        professor.addCourse(course);
        assertEquals(1, professor.getTaughtCourses().size());
        assertEquals(professor, course.getProfessor());
    }

    @Test
    @DisplayName("Test Professor removing a course")
    void testProfessorRemoveCourse() {
        Assignment3Key.Professor professor = new Assignment3Key.Professor(101, "Dr. Smith", LocalDate.of(1980, 3, 20));
        Assignment3Key.Course course = new Assignment3Key.Course("Mathematics", "Room 101");

        professor.addCourse(course);
        professor.removeCourse(course);
        assertEquals(0, professor.getTaughtCourses().size());
        assertNull(course.getProfessor());
    }

    @Test
    @DisplayName("Test Course with multiple students")
    void testCourseWithMultipleStudents() {
        Assignment3Key.Student student1 = new Assignment3Key.Student(1, "Alice", LocalDate.of(2005, 5, 10));
        Assignment3Key.Student student2 = new Assignment3Key.Student(2, "Bob", LocalDate.of(2006, 8, 15));
        Assignment3Key.Course course = new Assignment3Key.Course("Mathematics", "Room 101");

        student1.enroll(course);
        student2.enroll(course);
        assertEquals(2, course.getStudents().size());
        assertTrue(course.getStudents().contains(student1));
        assertTrue(course.getStudents().contains(student2));
    }

    @Test
    @DisplayName("Test Course with a professor and students")
    void testCourseWithProfessorAndStudents() {
        Assignment3Key.Professor professor = new Assignment3Key.Professor(101, "Dr. Smith", LocalDate.of(1980, 3, 20));
        Assignment3Key.Student student = new Assignment3Key.Student(1, "Alice", LocalDate.of(2005, 5, 10));
        Assignment3Key.Course course = new Assignment3Key.Course("Mathematics", "Room 101");

        professor.addCourse(course);
        student.enroll(course);
        assertEquals(professor, course.getProfessor());
        assertEquals(1, course.getStudents().size());
        assertTrue(course.getStudents().contains(student));
    }

    @Test
    @DisplayName("Test Student enrolling in multiple courses")
    void testStudentEnrollInMultipleCourses() {
        Assignment3Key.Student student = new Assignment3Key.Student(1, "Alice", LocalDate.of(2005, 5, 10));
        Assignment3Key.Course mathCourse = new Assignment3Key.Course("Mathematics", "Room 101");
        Assignment3Key.Course scienceCourse = new Assignment3Key.Course("Science", "Room 102");

        student.enroll(mathCourse);
        student.enroll(scienceCourse);
        assertEquals(2, student.getEnrolledCourses().size());
        assertTrue(student.getEnrolledCourses().contains(mathCourse));
        assertTrue(student.getEnrolledCourses().contains(scienceCourse));
    }

    @Test
    @DisplayName("Test Professor teaching multiple courses")
    void testProfessorTeachMultipleCourses() {
        Assignment3Key.Professor professor = new Assignment3Key.Professor(101, "Dr. Smith", LocalDate.of(1980, 3, 20));
        Assignment3Key.Course mathCourse = new Assignment3Key.Course("Mathematics", "Room 101");
        Assignment3Key.Course scienceCourse = new Assignment3Key.Course("Science", "Room 102");

        professor.addCourse(mathCourse);
        professor.addCourse(scienceCourse);
        assertEquals(2, professor.getTaughtCourses().size());
        assertTrue(professor.getTaughtCourses().contains(mathCourse));
        assertTrue(professor.getTaughtCourses().contains(scienceCourse));
    }

    @Test
    @DisplayName("Test Course without a professor")
    void testCourseWithoutProfessor() {
        Assignment3Key.Course course = new Assignment3Key.Course("Mathematics", "Room 101");
        assertNull(course.getProfessor());
    }

}
