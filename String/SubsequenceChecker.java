package String;


public class SubsequenceChecker {

    // Function to check if s2 is a subsequence of s1
    public static boolean isSubseq(String s1, String s2, int n, int m) {
        // If length of s2 is greater than s1, return false
        if (m > n) return false;

        int j = 0; // Index for s2
        // Loop through s1
        for (int i = 0; i < n; i++) {
            // Check if characters match
            if (j < m && s1.charAt(i) == s2.charAt(j)) {
                j++; // Move to the next character in s2
            }
        }
        return j == m; // Check if all characters of s2 were found in s1
    }


    public static boolean isSubseqRec(String s1, String s2, int n, int m) {
        // If s2 is empty, it is a subsequence of s1
        if (m == 0) return true;
        // If s1 is empty but s2 is not, s2 cannot be a subsequence
        if (n == 0) return false;

        // If the last characters match
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return isSubseqRec(s1, s2, n - 1, m - 1);
        } else {
            // If the last characters do not match, ignore the last character of s1
            return isSubseqRec(s1, s2, n - 1, m);
        }
    }

    public static void main(String[] args) {
        String s1 = "ahbgdc"; // Larger string
        String s2 = "abc";    // Smaller string
        int n = s1.length();
        int m = s2.length();

        if (isSubseq(s1, s2, n, m)) {
            System.out.println(s2 + " is a subsequence of " + s1);
        } else {
            System.out.println(s2 + " is not a subsequence of " + s1);
        }

        System.out.println();

        if (isSubseqRec(s1, s2, n, m)) {
            System.out.println(s2 + " is a subsequence of " + s1);
        } else {
            System.out.println(s2 + " is not a subsequence of " + s1);
        }
    }
}