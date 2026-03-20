package Sorting;
public class CountingSort {
 
    public static int[] countingSort(int[] arr) {
        // Find the maximum value in the array to determine the range
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create a count array of size (max + 1)
        int[] count = new int[max + 1];

        // Count occurrences of each element in the array
        for (int num : arr) {
            count[num]++;
        }

        // Rebuild the sorted array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 4, 2, 7};

        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        countingSort(arr);

        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

