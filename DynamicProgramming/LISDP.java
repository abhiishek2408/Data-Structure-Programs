package DynamicProgramming;
/*Approach 1: Dynamic Programming (O(n²)) */
import java.util.Arrays;
import java.util.Scanner;

public class LISDP {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Each element is an LIS of at least length 1
        int maxLIS = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        return maxLIS;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[]{1,5,3,8,4};

        LISDP sol = new LISDP();
        int result = sol.lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + result);
        scanner.close();
    }
}

/*Explanation
Create a dp array where dp[i] stores the length of the LIS ending at index i.
Iterate over nums, and for each nums[i], check all previous elements nums[j] where j < i and nums[j] < nums[i].
Update dp[i] = max(dp[i], dp[j] + 1).
The final answer is max(dp). */


