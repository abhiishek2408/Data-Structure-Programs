package Array;

// Longest Nice Substring Problem
// A string is nice if for every letter that appears in the string, both its uppercase and lowercase appear.
// This class provides a method to find the longest nice substring in a given string.

class LongestNiceSubstring {
    // Optimal approach: Divide and Conquer
    public String longestNiceSubstrings(String s) {
        if (s.length() < 2) return "";
        int mask = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) mask |= (1 << (c - 'a'));
            else mask |= (1 << (c - 'A'));
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((mask & (1 << (Character.toLowerCase(c) - 'a'))) > 0 &&
                (mask & (1 << (Character.toUpperCase(c) - 'A'))) > 0) {
                continue;
            }
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));
            return left.length() >= right.length() ? left : right;
        }
        return s;
    }


      public String longestNiceSubstring(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (isNice(sub) && sub.length() > res.length()) {
                    res = sub;
                }
            }
        }
        return res;
    }

    private boolean isNice(String s) {
        for (char c : s.toCharArray()) {
            if (!(s.contains(Character.toLowerCase(c) + "") && s.contains(Character.toUpperCase(c) + ""))) {
                return false;
            }
        }
        return true;
    }
}
