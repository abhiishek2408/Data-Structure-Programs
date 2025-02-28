package Recursion;

public class DecimalToHexadecimal {
    public String decimalToHexadecimal(int n) {
        if (n == 0) return "0";
        StringBuilder hex = new StringBuilder();
        char[] hexChars = "0123456789ABCDEF".toCharArray();
        while (n > 0) {
            hex.insert(0, hexChars[n % 16]);
            n /= 16;
        }
        return hex.toString();
    }

    public static void main(String[] args) {
        DecimalToHexadecimal converter = new DecimalToHexadecimal();
        int testNumber = 255; // Example: 255 in hexadecimal is FF
        System.out.println("Hexadecimal representation of " + testNumber + " is: " + converter.decimalToHexadecimal(testNumber));
    }
}

