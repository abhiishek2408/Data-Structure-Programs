import java.util.*;

public class ShortestUnsortedSubarray {

    public static int findUnsortedSubarray(int[] nums) {

        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int left = -1;
        int right = -1;

        // left → right scan
        for(int i = 0; i < n; i++) {

            max = Math.max(max, nums[i]);

            if(nums[i] < max)
                right = i;
        }

        // right → left scan
        for(int i = n-1; i >= 0; i--) {

            min = Math.min(min, nums[i]);

            if(nums[i] > min)
                left = i;
        }

        if(right == -1)
            return 0;

        return right - left + 1;
    }

    public static void main(String[] args) {

        int nums[] = {2,6,4,8,10,9,15};

        System.out.println(findUnsortedSubarray(nums));
    }
}
