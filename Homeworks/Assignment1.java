// File header with name, class info, date

/**
 * Instructions: Implement each of the functions below and write docstrings as follows.
 *   - <strong>DON'T MODIFY THE FUNCTION HEADERS</strong> i.e. the public type function(params)
 *   - You don't need to modify the existing code in main, but you need to test your functions
 *     more extensively than the base tests I've provided.
 *   - Submit as Assignment1.java
 */
public class Assignment1 {

    /**
     * TODO: Write docstrings following this format above each function.
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int secondLargest(int a, int b, int c) {
        // TODO: Implement and return the second largest of three elements
        return -1;
    }

    public boolean isPrime(int num) {
        // TODO: Implement and return whether num is prime
        return false;
    }

    public boolean isPalindrome(String sequence) {
        // TODO: Implement and return whether the sequence is a palindrome
        return false;
    }

    public int sumOfDigits(int num) {
        // TODO: Implement and return the sum of the individual digits of num
        return -1;
    }

    public int countDigits(int num) {
        // TODO: Implement and return the number of digits in num's base-10 representation
        return -1;
    }

    public boolean isPalindrome(int num) {
        // TODO: Implement and return whether the num is a palindrome
        // Note: This has the same function name as a function above, foreshadowing a concept known as overloading
        return false;
    }

    public int reverseNumber(int num) {
        // TODO: Implement and return num, reversed (negative sign still stays at front)
        return -1;
    }

    public int romanNumeralToInt(String romanNumeral) {
        // TODO: Implement and return the integer equivalent of the roman numeral
        // Hint: switch
        return -1;
    }

    public boolean validPhoneNumber(String phoneNumber) {
        // TODO: Implement and return whether the string represents a valid phone number
        // Note: A valid phone number must follow one of the following formats:
        //   (###)###-####, ###-###-####, ##########
        //   where # represents a digit 0-9. No spaces.
        return false;
    }

    public double euclideanDistance(double x1, double y1, double x2, double y2) {
        // TODO: Implement and return the euclidean distance between points (x1, y1) and (x2, y2).
        return -1;
    }


    public static void main(String[] args) {
        Assignment1 test = new Assignment1();

        // secondLargest
        System.out.println(" 1. Second largest of 5, 8, 3: " +test.secondLargest(5, 8, 3)); // Expected: 5

        // isPrime
        System.out.println(" 2. Is 13 prime? " +test.isPrime(13)); // Expected: true

        // isPalindrome (String)
        System.out.println(" 3. Is 'madam' palindrome? " +test.isPalindrome("madam")); // Expected: true

        // sumOfDigits
        System.out.println(" 4. Sum of digits in 1234: " +test.sumOfDigits(1234)); // Expected: 10

        // countDigits
        System.out.println(" 5. Number of digits in 12345: " +test.countDigits(12345)); // Expected: 5

        // isPalindrome (int)
        System.out.println(" 6. Is 12321 palindrome? " +test.isPalindrome(12321)); // Expected: true

        // reverseNumber
        System.out.println(" 7. Reverse of 12345: " +test.reverseNumber(12345)); // Expected: 54321

        // romanNumeralToInt
        System.out.println(" 8. Roman numeral 'XIV' to integer: " +test.romanNumeralToInt("XIV")); // Expected: 14

        // validPhoneNumber
        System.out.println(" 9. Is '(123)456-7890' a valid phone number? " +test.validPhoneNumber("(123)456-7890")); // Expected: true

        // euclideanDistance
        System.out.println("10. Euclidean distance between (1,2) and (4,6): " +test.euclideanDistance(1, 2, 4, 6)); // Expected: 5.0
    }
}
