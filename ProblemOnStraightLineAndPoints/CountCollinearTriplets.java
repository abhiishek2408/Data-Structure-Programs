// CountCollinearTriplets.java
// Given a list of points in the plane, return the number of triplets that are collinear.
// Three points are collinear if they lie on a straight line.

public class CountCollinearTriplets {
    public int countCollinear(int[][] points) {
        int n = points.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (areCollinear(points[i], points[j], points[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Check if three points are collinear using area of triangle formula
    private boolean areCollinear(int[] a, int[] b, int[] c) {
        // Area = 0 if collinear: (x1(y2-y3) + x2(y3-y1) + x3(y1-y2)) == 0
        int area = a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1]);
        return area == 0;
    }

    // Example usage
    public static void main(String[] args) {
        CountCollinearTriplets cct = new CountCollinearTriplets();
        int[][] points = { {0,0}, {1,1}, {2,2}, {0,1}, {1,0} };
        System.out.println(cct.countCollinear(points)); // Output: 1
    }
}
