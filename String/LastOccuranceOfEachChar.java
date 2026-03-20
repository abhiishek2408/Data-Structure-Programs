package String;

public class LastOccuranceOfEachChar {
    
    public static void lastOccurance(String str) {

        int[] lastIndex = new int[26];

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            lastIndex[ch - 'a'] = i;
        }

        for(int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            System.out.println(ch + " : " + lastIndex[i]);
        }
    }

    public static void main(String[] args) {

        String str = "hello world";

        lastOccurance(str);
    }
    
}
