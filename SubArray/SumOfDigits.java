public class SumOfDigits {

    // Recursive function to calculate sum of digits
    public static int sumOfDigits(int num) {
        // Base case: when the number is 0, return 0
        if (num == 0) {
            return 0;
        }

        // Extract the last digit and add it to the sum of the remaining digits
        return (num % 10) + sumOfDigits(num / 10);
    }

    public static void main(String[] args) {
        int number = 12345; // Example number
        // Calculate and print the sum of digits
        System.out.println("Sum of digits: " + sumOfDigits(number));
    }
}
