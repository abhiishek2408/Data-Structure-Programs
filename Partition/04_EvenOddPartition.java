package Partition;

public class EvenOddPartition {
    public static void partitionEvenOdd(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (arr[left] % 2 == 0 && left < right) left++;
            while (arr[right] % 2 != 0 && left < right) right--;

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 45, 9, 8, 90, 3};
        partitionEvenOdd(arr);

        System.out.println("Partitioned array: " + java.util.Arrays.toString(arr));
    }
}
