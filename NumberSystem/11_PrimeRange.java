import java.util.ArrayList;
import java.util.Arrays;

public class PrimeRange {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void printPrimes(int L, int R) {

        for (int i = L; i <= R; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

     public static void SieveOfEratosthenes(int L, int R) {

        boolean[] isPrime = new boolean[R + 1];

        for (int i = 2; i <= R; i++)
            isPrime[i] = true;

        for (int i = 2; i * i <= R; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= R; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = L; i <= R; i++) {
            if (isPrime[i])
                System.out.print(i + " ");
        }
    }


    public static ArrayList<Integer> primeRange(int L, int R) {

        boolean[] isPrime = new boolean[R + 1];
        Arrays.fill(isPrime, true);

        // 0 and 1 are not prime
        if (R >= 0) isPrime[0] = false;
        if (R >= 1) isPrime[1] = false;

        // Sieve
        for (int i = 2; i * i <= R; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= R; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect result
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = Math.max(L, 2); i <= R; i++) {
            if (isPrime[i]) {
                result.add(i);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        SieveOfEratosthenes(10, 30);
        printPrimes(0, 0);
    }
}