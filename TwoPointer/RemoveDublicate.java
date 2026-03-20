package TwoPointer;

public class RemoveDublicate {
    
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 1; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static int[] removeDuplicatesAndGetArray(int[] nums) {
        if (nums.length == 0) return new int[0];

        int j = 1; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++; 
                nums[j] = nums[i];
            }
        }
        int[] result = new int[j + 1];
        System.arraycopy(nums, 0, result, 0, j + 1);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(nums);
        
        System.out.println("New length after removing duplicates: " + newLength);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
