//this program is to check whether a number is prime or not

public class CheckPrime {
    public static boolean isPrime(int n) {
        if (n <= 1) return false; // 0 and 1 are not prime numbers
        if (n <= 3) return true;  // 2 and 3 are prime numbers

        // Check for factors from 2 to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false; // If n is divisible by any number, it's not prime
        }
        return true; // If no factors found, n is prime
    }

    public static void main(String[] args) {
        int number = 29;
        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
    
}
