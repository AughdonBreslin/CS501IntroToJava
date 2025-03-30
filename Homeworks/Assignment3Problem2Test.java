/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/2/2025, Sunday
 **/

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class Assignment3Problem2Test {
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
        System.out.println("Total assertions in test suite: " + 18);
    }

    @Test
    @DisplayName("Test Circle area calculation")
    void testCircleArea() {
        Assignment3Key.Circle<Double> circle = new Assignment3Key.Circle<>(5.0, 1.0);
        assertEquals(78.539, circle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Test Triangle area calculation")
    void testTriangleArea() {
        Assignment3Key.Triangle<Double> triangle = new Assignment3Key.Triangle<>(4.0, 3.0, 5.0, 1.0);
        assertEquals(6.0, triangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Test Rectangle area calculation")
    void testRectangleArea() {
        Assignment3Key.Rectangle<Double> rectangle = new Assignment3Key.Rectangle<>(5.0, 4.0, 1.0);
        assertEquals(20.0, rectangle.calculateArea(), 0.001);
    }

    @Test
    @DisplayName("Test Circle perimeter calculation")
    void testCirclePerimeter() {
        Assignment3Key.Circle<Double> circle = new Assignment3Key.Circle<>(5.0, 1.0);
        assertEquals(31.415, circle.calcPerimeter(), 0.001);
    }

    @Test
    @DisplayName("Test Triangle perimeter calculation")
    void testTrianglePerimeter() {
        Assignment3Key.Triangle<Double> triangle = new Assignment3Key.Triangle<>(4.0, 3.0, 5.0, 1.0);
        assertEquals(14.0, triangle.calcPerimeter(), 0.001);
    }

    @Test
    @DisplayName("Test Rectangle perimeter calculation")
    void testRectanglePerimeter() {
        Assignment3Key.Rectangle<Double> rectangle = new Assignment3Key.Rectangle<>(5.0, 4.0, 1.0);
        assertEquals(18.0, rectangle.calcPerimeter(), 0.001);
    }

    @Test
    @DisplayName("Test Circle getters and setters")
    void testCircleGettersAndSetters() {
        Assignment3Key.Circle<Double> circle = new Assignment3Key.Circle<>(5.0, 1.0);
        assertEquals(5.0, circle.getRadius(), 0.001);
        circle.setRadius(10.0);
        assertEquals(10.0, circle.getRadius(), 0.001);
    }

    @Test
    @DisplayName("Test Triangle getters and setters")
    void testTriangleGettersAndSetters() {
        Assignment3Key.Triangle<Double> triangle = new Assignment3Key.Triangle<>(4.0, 3.0, 5.0, 1.0);
        assertEquals(4.0, triangle.getBase(), 0.001);
        assertEquals(3.0, triangle.getHeight(), 0.001);
        assertEquals(5.0, triangle.getSide(), 0.001);
        triangle.setBase(6.0);
        triangle.setHeight(5.0);
        triangle.setSide(7.0);
        assertEquals(6.0, triangle.getBase(), 0.001);
        assertEquals(5.0, triangle.getHeight(), 0.001);
        assertEquals(7.0, triangle.getSide(), 0.001);
    }

    @Test
    @DisplayName("Test Rectangle getters and setters")
    void testRectangleGettersAndSetters() {
        Assignment3Key.Rectangle<Double> rectangle = new Assignment3Key.Rectangle<>(5.0, 4.0, 1.0);
        assertEquals(5.0, rectangle.getLength(), 0.001);
        assertEquals(4.0, rectangle.getWidth(), 0.001);
        rectangle.setLength(10.0);
        rectangle.setWidth(8.0);
        assertEquals(10.0, rectangle.getLength(), 0.001);
        assertEquals(8.0, rectangle.getWidth(), 0.001);
    }

    @Test
    @DisplayName("Test Circle toString()")
    void testCircleToString() {
        Assignment3Key.Circle<Double> circle = new Assignment3Key.Circle<>(5.0, 1.0);
        assertEquals("Circle[radius=5.0, unit=1.0]", circle.toString());
    }

    @Test
    @DisplayName("Test Triangle toString()")
    void testTriangleToString() {
        Assignment3Key.Triangle<Double> triangle = new Assignment3Key.Triangle<>(4.0, 3.0, 5.0, 1.0);
        assertEquals("Triangle[base=4.0, height=3.0, side=5.0, unit=1.0]", triangle.toString());
    }

    @Test
    @DisplayName("Test Rectangle toString()")
    void testRectangleToString() {
        Assignment3Key.Rectangle<Double> rectangle = new Assignment3Key.Rectangle<>(5.0, 4.0, 1.0);
        assertEquals("Rectangle[length=5.0, width=4.0, unit=1.0]", rectangle.toString());
    }

    @Test
    @DisplayName("Test Circle with Integer units")
    void testCircleWithIntegerUnits() {
        Assignment3Key.Circle<Integer> circle = new Assignment3Key.Circle<>(5, 1);
        assertEquals(78.539, circle.calculateArea(), 0.001);
        assertEquals(31.415, circle.calcPerimeter(), 0.001);
    }

    @Test
    @DisplayName("Test Triangle with Integer units")
    void testTriangleWithIntegerUnits() {
        Assignment3Key.Triangle<Integer> triangle = new Assignment3Key.Triangle<>(4, 3, 5, 1);
        assertEquals(6.0, triangle.calculateArea(), 0.001);
        assertEquals(14.0, triangle.calcPerimeter(), 0.001);
    }

    @Test
    @DisplayName("Test Rectangle with Integer units")
    void testRectangleWithIntegerUnits() {
        Assignment3Key.Rectangle<Integer> rectangle = new Assignment3Key.Rectangle<>(5, 4, 1);
        assertEquals(20.0, rectangle.calculateArea(), 0.001);
        assertEquals(18.0, rectangle.calcPerimeter(), 0.001);
    }

    @Test
    @DisplayName("Test Shape unit getter and setter")
    void testShapeUnitGetterAndSetter() {
        Assignment3Key.Circle<Double> circle = new Assignment3Key.Circle<>(5.0, 1.0);
        assertEquals(1.0, circle.getUnit(), 0.001);
        circle.setUnit(2.0);
        assertEquals(2.0, circle.getUnit(), 0.001);
    }
}

