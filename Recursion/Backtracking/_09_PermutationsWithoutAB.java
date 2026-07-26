package Recursion.Backtracking;

public class _09_PermutationsWithoutAB {

    public void permute(String str, String prefix) {
        if (str.length() == 0) {
            if (!prefix.contains("AB")) {
                System.out.println(prefix);
            }
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
        _09_PermutationsWithoutAB perm = new _09_PermutationsWithoutAB();
        perm.permute(str, "");
    }
}
