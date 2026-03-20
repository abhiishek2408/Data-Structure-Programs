package String;

class FindSubstringInWraproundString {
    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26]; 
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || s.charAt(i - 1) - s.charAt(i) == 25)) {
                maxLength++; 
            } else {
                maxLength = 1;
            }

            int index = s.charAt(i) - 'a';
            dp[index] = Math.max(dp[index], maxLength);
        }

        int totalUniqueSubstrings = 0;
        for (int num : dp) {
            totalUniqueSubstrings += num;
        }

        return totalUniqueSubstrings;
    }
}

