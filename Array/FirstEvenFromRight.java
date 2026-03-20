package Array;

class FirstEvenFromRight {
    // Returns the index of the first even number from the right, or -1 if none found
    public int findFirstEvenFromRight(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] % 2 == 0) {
                return i;
            }
        }
        
        return -1;
    }

    public int findFirstEvenFromRightUsingIteration(int[] nums) {
        int index = nums.length - 1;
        
        while (index >= 0) {
            if (nums[index] % 2 == 0) {
                return index; // Found the first even number
            }
            index--;
        }
        
        return -1; // No even number found
    }

    public int findFirstEvenFromRightUsingIterationsiplestwhileloop(int[] nums) {
        int index = nums.length - 1;
        
        while (index >= 0 && nums[index] % 2 != 0) {
            index--;
        }
        
        return index; // Returns -1 if no even number is found
    }

    public int findFirstEvenFromRightUsingRecursion(int[] nums, int index) {
        if (index < 0) {
            return -1; // Base case: no even number found
        }
        
        if (nums[index] % 2 == 0) {
            return index; // Found the first even number
        }
        
        return findFirstEvenFromRightUsingRecursion(nums, index - 1); // Recursive call
    }

  

}
