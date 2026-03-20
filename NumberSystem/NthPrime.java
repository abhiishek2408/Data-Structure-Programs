import java.util.*;

public class NthPrime {

    public static int nthPrime(int n) {

        if (n == 1) return 2;

        // Estimate upper bound
        int limit = (int)(n * (Math.log(n) + Math.log(Math.log(n)))) + 10;

        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        // Sieve
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count primes
        int count = 0;

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                count++;
                if (count == n) {
                    return i;
                }
            }
        }

        return -1; // fallback
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println("Nth Prime: " + nthPrime(n));
    }
}
