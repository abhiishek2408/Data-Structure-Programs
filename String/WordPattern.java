package String;

import java.util.*;

class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false; // Mismatch in length

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check for inconsistent mapping
            if (charToWord.containsKey(c) && !charToWord.get(c).equals(word)) return false;
            if (wordToChar.containsKey(word) && wordToChar.get(word) != c) return false;

            // Create new mapping
            charToWord.put(c, word);
            wordToChar.put(word, c);
        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern solution = new WordPattern();

        System.out.println(solution.wordPattern("abba", "dog cat cat dog")); // Expected: true
        System.out.println(solution.wordPattern("abba", "dog cat cat fish")); // Expected: false
        System.out.println(solution.wordPattern("aaaa", "dog dog dog dog")); // Expected: true
        System.out.println(solution.wordPattern("abba", "dog dog dog dog")); // Expected: false
    }
}

