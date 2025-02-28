

import java.util.*;

public class CeilingOnLeftSide {

    public static void printCeilingNaive(int[] arr, int n) {
        System.out.print("-1 "); // First element has no left side, so print -1

        for (int i = 1; i < n; i++) {
            int diff = Integer.MAX_VALUE; // Initialize difference as positive infinity
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i]) {
                    diff = Math.min(diff, arr[j] - arr[i]);
                }
            }
            if (diff == Integer.MAX_VALUE) {
                System.out.print("-1 ");
            } else {
                System.out.print((arr[i] + diff) + " ");
            }
        }
    }

    public static void printCeilingEfficient(int[] arr, int n) {
        TreeSet<Integer> set = new TreeSet<>();
        System.out.print("-1 "); // First element has no left side, so print -1
        set.add(arr[0]);

        for (int i = 1; i < n; i++) {
            Integer ceiling = set.ceiling(arr[i]);
            if (ceiling != null) {
                System.out.print(ceiling + " ");
            } else {
                System.out.print("-1 ");
            }
            set.add(arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 8, 30, 15, 25, 123};
        int n = arr.length;
        printCeilingNaive(arr, n);
        System.out.println();
        printCeilingEfficient(arr, n);

    }
}
