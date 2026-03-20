
import java.util.*;


class TwoDifference {
    public boolean twoDifference(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    return true;
                }
            }
        }
        return false;
    }

     public boolean twoDifferenceEfficient(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num - k) || set.contains(num + k)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }


    public boolean twoDifferenceSorted(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 1;
        
        while (right < nums.length) {
            int diff = nums[right] - nums[left];
            
            if (diff == k && left != right) return true;
            else if (diff < k) right++;
            else left++;
        }
        return false;
    }

    public static void main(String[] args) {
        TwoDifference solution = new TwoDifference();
        int[] nums = {10, 15, 3, 7};
        int k = 5;

        boolean result = solution.twoDifference(nums, k);
        System.out.println("Two difference exists: " + result);
    }
}


