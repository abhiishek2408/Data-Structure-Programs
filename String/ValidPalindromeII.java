package String;

public class ValidPalindromeII {
    
    public static void main(String[] args) {
        ValidPalindromeII solution = new ValidPalindromeII();
        String testString = "abca";
        System.out.println("Can be a palindrome by removing one character: " + solution.validPalindrome(testString));
    }

    // Method to check if the given string can be a palindrome by removing at most one character
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // If characters don't match, check by skipping either character
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true; // String is already a palindrome
    }

    // Helper method to check if a substring is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        return true; // It is a palindrome
    }
}
