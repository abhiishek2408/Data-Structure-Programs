package Recursion;


public class BasicRec {

    public static void oneton(int n) {
        if (n == 0) { 
            return;
        }
        oneton(n - 1); 
        System.out.print(n + " ");
    }

    public static void ntone(int n) {
        if (n == 0) { 
            return;
        }
        System.out.print(n + " "); 
        ntone(n - 1); 
    }

    public static int sumofnum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumofnum(n - 1);
    }

    public static int fact(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fact(n - 1);  // Recursive call is not the last operation, so it's not tail tail recursion
    }

    public static int factorial(int n, int k) {
        if (n == 0 || n==1) {
            return k;
        }

        return factorial(n-1, k*n);
    }


    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;

        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        oneton(6);
        System.out.println();
        ntone(6);
        System.out.println();
        System.out.println("Sum of Natural No:"+sumofnum(6));
        System.out.println(fact(5));
        System.out.println(fact(6));
        System.out.println(fib(6));

        System.out.println(isPowerOfTwo(16));

        
    }
}



