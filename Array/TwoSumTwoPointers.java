package Array;

// TwoSumTwoPointers.java
// Implementation of twoSum using two pointers (left, right)

public class TwoSumTwoPointers {
    /**
     * Finds two numbers in a sorted array that add up to the target using two pointers.
     * @param numbers Sorted input array
     * @param target The target sum
     * @return Indices (1-based) of the two numbers adding up to target, or {-1, -1} if not found
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-based index
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    // Example usage
    public static void main(String[] args) {
        TwoSumTwoPointers solution = new TwoSumTwoPointers();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
