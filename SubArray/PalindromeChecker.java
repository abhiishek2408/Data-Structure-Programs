

public class PalindromeChecker {

    // Function to check palindrome recursively
    public static boolean isPalindrome(String str, int start, int end) {
        // Base case: if the string has 0 or 1 character, it's a palindrome
        if (start >= end) {
            return true;
        }

        // If characters at the current positions do not match, it's not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recur for the remaining substring
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String str = "madam"; // Test string
        // Check palindrome from start (0) to end (length-1)
        if (isPalindrome(str, 0, str.length() - 1)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
    }
}

