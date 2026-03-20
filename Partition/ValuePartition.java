package Partition;

public class ValuePartition {
    public static void partitionByValue(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (arr[left] < k && left < right) left++;
            while (arr[right] >= k && left < right) right--;

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 8, 2, 6, 4};
        int k = 5;
        partitionByValue(arr, k);

        System.out.println("Partitioned array: " + java.util.Arrays.toString(arr));
    }
}
