// ConvexHull.java
// Given a set of points, find the points that form the convex hull (the smallest convex polygon containing all the points).
// This uses the basic Graham scan algorithm.

import java.util.*;

public class ConvexHull {
    public List<int[]> convexHull(int[][] points) {
        int n = points.length;
        if (n < 3) return new ArrayList<>();
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> hull = new ArrayList<>();
        // Lower hull
        for (int[] p : points) {
            while (hull.size() >= 2 && cross(hull.get(hull.size()-2), hull.get(hull.size()-1), p) <= 0) {
                hull.remove(hull.size()-1);
            }
            hull.add(p);
        }
        // Upper hull
        int t = hull.size() + 1;
        for (int i = n - 2; i >= 0; i--) {
            int[] p = points[i];
            while (hull.size() >= t && cross(hull.get(hull.size()-2), hull.get(hull.size()-1), p) <= 0) {
                hull.remove(hull.size()-1);
            }
            hull.add(p);
        }
        // Remove last point because it's the same as the first
        hull.remove(hull.size()-1);
        return hull;
    }

    // Cross product of OA x OB
    private int cross(int[] o, int[] a, int[] b) {
        return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0]);
    }

    // Example usage
    public static void main(String[] args) {
        ConvexHull ch = new ConvexHull();
        int[][] points = { {0,0}, {1,1}, {2,2}, {2,0}, {2,4}, {3,3}, {4,2} };
        List<int[]> hull = ch.convexHull(points);
        System.out.println("Convex Hull:");
        for (int[] p : hull) {
            System.out.println(Arrays.toString(p));
        }
    }
}
