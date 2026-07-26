package SlidingWindow;

import java.util.HashMap;

public class _25_SlidingWinAnagram {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String t = "abc";

        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int i = 0; 
        int k = t.length(); 

        System.out.println("Finding all anagrams of '" + t + "' in '" + s + "':");

        for (int j = 0; j < s.length(); j++) {
            Character c = s.charAt(j);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (j - i + 1 > k) { 
                Character ch = s.charAt(i); 
                window.put(ch, window.get(ch) - 1);

                if (window.get(ch) == 0) {
                    window.remove(ch);
                }
                i++;
            }

            if (j - i + 1 == k) {
                if (window.equals(targetMap)) {
                    System.out.println("Anagram found at index: " + i);
                }
            }
        }
    }
}
