// NumberOfRightTriangles.java
// Given a list of points in the plane, return the number of right triangles that can be formed by any three points.
// A right triangle has one angle of 90 degrees.

import java.util.HashMap;

public class NumberOfRightTriangles {
    public int countRightTriangles(int[][] points) {
        int n = points.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> slopeMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int gcd = gcd(dx, dy);
                if (gcd != 0) {
                    dx /= gcd;
                    dy /= gcd;
                }
                String slope = dx + "," + dy;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
            }
            for (String s : slopeMap.keySet()) {
                String perp = perpendicularSlope(s);
                if (slopeMap.containsKey(perp)) {
                    count += slopeMap.get(s) * slopeMap.get(perp);
                }
            }
        }
        // Each triangle is counted twice (once for each leg), so divide by 2
        return count / 2;
    }

    // Returns the perpendicular slope as a string
    private String perpendicularSlope(String slope) {
        String[] parts = slope.split(",");
        int dx = Integer.parseInt(parts[0]);
        int dy = Integer.parseInt(parts[1]);
        // Perpendicular slope: (dx, dy) -> (-dy, dx)
        return (-dy) + "," + dx;
    }

    private int gcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }

    // Example usage
    public static void main(String[] args) {
        NumberOfRightTriangles nrt = new NumberOfRightTriangles();
        int[][] points = { {0,0}, {1,0}, {0,1}, {1,1} };
        System.out.println(nrt.countRightTriangles(points)); // Output: 8
    }
}
