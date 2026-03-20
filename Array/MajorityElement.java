package Array;

// Majority Element using Boyer-Moore Voting Algorithm
// Returns the element that appears more than n/2 times in the array

class MajorityElement {

    // Optimal Approach: Boyer-Moore Voting Algorithm
    public int majorityElement1(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

// Brute Force Approach
    public int majorityElement2(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    // Using HashMap
    public int majorityElement3(int[] nums) {
        int n = nums.length;
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = {3, 2, 3};
        System.out.println("Majority Element (Method 1): " + me.majorityElement1(nums));
        System.out.println("Majority Element (Method 2): " + me.majorityElement2(nums));
    }


}
