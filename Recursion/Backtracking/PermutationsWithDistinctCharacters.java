package Recursion.Backtracking;

public class PermutationsWithDistinctCharacters {

    
    public void permute(String str, String prefix) {
        // Base case: if the string is empty, print the accumulated prefix
        if (str.length() == 0) {
            System.out.println(prefix);
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
    public static void main(String[] args) {
        String str = "ABC";
        PermutationsWithDistinctCharacters permutations = new PermutationsWithDistinctCharacters();
        permutations.permute(str, "");
    }
}
