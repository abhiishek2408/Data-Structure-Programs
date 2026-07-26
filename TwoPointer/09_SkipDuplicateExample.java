package TwoPointer;

import java.util.Arrays;

public class SkipDuplicateExample {
    public static void main(String[] args) {

        int nums[] = {3,1,2,2,3,4,4};

        Arrays.sort(nums);   // sort the array

        for(int i = 0; i < nums.length; i++) {

            if(i > 0 && nums[i] == nums[i - 1])
                continue;   // skip duplicate element

            System.out.println(nums[i]);
        }
    }
}

//1 2 3 4