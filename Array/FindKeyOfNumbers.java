class FindKeyOfNumbers {
    public static int findKey(int num1, int num2, int num3) {
        int result = 0;
        int multiplier = 1;

        // Process each digit position
        for (int i = 0; i < 4; i++) {
            // Get digit at current position for each number
            int digit1 = (num1 % (multiplier * 10)) / multiplier;
            int digit2 = (num2 % (multiplier * 10)) / multiplier;
            int digit3 = (num3 % (multiplier * 10)) / multiplier;

            System.out.println(digit1 + " " + digit2 + " " + digit1);

            // Find minimum digit
            int minDigit = Math.min(Math.min(digit1, digit2), digit3);

            System.out.println(minDigit);

            // Add to result
            result += minDigit * multiplier;
            multiplier *= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        findKey(1, 10, 1000);
    }
}