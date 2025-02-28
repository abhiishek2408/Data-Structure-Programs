package DynamicProgramming;
//Approach 2: Binary Search + Patience Sorting (O(n log n))
import java.util.*;

public class LISBinarySearch {

    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        for (int num : nums) {
            int idx = Collections.binarySearch(sub, num);
            if (idx < 0) {
                idx = -(idx + 1); // Get the correct insert position
            }
            if (idx < sub.size()) {
                sub.set(idx, num); // Replace element5
            } else {
                sub.add(num); // Extend sequence
            }
        }
        
        return sub.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        LISBinarySearch sol = new LISBinarySearch();
        int result = sol.lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + result);
        scanner.close();
    }
}

/*Complexity Analysis
Time Complexity: O(nlogn) (Binary search for each element)
Space Complexity: O(n) (Storage for sub array) */

/*Explanation
Maintain a sub array that represents the smallest ending element of increasing subsequences of different lengths.
Use binary search (Arrays.binarySearch()) to find the correct position of nums[i] in sub.
If nums[i] is larger than the largest element in sub, append it.
Otherwise, replace the element at the found position.
The length of sub is the length of LIS. */