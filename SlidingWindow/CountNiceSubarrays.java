package SlidingWindow;

public class CountNiceSubarrays {
    
    public static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public static int atMost(int[] nums, int k) {

        int left = 0;
        int count = 0;

        for(int right = 0; right < nums.length; right++) {

            if(nums[right] % 2 == 1)
                k--;

            while(k < 0) {

                if(nums[left] % 2 == 1)
                    k++;

                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {

        int nums[] = {1,1,2,1,1};
        int k = 3;

        System.out.println(numberOfSubarrays(nums,k));
    }
}
