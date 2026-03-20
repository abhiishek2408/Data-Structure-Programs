package Array;

// ReverseStringTwoPointers.java
// Implementation of reverseString using two pointers (left, right)

public class ReverseStringTwoPointers {
    /**
     * Reverses the input character array in place using two pointers.
     * @param s Input character array
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    // Example usage
    public static void main(String[] args) {
        ReverseStringTwoPointers solution = new ReverseStringTwoPointers();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
        System.out.print("Reversed string: ");
        for (char c : s) {
            System.out.print(c);
        }
    }
}
