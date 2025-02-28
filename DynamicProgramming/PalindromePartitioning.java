package DynamicProgramming;

public class PalindromePartitioning {
    
    // Function to check if a substring is a palindrome
    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // Recursive function to find the minimum cuts
    private static int minCutRecursive(String s, int i, int j) {
        // Base case: If the substring is already a palindrome or only one character
        if (i >= j || isPalindrome(s, i, j)) return 0;

        int minCuts = Integer.MAX_VALUE;

        // Try every possible partitioning point
        for (int k = i; k < j; k++) {
            int cuts = 1 + minCutRecursive(s, i, k) + minCutRecursive(s, k + 1, j);
            minCuts = Math.min(minCuts, cuts);
        }

        return minCuts;
    }

    public static void main(String[] args) {
        String s = "geek"; // Example input
        int n = s.length();
        
        System.out.println("Minimum cuts needed for palindrome partitioning: " + minCutRecursive(s, 0, n - 1));
    }
}
