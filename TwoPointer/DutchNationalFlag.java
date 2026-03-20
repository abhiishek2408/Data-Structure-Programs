package TwoPointer;
//Sort Colors (Dutch National Flag variant)
import java.util.Arrays;

public class DutchNationalFlag {

    // Main sorting function
    public static void sortColors(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {

                swap(arr, low, mid);
                low++;
                mid++;

            } else if (arr[mid] == 1) {

                mid++;

            } else if (arr[mid] == 2) {

                swap(arr, mid, high);
                high--;
            }
        }
    }

    // Separate swap function
    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method
    public static void main(String[] args) {

        int[] arr = {2, 0, 2, 1, 1, 0};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(arr));

        sortColors(arr);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(arr));
    }
}
