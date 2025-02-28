public class MajorityElementBoyerMoore {

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

// 3 2 3
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }

            if (nums[i] == candidate) { //true
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Return the candidate (verification step is not needed here)
        return candidate;
    }
}
