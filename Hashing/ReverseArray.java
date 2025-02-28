

package Hashing;

import java.util.*;

class ReverseArray {

    void reverse(int[] a) {

        HashSet<Integer> set = new HashSet<>();

    
        // Add all elements from array b to HashSet
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        // Check elements from array a if they exist in HashSet
        System.out.print("Reverse: ");
        for (int i = a.length-1; i >= 0; i--) {
                System.out.print(a[i] + " ");   // 2 4 5 
                
           
        }System.out.println("first"+a[0]);   // 2 4 5 
    }

public static void main(String[] args) {
    ReverseArray solution = new ReverseArray();

        int[] a1 = { 1,2, 3, 4, 5 };
        solution.reverse(a1);
    }
}