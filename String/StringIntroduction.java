package String;

import java.io.*;
import java.util.*;

class StringIntroduction {
    public static void main(String[] args) {

        String str = "GeeksforGeeks";
        String s = new String("GeeksforGeeks");

        // Returns the number of characters in the String.
        System.out.println("String length = " + str.length());
        System.out.println("String length = " + s.length());

        // Returns the character at ith index.
        System.out.println("Character at 3rd position = " + s.charAt(3));

        // Return the substring from the ith index character to end of string
        System.out.println("Substring " + s.substring(3));

        // Returns the substring from i to j-1 index.
        System.out.println("Substring = " + s.substring(2, 5));

        // Concatenates string2 to the end of string1.
        String s1 = "Geeks";
        String s2 = "forGeeks";
        System.out.println("Concatenated string = " + s1.concat(s2));

        // Returns the index within the string of the first occurrence of the specified string.
        String s4 = "Learn Share Learn";
        System.out.println("Index of Share " + s4.indexOf("Share"));

        // Returns the index within the string of the first occurrence of the specified string, starting at the specified index.
        System.out.println("Index of a = " + s4.indexOf('a', 3));

        // Checking equality of Strings
        Boolean out = "Geeks".equals("geeks");
        System.out.println("Checking Equality " + out); // false

        out = "Geeks".equals("Geeks");
        System.out.println("Checking Equality " + out);

        out = "Geeks".equalsIgnoreCase("gEeks");
        System.out.println("Checking Equality " + out);

        int out1 = s1.compareTo(s2);
        System.out.println("If s1 = s2 " + out);

        // Converting cases
        String word1 = "GeeKyMe";
        System.out.println("Changing to lower Case " + word1.toLowerCase());

        // Converting cases
        String word2 = "GeekyME";
        System.out.println("Changing to UPPER Case " + word1.toUpperCase());

        // Trimming the word
        String word4 = " Learn Share Learn ";
        System.out.println("Trim the word " + word4.trim());

        // Replacing characters
        String str1 = "feeksforfeeks";
        System.out.println("Original String " + str1);
        String str2 = "feeksforfeeks".replace('f', 'g');
        System.out.println("Replaced f with g -> " + str2);

        // ***************** Additional String Functions *****************

        // contains() - Checks if the string contains a certain sequence
        System.out.println("Contains 'Share': " + s4.contains("Share"));

        // startsWith() and endsWith()
        System.out.println("Starts with 'Learn': " + s4.startsWith("Learn"));
        System.out.println("Ends with 'Learn': " + s4.endsWith("Learn"));

        // isEmpty() - Checks if the string is empty
        String emptyStr = "";
        System.out.println("Is empty string? " + emptyStr.isEmpty());

        // split() - Splitting a string based on space
        String[] words = s4.split(" ");
        System.out.println("Split words: " + Arrays.toString(words));

        // join() - Joining an array of words into a single string
        String joinedString = String.join("-", words);
        System.out.println("Joined String: " + joinedString);

        // toCharArray() - Converts string to char array
        char[] charArray = s1.toCharArray();
        System.out.println("Character Array: " + Arrays.toString(charArray));

        // format() - Formatting strings
        String formattedString = String.format("Hello %s, welcome to %s!", "Alice", "Java");
        System.out.println("Formatted String: " + formattedString);

        // matches() - Checks if a string matches a regex pattern
        System.out.println("Does '1234' match digits? " + "1234".matches("\\d+"));

        String str10 = "Welcome ?7hello";

        int alphaNumericCount = 0;
        for (int i = 0; i < str10.length(); i++) {
            if (Character.isLetterOrDigit(str10.charAt(i))) {
                alphaNumericCount++;
            }
        }
        System.out.println("Number of alphanumeric characters in '" + str10 + "' = " + alphaNumericCount);

    }
}
