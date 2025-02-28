package Hashing;

import java.util.*;

class IntersectionOfArray {

    void intersect(int[] a, int[] b) {

        HashSet<Integer> set = new HashSet<>();

    
        // Add all elements from array b to HashSet
        for (int i = 0; i < b.length; i++) {
            set.add(b[i]);
        }


        // Check elements from array a if they exist in HashSet
        System.out.print("Intersection: ");
        for (int i = 0; i < a.length; i++) {
            if (set.contains(a[i])) {
                System.out.print(a[i] + " ");   // 2 4 5 
                set.remove(a[i]); 
            }
        }
    }

public static void main(String[] args) {
    IntersectionOfArray solution = new IntersectionOfArray();

        int[] a1 = { 1, 2,2, 3, 4, 5 };
        int[] b1 = { 4, 5,2, 6, 7, 2 };

        solution.intersect(a1, b1);
    }
}