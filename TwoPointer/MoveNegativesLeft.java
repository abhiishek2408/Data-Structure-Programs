package TwoPointer;

public class MoveNegativesLeft {
    
    public static void moveNegative(int[] nums){

    int left = 0;
    int right = nums.length - 1;

    while(left <= right){

        if(nums[left] < 0)
            left++;

        else if(nums[right] > 0)
            right--;

        else{
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}

    public static void main(String[] args) {

        int nums[] = {1, -2, 3, -4, 5, -6};

        System.out.println("Before Moving Negatives:");
        for(int num : nums)
            System.out.print(num + " ");
        System.out.println();

        moveNegative(nums);

        System.out.println("After Moving Negatives:");
        for(int num : nums)
            System.out.print(num + " ");
    }
}
