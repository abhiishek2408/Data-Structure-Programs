package TwoPointer;

public class Palindrome {
    
    public static boolean isPalindrome(int x) {
        if (x < 0) return false; 

        String str = Integer.toString(x);
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; 
            }
            left++;
            right--;
        }
        return true; 
    }


    public static String palindrome(String str){
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] charArray = str.toCharArray();
        int left = 0, right = charArray.length - 1;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return "Not a palindrome"; 
            }
            left++;
            right--;
        }
        return "Palindrome";
    }

//Valid Palindrome ignoring special characters



    public static void main(String[] args) {
        int num = 121;
        boolean result = isPalindrome(num);
        
        System.out.println(num + " is a palindrome: " + result);
    }
}
