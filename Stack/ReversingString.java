
import java.util.Stack;

public class ReversingString {

    public void reverseString(char[] s) {
        Stack<Character> st = new Stack<>();

        // Push all characters of the string into the stack
        for (int i = 0; i < s.length; i++) {
            st.push(s[i]);
        }

        // Pop characters from the stack and put them back into the array
        for (int i = 0; i < s.length; i++) {
            s[i] = st.pop();
        }
    }

    public static void main(String[] args) {
        ReversingString obj = new ReversingString();

        char[] str = { 'h', 'e', 'l', 'l', 'o' };

        // Reverse the string
        obj.reverseString(str);

        // Print the reversed string
        for (char c : str) {
            System.out.print(c);
        }
    }
}
