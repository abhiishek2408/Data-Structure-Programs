package String;

import java.util.*;

public class NoOfSubsequence {
    public static void main(String[] args) {
        // The main string in which we check for subsequences
        String s = "abcde";
        // List of words to check if they are subsequences of s
        String[] words = {"ace", "aec", "bd", "a", "e"};  
        
        // Map to store character indices in s
        Map<Character, List<Integer>> charIndices = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // Store the indices of each character in s
            char c = s.charAt(i);  // Get the character at index i in string s
            charIndices.putIfAbsent(c, new ArrayList<>());  // If the character is not in the map, initialize it with a new ArrayList
            charIndices.get(c).add(i);  // Add the index i to the list of indices for this character The get(c) method is used to retrieve the list of indices

        }

        System.out.println(charIndices);
        
        // Check each word in the list
        int count = 0;
        for (String word : words) {
            if (isSubsequence(word, charIndices)) {
                count++;
            } 
        }
        
        System.out.println("Total number of subsequences: " + count);
    }
    
    // Method to check if a word is a subsequence of s
    private static boolean isSubsequence(String word, Map<Character, List<Integer>> charIndices) {
        int currentPosition = -1; // Track the position in s
        for (char c : word.toCharArray()) {
            if (!charIndices.containsKey(c)) {
                return false; // Character not found in s
            }


            List<Integer> indices = charIndices.get(c);  

            
            // Find the smallest index greater than currentPosition
            int pos = Collections.binarySearch(indices, currentPosition + 1);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            if (pos == indices.size()) {
                return false; // No valid position found
            }
            currentPosition = indices.get(pos); // Move to the next valid position
        }
        System.out.println();
        return true; // All characters found in correct order
    }
}
