package DynamicProgramming;


import java.util.Arrays;
import java.util.Scanner;

class LDSDP {
    public int lengthOfLDS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Every element is an LDS of at least length 1
        int maxLDS = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) { // Change from LIS condition
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLDS = Math.max(maxLDS, dp[i]);
        }

        return maxLDS;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        LDSDP sol = new LDSDP();
        int result = sol.lengthOfLDS(nums);
        System.out.println("Length of Longest Decreasing Subsequence: " + result);
        scanner.close();
    }
}


