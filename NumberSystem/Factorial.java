// Factorial calculation for a number
public class Factorial {
    // Calculate factorial using recursion
    public static long factorialRecursive(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
        if (n == 0 || n == 1) return 1;
        return n * factorialRecursive(n - 1);
    }

    // Calculate factorial using iteration
    public static long factorialIterative(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Example usage
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial (recursive) of " + num + " is: " + factorialRecursive(num));
        System.out.println("Factorial (iterative) of " + num + " is: " + factorialIterative(num));
    }
}
