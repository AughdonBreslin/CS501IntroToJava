package Loops_4;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/2/2025, Sunday
 **/
public class DisplayPrimes {
    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.floor(Math.sqrt(n)); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final int PRIMES = 50;
        final int PRIMES_PER_LINE = 10;
        int count = 0;
        int number = 2;
        DisplayPrimes dp = new DisplayPrimes();

        while (count < PRIMES) {
            if (dp.isPrime(number)) {
                count++;
                if (count % PRIMES_PER_LINE == 0) {
                    System.out.printf("%4d\n", number);
                } else {
                    System.out.printf("%4d", number);
                }
            }
            number++;
        }
    }
}
