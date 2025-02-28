package Recursion;

import java.util.*;

public class LetterCasePermutation {
    

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        helper(0, s, new StringBuilder(), ans);
        return ans;
    }

    public static void helper(int i, String s, StringBuilder sb, List<String> ans) {
        // we are processing the entire string
        if (i == s.length()) {
            ans.add(sb.toString());
            return;
        }
        
        char c = s.charAt(i);
        // Append the original character normally to string builder
        sb.append(c);
        helper(i + 1, s, sb, ans);
        sb.deleteCharAt(sb.length() - 1); // Backtrack

        // If character is a letter, try flipping its case
        if (Character.isLetter(c)) {
            sb.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
            helper(i + 1, s, sb, ans);
            sb.deleteCharAt(sb.length() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation solution = new LetterCasePermutation();
        String input = "a1b2";
        List<String> result = solution.letterCasePermutation(input);
        System.out.println("Letter Case Permutations of \"" + input + "\": " + result);
    }
}
