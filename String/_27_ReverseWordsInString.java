package String;

public class _27_ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _27_ReverseWordsInString sol = new _27_ReverseWordsInString();
        String s = "the sky is blue";
        System.out.println("Original: " + s);
        System.out.println("Reversed: " + sol.reverseWords(s));
    }
}
