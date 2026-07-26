package String;

public class _28_ReverseEachWord {
    public String reverseEachWord(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder rev = new StringBuilder(word);
            result.append(rev.reverse().toString()).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        _28_ReverseEachWord sol = new _28_ReverseEachWord();
        String s = "Hello World";
        System.out.println("Original: " + s);
        System.out.println("Reversed each word: " + sol.reverseEachWord(s));
    }
}
