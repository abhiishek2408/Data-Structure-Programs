// ReverseToMaximizeSum.java
// Finds the subarray to reverse to maximize the sum of absolute differences of adjacent elements
/*
Test case:
Input: arr = {1, 3, 2, 4}
Best reversal: reverse subarray from 1 to 2 -> {1, 2, 3, 4}
Sum before: |1-3|+|3-2|+|2-4| = 2+1+2 = 5
Sum after:  |1-2|+|2-3|+|3-4| = 1+1+1 = 3
But for arr = {2, 3, 1, 5, 4}, best reversal is from 2 to 4 -> {2, 3, 4, 5, 1}, sum = 1+1+1+4 = 7
*/

class ReverseToMaximizeSum {

    // Calculate sum of absolute differences of adjacent elements
    static int calcSum(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += Math.abs(arr[i] - arr[i - 1]);
        }
        return sum;
    }

    // Find the subarray to reverse to maximize the sum
    static int[] reverseToMaximizeSum(int[] arr) {
        int n = arr.length;
        int maxSum = calcSum(arr);
        int bestL = 0, bestR = 0;
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                // Copy and reverse subarray arr[l..r]
                int[] temp = arr.clone();
                int left = l, right = r;
                while (left < right) {
                    int t = temp[left];
                    temp[left] = temp[right];
                    temp[right] = t;
                    left++;
                    right--;
                }
                int currSum = calcSum(temp);
                if (currSum > maxSum) {
                    maxSum = currSum;
                    bestL = l;
                    bestR = r;
                }
            }
        }
        return new int[]{bestL, bestR, maxSum};
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 4};
        int[] result = reverseToMaximizeSum(arr);
        System.out.println("Reverse from " + result[0] + " to " + result[1] + " for max sum: " + result[2]);
    }
}
