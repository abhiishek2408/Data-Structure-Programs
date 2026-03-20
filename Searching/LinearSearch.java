package Searching;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Element found
            }
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;
        int index = linearSearch(arr, target);
        System.out.println("Element found at index: " + index);
    }
}

/*Best Case	O(1) (Element found at the first index)
Average Case O(n) (Element found somewhere in the middle)
Worst Case O(n) (Element not found or at the last index)

Space Complexity:O(1) (No extra space is used) */