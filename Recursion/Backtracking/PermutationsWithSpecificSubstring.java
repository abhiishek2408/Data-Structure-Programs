package Recursion.Backtracking;

public class PermutationsWithSpecificSubstring {

    public static void main(String[] args) {
        String str = "ABCD";
        String specificSubstring = "BC";
        PermutationsWithSpecificSubstring permutations = new PermutationsWithSpecificSubstring();
        permutations.permuteWithSubstring(str, specificSubstring);
    }

    public void permuteWithSubstring(String str, String specificSubstring) {
        // Remove the specific substring from the original string to get remaining characters
        String remaining = str.replaceFirst(specificSubstring, "");

        // Generate permutations by placing the specific substring at different positions
        for (int i = 0; i <= remaining.length(); i++) {
            // Split the remaining string into two parts
            String left = remaining.substring(0, i);
            String right = remaining.substring(i);

            // Generate permutations of the combined string
            permute(left + specificSubstring + right, "");
        }
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
}