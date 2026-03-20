// CheckStraightLine.java
// Checks if given coordinates are in a straight line
/*
Test case:
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            // Cross multiplication check
            if ((y - y0) * (x1 - x0) != (y1 - y0) * (x - x0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter number of points: ");
        int n = scanner.nextInt();
        int[][] coords1 = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter x and y for point " + (i + 1) + ": ");
            coords1[i][0] = scanner.nextInt();
            coords1[i][1] = scanner.nextInt();
        }
        scanner.close();

        int[][] coords2 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println("Result for user input: " + sol.checkStraightLine(coords1));
        System.out.println("Result for hardcoded test: " + sol.checkStraightLine(coords2));
    }
}
