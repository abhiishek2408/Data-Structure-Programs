package Recursion;

public class DecimalToOctal {
    public String decimalToOctal(int n) {
        if (n == 0) return "0";
        StringBuilder octal = new StringBuilder();
        while (n > 0) {
            octal.insert(0, n % 8);
            n /= 8;
        }
        return octal.toString();
    }

    public static void main(String[] args) {
        DecimalToOctal converter = new DecimalToOctal();
        int testNumber = 100; // Example: 100 in octal is 144
        System.out.println("Octal representation of " + testNumber + " is: " + converter.decimalToOctal(testNumber));
    }
}
