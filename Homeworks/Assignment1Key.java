/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/2/2025, Sunday
 **/
public class Assignment1Key {

    // secondLargest function: Returns the second largest of three numbers
    public int secondLargest(int a, int b, int c) {
        int largest = Math.max(a, Math.max(b, c));
        int smallest = Math.min(a, Math.min(b, c));
        // The second largest is the remaining number
        if (a != largest && a != smallest) return a;
        if (b != largest && b != smallest) return b;
        return c; // If not a or b, then it's c
    }

    // isPrime function: Checks if a number is prime
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // isPalindrome function (String): Checks if a string is a palindrome
    public boolean isPalindrome(String sequence) {
        int left = 0, right = sequence.length() - 1;
        while (left < right) {
            if (sequence.charAt(left) != sequence.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // sumOfDigits function: Sums the digits of a number
    public int sumOfDigits(int num) {
        int sum = 0;
        num = Math.abs(num); // Handle negative numbers
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // countDigits function: Counts the number of digits in a number
    public int countDigits(int num) {
        if (num == 0) return 1;
        num = Math.abs(num);
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    // isPalindrome function (int): Checks if an integer is a palindrome
    public boolean isPalindrome(int num) {
        return num == reverseNumber(num);
    }

    // reverseNumber function: Reverses a number
    public int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

    // romanNumeralToInt function: Converts a Roman numeral to an integer
    public int romanNumeralToInt(String romanNumeral) {
        int result = 0;
        int prevValue = 0;
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            int value = getRomanValue(romanNumeral.charAt(i));
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }
        return result;
    }

    private int getRomanValue(char roman) {
        return switch (roman) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    // validPhoneNumber function: Validates phone number formats
    public boolean validPhoneNumber(String phoneNumber) {
        // Check if it matches (###)###-####
        if (phoneNumber.length() == 13 &&
                phoneNumber.charAt(0) == '(' &&
                phoneNumber.charAt(4) == ')' &&
                phoneNumber.charAt(8) == '-') {
            return isDigits(phoneNumber.substring(1, 4)) && // Area code
                    isDigits(phoneNumber.substring(5, 8)) && // First 3 digits
                    isDigits(phoneNumber.substring(9));      // Last 4 digits
        }

        // Check if it matches ###-###-####
        if (phoneNumber.length() == 12 &&
                phoneNumber.charAt(3) == '-' &&
                phoneNumber.charAt(7) == '-') {
            return isDigits(phoneNumber.substring(0, 3)) &&
                    isDigits(phoneNumber.substring(4, 7)) &&
                    isDigits(phoneNumber.substring(8));
        }

        // Check if it matches ##########
        if (phoneNumber.length() == 10) {
            return isDigits(phoneNumber);
        }

        // If none of the formats match, return false
        return false;
    }

    // Helper function to check if a string consists only of digits
    private boolean isDigits(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    // euclideanDistance function: Calculates the Euclidean distance between two points
    public double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Assignment1Key key = new Assignment1Key();

        // secondLargest
        System.out.println("Second largest of 5, 8, 3: " + key.secondLargest(5, 8, 3)); // Expected: 5

        // isPrime
        System.out.println("Is 13 prime? " + key.isPrime(13)); // Expected: true

        // isPalindrome (String)
        System.out.println("Is 'madam' palindrome? " + key.isPalindrome("madam")); // Expected: true

        // sumOfDigits
        System.out.println("Sum of digits in 1234: " + key.sumOfDigits(1234)); // Expected: 10

        // countDigits
        System.out.println("Number of digits in 12345: " + key.countDigits(12345)); // Expected: 5

        // isPalindrome (int)
        System.out.println("Is 12321 palindrome? " + key.isPalindrome(12321)); // Expected: true

        // reverseNumber
        System.out.println("Reverse of 12345: " + key.reverseNumber(12345)); // Expected: 54321

        // romanNumeralToInt
        System.out.println("Roman numeral 'XIV' to integer: " + key.romanNumeralToInt("XIV")); // Expected: 14

        // validPhoneNumber
        System.out.println("Is '(123)456-7890' a valid phone number? " + key.validPhoneNumber("(123)456-7890")); // Expected: true

        // euclideanDistance
        System.out.println("Euclidean distance between (1,2) and (4,6): " + key.euclideanDistance(1, 2, 4, 6)); // Expected: 5.0
    }
}

