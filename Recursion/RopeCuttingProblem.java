package Recursion;

public class RopeCuttingProblem {

    // Recursive function to find the maximum number of pieces
    public static int maxPieces(int n, int x, int y, int z) {
        // Base case: if the length of rope is 0, no more cuts are needed
        if (n == 0) {
            return 0;
        }

        // If the length of rope becomes negative, it's not a valid cut
        if (n < 0) {
            return -1;
        }

        // Try cutting the rope using lengths x, y, and z and get the maximum result
        int res = Math.max(Math.max(maxPieces(n - x, x, y, z),maxPieces(n - y, x, y, z)),maxPieces(n - z, x, y, z));
        
        // If no valid cuts are found, return -1 (invalid cut)
        if (res == -1) {
            return -1;
        }

        // Return the maximum number of pieces, adding 1 for the current cut
        return res + 1;
    }

    public static void main(String[] args) {
        int n = 23; // Length of the rope
        int x = 11; // First possible length of cut
        int y = 9;  // Second possible length of cut
        int z = 12; // Third possible length of cut
        
        // Call the recursive function and print the result
        int result = maxPieces(n, x, y, z);
        
        // If the result is -1, it means no valid cuts are possible
        if (result == -1) {
            System.out.println("It's not possible to cut the rope into valid pieces.");
        } else {
            System.out.println("Maximum number of pieces: " + result);
        }
    }
}
