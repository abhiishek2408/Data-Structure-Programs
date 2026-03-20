package String;
// EncodeAndDecodeStrings.java
// Implements encoding and decoding of strings (e.g., run-length encoding)

public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public static String encode(String[] strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s.length()).append('#').append(s);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public static String[] decode(String s) {
        java.util.List<String> result = new java.util.ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(s.substring(i, j));
            j++; // skip '#'
            result.add(s.substring(j, j + length));
            i = j + length;
        }
        return result.toArray(new String[0]);
    }

    // Example usage
    public static void main(String[] args) {
        String[] input = {"hello", "world", "#hashtag", "123"};
        String encoded = encode(input);
        System.out.println("Encoded: " + encoded);
        String[] decoded = decode(encoded);
        System.out.print("Decoded: ");
        for (String str : decoded) {
            System.out.print(str + " ");
        }
    }
}
