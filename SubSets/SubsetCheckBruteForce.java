package SubSets;

public class SubsetCheckBruteForce {
    public static boolean isSubset(int[] A, int[] B) {
        for (int b : B) {
            boolean found = false;
            for (int a : A) {
                if (a == b) {
                    found = true;
                    break;
                }
            }
            if (!found) return false; // If an element is missing, return false
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 4, 6};
        System.out.println(isSubset(A, B) ? "Yes" : "No"); // Output: No
    }
}
//Time Complexity: O(m×n)
