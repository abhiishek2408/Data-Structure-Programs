package Array;

import java.util.*;

class SpecialTriplets {

    private static final int MOD = 1_000_000_007;

    public int specialTriplets(int[] nums) {
        Map<Integer, Long> right = new HashMap<>();
        Map<Integer, Long> left = new HashMap<>();

        for (int num : nums) {
            right.put(num, right.getOrDefault(num, 0L) + 1);
        }

        long ans = 0;

        for (int j = 0; j < nums.length; j++) {
            int mid = nums[j];

            right.put(mid, right.get(mid) - 1);

            long leftCount = left.getOrDefault(2 * mid, 0L);
            long rightCount = right.getOrDefault(2 * mid, 0L);

            ans = (ans + leftCount * rightCount) % MOD;

            left.put(mid, left.getOrDefault(mid, 0L) + 1);
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        SpecialTriplets st = new SpecialTriplets();
        int[] nums = {1, 2, 3, 4, 5};
        int result = st.specialTriplets(nums);
        System.out.println("Number of special triplets: " + result);
    }
}
