import java.util.HashMap;

class AnagramWinAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        HashMap<Character, Integer> window = new HashMap<>();
        int i = 0; // Initialize i
        int k = t.length(); // Define k as the length of t

        for (int j = 0; j < s.length(); j++) {
            Character c = s.charAt(j);
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (j - i + 1 > k) { // Fix condition
                Character ch = s.charAt(i); // Use correct variable
                window.put(ch, window.getOrDefault(ch, 0) - 1);

                if (window.get(ch) == 0) {
                    window.remove(ch);
                }
                i++;
            }
        }
    }
}
