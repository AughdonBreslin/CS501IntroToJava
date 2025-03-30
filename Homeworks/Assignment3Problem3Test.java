/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/2/2025, Sunday
 **/

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class Assignment3Problem3Test {
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
        System.out.println("Total assertions in test suite: " + 9);
    }

    @Test
    @DisplayName("Test Employee creation and toString()")
    void testEmployeeCreation() {
        Assignment3Key.Employee employee = new Assignment3Key.Employee("Alice", 101);
        assertEquals("Alice", employee.getName());
        assertEquals(101, employee.getId());
        assertEquals("Employee[name=Alice, id=101, certifications=[]]", employee.toString());
    }

    @Test
    @DisplayName("Test Employee addCertification()")
    void testEmployeeAddCertification() {
        Assignment3Key.Employee employee = new Assignment3Key.Employee("Bob", 102);
        employee.addCertification("Java Certification");
        employee.addCertification("AWS Certification");
        List<String> certifications = employee.getCertifications();
        assertEquals(2, certifications.size());
        assertTrue(certifications.contains("Java Certification"));
        assertTrue(certifications.contains("AWS Certification"));
    }

    @Test
    @DisplayName("Test Employee generatePerformanceScore()")
    void testEmployeeGeneratePerformanceScore() {
        Assignment3Key.Employee employee = new Assignment3Key.Employee("Charlie", 103);
        employee.addCertification("Java Certification");
        employee.addCertification("AWS Certification");
        employee.addCertification("Scrum Master Certification");
        int score = employee.generatePerformanceScore();
        assertEquals(30, score); // 3 certifications * 10 points each
    }

    @Test
    @DisplayName("Test Employee calculateSalary() with low performance")
    void testEmployeeCalculateSalaryLowPerformance() {
        Assignment3Key.Employee employee = new Assignment3Key.Employee("David", 104);
        employee.addCertification("Java Certification");
        int score = employee.generatePerformanceScore();
        double salary = employee.calculateSalary(score);
        assertEquals(50000.0 + (50000.0 * 0.10), salary, 0.001); // 10% bonus
    }

    @Test
    @DisplayName("Test Employee calculateSalary() with high performance")
    void testEmployeeCalculateSalaryHighPerformance() {
        Assignment3Key.Employee employee = new Assignment3Key.Employee("Eve", 105);
        for (int i = 0; i < 10; i++) {
            employee.addCertification("Certification " + (i + 1));
        }
        int score = employee.generatePerformanceScore();
        double salary = employee.calculateSalary(score);
        assertEquals(50000.0 + (50000.0 * 1.0), salary, 0.001); // 100% bonus (capped at 100)
    }

    @Test
    @DisplayName("Test Employee calculateSalary() with no certifications")
    void testEmployeeCalculateSalaryNoCertifications() {
        Assignment3Key.Employee employee = new Assignment3Key.Employee("Frank", 106);
        int score = employee.generatePerformanceScore();
        double salary = employee.calculateSalary(score);
        assertEquals(50000.0, salary, 0.001); // No bonus
    }

    @Test
    @DisplayName("Test Employee with multiple certifications")
    void testEmployeeMultipleCertifications() {
        Assignment3Key.Employee employee = new Assignment3Key.Employee("Grace", 107);
        employee.addCertification("Java Certification");
        employee.addCertification("AWS Certification");
        employee.addCertification("Scrum Master Certification");
        employee.addCertification("Python Certification");
        List<String> certifications = employee.getCertifications();
        assertEquals(4, certifications.size());
        assertEquals(40, employee.generatePerformanceScore());
    }

    @Test
    @DisplayName("Test Employee with maximum performance score")
    void testEmployeeMaximumPerformanceScore() {
        Assignment3Key.Employee employee = new Assignment3Key.Employee("Henry", 108);
        for (int i = 0; i < 15; i++) {
            employee.addCertification("Certification " + (i + 1));
        }
        int score = employee.generatePerformanceScore();
        assertEquals(100, score); // Capped at 100
    }

    @Test
    @DisplayName("Test Employee with no certifications and default salary")
    void testEmployeeNoCertifications() {
        Assignment3Key.Employee employee = new Assignment3Key.Employee("Ivy", 109);
        int score = employee.generatePerformanceScore();
        double salary = employee.calculateSalary(score);
        assertEquals(50000.0, salary, 0.001); // Base pay only
    }
}