package Recursion;

public class _02_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        _02_PowerOfTwo solution = new _02_PowerOfTwo();
        int testNumber = 16;
        System.out.println("Is " + testNumber + " a power of two? " + solution.isPowerOfTwo(testNumber));
    }
}
