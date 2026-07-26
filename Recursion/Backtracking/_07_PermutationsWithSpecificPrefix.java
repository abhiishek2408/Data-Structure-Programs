package Recursion.Backtracking;

public class _07_PermutationsWithSpecificPrefix {

    
    
    public void permuteWithPrefix(String str, String prefix) {
        // Extract characters that are not part of the prefix
        String remaining = str.replaceFirst(prefix, "");
        
        // Start the permutation process
        permute(remaining, prefix);
    }
    
    public void permute(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                String remaining = str.substring(0, i) + str.substring(i + 1);
                permute(remaining, prefix + ch);
            }
        }
    }
        public static void main(String[] args) {
            String str = "ABC";
            String prefix = "A";
            _07_PermutationsWithSpecificPrefix permutations = new _07_PermutationsWithSpecificPrefix();
            permutations.permuteWithPrefix(str, prefix);
        }
}