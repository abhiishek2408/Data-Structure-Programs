public class MissingNumber {
    // Given an array nums containing n distinct numbers in the range [0, n], return the 
    // only number in the range that is missing from the array.
    
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;

        for (int num : nums) {
            arraySum += num;
        }

        return totalSum - arraySum;
    }

    //using XOR
    public int missingNumberXOR(int[] nums) {
        int n = nums.length;
        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i];
        }

        return xor ^ n;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        int[] nums = {3, 0, 1};
        System.out.println(solution.missingNumber(nums)); // Output: 2
        System.out.println(solution.missingNumberXOR(nums)); // Output: 2
    }
}
