package SlidingWindow;

import java.util.Arrays;

public class IsAnagram {
    static final int CHAR = 256;

public static boolean areAnagramsNaive(String s1, String s2) {
        // Check if lengths are different
        if (s1.length() != s2.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        // Sort the character arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Convert sorted arrays back to strings
        s1 = new String(arr1);
        s2 = new String(arr2);

        // Check if the sorted strings are equal
        return s1.equals(s2);
    }

    public static boolean isAnagram(String s1, String s2){

    if(s1.length() != s2.length())
        return false;

    int[] count = new int[26];

    for(char c : s1.toCharArray())
        count[c - 'a']++;

    for(char c : s2.toCharArray())
        count[c - 'a']--;

    for(int i : count)
        if(i != 0)
            return false;

    return true;
}

    // Efficient method using character counting
    public static boolean areAnagramsEfficient(String s1, String s2) {
        // Check if lengths are different
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create a count array to store the count of characters
        int[] count = new int[CHAR];

    
        // Count characters in s1 and s2           
        for (int i = 0; i < s1.length(); i++) {     
            count[s1.charAt(i)]++; 
            count[s2.charAt(i)]--;
           
        }


    // Check if all counts are zero
        for (int i = 0; i < CHAR; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "abbcac";
        String str2 = "abccba";

        // Using the naive method
        // if (areAnagramsNaive(str1, str2)) {
        //     System.out.println(str1 + " and " + str2 + " are anagrams (Naive method).");
        // } else {
        //     System.out.println(str1 + " and " + str2 + " are not anagrams (Naive method).");
        // }

        // Using the efficient method
        if (areAnagramsEfficient(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams (Efficient method).");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams (Efficient method).");
        }
    }
}