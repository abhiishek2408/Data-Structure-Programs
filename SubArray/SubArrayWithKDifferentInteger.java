import java.util.HashMap;

public class SubArrayWithKDifferentInteger {
    public static int subarraysWithKDistinct(int[] nums, int K) {
        return atMostK(nums, K) - atMostK(nums, K - 1);
    }

    private static int atMostK(int[] nums, int K) {
        int left = 0, count = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            // Add right element to window
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            
            // Reduce window if more than K distinct
            while (freq.size() > K) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            // Add subarrays ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int K = 2;
        System.out.println("Subarrays with exactly " + K + " different integers: " + subarraysWithKDistinct(nums, K));
    }
}
