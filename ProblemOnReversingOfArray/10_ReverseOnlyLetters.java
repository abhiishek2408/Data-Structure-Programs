// ReverseOnlyLetters.java
// Reverses only the letters in a string, keeping other characters in place
/*
Test case:
Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
*/

class ReverseOnlyLetters {
    // Returns a string with only the letters reversed
    static String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (!Character.isLetter(arr[left])) {
                left++;
            } else if (!Character.isLetter(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s1 = "a-bC-dEf-ghIj";
        String s2 = "Test1ng-Leet=code-Q!";
        System.out.println(reverseOnlyLetters(s1)); // j-Ih-gfE-dCba
        System.out.println(reverseOnlyLetters(s2)); // Qedo1ct-eeLg=ntse-T!
    }
}
