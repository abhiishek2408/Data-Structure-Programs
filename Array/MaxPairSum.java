import java.util.HashMap;
import java.util.Map;

public class MaxPairSum {

   
    public int maxSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int maxDigit = maxdig(num);

            if (map.containsKey(maxDigit)) {
                maxSum = Math.max(maxSum, map.get(maxDigit) + num);
                map.put(maxDigit, Math.max(map.get(maxDigit), num));
            } else {
                map.put(maxDigit, num);
            }
        }
        return maxSum;
    }

    int maxdig(int n) {
        int max = 0;
        while (n != 0) {
            max = Math.max(max, n % 10);
            n /= 10;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxPairSum sol = new MaxPairSum();
        int[] nums = {51, 71, 17, 42};
        System.out.println(sol.maxSum(nums));  // Output: 88 (71 + 17)
    }
}


