package SlidingWindow;

import java.util.Arrays;

public class CountAnagramPattern {
 
        public static int countAnagrams(String txt, String pat) {

        int k = pat.length();
        int count = 0;

        int[] patCount = new int[26];
        int[] winCount = new int[26];

        // pattern frequency
        for(char c : pat.toCharArray())
            patCount[c - 'a']++;

        for(int i = 0; i < txt.length(); i++) {

            // add new character
            winCount[txt.charAt(i) - 'a']++;

            // remove old character
            if(i >= k)
                winCount[txt.charAt(i-k) - 'a']--;

            // check anagram
            if(Arrays.equals(patCount, winCount))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {

        String txt = "forxxorfxdofr";
        String pat = "for";

        System.out.println(countAnagrams(txt, pat));
    }
}
