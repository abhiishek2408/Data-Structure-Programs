package Recursion.Backtracking;

import java.util.HashSet;
import java.util.Set;

public class PermutationsWithoutConsecutiveVowels {

    
    public void permute(String str, String prefix) {
        // Base case: if the string is empty, check the prefix for consecutive vowels
        if (str.length() == 0) {
            if (!hasConsecutiveVowels(prefix)) {
                System.out.println(prefix);
            }
        } else {
            // Recursive case: iterate over the string
            for (int i = 0; i < str.length(); i++) {
                // Choose the current character
                char ch = str.charAt(i);
                
                // Form the remaining string by excluding the chosen character
                String remaining = str.substring(0, i) + str.substring(i + 1);
                
                // Recursively permute the remaining string with the updated prefix
                permute(remaining, prefix + ch);
            }
        }
    }
    
    
    private boolean hasConsecutiveVowels(String str) {
        // Define a set of vowels for easy checking
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        // Check each pair of consecutive characters in the string
        for (int i = 0; i < str.length() - 1; i++) {
            if (vowels.contains(str.charAt(i)) && vowels.contains(str.charAt(i + 1))) {
                return true; // Found consecutive vowels
            }
        }
        return false; // No consecutive vowels found
    }
    
    public static void main(String[] args) {
        String str = "AEIOU";
        PermutationsWithoutConsecutiveVowels permutations = new PermutationsWithoutConsecutiveVowels();
        permutations.permute(str, "");
    }
}