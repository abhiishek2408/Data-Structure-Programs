import java.util.*;

public class Longest_Substring_Without_Repeating {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            if (map.containsKey(currentChar)) {
                left = Math.max(map.get(currentChar) + 1, left); 
            }


            map.put(currentChar, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        Longest_Substring_Without_Repeating obj = new Longest_Substring_Without_Repeating();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb")); 
        System.out.println(obj.lengthOfLongestSubstring("bbbbb")); 
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }
}
