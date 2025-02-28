package String;

import java.util.*;

public class Autometa {

    public static void main(String[] args) {
        
        String str = "ababaabCa";
        HashMap<Character, Integer> map = new HashMap<>();

        // Count the occurrences of each character
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            int count = map.getOrDefault(currentChar, 0) + 1;
            map.put(currentChar, count);
        }

        // Find the maximum count of any character
        int maxCount = 0;
        for (int count : map.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        System.out.println(map);
        System.out.println();
        System.out.println("Maximum count of any character: " + maxCount);
    }
}