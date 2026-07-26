import java.util.Scanner;

class CountBeautifulPairs {
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int firstDigit = getFirstDigit(nums[i]);
            
            for (int j = i + 1; j < n; j++) {
                int lastDigit = nums[j] % 10;
                
                if (gcd(firstDigit, lastDigit) == 1) {
                    count++;
                }
            }
        }
        
        return count;
    }

    // Helper function to get the first digit of a number
    private int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    // Helper function to compute the greatest common divisor (GCD)
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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        CountBeautifulPairs solution = new CountBeautifulPairs();
        int result = solution.countBeautifulPairs(nums);
        
        System.out.println("Number of beautiful pairs: " + result);

        scanner.close();
    }
}
