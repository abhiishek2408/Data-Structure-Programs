package DynamicProgramming;

public class FibonacciMemo {

    private static final int MAX = 100;
    private static int[] memo = new int[MAX];

    public static void initializeMemo() {
        for (int i = 0; i < MAX; i++) {
            memo[i] = -1;
        }
    }

    public static int fib(int n) {
        if (memo[n] == -1) {
            int res;
            if (n == 0 || n == 1)
                res = n;
            else
                res = fib(n - 1) + fib(n - 2);  // fib(4)    +       fib(3)
            memo[n] = res;                    //fib(3)+fib(2)   fib(2)+fib(1)  
        }
        return memo[n];                           
    }

    public static void main(String[] args) {
        initializeMemo();
        int n = 10; // Example: Find the 10th Fibonacci number
        System.out.println("Fibonacci of " + n + " is " + fib(n));
    }
}