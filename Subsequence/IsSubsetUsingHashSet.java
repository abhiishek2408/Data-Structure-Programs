package Subsequence;

import java.util.*;

public class IsSubsetUsingHashSet {
    public static boolean isSubset(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        
        // Store all elements of A in HashSet
        for (int num : A) {
            set.add(num);
        }

        // Check if every element of B exists in the set
        for (int num : B) {
            if (!set.contains(num)) {
                return false; // If an element is missing, B is not a subset
            }
        }

        return true; // All elements of B exist in A
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 4, 5};

        System.out.println(isSubset(A, B) ? "Yes" : "No"); // Output: Yes (B is a subset, but not necessarily a subsequence)
    }
}


/* Why HashSet is NOT Ideal for Subsequence Check?
HashSet only checks presence, not order.
Subsequence requires order to be preserved, so HashSet alone cannot determine if B is a subsequence of A.
Approach 1: Using HashSet to Check Presence (Not Order)
📌 This only checks if B is a subset of A, NOT a subsequence.
📌 Time Complexity: O(n+m)
📌 Space Complexity:O(n) */
