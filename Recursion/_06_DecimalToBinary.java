package Recursion;

public class _06_DecimalToBinary {
    public String decimalToBinary(int n) {
        if (n == 0) return "0";
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        _06_DecimalToBinary converter = new _06_DecimalToBinary();
        int testNumber = 10; // Example: 10 in binary is 1010
        System.out.println("Binary representation of " + testNumber + " is: " + converter.decimalToBinary(testNumber));
    }
}