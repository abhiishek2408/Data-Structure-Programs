package TwoPointer;

public class SegregateEvenOddNumbers {
    
    public static void segregateEvenOdd(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {

            if(nums[left] % 2 == 0)
                left++;

            else if(nums[right] % 2 != 0)
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

        int nums[] = {12, 17, 70, 15, 22, 65, 21, 90};

        System.out.println("Before Segregation:");
        for(int num : nums)
            System.out.print(num + " ");
        System.out.println();

        segregateEvenOdd(nums);

        System.out.println("After Segregation:");
        for(int num : nums)
            System.out.print(num + " ");
    }
}
