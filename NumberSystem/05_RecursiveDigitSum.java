class RecursiveDigitSum {
    
    public static int superDigit(String n, int k) {
        // Calculate the sum of digits in n
        long sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += (n.charAt(i) - '0'); // Convert character to integer
        }

        // Multiply by k since n is repeated k times
        sum *= k;

        // Convert sum to string for further processing
        return computeSuperDigit(sum);
    }

    private static int computeSuperDigit(long num) {
        // Base case: if the number is a single digit, return it
        if (num < 10) {
            return (int) num;
        }

        // Compute sum of digits
        long sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        // Recursive call with new sum
        return computeSuperDigit(sum);
    }

    public static void main(String[] args) {
        System.out.println(superDigit("9875", 4)); // Output: 8
    }
}
