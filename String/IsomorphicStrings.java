package String;

import java.util.*;

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false; // Different lengths can't be isomorphic

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if mapping exists and is consistent
            if (sToT.containsKey(charS) && sToT.get(charS) != charT) return false;
            if (tToS.containsKey(charT) && tToS.get(charT) != charS) return false;

            // Establish new mapping
            sToT.put(charS, charT);
            tToS.put(charT, charS);
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings solution = new IsomorphicStrings();

        System.out.println(solution.isIsomorphic("egg", "add")); // Expected: true
        System.out.println(solution.isIsomorphic("foo", "bar")); // Expected: false
        System.out.println(solution.isIsomorphic("paper", "title")); // Expected: true
        System.out.println(solution.isIsomorphic("ab", "aa")); // Expected: false
    }
}
