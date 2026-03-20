package Recursion.Backtracking;

import java.util.HashMap;
import java.util.Map;

public class PermutationsWithLimitedRepetitions {
    
    public void permute(String str) {
        // Create a frequency map to count occurrences of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        
        // Start the permutation process
        permuteHelper(frequencyMap, "", str.length());
    }
    
    private void permuteHelper(Map<Character, Integer> frequencyMap, String prefix, int remaining) {
        if (remaining == 0) {
            // All characters are used, print the permutation
            System.out.println(prefix);
            return;
        }
        
        // Iterate over the frequency map
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            
            if (count > 0) {
                // Use the character and decrement its count
                frequencyMap.put(ch, count - 1);
                
                // Recursively build the permutation
                permuteHelper(frequencyMap, prefix + ch, remaining - 1);
                
                // Backtrack: restore the character count
                frequencyMap.put(ch, count);
            }
        }
    }
    
        public static void main(String[] args) {
            String str = "AAB";
            PermutationsWithLimitedRepetitions permutations = new PermutationsWithLimitedRepetitions();
            permutations.permute(str);
        }
}