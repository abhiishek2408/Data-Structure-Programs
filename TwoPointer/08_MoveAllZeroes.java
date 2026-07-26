package TwoPointer;

public class MoveAllZeroes {
    
    public static void moveZeroes(int[] nums) {
        int j = 0; 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

public static void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

    public static int[] moveZeroesInPlace(int[] nums) {
       int left = 0;

    for(int right = 0; right < nums.length; right++){
    if(nums[right] != 0){
       swap(left, right, nums);
        left++;
    }
}
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        
        System.out.print("Array after moving zeroes: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
