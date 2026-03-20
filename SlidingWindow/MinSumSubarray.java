package SlidingWindow;

public class MinSumSubarray {

    public static int minSum(int[] arr, int k) {

        int windowSum = 0;

        for(int i = 0; i < k; i++)
            windowSum += arr[i];

        int minSum = windowSum;

        for(int i = k; i < arr.length; i++) {

            windowSum += arr[i];
            windowSum -= arr[i-k];

            minSum = Math.min(minSum, windowSum);
        }

        return minSum;
    }

    public static void main(String[] args) {

        int arr[] = {2,1,5,1,3,2};
        int k = 3;

        System.out.println(minSum(arr, k));
    }
}