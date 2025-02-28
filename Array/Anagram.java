import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        if (s.length() != t.length()) {
            System.out.println(false);
            return;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Populate the frequency map for both strings
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Check if both maps are equal
        boolean ans = map1.equals(map2);
        System.out.println(ans);
      
    }
}