package Recursion;

public class ReverseString {

    public static String reverseString(String s) {
        int n = s.length();
        if (n == 1) {
            return s;
        }

        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(str);
        System.out.println(str.substring(1));
        System.out.println(reverseString(str.substring(1)));
        System.out.println(reverseString(str));
        System.out.println(str.charAt(0));
    }

}
