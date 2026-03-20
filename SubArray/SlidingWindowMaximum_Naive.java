// Java Program to find the maximum for each contiguous subarray of size k
// using a naive approach
// Time Complexity: O(n*k) where n is the number of elements in the array and k is the size of the subarray
// Space Complexity: O(1) as we are using only a constant amount of extra space
// i+j is the index of the current element in the window if i only then it will check the first element only otherwise it will check all the elements of the window
//if we use j only then it will check the first k elements only  meaning it will not slide the window

public class SlidingWindowMaximum_Naive {
    // Method to find the maximum for each contiguous subarray of size k
    static void printKMax(int arr[], int n, int k) {
        int max;
        
        // Loop through the array
        for (int i = 0; i <= n - k; i++) {
            max = arr[i];  // Assume first element of window is max
            
            // Traverse the next (k-1) elements in the window
            for (int j = 1; j < k; j++) {
                if (arr[i + j] > max)  
                    max = arr[i + j];
            }
            
            // Print the maximum of this window
            System.out.print(max + " ");
        }
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = {1, 3, 2, 5, 8, 6, 7, 9, 10, 12};
        int k = 3;
        int n = arr.length;

        // Call the function to print maximums
        printKMax(arr, n, k);
    }
}


