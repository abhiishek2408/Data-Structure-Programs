package Subsequence;

public class IsSubsequenceEfficient {
    public static boolean isSubsequence(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                j++; // Move pointer in B
            }
            i++; // Always move pointer in A
        }
        return j == B.length; // If j reached end, B is a subsequence
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 4, 5};

        System.out.println(isSubsequence(A, B) ? "Yes" : "No"); // Output: Yes
    }
}

