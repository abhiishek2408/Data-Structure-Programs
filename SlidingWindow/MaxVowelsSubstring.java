package SlidingWindow;

public class MaxVowelsSubstring {

    public static int maxVowels(String s, int k) {

        int count = 0;
        int max = 0;

        for(int i = 0; i < s.length(); i++) {

            // add new character
            if(isVowel(s.charAt(i)))
                count++;

            // remove old character
            if(i >= k && isVowel(s.charAt(i-k)))
                count--;

            // update max after window size k
            if(i >= k-1)
                max = Math.max(max, count);
        }

        return max;
    }

    public static boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }

    public static void main(String[] args) {

        String s = "abciiidef";
        int k = 3;

        System.out.println(maxVowels(s,k));
    }
}
