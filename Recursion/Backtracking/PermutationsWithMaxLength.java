package Recursion.Backtracking;

public class PermutationsWithMaxLength {

    public static void main(String[] args) {
        String str = "ABC";
        int maxLength = 2;
        PermutationsWithMaxLength permutations = new PermutationsWithMaxLength();
        permutations.permute(str, "", maxLength);
    }

    public void permute(String str, String prefix, int maxLength) {
        // Base case: if the prefix length reaches the maximum length, print the prefix
        if (prefix.length() == maxLength) {
            System.out.println(prefix);
            return;
        }

        // Print the current prefix if it's not empty
        if (!prefix.isEmpty()) {
            System.out.println(prefix);
        }

        // Recursive case: iterate over the string
        for (int i = 0; i < str.length(); i++) {
            // Choose the current character
            char ch = str.charAt(i);
            
            // Form the remaining string by excluding the chosen character
            String remaining = str.substring(0, i) + str.substring(i + 1);
            
            // Recursively permute the remaining string with the updated prefix
            permute(remaining, prefix + ch, maxLength);
        }
    }
}