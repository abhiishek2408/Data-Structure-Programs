package TwoPointer;

public class PivotIndex {
    
    public static int pivotIndex(int[] nums) {

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {

        int nums[] = {10,7,8,9,1,5};

        int pivotIndex = pivotIndex(nums);

        if (pivotIndex != -1) {
            System.out.println("Pivot Index: " + pivotIndex);
        } else {
            System.out.println("No Pivot Index found.");
        }
    }
}
