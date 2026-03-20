import java.util.*;

public class HouseRobber {

    public static int rob(int[] arr) {

        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int num : arr) {
            int curr = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public int robDP(int[] arr) {

    int n = arr.length;
    if(n == 0) return 0;
    if(n == 1) return arr[0];

    int[] dp = new int[n];

    dp[0] = arr[0];
    dp[1] = Math.max(arr[0], arr[1]);

    for(int i = 2; i < n; i++){
        dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
    }

    return dp[n-1];
}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input values
        System.out.println("Enter money in each house:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = rob(arr);

        // Output
        System.out.println("Maximum stolen value: " + result);

        sc.close();
    }
}
