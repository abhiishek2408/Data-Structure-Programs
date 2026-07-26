// ReversePairsToSort.java
// Finds and reverses pairs in the array to make it sorted (bubble sort style swaps)
/*
Test case:
Input: arr = {3, 1, 2, 4}
Reverse pairs (swap 3,1) -> {1,3,2,4}
Reverse pairs (swap 3,2) -> {1,2,3,4}
Output: 1 2 3 4
Total reversals: 2
*/

class ReversePairsToSort {

    // Reverse (swap) pairs to sort the array, returns the number of swaps
    static int reversePairsToSort(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int reversals = reversePairsToSort(arr);
        System.out.print("Sorted array: ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println("\nTotal reversals: " + reversals);
    }
}
