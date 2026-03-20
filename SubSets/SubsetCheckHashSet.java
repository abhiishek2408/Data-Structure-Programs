package SubSets;

import java.util.HashSet;

public class SubsetCheckHashSet {
    public static boolean isSubset(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : A) set.add(a); // Store A elements in HashSet

        for (int b : B) {
            if (!set.contains(b)) return false; // If B element is missing, return false
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 4, 6};
        System.out.println(isSubset(A, B) ? "Yes" : "No"); // Output: No
    }
}
