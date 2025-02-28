package Recursion;

public class SortArray {
    public static void sort(int[] arr, int n) {
        if (n == 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        sort(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 9, 3};
        sort(nums, nums.length);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
