package Recursion;

public class _09_OneInBinaryNo {

    public int hammingWeight(int n) {
        if (n == 0) return 0;
        return (n & 1) + hammingWeight(n >>> 1);
    }

    public static void main(String[] args) {
        _09_OneInBinaryNo solution = new _09_OneInBinaryNo();
        int testNumber = 11; // Example: 11 (1011 in binary) has 3 ones
        System.out.println("Hamming Weight of " + testNumber + " is: " + solution.hammingWeight(testNumber));
    }
}