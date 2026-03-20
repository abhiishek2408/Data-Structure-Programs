package TwoPointer;

import java.util.Arrays;

public class PairWithGivenDifference {

    public static boolean findPair(int[] arr, int k) {

        Arrays.sort(arr);

        int left = 0;
        int right = 1;

        while(right < arr.length) {

            int diff = arr[right] - arr[left];

            if(diff == k && left != right)
                return true;

            else if(diff < k)
                right++;

            else
                left++;
        }

        return false;
    }

    public static void main(String[] args) {

        int arr[] = {5,20,3,2,50,80};
        int k = 78;

        System.out.println(findPair(arr, k));
    }
}
