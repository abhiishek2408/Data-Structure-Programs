package String;

import java.util.Scanner;

public class PalindromeCheck {
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        
        s = s.toLowerCase().replace("[^a-z0-9]","");

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public static boolean isPalindromeNaive(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return s.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next(); // Input the string
        scanner.close();
        
        if (isPalindrome(s)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        // Testing the naive approach
        if (isPalindromeNaive(s)) {
            System.out.println("Yes (Naive)");
        } else {
            System.out.println("No (Naive)");
        }
    }
}
