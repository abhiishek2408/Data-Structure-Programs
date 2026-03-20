import java.util.*;

public class TripletSumLessThanTarget {

    public static int countTriplets(int[] arr, int target) {

        Arrays.sort(arr);

        int count = 0;

        for(int i = 0; i < arr.length - 2; i++) {

            int left = i + 1;
            int right = arr.length - 1;

            while(left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                if(sum < target) {

                    count += right - left;
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int arr[] = {5,1,3,4,7};
        int target = 12;

        System.out.println(countTriplets(arr,target));
    }
}
