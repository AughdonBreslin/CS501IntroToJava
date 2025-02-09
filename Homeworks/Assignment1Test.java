/**
 * Test class for Assignment1.java
 * Tests all methods with various edge cases and normal scenarios
 *
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @created: 2/6/2025, Thursday
 */

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class Assignment1Test {
    private final Assignment1Key test = new Assignment1Key();

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
        System.out.println("Total assertions in test suite: " + 80);
    }

    @Test
    @DisplayName("Test second largest: ordered numbers 1,2,3")
    void testSecondLargest1() {
        assertEquals(2, test.secondLargest(1, 2, 3));
    }

    @Test
    @DisplayName("Test second largest: ordered numbers 10,20,30")
    void testSecondLargest2() {
        assertEquals(20, test.secondLargest(10, 20, 30));
    }

    @Test
    @DisplayName("Test second largest: unordered numbers 5,8,3")
    void testSecondLargest3() {
        assertEquals(5, test.secondLargest(5, 8, 3));
    }

    @Test
    @DisplayName("Test second largest: unordered numbers 100,50,75")
    void testSecondLargest4() {
        assertEquals(75, test.secondLargest(100, 50, 75));
    }

    @Test
    @DisplayName("Test second largest: unordered numbers 9,12,11")
    void testSecondLargest5() {
        assertEquals(11, test.secondLargest(9, 12, 11));
    }

    @Test
    @DisplayName("Test second largest: all equal 7,7,7")
    void testSecondLargest6() {
        assertEquals(7, test.secondLargest(7, 7, 7));
    }

    @Test
    @DisplayName("Test second largest: negative numbers -5,-3,-8")
    void testSecondLargest7() {
        assertEquals(-5, test.secondLargest(-5, -3, -8));
    }

    @Test
    @DisplayName("Test second largest: negative numbers 0,-1,-2")
    void testSecondLargest8() {
        assertEquals(-1, test.secondLargest(0, -1, -2));
    }

    @Test
    @DisplayName("Test prime: 2 is prime")
    void testIsPrime1() {
        assertTrue(test.isPrime(2));
    }

    @Test
    @DisplayName("Test prime: 17 is prime")
    void testIsPrime2() {
        assertTrue(test.isPrime(17));
    }

    @Test
    @DisplayName("Test prime: 2147483647 is prime")
    void testIsPrime3() {
        assertTrue(test.isPrime(2147483647));
    }

    @Test
    @DisplayName("Test prime: 4 is not prime")
    void testIsPrime4() {
        assertFalse(test.isPrime(4));
    }

    @Test
    @DisplayName("Test prime: 20 is not prime")
    void testIsPrime5() {
        assertFalse(test.isPrime(20));
    }

    @Test
    @DisplayName("Test prime: 0 is not prime")
    void testIsPrime6() {
        assertFalse(test.isPrime(0));
    }

    @Test
    @DisplayName("Test prime: 1 is not prime")
    void testIsPrime7() {
        assertFalse(test.isPrime(1));
    }

    @Test
    @DisplayName("Test prime: -7 is not prime")
    void testIsPrime8() {
        assertFalse(test.isPrime(-7));
    }

    @Test
    @DisplayName("Test palindrome string: 'racecar' is palindrome")
    void testPalindromeString1() {
        assertTrue(test.isPalindrome("racecar"));
    }

    @Test
    @DisplayName("Test palindrome string: 'noon' is palindrome")
    void testPalindromeString2() {
        assertTrue(test.isPalindrome("noon"));
    }

    @Test
    @DisplayName("Test palindrome string: 'deified' is palindrome")
    void testPalindromeString3() {
        assertTrue(test.isPalindrome("deified"));
    }

    @Test
    @DisplayName("Test palindrome string: 'hello' is not palindrome")
    void testPalindromeString4() {
        assertFalse(test.isPalindrome("hello"));
    }

    @Test
    @DisplayName("Test palindrome string: 'world' is not palindrome")
    void testPalindromeString5() {
        assertFalse(test.isPalindrome("world"));
    }

    @Test
    @DisplayName("Test palindrome string: 'test' is not palindrome")
    void testPalindromeString6() {
        assertFalse(test.isPalindrome("test"));
    }

    @Test
    @DisplayName("Test palindrome string: empty string is palindrome")
    void testPalindromeString7() {
        assertTrue(test.isPalindrome(""));
    }

    @Test
    @DisplayName("Test palindrome string: 'a' is palindrome")
    void testPalindromeString8() {
        assertTrue(test.isPalindrome("a"));
    }

    @Test
    @DisplayName("Test sum of digits: 1234 -> 10")
    void testSumOfDigits1() {
        assertEquals(10, test.sumOfDigits(1234));
    }

    @Test
    @DisplayName("Test sum of digits: 789 -> 24")
    void testSumOfDigits2() {
        assertEquals(24, test.sumOfDigits(789));
    }

    @Test
    @DisplayName("Test sum of digits: 1000 -> 1")
    void testSumOfDigits3() {
        assertEquals(1, test.sumOfDigits(1000));
    }

    @Test
    @DisplayName("Test sum of digits: 900 -> 9")
    void testSumOfDigits4() {
        assertEquals(9, test.sumOfDigits(900));
    }

    @Test
    @DisplayName("Test sum of digits: 555 -> 15")
    void testSumOfDigits5() {
        assertEquals(15, test.sumOfDigits(555));
    }

    @Test
    @DisplayName("Test sum of digits: 111 -> 3")
    void testSumOfDigits6() {
        assertEquals(3, test.sumOfDigits(111));
    }

    @Test
    @DisplayName("Test sum of digits: 0 -> 0")
    void testSumOfDigits7() {
        assertEquals(0, test.sumOfDigits(0));
    }

    @Test
    @DisplayName("Test sum of digits: -13 -> 4")
    void testSumOfDigits8() {
        assertEquals(4, test.sumOfDigits(-13));
    }

    @Test
    @DisplayName("Test count digits: 0 -> 1")
    void testCountDigits1() {
        assertEquals(1, test.countDigits(0));
    }

    @Test
    @DisplayName("Test count digits: 5 -> 1")
    void testCountDigits2() {
        assertEquals(1, test.countDigits(5));
    }

    @Test
    @DisplayName("Test count digits: 10 -> 2")
    void testCountDigits3() {
        assertEquals(2, test.countDigits(10));
    }

    @Test
    @DisplayName("Test count digits: 999 -> 3")
    void testCountDigits4() {
        assertEquals(3, test.countDigits(999));
    }

    @Test
    @DisplayName("Test count digits: 10000 -> 5")
    void testCountDigits5() {
        assertEquals(5, test.countDigits(10000));
    }

    @Test
    @DisplayName("Test count digits: 123456 -> 6")
    void testCountDigits6() {
        assertEquals(6, test.countDigits(123456));
    }

    @Test
    @DisplayName("Test count digits: 9876543 -> 7")
    void testCountDigits7() {
        assertEquals(7, test.countDigits(9876543));
    }

    @Test
    @DisplayName("Test count digits: -10 -> 2")
    void testCountDigits8() {
        assertEquals(2, test.countDigits(-10));
    }

    @Test
    @DisplayName("Test integer palindrome: 12321 -> true")
    void testIsPalindromeInt1() {
        assertTrue(test.isPalindrome(12321));
    }

    @Test
    @DisplayName("Test integer palindrome: 1 -> true")
    void testIsPalindromeInt2() {
        assertTrue(test.isPalindrome(1));
    }

    @Test
    @DisplayName("Test integer palindrome: 22 -> true")
    void testIsPalindromeInt3() {
        assertTrue(test.isPalindrome(22));
    }

    @Test
    @DisplayName("Test integer palindrome: 444 -> true")
    void testIsPalindromeInt4() {
        assertTrue(test.isPalindrome(444));
    }

    @Test
    @DisplayName("Test integer palindrome: 1221 -> true")
    void testIsPalindromeInt5() {
        assertTrue(test.isPalindrome(1221));
    }

    @Test
    @DisplayName("Test integer palindrome: 100 -> false")
    void testIsPalindromeInt6() {
        assertFalse(test.isPalindrome(100));
    }

    @Test
    @DisplayName("Test integer palindrome: 1234322 -> false")
    void testIsPalindromeInt7() {
        assertFalse(test.isPalindrome(1234322));
    }

    @Test
    @DisplayName("Test integer palindrome: -121 -> true")
    void testIsPalindromeInt8() {
        assertTrue(test.isPalindrome(-121));
    }

    @Test
    @DisplayName("Test reverse number: 12345 -> 54321")
    void testReverseNumber1() {
        assertEquals(54321, test.reverseNumber(12345));
    }

    @Test
    @DisplayName("Test reverse number: 789 -> 987")
    void testReverseNumber2() {
        assertEquals(987, test.reverseNumber(789));
    }

    @Test
    @DisplayName("Test reverse number: 123 -> 321")
    void testReverseNumber3() {
        assertEquals(321, test.reverseNumber(123));
    }

    @Test
    @DisplayName("Test reverse number: -12345 -> -54321")
    void testReverseNumber4() {
        assertEquals(-54321, test.reverseNumber(-12345));
    }

    @Test
    @DisplayName("Test reverse number: -7 -> -7")
    void testReverseNumber5() {
        assertEquals(-7, test.reverseNumber(-7));
    }

    @Test
    @DisplayName("Test reverse number: -123 -> -321")
    void testReverseNumber6() {
        assertEquals(-321, test.reverseNumber(-123));
    }

    @Test
    @DisplayName("Test reverse number: 1 -> 1")
    void testReverseNumber7() {
        assertEquals(1, test.reverseNumber(1));
    }

    @Test
    @DisplayName("Test reverse number: 0 -> 0")
    void testReverseNumber8() {
        assertEquals(0, test.reverseNumber(0));
    }

    @Test
    @DisplayName("Test Roman numeral to int: XIV -> 14")
    void testRomanNumeralToInt1() {
        assertEquals(14, test.romanNumeralToInt("XIV"));
    }

    @Test
    @DisplayName("Test Roman numeral to int: LVIII -> 58")
    void testRomanNumeralToInt2() {
        assertEquals(58, test.romanNumeralToInt("LVIII"));
    }

    @Test
    @DisplayName("Test Roman numeral to int: IX -> 9")
    void testRomanNumeralToInt3() {
        assertEquals(9, test.romanNumeralToInt("IX"));
    }

    @Test
    @DisplayName("Test Roman numeral to int: XL -> 40")
    void testRomanNumeralToInt4() {
        assertEquals(40, test.romanNumeralToInt("XL"));
    }

    @Test
    @DisplayName("Test Roman numeral to int: CD -> 400")
    void testRomanNumeralToInt5() {
        assertEquals(400, test.romanNumeralToInt("CD"));
    }

    @Test
    @DisplayName("Test Roman numeral to int: CM -> 900")
    void testRomanNumeralToInt6() {
        assertEquals(900, test.romanNumeralToInt("CM"));
    }

    @Test
    @DisplayName("Test Roman numeral to int: MCMXCIV -> 1994")
    void testRomanNumeralToInt7() {
        assertEquals(1994, test.romanNumeralToInt("MCMXCIV"));
    }

    @Test
    @DisplayName("Test Roman numeral to int: empty string -> 0")
    void testRomanNumeralToInt8() {
        assertEquals(0, test.romanNumeralToInt(""));
    }

    @Test
    @DisplayName("Test valid phone number: (123)456-7890 -> true")
    void testValidPhoneNumber1() {
        assertTrue(test.validPhoneNumber("(123)456-7890"));
    }

    @Test
    @DisplayName("Test valid phone number: 123-456-7890 -> true")
    void testValidPhoneNumber2() {
        assertTrue(test.validPhoneNumber("123-456-7890"));
    }

    @Test
    @DisplayName("Test valid phone number: 1234567890 -> true")
    void testValidPhoneNumber3() {
        assertTrue(test.validPhoneNumber("1234567890"));
    }

    @Test
    @DisplayName("Test invalid phone number: 123 456 7890 -> false")
    void testValidPhoneNumber4() {
        assertFalse(test.validPhoneNumber("123 456 7890"));
    }

    @Test
    @DisplayName("Test invalid phone number: 123.456.7890 -> false")
    void testValidPhoneNumber5() {
        assertFalse(test.validPhoneNumber("123.456.7890"));
    }

    @Test
    @DisplayName("Test invalid phone number: (123) 456-7890 -> false")
    void testValidPhoneNumber6() {
        assertFalse(test.validPhoneNumber("(123) 456-7890"));
    }

    @Test
    @DisplayName("Test invalid phone number: abc-def-ghij -> false")
    void testValidPhoneNumber7() {
        assertFalse(test.validPhoneNumber("abc-def-ghij"));
    }

    @Test
    @DisplayName("Test invalid phone number: 12-3456-7890 -> false")
    void testValidPhoneNumber8() {
        assertFalse(test.validPhoneNumber("12-3456-7890"));
    }

    @Test
    @DisplayName("Test Euclidean distance: (1,2) to (4,6) -> 5.0")
    void testEuclideanDistance1() {
        assertEquals(5.0, test.euclideanDistance(1, 2, 4, 6));
    }

    @Test
    @DisplayName("Test Euclidean distance: (0,0) to (0,0) -> 0.0")
    void testEuclideanDistance2() {
        assertEquals(0.0, test.euclideanDistance(0, 0, 0, 0));
    }

    @Test
    @DisplayName("Test Euclidean distance: (0,0) to (6,8) -> 10.0")
    void testEuclideanDistance3() {
        assertEquals(10.0, test.euclideanDistance(0, 0, 6, 8));
    }

    @Test
    @DisplayName("Test Euclidean distance: (2,3) to (4,3) -> 2.0")
    void testEuclideanDistance4() {
        assertEquals(2.0, test.euclideanDistance(2, 3, 4, 3));
    }

    @Test
    @DisplayName("Test Euclidean distance: (1,1) to (2,3) -> 2.236")
    void testEuclideanDistance5() {
        assertEquals(2.236, test.euclideanDistance(1, 1, 2, 3), 0.001);
    }

    @Test
    @DisplayName("Test Euclidean distance: (3,4) to (-9,-2) -> 13.416")
    void testEuclideanDistance6() {
        assertEquals(13.416, test.euclideanDistance(3, 4, -9, -2), 0.001);
    }

    @Test
    @DisplayName("Test Euclidean distance: (2,2) to (3,3) -> 1.414")
    void testEuclideanDistance7() {
        assertEquals(1.414, test.euclideanDistance(2, 2, 3, 3), 0.001);
    }

    @Test
    @DisplayName("Test Euclidean distance: (5,5) to (10,10) -> 7.071")
    void testEuclideanDistance8() {
        assertEquals(7.071, test.euclideanDistance(5, 5, 10, 10), 0.001);
    }
}