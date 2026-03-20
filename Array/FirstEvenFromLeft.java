package Array;

class FirstEvenFromLeft {
    // Returns the index of the first even number from the left, or -1 if none found
    public int findFirstEvenFromLeft(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                return i;
            }
        }
        return -1;
    }
}
