package Array;

import java.util.Arrays;

public class DistanceValueBWTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int x : arr1) {
            if (isValid(x, arr2, d)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValid(int x, int[] arr2, int d) {
        int left = 0, right = arr2.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (Math.abs(x - arr2[mid]) <= d) {
                return false; // violates condition
            } else if (arr2[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return true;
    }


     public int findTheDistanceValueTP(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int x : arr1) {
            if (isValidTP(x, arr2, d)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValidTP(int x, int[] arr2, int d) {
        int j = 0;

        while (j < arr2.length) {
            if (Math.abs(x - arr2[j]) <= d) {
                return false; // condition fail
            }
            // Optimization: arr2 sorted hai
            if (arr2[j] > x && arr2[j] - x > d) {
                break;
            }
            j++;
        }
        return true;
    }
}
