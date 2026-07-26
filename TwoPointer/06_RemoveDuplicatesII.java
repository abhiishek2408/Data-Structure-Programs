package TwoPointer;

public class RemoveDuplicatesII {

    public static int removeDuplicates(int[] nums) {

        if(nums.length <= 2)
            return nums.length;

        int slow = 2;

        for(int fast = 2; fast < nums.length; fast++) {
            if(nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
        }

        return slow;
    }

    public static void main(String[] args) {

        int nums[] = {1,1,1,2,2,3};

        int len = removeDuplicates(nums);

        for(int i = 0; i < len; i++)
            System.out.print(nums[i] + " ");
    }
}
