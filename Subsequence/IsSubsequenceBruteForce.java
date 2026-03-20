package Subsequence;

public class IsSubsequenceBruteForce {
    public static boolean isSubsequence(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int j = 0; // Pointer for B

        for (int i = 0; i < m; i++) { // Loop through A
            if (j < n && A[i] == B[j]) {
                j++; // Move pointer in B if there's a match
            }
        }

        return j == n; // If j reaches end of B, it's a subsequence
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 4, 5};

        System.out.println(isSubsequence(A, B) ? "Yes" : "No"); // Output: Yes
    }
}
