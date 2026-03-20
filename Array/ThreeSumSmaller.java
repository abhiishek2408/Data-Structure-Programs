import java.util.*;

public class ThreeSumSmaller {

    public static int threeSumSmaller(int[] nums, int target) {

        Arrays.sort(nums);

        int count = 0;

        for(int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if(sum < target) {

                    count += right - left;
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int nums[] = {-2,0,1,3};
        int target = 2;

        System.out.println(threeSumSmaller(nums,target));
    }
}
