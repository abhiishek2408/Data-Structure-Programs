package Partition;

/*2. Hoare’s Partition (Alternative QuickSort Partitioning)
This method partitions the array differently by selecting a pivot and moving elements around. */

public class HoarePartition {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;

        while (i < j) {
            while (i < high && arr[i] < pivot) {
                i++;
            }
            while (j > low && arr[j] > pivot) {
                j--;
            }
            
            if (i < j) {
                swap(arr, i, j);
            }
        }
        return j;
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
