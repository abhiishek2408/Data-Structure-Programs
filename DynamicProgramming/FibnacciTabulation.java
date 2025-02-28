package DynamicProgramming;

public class FibnacciTabulation {
    
    public static int fib(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static void main(String[] args) {
        int n = 10; // Example: Find the 10th Fibonacci number
        System.out.println("Fibonacci of " + n + " is " + fib(n));
    }
}