package Recursion;

public class Permutations {
    
    public static void main(String[] args) {
        String str = "ABC";
        permute(str, 0);
    }

    public static void permute(String s, int i) {
        // Base case: if the index reaches the end of the string
        if (i == s.length() - 1) {
            System.out.println(s);
            return;
        }

        // Loop to swap and generate permutations
        for (int j = i; j < s.length(); j++) {
            s = swap(s, i, j); // Swap characters
            permute(s, i + 1); // Recursively permute remaining string
            s = swap(s, i, j); // Backtrack (restore original string)
        }
    }

    public static String swap(String s, int i, int j) {
        char[] charArray = s.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }
}

/*                 ABC (Start)
                   /   |    \
              ABC       BAC     CBA
             /   \     /   \    /   \
        ABC     ACB  BAC   BCA CBA   CAB */