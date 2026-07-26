package Partition;

/*1. Lomuto Partition (Used in QuickSort)
This method partitions the array around a pivot element, placing all smaller elements 
on the left and all larger elements on the right. */


public class LomutoPartition {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = low - 1; 

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1; 
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        int pivotIndex = partition(arr, 0, arr.length - 1);

        System.out.println("Partitioned array: " + java.util.Arrays.toString(arr));
        System.out.println("Pivot index: " + pivotIndex);
    }
}
