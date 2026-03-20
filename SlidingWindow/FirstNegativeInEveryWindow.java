package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeInEveryWindow {
    public static int[] firstNegativeNaive(int[] arr, int k) {
    int n = arr.length;
    int[] result = new int[n - k + 1];

    for(int i = 0; i <= n - k; i++) {
        result[i] = 0;

        for(int j = i; j < i + k; j++) {
            if(arr[j] < 0) {
                result[i] = arr[j];
                break;
            }
        }
    }

    return result;
}


public static int[] firstNegative(int[] arr, int k) {

    int n = arr.length;
    int[] result = new int[n - k + 1];

    Deque<Integer> dq = new LinkedList<>();

    for(int i = 0; i < n; i++) {

        // Add negative element index
        if(arr[i] < 0)
            dq.addLast(i);

        // Remove out of window index
        if(!dq.isEmpty() && dq.peekFirst() <= i - k)
            dq.pollFirst();

        // Window formed
        if(i >= k - 1) {
            if(dq.isEmpty())
                result[i - k + 1] = 0;
            else
                result[i - k + 1] = arr[dq.peekFirst()];
        }
    }

    return result;
}

    public static void main(String[] args) {

        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        int result[] = firstNegative(arr, k);

        for(int num : result)
            System.out.print(num + " ");
    }
}
