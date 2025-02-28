package Recursion;

public class BinaryToDecimal {

    public int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }

    public static void main(String[] args) {
        BinaryToDecimal converter = new BinaryToDecimal();
        String binaryNumber = "1010"; // Example: 1010 in binary is 10 in decimal
        System.out.println("Decimal representation of " + binaryNumber + " is: " + converter.binaryToDecimal(binaryNumber));
    }
}
