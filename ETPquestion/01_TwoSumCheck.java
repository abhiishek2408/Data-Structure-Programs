package ETPquestion;

public class TwoSumCheck {
    public static String hasTwoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return "YES";
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 9, 11};  // sorted array
        int target = 10;

        System.out.println(hasTwoSum(nums, target));  // Output: YES
    }
}
