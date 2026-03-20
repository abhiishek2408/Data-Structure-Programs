package TwoPointer;

public class Sort01 {

    public static void sort01(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {

            if(nums[left] == 0)
                left++;

            else if(nums[right] == 1)
                right--;

            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {

        int nums[] = {0,1,0,1,1,0};

        System.out.println("Before Sorting:");
        for(int num : nums)
            System.out.print(num + " ");
        System.out.println();

        sort01(nums);

        System.out.println("After Sorting:");
        for(int num : nums)
            System.out.print(num + " ");
    }
}
