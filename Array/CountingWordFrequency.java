import java.util.HashMap;

public class CountingWordFrequency {
    public static void main(String[] args) {
        String text = "hello world hello java";
        String[] words = text.split(" ");

        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        wordCount.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
