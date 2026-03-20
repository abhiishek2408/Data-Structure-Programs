package SlidingWindow;

public class MinimumWindowSubstring {
    
     public static String minWindow(String s, String t) {

        // If any string is empty → return empty
        if (s.length() == 0 || t.length() == 0)
            return "";

        // Frequency array to store count of characters in T
        int[] freq = new int[128];

        // Step 1: Store frequency of characters of T
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        // Left pointer of sliding window
        int left = 0;

        // Total characters of T we still need to match
        int count = t.length();

        // To store minimum window length
        int minLen = Integer.MAX_VALUE;

        // Starting index of minimum window
        int start = 0;

        // Step 2: Expand window using right pointer
        for (int right = 0; right < s.length(); right++) {

            // If this character is required
            if (freq[s.charAt(right)] > 0) {
                count--;
            }

            // Reduce frequency because character is included in window
            freq[s.charAt(right)]--;

            // Step 3: When all characters of T are found
            while (count == 0) {

                // Update minimum window length
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Step 4: Try to shrink window from left
                freq[s.charAt(left)]++;

                // If character becomes required again
                if (freq[s.charAt(left)] > 0) {
                    count++;
                }

                // Move left pointer forward
                left++;
            }
        }

        // Step 5: Return minimum substring
        if (minLen == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + minLen);
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}
