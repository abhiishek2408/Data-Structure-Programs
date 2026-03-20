
import java.util.*;

class Longest_Substring_Contain_K_Distinct {
    public int longestkSubstr(String s, int k) {
        if (k == 0) return 0;
        
        int i = 0, ans = -1;
        HashMap<Character, Integer> current = new HashMap<>();
        
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            current.put(c, current.getOrDefault(c, 0) + 1);
            
            while (current.size() > k) {
                char startChar = s.charAt(i);
                current.put(startChar, current.get(startChar) - 1);
                if (current.get(startChar) == 0) {
                    current.remove(startChar);
                }
                i++;
            }
            
            if (current.size() == k) {
                ans = Math.max(ans, j - i + 1);
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Longest_Substring_Contain_K_Distinct solution = new Longest_Substring_Contain_K_Distinct();
        
        // Test cases
        String s1 = "aabbcc";
        int k1 = 3;
        System.out.println("Longest substring with " + k1 + " distinct characters: " + solution.longestkSubstr(s1, k1)); // Expected output: 6

        String s2 = "abc";
        int k2 = 3;
        System.out.println("Longest substring with " + k2 + " distinct characters: " + solution.longestkSubstr(s2, k2)); // Expected output: 3

        String s3 = "aaabbcc";
        int k3 = 2;
        System.out.println("Longest substring with " + k3 + " distinct characters: " + solution.longestkSubstr(s3, k3)); // Expected output: 5
    }
}
