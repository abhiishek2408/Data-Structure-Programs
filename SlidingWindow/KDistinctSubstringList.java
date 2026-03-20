package SlidingWindow;

import java.util.*;

public class KDistinctSubstringList {

    public static int countSubstrings(String s, int k) {

        int count = 0;

        for(int i = 0; i < s.length(); i++) {

            List<Character> list = new ArrayList<>();

            for(int j = i; j < s.length(); j++) {

                list.add(s.charAt(j));

                // check distinct characters
                Set<Character> set = new HashSet<>(list);

                if(set.size() == k)
                    count++;

                if(set.size() > k)
                    break;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String s = "pqpqs";
        int k = 2;

        System.out.println(countSubstrings(s,k));
    }
}