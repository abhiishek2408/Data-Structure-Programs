package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSetString {

    // str : Stores input string curr : Stores current subset index : Index in
    // current subset, curr
    static void powerSet(String str, int index, String curr, List<String> list) {
        int n = str.length();

        // base case
        if (index == n) {
            list.add(curr);
            return;
        }
        
        // Two cases for every character
        powerSet(str, index + 1, curr + str.charAt(index), list); // (i) We consider the character as part of current
        // subset
        powerSet(str, index + 1, curr, list); // (ii) We do not consider current character as part of current subset
        //This "backtracks" by not modifying curr and exploring an alternative path.
    }
    
    // Driver code
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String str = "abc";
        int index = 0;
        String curr = "";
        powerSet(str, index, curr, list);
        System.out.println(list);
    }
}
