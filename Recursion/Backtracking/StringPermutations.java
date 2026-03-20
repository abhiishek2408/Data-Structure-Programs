package Recursion.Backtracking;

public class StringPermutations {

    
    public void permute(String str, String prefix) {
        // Base case: if the string is empty, print the accumulated prefix
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);  // Choose the current character
                
                // Form the remaining string by excluding the chosen character
                String remaining = str.substring(0, i) + str.substring(i + 1);
                
                // Recursively permute the remaining string with the updated prefix
                permute(remaining, prefix + ch);
            }
        }
    }
    public static void main(String[] args) {
        // Define the string for which permutations are to be generated
        String str = "ABC";
        
        // Create an instance of the StringPermutations class
        StringPermutations permutations = new StringPermutations();
        
        // Call the permute method with the initial string and an empty prefix
        permutations.permute(str, "");
    }
}