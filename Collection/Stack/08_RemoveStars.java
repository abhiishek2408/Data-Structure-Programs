package Collection.Stack;

public class RemoveStars {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                // Remove the last character if it exists
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RemoveStars obj = new RemoveStars();
        String input = "leet**cod*e";
        String output = obj.removeStars(input);
        System.out.println("Output: " + output);  // Output: "lecoe"
    }
}
