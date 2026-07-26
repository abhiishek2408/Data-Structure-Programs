package Array;

public class _03_CheckIfArrayIsSorted {
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 2, 4, 5};

        System.out.println("Array 1 is sorted: " + isSorted(arr1));
        System.out.println("Array 2 is sorted: " + isSorted(arr2));
    }
}
