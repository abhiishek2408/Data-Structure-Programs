package SlidingWindow;

public class MinimumWindowSubsequence {

    public static String minWindow(String S, String T) {

        int n = S.length();
        int m = T.length();

        int minLen = Integer.MAX_VALUE;
        int start = -1;

        int i = 0;

        while(i < n) {

            int j = 0;

            // Forward scan
            while(i < n) {

                if(S.charAt(i) == T.charAt(j)) {
                    j++;
                    if(j == m) break;
                }
                i++;
            }

            if(i == n) break;

            int end = i + 1;

            j = m - 1;

            // Backward scan
            while(i >= 0) {

                if(S.charAt(i) == T.charAt(j)) {
                    j--;
                    if(j < 0) break;
                }
                i--;
            }

            int windowLen = end - i;

            if(windowLen < minLen) {
                minLen = windowLen;
                start = i;
            }

            i = i + 1;
        }

        return start == -1 ? "" : S.substring(start, start + minLen);
    }

    public static void main(String[] args) {

        String S = "abcdebdde";
        String T = "bde";

        System.out.println(minWindow(S,T));
    }
}