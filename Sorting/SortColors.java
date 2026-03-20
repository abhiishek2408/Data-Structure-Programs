package Sorting;

public class SortColors {

    /*
    It uses three pointers:
    low → position where the next 0 should be placed
    mid → current element being checked
    high → position where the next 2 should be placed
    
    */

    // Function to sort an array of 0s, 1s, and 2s (variation of sortBinaryArray)
    public static void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public void sortColorss(int[] nums) {
    int right = 0;
    int left = nums.length - 1;

    for (int i = right; i <= left; i++) {

      while (nums[i] == 0 && i > right) {
          swap(nums, i, right++);
      }

      while (nums[i] == 2 && i < left) {
        swap(nums, i, left--);
      }
    }
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

    public static void sortColorsDutchNationalFlag(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }


    public static void sortColorsCountingMethod(int[] arr) {
    int count0 = 0, count1 = 0, count2 = 0;

    // Step 1: Count
    for (int num : arr) {
        if (num == 0) count0++;
        else if (num == 1) count1++;
        else count2++;
    }

    // Step 2: Overwrite array
    int index = 0;

    while (count0-- > 0) arr[index++] = 0;
    while (count1-- > 0) arr[index++] = 1;
    while (count2-- > 0) arr[index++] = 2;
}



    public static void sortColorsBeginner(int[] arr) {
    int[] temp = new int[arr.length];
    int idx = 0;

    for (int x : arr) if (x == 0) temp[idx++] = 0;
    for (int x : arr) if (x == 1) temp[idx++] = 1;
    for (int x : arr) if (x == 2) temp[idx++] = 2;

    for (int i = 0; i < arr.length; i++)
        arr[i] = temp[i];
}



    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 1, 0};
        System.out.println("Original array:");
        printArray(arr);
        sort012(arr);
        System.out.println("Sorted array of 0s, 1s, and 2s:");
        printArray(arr);
    }
}
