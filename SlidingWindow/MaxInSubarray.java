package SlidingWindow;

import java.util.Collections;
import java.util.PriorityQueue;

// Maximum in each subarray of size k 
// Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

public class MaxInSubarray {
    
    public static int[] findMax(int[] arr, int k) {

        int[] result = new int[arr.length - k + 1];

        for(int i = 0; i <= arr.length - k; i++) {
            int max = Integer.MIN_VALUE;

            for(int j = i; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }

            result[i] = max;
        }

        return result;
    }

    public static int[] findMaxOptimized(int[] arr, int k) {

        int[] result = new int[arr.length - k + 1];

        for(int i = 0; i <= arr.length - k; i++) {
            if(i == 0) {
                int max = Integer.MIN_VALUE;

                for(int j = i; j < i + k; j++) {
                    max = Math.max(max, arr[j]);
                }

                result[i] = max;
            }
            else {
                if(arr[i + k - 1] > result[i - 1]) {
                    result[i] = arr[i + k - 1];
                }
                else if(result[i - 1] == arr[i - 1]) {
                    int max = Integer.MIN_VALUE;

                    for(int j = i; j < i + k; j++) {
                        max = Math.max(max, arr[j]);
                    }

                    result[i] = max;
                }
                else {
                    result[i] = result[i - 1];
                }
            }
        }

        return result;
    }


        public static void maxSubarray(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < k; i++)
            pq.add(arr[i]);

        System.out.print(pq.peek() + " ");

        for(int i = k; i < arr.length; i++) {

            pq.remove(arr[i-k]);
            pq.add(arr[i]);

            System.out.print(pq.peek() + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = {2,1,3,4,6,3,8,9,10,12,56};
        int k = 4;

        int result[] = findMax(arr, k);

        for(int num : result)
            System.out.print(num + " ");

        System.out.println();
        int resultOptimized[] = findMaxOptimized(arr, k);
        for(int num : resultOptimized)
            System.out.print(num + " ");
    }
}
