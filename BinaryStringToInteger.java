    import java.util.*;

public class BinaryStringToInteger {

    public static int operationsBinaryString(String str) {
        // Check for null or empty input
        if (str == null || str.length() == 0)
            return -1;

        // Convert first binary character to integer
        int result = str.charAt(0) - '0';

        // Loop through the string (operator + next digit)
        for (int i = 1; i < str.length(); i += 2) {
            char operation = str.charAt(i);     // 'A', 'B', or 'C'
            int nextDigit = str.charAt(i + 1) - '0'; // Convert to int (0 or 1)

            switch (operation) {
                case 'A': result = result & nextDigit; break; // AND
                case 'B': result = result | nextDigit; break; // OR
                case 'C': result = result ^ nextDigit; break; // XOR
                default:
                    return -1; // Invalid operator
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(operationsBinaryString(str));
    }
}

