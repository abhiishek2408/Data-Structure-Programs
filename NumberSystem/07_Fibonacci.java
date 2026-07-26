// Fibonacci series generation for a number
public class Fibonacci {
        // Find nth Fibonacci term (iterative)
        public static long nthFibonacciIterative(int n) {
            if (n < 0) throw new IllegalArgumentException("Negative index not allowed");
            if (n == 0) return 0;
            if (n == 1) return 1;
            long a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                long next = a + b;
                a = b;
                b = next;
            }
            return b;
        }

        // Find nth Fibonacci term (recursive)
        public static long nthFibonacciRecursive(int n) {
            if (n < 0) throw new IllegalArgumentException("Negative index not allowed");
            if (n <= 1) return n;
            return nthFibonacciRecursive(n - 1) + nthFibonacciRecursive(n - 2);
        }
        
    // Generate Fibonacci series up to n terms (iterative)
    public static void fibonacciIterative(int n) {
        if (n <= 0) {
            System.out.println("Number of terms must be positive.");
            return;
        }
        long a = 0, b = 1;
        System.out.print("Fibonacci Series (iterative): ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    // Generate Fibonacci series up to n terms (recursive)
    public static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Example usage
    public static void main(String[] args) {
        int terms = 10;
        fibonacciIterative(terms);
        System.out.print("Fibonacci Series (recursive): ");
        for (int i = 0; i < terms; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();

        int nth = 7;
        System.out.println("\n" + nth + "th Fibonacci term (iterative): " + nthFibonacciIterative(nth));
        System.out.println(nth + "th Fibonacci term (recursive): " + nthFibonacciRecursive(nth));
    }
}
