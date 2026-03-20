package SlidingWindow;

import java.util.*;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
            return false;

        int[] s1Count = new int[26];
        int[] window = new int[26];

        for(char c : s1.toCharArray())
            s1Count[c - 'a']++;

        int k = s1.length();

        for(int i = 0; i < s2.length(); i++) {

            window[s2.charAt(i) - 'a']++;

            if(i >= k)
                window[s2.charAt(i-k) - 'a']--;

            if(Arrays.equals(s1Count, window))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1,s2));
    }
}
