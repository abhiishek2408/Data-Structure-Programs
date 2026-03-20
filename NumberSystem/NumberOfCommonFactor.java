class NumberOfCommonFactor {
    public int commonFactors(int a, int b) {
        int gcdValue = gcd(a, b);
        int count = 0;

        // Count the number of divisors of gcdValue
        for (int i = 1; i <= gcdValue; i++) {
            if (gcdValue % i == 0) {
                count++;
            }
        }
        return count;
    }

    // Helper function to compute GCD using Euclidean Algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Main method for testing
    public static void main(String[] args) {
        NumberOfCommonFactor solution = new NumberOfCommonFactor();

        System.out.println(solution.commonFactors(12, 18)); // Output: 4 (Common factors: 1, 2, 3, 6)
        System.out.println(solution.commonFactors(25, 30)); // Output: 2 (Common factors: 1, 5)
        System.out.println(solution.commonFactors(8, 12));  // Output: 4 (Common factors: 1, 2, 4, 8)
    }
}
