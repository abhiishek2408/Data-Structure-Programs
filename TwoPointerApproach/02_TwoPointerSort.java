package TwoPointerApproach;
public class TwoPointerSort {
    public static void sortBinaryArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            // If left is 1 and right is 0, swap them
            if (arr[left] == 1 && arr[right] == 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            
            // Move left pointer to the right if it's 0
            if (arr[left] == 0) {
                left++;
            }
            
            // Move right pointer to the left if it's 1
            if (arr[right] == 1) {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 0, 1};
        sortBinaryArray(arr);
        
        // Print the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

