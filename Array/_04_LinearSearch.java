package Array;

public class _04_LinearSearch {
       
    public int linearSearch(int[] nums, int var) {
        if (nums.length == 0) return 0;

        int count = 0; 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == var) {        
                return i;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        _04_LinearSearch solution = new _04_LinearSearch();
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 5, 3};
        int target = 3;
        int index = solution.linearSearch(nums, target);
        
        System.out.println("Element " + target + " found at index: " + index);
       
    }
}

