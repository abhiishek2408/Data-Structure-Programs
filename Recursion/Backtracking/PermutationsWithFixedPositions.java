package Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithFixedPositions {

    public static void main(String[] args) {
        String str = "A*B*C";
        PermutationsWithFixedPositions permutations = new PermutationsWithFixedPositions();
        permutations.permute(str);
    }

    public void permute(String str) {
        // Extract characters that are not fixed
        List<Character> nonFixedChars = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            if (ch != '*') {
                nonFixedChars.add(ch);
            }
        }

        // Start the permutation process
        permuteHelper(nonFixedChars, "", str);
    }

    private void permuteHelper(List<Character> nonFixedChars, String prefix, String template) {
        if (nonFixedChars.isEmpty()) {
            // All non-fixed characters are used, fill the template
            StringBuilder result = new StringBuilder(template);
            int index = 0;
            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) != '*') {
                    result.setCharAt(i, prefix.charAt(index++));
                }
            }
            System.out.println(result.toString());
        } else {
            // Generate permutations by choosing each non-fixed character
            for (int i = 0; i < nonFixedChars.size(); i++) {
                char ch = nonFixedChars.get(i);
                List<Character> remaining = new ArrayList<>(nonFixedChars);
                remaining.remove(i);
                permuteHelper(remaining, prefix + ch, template);
            }
        }
    }
}


/*Clarification:
If you have a string like "A*BC", and you decide that 'A' is fixed, then 'B' and 'C' 
are non-fixed characters. You can generate permutations of 'B' and 'C' while keeping 
'A' in its position. The permutations of 'B' and 'C' would be "BC" and "CB", and the 
resulting strings would be "ABC" and "ACB".

Adjusting the Example:
To illustrate with a more meaningful example, let's say you have a string "A*BC" where:

'A' is fixed.
'*' is a placeholder for non-fixed characters.
'B' and 'C' are non-fixed characters.
In this case, you would generate permutations of 'B' and 'C', resulting in:

"ABC"
"ACB" */