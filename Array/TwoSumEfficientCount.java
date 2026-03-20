import java.util.Arrays;
import java.util.HashMap;

class TwoSumEfficientCount {
    public boolean twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return true; 
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
    

    public static boolean twoSumCount(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff)) {
                return true; // return true if pair found
            }
            map.put(arr[i], i);
        }
        return false; // return false if no pair found
    }


    public static void main(String[] args) {
        TwoSumEfficientCount solution = new TwoSumEfficientCount();
        int[] nums = {10, 15, 3, 7};
        int target = 17;

        boolean result = solution.twoSum(nums, target);
        System.out.println("Two sum exists: " + result);
    }
}
